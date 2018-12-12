package com.aikq.ai;

import com.aikq.ai.VO.MessageVO;
import com.aikq.ai.demo.RabbitMqConsumer;
import com.aikq.ai.demo.RabbitMqManage;
import com.aikq.ai.demo.RabbitMqProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 *  E
 * @author aikq
 * @date 2018年12月10日 11:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

	@Autowired
	private RabbitMqProvider rabbitMqProvider;

	@Autowired
	private RabbitMqManage rabbitMqManage;

	@Test
	public void sendTest(){
		String msg = "hello, xiao qiang new";
		rabbitMqProvider.sendMsg(msg);
	}

	@Test
	public void sendVoTest(){
		MessageVO vo = new MessageVO();
		vo.setId(2);
		vo.setContent("第2条信息");
		vo.setType(2);
		vo.setCreateTime(new Date());
		vo.setForm("from");
		vo.setTo("to");
		rabbitMqProvider.sendMsgVO(vo);
	}

	@Test
	public void manageTest(){
		rabbitMqManage.createExchange("jack_1");
	}

	@Test
	public void sendVoByKeyTest(){
		MessageVO vo = new MessageVO();
		vo.setId(3);
		vo.setContent("第3条信息");
		vo.setType(3);
		vo.setCreateTime(new Date());
		vo.setForm("from3");
		vo.setTo("to3");
		rabbitMqProvider.sendMsgVOByRoutingKey("jack_1",vo);
	}

}
