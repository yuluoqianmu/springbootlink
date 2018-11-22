package com.maolin.linkshiro.controller;


import com.maolin.linkshiro.entity.User;
import com.maolin.linkshiro.model.request.UserRequest;
import com.maolin.linkshiro.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shaomaolin
 * @since 2018-11-20
 */
@Api(tags = {"用户信息 /user"} )
@RestController("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @ApiOperation("新增用户")
    @PutMapping("/addUser")
    public User addUser(UserRequest userRequest){
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        user.setId(UUID.randomUUID().toString());
        user.setUpdateTime(LocalDateTime.now());
        user.setCreateTime(LocalDateTime.now());
        userService.save(user);
        return user;
    }

    @ApiOperation("查询用户信息")
    @GetMapping("/queryUser/{id}")
    public User queryUser(@PathVariable String id) {
        User user = userService.getById(id);
        return user;
    }

}
