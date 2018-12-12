package com.aikq.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description  配置中心客户端demo启动类
 * @author aikq
 * @date 2018/12/11 20:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClient {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClient.class, args);
	}
}
