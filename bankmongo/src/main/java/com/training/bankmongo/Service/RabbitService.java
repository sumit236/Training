/**
 * 
 */
package com.training.bankmongo.Service;

import java.io.IOException;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.bankmongo.Model.Audit;

/**
 * @author Sumit
 *
 */

@Component
public class RabbitService {

	public static Object fromJsonToJava(String json, Class type)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.readValue(json, type);
	}

	public void receiveMessage(String message) {
		Audit audit = null;

		try {
			System.out.println("Message Number " + RabbitService.fromJsonToJava(message, Audit.class) + " received.");
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
