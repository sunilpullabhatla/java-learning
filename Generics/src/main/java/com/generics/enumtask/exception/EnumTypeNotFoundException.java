package com.generics.enumtask.exception;

/**
 * Custom exception for Generic Enum type
 * 
 * @author Sunil Pavan
 *
 */
public class EnumTypeNotFoundException extends Exception{
	
	private static final long serialVersionUID = -5981860986330558863L;

	public EnumTypeNotFoundException(String message) {
		super(message);
	}
}
