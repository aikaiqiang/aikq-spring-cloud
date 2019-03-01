package com.aikq.ai.controller;

import com.aikq.ai.service.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  hello 测试
 * @author aikq
 * @date 2018年12月27日 20:08
 */
@RestController
public class HelloController {

	@Reference
	private HelloService helloService;

	@RequestMapping("/hello")
	public String hello() {
		String hello = helloService.sayHello("world");
		System.out.println(helloService.sayHello("aikq"));
		return hello;
	}
}
