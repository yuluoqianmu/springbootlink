package com.maolin.bootlink.common;

/**
 * Created by shaomaolin on 2018/11/7.
 */

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 基础父类测试
 * </p>
 *
 * @author hubin
 * @since 2018-08-11
 */
@Data
@Accessors(chain = true)
public class BaseEntity {
    private Long id;

}