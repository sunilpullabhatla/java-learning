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
			String day = GenericEnum.getEnumFromValue(WeekDays.class, "Friday").toString();
			System.out.println(day);
			
		} catch (EnumTypeNotFoundException e) {
			e.printStackTrace();
		}
	}
}
