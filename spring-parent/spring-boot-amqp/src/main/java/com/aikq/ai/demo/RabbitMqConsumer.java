package com.aikq.ai.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 *  消息消费者
 * @author aikq
 * @date 2018年12月10日 11:11
 */
@Component
@RabbitListener(queues = "test-aikq-rabbitmq")
public class RabbitMqConsumer {

	@RabbitHandler
	public void process(@Payload String msg){
		System.out.println("***********消费者收到消息：" + msg);
	}
}
