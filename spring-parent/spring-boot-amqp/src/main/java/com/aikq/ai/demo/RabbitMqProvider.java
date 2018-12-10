package com.aikq.ai.demo;

import com.aikq.ai.VO.MessageVO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  消息提供者
 * @author aikq
 * @date 2018年12月10日 11:11
 */
@Component
public class RabbitMqProvider {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendMsg(String msg){
		System.out.println("----------消息发送start----------");
		long startTime = System.currentTimeMillis();
		amqpTemplate.convertAndSend("test-aikq-rabbitmq", msg);
		System.out.println("耗时=" + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println("----------消息发送end----------");
	}

	public void sendMsgVO(MessageVO vo){
		System.out.println("----------消息发送开始");
		amqpTemplate.convertAndSend("test-aikq-rabbitmq", vo);
		System.out.println("----------消息发送end----------");
	}

	public void sendMsgVOByRoutingKey(String routingKey, MessageVO vo){
		System.out.println("----------指定队列消息发送开始");
		amqpTemplate.convertAndSend("admin.exchange", routingKey, vo);
		System.out.println("----------指定队列消息发送end----------");
	}
}
