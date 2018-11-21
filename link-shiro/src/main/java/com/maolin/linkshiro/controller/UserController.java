package com.maolin.linkshiro.controller;


import com.maolin.linkshiro.entity.User;
import com.maolin.linkshiro.model.request.UserRequest;
import com.maolin.linkshiro.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shaomaolin
 * @since 2018-11-20
 */
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
        userService.save(user);
        return user;
    }

}
