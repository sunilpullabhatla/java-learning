package com.annotations.customValidators;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.annotations.customAnnotations.NotNull;
import com.annotations.customAnnotations.Regx;

public class AnnotationsValidator{

	
	public static void validationInSequence(Annotation annotation,Object value) {
		
		if (annotation instanceof Regx) {
 			Regx regx = (Regx) annotation;
 			
 			List<Class> classes = new ArrayList<>();
 			
 			classes.addAll(Arrays.asList(regx.PreValidators()));
 			 
 			classes.add(Regx.class);
 			validateAll(regx,classes,value);
		}
		
	}
	
	public static <T extends Annotation> void validateAll(T annoInstance,List<Class> classes,Object value) {
		
		
		Boolean result;
		
			for(Class clazz: classes ) {
				
				if(clazz.equals(NotNull.class)){
					
					result = AnnotationsValidator.notNullValidator(value);
					System.out.println("Not null Checked, Result = "+result);
					if(!result) break;
					
				}else if(clazz.equals(Regx.class)) {
					
					result = AnnotationsValidator.regxValidator((Regx) annoInstance,value.toString());
					System.out.println("Regex Checked, Result = "+result);
					if(!result) break;
				}
				
				
			}	
		
	}
	
	public static boolean regxValidator(Regx regx,String value) {
		
		return value.matches(regx.expression());
	}
	
	
	public static boolean notNullValidator(Object obj) {
		return Objects.nonNull(obj);
	}
}
