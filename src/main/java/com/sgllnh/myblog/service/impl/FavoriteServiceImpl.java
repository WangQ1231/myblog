package com.sgllnh.myblog.service.impl;

import com.sgllnh.myblog.entity.Favorite;
import com.sgllnh.myblog.mapper.FavoriteMapper;
import com.sgllnh.myblog.service.IFavoriteService;
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
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements IFavoriteService {

}
