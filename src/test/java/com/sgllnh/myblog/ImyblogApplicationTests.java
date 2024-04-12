package com.sgllnh.myblog;

import com.sgllnh.myblog.entity.Channel;
import com.sgllnh.myblog.mapper.ChannelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ImyblogApplicationTests {

	@Autowired
	ChannelMapper channelMapper;
	@Test
	void contextLoads() {
	}

	@Test
	public void testJava(){
		List<Channel> channels = channelMapper.selectList(null);
		for (Channel channel : channels) {
			System.out.println(channel.toString());
		}
	}
}
