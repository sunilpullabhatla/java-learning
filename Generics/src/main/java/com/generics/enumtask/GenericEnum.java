package com.generics.enumtask;

import com.generics.enumtask.exception.EnumTypeNotFoundException;

/**
 * Interface for generic enum.
 * 
 * @author Sunil Pavan
 *
 */
public interface GenericEnum {

	public <T> T getValue();
	
	
}
