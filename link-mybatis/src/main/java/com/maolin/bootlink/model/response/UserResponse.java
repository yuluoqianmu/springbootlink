package com.maolin.bootlink.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by shaomaolin on 2018/11/8.
 */
@Data
@ApiModel(value = "UserResponse", description = "用户返回对象")
public class UserResponse {

    @ApiModelProperty(value = "id", name="id", dataType = "Long")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "用户名称", name="name", dataType = "String")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄",  name="age", dataType = "Integer")
    private Integer age;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱",  name="email", dataType = "String")
    private String email;
}
