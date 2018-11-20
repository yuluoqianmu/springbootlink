package com.maolin.bootlink.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by shaomaolin on 2018/11/8.
 */
@Data
@ApiModel(value = "userRequest", description = "用户请求对象")
public class UserRequest {

    @ApiModelProperty(value = "id", dataType = "Long")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(name = "用户名称", dataType = "String")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(name = "年龄", dataType = "Integer")
    private Integer age;

    /**
     * 邮箱
     */
    @ApiModelProperty(name = "邮箱", dataType = "String")
    private String email;

}
