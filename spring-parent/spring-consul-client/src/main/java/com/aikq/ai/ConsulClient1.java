package com.aikq.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description 启动器
 * @author aikq
 * @date 2018/12/7 19:48
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulClient1 {

	public static void main(String[] args) {
		SpringApplication.run(ConsulClient1.class, args);
	}
}
