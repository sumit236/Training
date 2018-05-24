package com.training.bankmongo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.training.bankmongo.Model.Audit;
import com.training.bankmongo.Repository.AuditDAO;
import com.training.bankmongo.Service.AuditService;
import com.training.bankmongo.Service.AuditServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BankmongoApplicationTests<T> {

	@Mock
	private AuditDAO auditDAO;

	@InjectMocks
	AuditService auditServcie = new AuditServiceImpl();
	Date date = new Date();
	String id;
	Timestamp time;
	T base1;
	Audit audit;
	Audit audit1;
	Audit audit2;

	@Before
	public void init() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		id = UUID.fromString("asdasdasd").toString();
		time = new Timestamp(date.getTime());
	
		//audit1 = new Audit(id, "bank", "nameUpdate", timestamp.toString(),old,newInt);
		audit1 = new Audit( "bank", "nameUpdate", timestamp.toString(),1,"y");
		
		audit2 = new Audit(UUID.fromString("38400000-8cf0-11cd-b23e-10b96e4ef00d").toString(), "createnew", "creation", time,
				"3", base1, bsae2);
	}

	@Test
	public void auditcreateTest() throws AuditException {
		Date date = new Date();
		UUID id = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		Timestamp time = new Timestamp(date.getTime());
		
		Audit audit = new AuditLog(id, "create", "creation", time, "3", base1, bsae2);
		Mockito.when(auditDAO.save(audit)).thenReturn(audit);
		Audit audi;

		audi = auditServcie.createAudit(audit);
		assertEquals("created", audi, audit);
	}


}
