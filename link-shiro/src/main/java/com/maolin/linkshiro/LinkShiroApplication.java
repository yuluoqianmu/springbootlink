package com.maolin.linkshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.maolin.linkshiro.mapper")
public class LinkShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkShiroApplication.class, args);
	}
}
