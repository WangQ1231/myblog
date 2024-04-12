package com.sgllnh.myblog.service.impl;

import com.sgllnh.myblog.entity.Message;
import com.sgllnh.myblog.mapper.MessageMapper;
import com.sgllnh.myblog.service.IMessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
