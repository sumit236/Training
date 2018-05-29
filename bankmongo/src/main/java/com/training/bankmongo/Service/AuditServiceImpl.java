/**
 * 
 */
package com.training.bankmongo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.bankmongo.Model.Audit;
import com.training.bankmongo.Repository.AuditDAO;

/**
 * @author Sumit
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
		return auditDAO.insert(audit);
	}

	@Override
	public Audit getAudit(String eventName) {
		Optional<Audit> auditDummy = null;
		Audit audit = null;
		audit = auditDAO.findByEventName(eventName);
		if(audit != null){
			return audit;
		} else {
			return null;
		}
	}

	@Override
	public Audit deleteAudit(String uuid) {
		Optional<Audit> auditDummy = null;
		Audit audit = null;
		//auditDummy = auditDAO.findById(uuid);
		if (auditDummy.isPresent()) {
			audit = auditDummy.get();
			auditDAO.delete(audit);
			return audit;
		} else {
			return null;
		}
	}

	@Override
	public Audit updateAudit(String uuid) {
		Optional<Audit> auditDummy = null;
		Audit audit = null;
		//auditDummy = auditDAO.findById(uuid);
		if (auditDummy.isPresent()) {
			audit = auditDummy.get();
			audit.setEventName("customer");
			auditDAO.save(audit);
			return audit;
		} else {
			return null;
		}
	
	}

}
