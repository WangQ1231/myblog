package com.sgllnh.myblog;

import com.sgllnh.myblog.entity.Channel;
import com.sgllnh.myblog.entity.User;
import com.sgllnh.myblog.mapper.ChannelMapper;
import com.sgllnh.myblog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ImyblogApplicationTests {

	@Autowired
	UserMapper userMapper;
	@Test
	void contextLoads() {
	}

	@Test
	public void testJava(){
		User zhangsan = userMapper.findByUsername("zhangsan");
		System.out.println(zhangsan);

		userMapper.add("zhangsan", "123456", "123456@qq.com");
	}

}
