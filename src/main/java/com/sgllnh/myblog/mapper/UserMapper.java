package com.sgllnh.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sgllnh.myblog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 * `
 *
 * @author wangqiang
 * @since 2024-04-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findByUsername(String username);
}
