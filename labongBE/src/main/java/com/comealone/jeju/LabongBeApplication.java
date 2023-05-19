package com.comealone.jeju;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = {"com.comealone.jeju.domain.repository"})
public class LabongBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabongBeApplication.class, args);
	}

}
