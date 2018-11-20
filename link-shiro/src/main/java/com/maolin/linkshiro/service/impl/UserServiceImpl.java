package com.maolin.linkshiro.service.impl;

import com.maolin.linkshiro.entity.User;
import com.maolin.linkshiro.mapper.UserMapper;
import com.maolin.linkshiro.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
