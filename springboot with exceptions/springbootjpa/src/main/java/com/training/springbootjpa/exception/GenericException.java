package com.training.springbootjpa.exception;

public class GenericException extends Exception{

private String exceptionMessage;

/**
 * @param exceptionMessage
 */
public GenericException(String exceptionMessage) {
	super(exceptionMessage);
}
}
