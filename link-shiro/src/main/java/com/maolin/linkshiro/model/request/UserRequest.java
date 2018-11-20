package com.maolin.linkshiro.model.request;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by shaomaolin on 2018/11/8.
 */
@Data
@ApiModel(value = "userRequest", description = "用户请求对象")
public class UserRequest {

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 用户状态：0：创建未认证，1：有效，2：锁定
     */
    @ApiModelProperty("用户状态：0：创建未认证，1：有效，2：锁定")
    private Integer state;

    /**
     * 数据状态：1：有效，0：逻辑删除
     */
    @ApiModelProperty("数据状态：1：有效，0：逻辑删除")
    private Integer isDeleted;

}
