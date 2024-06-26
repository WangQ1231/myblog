package com.sgllnh.myblog.service;

import com.sgllnh.myblog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangqiang
 * @since 2024-04-12
 */
public interface IUserService extends IService<User> {

    User findByUsername(String username);

    void register(String username, String password,String email);
}
