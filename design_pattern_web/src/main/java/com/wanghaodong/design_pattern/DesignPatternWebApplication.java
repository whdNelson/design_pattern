package com.wanghaodong.design_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wanghaodong.design_pattern.mapper")
public class DesignPatternWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternWebApplication.class, args);
	}
}
