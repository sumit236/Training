/**
 * 
 */
package com.training.bankmongo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.bankmongo.Model.Audit;
import com.training.bankmongo.Repository.AuditDAO;

/**
 * @author trainee
 *
 */
@Service("auditService")
public class AuditServiceImpl implements AuditService {

	@Autowired
	AuditDAO auditDAO;

	/*
	 * @see com.training.bankmongo.Service.AuditService#createAudit(com.training.
	 * bankmongo.Model.Audit)
	 */
	@Override
	public Audit createAudit(Audit audit) {

		Audit auditDummy = null;
		auditDummy = auditDAO.save(audit);
		return audit;
	}

}
