package com.maolin.linkshiro.security;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Preconditions;
import com.maolin.linkshiro.entity.Permission;
import com.maolin.linkshiro.entity.Role;
import com.maolin.linkshiro.entity.User;
import com.maolin.linkshiro.service.IPermissionService;
import com.maolin.linkshiro.service.IRoleService;
import com.maolin.linkshiro.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaomaolin on 2018/11/20.
 */
@Log4j2
public class UserRealm extends AuthorizingRealm {

    //用于用户查询
    @Autowired
    private IUserService userService;
    //用于角色查询
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    /**
     * 用户认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        try {
            //获取登录用户名
            String userName = (String)principalCollection.getPrimaryPrincipal();

            QueryWrapper<User> userWrapper = new QueryWrapper<>();
            userWrapper.lambda().eq(User::getUserName, userName)
                    .eq(User::getIsDeleted, 0).eq(User::getState, 1);

            User user = userService.getOne(userWrapper);
            Preconditions.checkNotNull(user, "用户不存在！");

            //添加角色和权限
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            QueryWrapper<Role> roleWrapper = new QueryWrapper<>();
            roleWrapper.lambda().eq(Role::getUserId, user.getId()).eq(Role::getIsDeleted, 0);
            List<Role> roleList = roleService.list(roleWrapper);

            Preconditions.checkNotNull(roleList, "该用户不存在角色");

            List<String> roleIdList = new ArrayList<>();
            for (Role role : roleList) {
                simpleAuthorizationInfo.addRole(role.getRoleName());
                roleIdList.add(role.getId());
            }
            List<Permission> permissionList = (List<Permission>)permissionService.listByIds(roleIdList);

            Preconditions.checkNotNull(permissionList,"查询权限为空！");

            for (Permission permission : permissionList) {
                simpleAuthorizationInfo.addStringPermission(permission.getPermission());
            }

            return simpleAuthorizationInfo;

        } catch (Exception e) {
            log.error("用户认证失败！", e);
            throw new RuntimeException("用户认证失败！", e);
        }
    }

    /**
     * //用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        Preconditions.checkNotNull(authenticationToken.getPrincipal(),"用户不存在");

        //获取用户信息
        String userName = authenticationToken.getPrincipal().toString();
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.lambda().eq(User::getUserName, userName)
                .eq(User::getIsDeleted, 0).eq(User::getState, 1);

        User user = userService.getOne(userWrapper);
        Preconditions.checkNotNull(user, "用户不存在！");

        //这里验证authenticationToken和simpleAuthenticationInfo的信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, user.getPassword().toString(), getName());
        return simpleAuthenticationInfo;
    }
}
