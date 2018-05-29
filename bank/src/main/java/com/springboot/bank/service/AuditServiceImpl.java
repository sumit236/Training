/*package com.springboot.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.springboot.bank.model.Audit;

@Service("auditService")
public class AuditServiceImpl implements AuditService {

	
		@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	RestTemplate restTemplate;

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void getAudit(Audit auditData) {

		String uri = "http://a-bankmongo-application/create";
		Audit audit = auditData;
		Audit resultOfOperation = restTemplate.postForObject(uri, audit, Audit.class);
	}*/
	
	/*
	 * @MethodName : getAudit 
	 * Description : The method accepts the Audit object and
	 * 				 passes it to different micro-service using rest template.
	 */
	
/*	public void getAudit(Audit auditData) {
		List<ServiceInstance> instance = discoveryClient.getInstances("a-bankmongo-application");
		ServiceInstance serviceInstance = instance.get(0);
		String uri = serviceInstance.getUri().toString();
		uri = uri + "/create";
		Audit audit = auditData;
		Audit resultOfOperation = restTemplate.postForObject(uri, audit, Audit.class);
	}
}*/
