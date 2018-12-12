package com.aikq.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulClient2 {

	public static void main(String[] args) {
		SpringApplication.run(ConsulClient2.class, args);
	}
}
