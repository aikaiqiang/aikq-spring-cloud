package com.aikq.ai;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  E
 * @author aikq
 * @date 2018年12月21日 9:43
 */
@SpringBootApplication
// 开启dubbo的自动配置
@EnableDubboConfiguration
public class DubboProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(DubboProviderApplication.class, args);
	}
}
