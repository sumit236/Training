package com.training.bankmongo;

import java.util.UUID;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.training.bankmongo.Repository.AuditDAO;
import com.training.bankmongo.Service.AuditService;
import com.training.bankmongo.Service.AuditServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BankmongoApplicationTests<T> {

	@Mock
	private AuditDAO auditDAO;

	@InjectMocks
	AuditService auditServcie = new AuditServiceImpl();
	
String id;


	@Before
	public void init() {
		id = UUID.fromString("3b171cb3-5ea4-4150-86af-f6da38460db3").toString();
		// Audit audit = new Audit<T>("bank", "", oldValue, newValue);
	
		
	}




}
