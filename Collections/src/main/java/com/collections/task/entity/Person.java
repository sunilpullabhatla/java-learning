package com.collections.task.entity;

import java.util.Date;

public class Person {

	private String name;
	
	private Date timeOfComing;
	 
	private InterviewType interviewType;
	
	
	public Person(String name, Date timeOfComing, InterviewType interviewType) {
		super();
		this.name = name;
		this.timeOfComing = timeOfComing;
		this.interviewType = interviewType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date gettimeOfComing() {
		return timeOfComing;
	}
	public void settimeOfComing(Date timeOfComing) {
		this.timeOfComing = timeOfComing;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", timeOfComing=" + timeOfComing + ", interviewType=" + interviewType + "]";
	}

	
}
