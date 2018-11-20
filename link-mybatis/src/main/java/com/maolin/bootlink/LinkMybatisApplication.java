package com.maolin.bootlink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.maolin.bootlink.mapper")
public class LinkMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkMybatisApplication.class, args);
	}
}
