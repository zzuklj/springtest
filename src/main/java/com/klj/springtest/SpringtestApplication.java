package com.klj.springtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = {"com.klj.springtest.mapper"})
@EnableSwagger2
public class SpringtestApplication {

	static {
		System.setProperty("es.set.netty.runtime.available.processors","false");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringtestApplication.class, args);
	}

}

