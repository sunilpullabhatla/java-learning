package com.annotaions.driver;


import java.lang.annotation.ElementType;

import com.annotaions.entity.Aadhar;
import com.annotations.customValidators.AnnotationsProcessor;

public class DocumentDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aadhar aadhar = new Aadhar();
		
		aadhar.setFullname("sunil-pavan");
		
		AnnotationsProcessor<Aadhar> aadharProcessor = new AnnotationsProcessor<>();
		
		aadharProcessor.processAll(aadhar);
		
		System.out.println(aadhar.toString());
		
 	}

}
