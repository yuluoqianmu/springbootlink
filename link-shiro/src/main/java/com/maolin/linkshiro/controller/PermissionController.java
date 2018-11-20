package com.maolin.linkshiro.controller;


import com.maolin.linkshiro.entity.Permission;
import com.maolin.linkshiro.model.request.PermissionRequest;
import com.maolin.linkshiro.service.IPermissionService;
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
@Api("权限信息")
@RestController("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @ApiOperation("新增权限")
    @PutMapping("/addPremission")
    public String addPremission(PermissionRequest permissionRequest){
        Permission permission = new Permission();
        BeanUtils.copyProperties(permissionRequest, permission);
        permission.setId(UUID.randomUUID().toString());
        permissionService.save(permission);
        return "addRole is ok! \n" + permission;
    }
}
