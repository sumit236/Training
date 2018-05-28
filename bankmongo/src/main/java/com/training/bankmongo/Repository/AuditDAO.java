/**
 * 
 */
package com.training.bankmongo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.training.bankmongo.Model.Audit;

/**
 * @author Sumit
 *
 */
public interface AuditDAO extends MongoRepository<Audit, String> {
	
	Audit findByEventName(String eventName);
	Long deleteByeventName(String name);
	Audit findByeventType(String name);

}
