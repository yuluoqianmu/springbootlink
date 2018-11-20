package com.maolin.linkshiro.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shaomaolin
 * @since 2018-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 数据状态，1：有效，0：逻辑删除
     */
    private Integer isDeleted;


}
