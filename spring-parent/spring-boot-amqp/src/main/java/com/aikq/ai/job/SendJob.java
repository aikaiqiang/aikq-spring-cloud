package com.aikq.ai.job;

import com.aikq.ai.demo.RabbitMqProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *  E
 * @author aikq
 * @date 2018年12月10日 13:47
 */
@Component
public class SendJob {

	@Autowired
	private RabbitMqProvider rabbitMqProvider;

//	@Scheduled(cron = "0/5 * * * * *")
	public void sendMsg(){
		String msg = "hello, test";
		rabbitMqProvider.sendMsg(msg);
	}
}
