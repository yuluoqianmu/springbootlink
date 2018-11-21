package com.maolin.linkshiro.controller;

import com.maolin.linkshiro.assembler.UserAssembler;
import com.maolin.linkshiro.entity.Permission;
import com.maolin.linkshiro.entity.Role;
import com.maolin.linkshiro.entity.User;
import com.maolin.linkshiro.model.request.LoginRequest;
import com.maolin.linkshiro.model.request.PermissionRequest;
import com.maolin.linkshiro.model.request.RoleRequest;
import com.maolin.linkshiro.model.request.UserRequest;
import com.maolin.linkshiro.service.IPermissionService;
import com.maolin.linkshiro.service.IRoleService;
import com.maolin.linkshiro.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

/**
 * Created by shaomaolin on 2018/11/20.
 */
@Api("用户登录")
@RestController("/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService permissionService;

    @ApiOperation("退出的时候是get请求，主要是用于退出")
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @ApiOperation("post登录")
    @PostMapping("/login")
    public String login(LoginRequest loginRequest){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginRequest.getUserName(), loginRequest.getPassword());
        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);
        return "login";
    }

    @ApiOperation("首页")
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @ApiOperation("登出")
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }

    @ApiOperation("错误页面展示")
    @GetMapping("/error")
    public String error(){
        return "error ok!";
    }

    @ApiOperation("注解的使用")
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @PutMapping(value = "/create")
    public String create(){
        return "Create success!";
    }
}
