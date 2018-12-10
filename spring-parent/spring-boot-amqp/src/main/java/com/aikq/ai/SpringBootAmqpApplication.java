package com.aikq.ai;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description 启动类
 * @author aikq
 * @date 2018/12/10 13:50
 */
@SpringBootApplication
@EnableScheduling
@EnableRabbit
public class SpringBootAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmqpApplication.class, args);
	}
}
