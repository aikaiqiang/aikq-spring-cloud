package com.aikq.ai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  配置
 * @author aikq
 * @date 2018年12月19日 12:29
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

	@Value("${useLocalCache:false}")
	private boolean useLocalCache;

	@GetMapping("/get")
	public boolean get(){
		return useLocalCache;
	}
}
