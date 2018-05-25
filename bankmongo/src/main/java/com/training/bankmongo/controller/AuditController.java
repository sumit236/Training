/**
 * 
 */
package com.training.bankmongo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.bankmongo.Model.Audit;
import com.training.bankmongo.Service.AuditService;

/**
 * @author Sumit
 *
 */

@RestController
public class AuditController {

	@Autowired
	AuditService auditService;

	final Logger LOGGER = Logger.getLogger(AuditController.class);
	
	@PostMapping("/create")
	Audit createAudit(@RequestBody Audit audit){
		Audit auditDummy = null;
		try {
			System.out.println(">>>>>>>>>>>>>> M2"+audit);
		auditDummy = auditService.createAudit(audit);
		}catch(Exception e){
			LOGGER.error("audit not found");
		}
		return auditDummy;
	}
	
	@GetMapping("/get/{uuid}")
	ResponseEntity<Audit> getAudit(@PathVariable String uuid){
		Audit auditDummy = null;
		try {
			auditDummy = auditService.getAudit(uuid);
			}catch(Exception e){
				LOGGER.error("audit not found");
			}
		if(auditDummy == null)
		{
			
		}
	return new ResponseEntity<Audit>(auditDummy, HttpStatus.OK);
	}
	
	@GetMapping("/delete/{uuid}")
	ResponseEntity<Audit> deleteAudit(@PathVariable String uuid){
		Audit auditDummy = null;
		try {
			auditDummy = auditService.deleteAudit(uuid);
			}catch(Exception e){
				LOGGER.error("audit not found");
			}
		if(auditDummy == null)
		{
			
		}
	return new ResponseEntity<Audit>(auditDummy, HttpStatus.OK);
	}
	
	@GetMapping("/update/{uuid}")
	ResponseEntity<Audit> updateAudit(@PathVariable String uuid){
		Audit auditDummy = null;
		try {
			auditDummy = auditService.updateAudit(uuid);
			}catch(Exception e){
				LOGGER.error("audit not found");
			}
		if(auditDummy == null)
		{
			
		}
	return new ResponseEntity<Audit>(auditDummy, HttpStatus.OK);
	}
}
