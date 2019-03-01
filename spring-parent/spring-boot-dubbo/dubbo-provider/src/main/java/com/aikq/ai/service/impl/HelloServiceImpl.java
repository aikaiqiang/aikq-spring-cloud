package com.aikq.ai.service.impl;

import com.aikq.ai.service.HelloService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 *  E
 * @author aikq
 * @date 2018年12月27日 20:07
 */
@Component
@Service
public class HelloServiceImpl implements HelloService {
	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}
}
