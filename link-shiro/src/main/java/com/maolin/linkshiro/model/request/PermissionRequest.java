package com.maolin.linkshiro.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by shaomaolin on 2018/11/20.
 */
@Data
@ApiModel(value = "PermissionRequest", description = "权限请求信息")
public class PermissionRequest{

    /*资源类型：menu，button等等*/
    @ApiModelProperty("资源类型：menu，button等等")
    private String resourceType;

    /*资源路径*/
    @ApiModelProperty("资源路径")
    private String url;

    /*权限*/
    @ApiModelProperty("权限")
    private String permission;

    /*父id*/
    @ApiModelProperty("父id")
    private String parentId;

    /*父id列表*/
    @ApiModelProperty("父id列表")
    private String parentIds;

    /*角色id*/
    @ApiModelProperty("角色id")
    private String roleId;

    /*数据状态，0：有效，1：逻辑删除*/
    @ApiModelProperty("数据状态，0：有效，1：逻辑删除")
    private Integer isDeleted;

}