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
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 资源类型：menu，button等等
     */
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限
     */
    private String permission;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 父id列表
     */
    private String parentIds;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 数据状态，1：有效，0：逻辑删除
     */
    private Integer isDeleted;


}
