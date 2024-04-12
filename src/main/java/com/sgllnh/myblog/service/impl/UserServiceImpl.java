package com.sgllnh.myblog.service.impl;

import com.sgllnh.myblog.entity.User;
import com.sgllnh.myblog.mapper.UserMapper;
import com.sgllnh.myblog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2024-04-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
