package com.maolin.bootlink.user.controller;


import com.google.common.base.Preconditions;
import com.maolin.bootlink.user.entity.SysUser;
import com.maolin.bootlink.user.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
 * @since 2018-11-07
 */
@Api("用户相关的接口")
@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @ApiOperation(value = "获取用户", notes = "根据id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required=true, dataType = "String")
    @GetMapping("/queryUser/{id}")
    @ResponseBody
    public SysUser queryUser(@PathVariable String id) {
        Preconditions.checkNotNull(id,"参数为空！");
        SysUser user = userService.getById(id);
        return user;
    }

}
