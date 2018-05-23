/**
 * 
 */
package com.training.bankmongo.Repository;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.training.bankmongo.Model.Audit;

/**
 * @author Sumit
 *
 */
public interface AuditDAO extends MongoRepository<Audit, UUID> {

}
