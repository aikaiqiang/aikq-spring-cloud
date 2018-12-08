package com.aikq.ai.controller;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Member;
import com.ecwid.consul.v1.agent.model.Service;
import com.ecwid.consul.v1.health.model.Check;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *  管理Consul服务
 * @author aikq
 * @date 2018年12月07日 17:04
 */
@RestController
@Slf4j
public class ConsulManageController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private ConsulClient consulClient;
	@Value("${consul.address}")
	private String consulAddress;

	@GetMapping("/dc")
	public String dc() {
		String services = "Services: " + discoveryClient.getServices();
		return services;
	}

	/**
	 * 清理无效服务
	 */
	@GetMapping("/ds")
	public Map<String, Object> deleteInvalidService(){
		Map<String, Object> resultMap = Maps.newHashMap();
		// 可用服务
		List<String> useableList = Lists.newArrayList();
		// 失效服务
		List<String> clearList = Lists.newArrayList();

		List<Member> members = consulClient.getAgentMembers().getValue();
		log.info("members={}", members);
		int node = 0;
		for(Member member: members){
			node++;
			// ip地址
			String ip = member.getAddress();
			log.info("节点node{}，ipAddress={}",node, ip);
			// 根据role获取每个member角色：role：consul---代表服务端   role：node---代表客户端
			String role = member.getTags().get("role");
			if ("consul".equals(role)){
				ConsulClient clearClient = new ConsulClient(ip);
				// 获取当前IP下所有的服务 使用迭代方式 获取map对象的值
				Iterator<Map.Entry<String, Service>> iterator = clearClient.getAgentServices().getValue().entrySet().iterator();
				while (iterator.hasNext()){
					Map.Entry<String, Service> serviceEntry = iterator.next();
					// 获取服务
					Service service = serviceEntry.getValue();
					// 获取服务名称
					String serviceName = service.getService();
					// 获取服务id
					String serviceId = service.getId();
					// 根据服务名称获取心跳检查状态
					Response<List<Check>> healthChecksForService = clearClient
							.getHealthChecksForService(serviceName, null);

					List<Check> checks = healthChecksForService.getValue();
					Map<String, Check> checkMap = Maps.newConcurrentMap();
					checks.forEach(check -> {
						checkMap.put(check.getServiceId(), check);
					});
					Check.CheckStatus checkStatus = checkMap.get(serviceId).getStatus();
					log.info("节点node{}-服务名称{}，服务id={}，服务状态={}", ip, serviceName, serviceId, checkStatus.toString());
					if (!checkStatus.equals(Check.CheckStatus.PASSING)){
						log.info("节点node{}-服务名称{}-无效服务即将删除", ip, serviceName);
						clearList.add(serviceName + serviceId);
						clearClient.agentServiceDeregister(serviceId);
						log.info("节点node{}-服务名称{}-无效服务已删除", ip, serviceName);
					}else {
						useableList.add(serviceName + serviceId);
					}
				}
			}
		}

		resultMap.put("可用服务", useableList);
		resultMap.put("失效服务", clearList);
		return resultMap;
	}
}
