package com.generics.enumtask;

/**
 * Implementation enum class to achieve generic enum.
 * 
 * @author Sunil Pavan
 *
 */
public enum WeekDays implements GenericEnum{
	MONDAY("Monday"), 
	TUESDAY("Tuesday"), 
	WEDNESDAY("Wednesday"), 
	THURSDAY("Thursday"), 
	FRIDAY("Friday"), 
	SATURDAY("Saturday"),
	SUNDAY("Sunday");

	String val;
	
	private WeekDays(String val) {
		this.val = val;
	}

	@Override
	public String getValue() {
		return this.val;
	}
}
