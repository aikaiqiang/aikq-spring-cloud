package com.aikq.ai.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *  RabbitMq配置文件
 * @author aikq
 * @date 2018年12月10日 11:06
 */
@Configuration
public class RabbitConfig {

	@Bean
	public Queue queue(){
		return new Queue("test-aikq-rabbitmq");
	}

	/**
	 * 修改默认的消息转换器，使用Json的消息转换器
	 * @return
	 */
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
