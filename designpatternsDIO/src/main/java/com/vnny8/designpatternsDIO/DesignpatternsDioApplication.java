package com.vnny8.designpatternsDIO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesignpatternsDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignpatternsDioApplication.class, args);
	}

}
