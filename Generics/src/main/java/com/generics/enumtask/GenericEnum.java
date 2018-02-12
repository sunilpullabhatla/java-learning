package com.generics.enumtask;

import com.generics.enumtask.exception.EnumTypeNotFoundException;

/**
 * Interface for generic enum.
 * 
 * @author Sunil Pavan
 *
 */
public interface GenericEnum<T> {

	public T getValue();
	
	public static <T> GenericEnum<T> getEnumFromValue(Class<? extends GenericEnum<T>> classVal, T t) 
			throws EnumTypeNotFoundException {
		for(GenericEnum<T> en: classVal.getEnumConstants()){
			if(en.getValue().equals(t)) return en;
		}
		throw new EnumTypeNotFoundException("Enum not found");
    }
}
