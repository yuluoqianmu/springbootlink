package com.maolin.linkshiro.controller;


import com.maolin.linkshiro.entity.Role;
import com.maolin.linkshiro.model.request.RoleRequest;
import com.maolin.linkshiro.service.IRoleService;
import io.swagger.annotations.Api;
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
@Api("角色信息")
@RestController("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation("新增角色")
    @PutMapping("/addRole")
    public String addRole(RoleRequest roleRequest){
        Role role = new Role();
        BeanUtils.copyProperties(roleRequest, role);
        role.setId(UUID.randomUUID().toString());
        roleService.save(role);
        return "addRole is ok! \n" + role;
    }
}
