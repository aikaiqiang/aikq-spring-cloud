package com.aikq.ai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  测试接口
 * @author aikq
 * @date 2018年12月11日 19:57
 */
@RestController
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中
public class TestController {

	@Value("${demo.test}")
	private String name;

	@RequestMapping("/test")
	public String test() {
		return this.name;
	}
}
