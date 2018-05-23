/**
 * 
 */
package com.training.bankmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("/create")
	ResponseEntity<Audit> createAudit(@RequestBody Audit audit){
		Audit auditDummy = null;
		auditDummy = auditService.createAudit(audit);
		
		if(auditDummy == null)
		{
			
		}
	return new ResponseEntity<Audit>(auditDummy, HttpStatus.OK);
	}
}
