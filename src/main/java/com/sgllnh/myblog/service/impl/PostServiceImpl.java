package com.sgllnh.myblog.service.impl;

import com.sgllnh.myblog.entity.Post;
import com.sgllnh.myblog.mapper.PostMapper;
import com.sgllnh.myblog.service.IPostService;
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
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
