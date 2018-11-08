package com.maolin.bootlink.controller.user;


import com.google.common.base.Preconditions;
import com.maolin.bootlink.entity.user.SysUser;
import com.maolin.bootlink.enums.ErrorCodeEnum;
import com.maolin.bootlink.exception.MessageException;
import com.maolin.bootlink.model.response.UserResponse;
import com.maolin.bootlink.service.user.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shaomaolin
 * @since 2018-11-08
 */
@Api("用户接口")
@Controller
@RequestMapping("/user")
@Log4j2
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @ApiOperation("根据用户id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String")
    @GetMapping("/queryUser/{id}")
    @ResponseBody
    public UserResponse queryUserById(@PathVariable String id) throws MessageException{
        try {
            Preconditions.checkNotNull(id, "用户id为空！");
            SysUser user = userService.getById(id);
            Preconditions.checkNotNull(user, "用户不存在！");
            UserResponse resp = new UserResponse();
            BeanUtils.copyProperties(user, resp);
            return resp;
        } catch (Exception e) {
            log.error( "根据id查询用户失败！", e);
            throw new MessageException("根据id查询用户失败！", e);
        }
    }

}
