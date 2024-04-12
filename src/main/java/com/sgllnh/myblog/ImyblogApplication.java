package com.sgllnh.myblog;

import com.sgllnh.myblog.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.sgllnh.myblog.mapper")
public class ImyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImyblogApplication.class, args);
	}

	@Bean
	public IdWorker idWorker() {
		return new IdWorker(1,1);
	}
}
