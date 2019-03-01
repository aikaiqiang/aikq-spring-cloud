package com.aikq.ai;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  E
 * @author aikq
 * @date 2018年12月21日 10:13
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApplication.class, args);
	}
}
