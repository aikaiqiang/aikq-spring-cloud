package com.aikq.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description  启动类
 * @author aikq
 * @date 2018/12/7 17:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsul {

	public static void main(String[] args) {
		SpringApplication.run(CloudConsul.class, args);
	}
}
