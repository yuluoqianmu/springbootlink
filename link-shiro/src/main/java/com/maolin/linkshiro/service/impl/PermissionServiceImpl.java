package com.maolin.linkshiro.service.impl;

import com.maolin.linkshiro.entity.Permission;
import com.maolin.linkshiro.mapper.PermissionMapper;
import com.maolin.linkshiro.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaomaolin
 * @since 2018-11-20
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
