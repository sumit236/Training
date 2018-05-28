/**
 * 
 *//*
package com.springboot.bank.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bank.model.Audit;

*//**
 * @author Sumit
 *
 *//*
@FeignClient("a-bankmongo-application")
public interface FeignService {
	
	@PostMapping("/create")
	Audit createAudit( Audit audit);

}
*/