package com.maolin.linkshiro.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by shaomaolin on 2018/11/20.
 */
@Data
@ApiModel(value = "RoleResponse", description = "角色返回信息")
public class RoleResponse{

    /*主键*/
    @ApiModelProperty("主键")
    private String id;

    /*角色名称*/
    @ApiModelProperty("角色名称")
    private String roleName;

    /*用户id*/
    @ApiModelProperty("用户id")
    private String userId;

    /*数据状态，1：有效，0：逻辑删除*/
    @ApiModelProperty("数据状态，1：有效，0：逻辑删除")
    private byte isDeleted;

}
