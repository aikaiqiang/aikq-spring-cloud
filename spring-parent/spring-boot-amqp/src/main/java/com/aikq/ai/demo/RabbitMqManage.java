package com.aikq.ai.demo;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  E
 * @author aikq
 * @date 2018年12月10日 15:10
 */
@Component
public class RabbitMqManage {
	@Autowired
	private AmqpAdmin amqpAdmin;

	public void createExchange(String routingKey){
		// 创建exchange
		amqpAdmin.declareExchange(new DirectExchange("admin.exchange"));
		// 名字，是否持久化
		amqpAdmin.declareQueue(new Queue("admin.queue",true));
		// 创建绑定
		amqpAdmin.declareBinding(new Binding("admin.queue",Binding.DestinationType.QUEUE,
				"admin.exchange",routingKey,null));
	}
}
