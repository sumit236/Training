package com.springboot.bank.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bank.model.Audit;

@FeignClient("a-bankmongo-application")
public interface AuditService {
	@PostMapping("/create")
	Audit createAudit( Audit audit);

}
