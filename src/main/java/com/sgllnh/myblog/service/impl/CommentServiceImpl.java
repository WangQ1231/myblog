package com.sgllnh.myblog.service.impl;

import com.sgllnh.myblog.entity.Comment;
import com.sgllnh.myblog.mapper.CommentMapper;
import com.sgllnh.myblog.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangqiang
 * @since 2024-04-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
