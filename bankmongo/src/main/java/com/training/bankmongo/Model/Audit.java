/**
 * 
 */
package com.training.bankmongo.Model;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sumit
 * @param <T>
 * @param <T>
 *
 */
@Document
public class Audit<T> {

	@Id
	UUID uuid;
	// String randomUUIDString = uuid.toString();
	String eventName;
	String eventType;
	Timestamp timestamp ;
	String userId;
	T oldValue;
	T newValue;

	/**
	 * @return the uuid
	 */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName
	 *            the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType
	 *            the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	
	/**
	 * @return the oldValue
	 */
	public T getOldValue() {
		return oldValue;
	}

	/**
	 * @param oldValue
	 *            the oldValue to set
	 */
	public void setOldValue(T oldValue) {
		this.oldValue = oldValue;
	}

	/**
	 * @return the newValue
	 */
	public T getNewValue() {
		return newValue;
	}

	/**
	 * @param newValue
	 *            the newValue to set
	 */
	public void setNewValue(T newValue) {
		this.newValue = newValue;
	}

	/**
	 * @param uuid
	 * @param eventName
	 * @param eventType
	 * @param userId
	 * @param oldValue
	 * @param newValue
	 */
	public Audit(UUID uuid, String eventName, String eventType, Timestamp timestamp, T oldValue, T newValue) {
		super();
		this.uuid = uuid;
		this.eventName = eventName;
		this.eventType = eventType;
		this.timestamp =  new Timestamp(System.currentTimeMillis());
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	/**
	 * 
	 */
	public Audit() {
		super();
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Audit [uuid=" + uuid + ", eventName=" + eventName + ", eventType=" + eventType + ", userId=" + userId
				+ ", oldValue=" + oldValue + ", newValue=" + newValue + "]";
	}

}
