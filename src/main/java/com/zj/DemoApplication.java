package com.zj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// 注册mybatis mapper接口类
@MapperScan("com.zj.mapper")
@EnableTransactionManagement
public class DemoApplication {

	public static void main(String[] args) {
		// 程序启动入口,启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(DemoApplication.class, args);
	}

}
