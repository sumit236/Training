package com.springboot.bank.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.springboot.bank.model.Audit;

@Service("auditService")
public class AuditServiceImpl implements AuditService {
	
	@Override
	public void getAudit(Audit auditData) {
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:9090/create";
		Audit audit = auditData;
		Audit resultOfOperation = restTemplate.postForObject(url, audit, Audit.class);
	}
}
