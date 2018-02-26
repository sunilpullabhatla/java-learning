package com.generics.enumtask;

import com.generics.enumtask.exception.EnumTypeNotFoundException;

/**
 * Demonstration class for generic enum
 * 
 * @author Sunil Pavan
 *
 */
public class EnumMain {
	
	
	public static void main(String[] args) {
		try {
			String day = getEnumFromValue(WeekDays.class, "Friday").toString();
			System.out.println(day);
			
		} catch (EnumTypeNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static <T> GenericEnum getEnumFromValue(Class<? extends GenericEnum> classVal, T t) 
			throws EnumTypeNotFoundException {
		for(GenericEnum en: classVal.getEnumConstants()){
			if(en.getValue().equals(t)) return en;
		}
		throw new EnumTypeNotFoundException("Enum not found");
    }
}
