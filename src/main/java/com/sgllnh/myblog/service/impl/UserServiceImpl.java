package com.sgllnh.myblog.service.impl;

import com.sgllnh.myblog.entity.User;
import com.sgllnh.myblog.mapper.UserMapper;
import com.sgllnh.myblog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgllnh.myblog.utils.DateUtils;
import com.sgllnh.myblog.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangqiang
 * @since 2024-04-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    IdWorker idWorker;
    @Override
    public User findByUsername(String username) {
        User user =userMapper.findByUsername(username);
        return user;
    }

    @Override
    public void register(String username, String password,String email) {

        //加密MD5
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        //添加
        User user = new User();
        user.setId(idWorker.nextId());
        user.setUsername(username);
        user.setPassword(md5DigestAsHex);
        user.setEmail(email);
        user.setStatus(0);
        user.setName(username);
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setRoleId(1);
        user.setAvatar("");
        user.setPosts(0);
        user.setComments(0);
        user.setGender(0);
        user.setSignature("");
        userMapper.insert(user);
    }

    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8)));

    }
}
