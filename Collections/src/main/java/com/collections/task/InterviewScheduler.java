package com.collections.task;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.collections.task.entity.InterviewType;
import com.collections.task.entity.Person;

public class InterviewScheduler {

	public static void main(String[] args) {
		
		try {
		
			final Date ScheduledInTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-02-2018 07:07:07");
			final Date WalkinInTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-02-2018 07:07:07");
			
			
			Person p1 = new Person("Sunil", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-02-2018 07:07:07"),InterviewType.Scheduled);
			Person p2 = new Person("Pavan", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-02-2018 07:07:07"),InterviewType.Scheduled);
			Person p3 = new Person("Kumar", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-02-2018 07:07:07"),InterviewType.Scheduled);
			
			Person p4 = new Person("Sunil", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-02-2018 07:07:07"),InterviewType.Walkin);
			Person p5 = new Person("Pavan", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-02-2018 07:07:07"),InterviewType.Walkin);
			Person p6 = new Person("Kumar", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-02-2018 07:07:07"),InterviewType.Walkin);
			
			
			
			
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
