package com.maolin.linkshiro.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by shaomaolin on 2018/11/21.
 */
@Data
@ApiModel(value = "LoginRequest", description = "用户登录请求")
public class LoginRequest {

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
}
