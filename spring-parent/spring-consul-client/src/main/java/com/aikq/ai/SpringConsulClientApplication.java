package com.aikq.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description 启动器
 * @author aikq
 * @date 2018/12/7 19:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringConsulClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConsulClientApplication.class, args);
	}
}
