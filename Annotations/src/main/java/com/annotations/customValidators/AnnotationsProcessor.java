package com.annotations.customValidators;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.annotaions.entity.Document;
import com.annotations.customAnnotations.Regx;

public class AnnotationsProcessor<T extends Document> {
	 
    
 	public  void process(T doc) {
 		
 		//------Class annotations Processing---------
 		
 			processClass(doc);
 		
           //------Field annotations Processing---------
            
            processFields(doc);
 
            //------Method annotations Processing---------
            
            processMethods(doc);
          
 
        
	}
 	
 	
 	
 	public void processClass(T doc) {
 		
 		Class<? extends Document> docClass = doc.getClass();
 		
 		Annotation[] classAnnos = docClass.getAnnotations(); 

 		for(Annotation classAnno: classAnnos) {
        
		if (classAnno instanceof Regx) {
			Regx regx = (Regx) classAnno;
		}
	}
	}
 	
 	
 	public void processFields(T doc) {
 		
 	try {
 		Class<? extends Document> docClass = doc.getClass();
 		
 		 List<Field> fields = new ArrayList<>();
         
         while (docClass != Object.class) {
             fields.addAll(Arrays.asList(docClass.getDeclaredFields()));
             docClass = (Class<? extends Document>) docClass.getSuperclass();
             
         }
         
         for (Field field : fields) {
         	
         	System.out.println(field.getName());
         	
         	Annotation[] annotations =  field.getAnnotations();
         	
         		for(Annotation annotation:annotations) {
         		
         			AnnotationsValidator.validationInSequence(annotation, field.get(doc));
         		}
         		
         		
         }
 	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
 		
 	}
 	
 	public void processMethods(T doc) {
 		
 		  Method[] methods = doc.getClass().getMethods();
          for (Method method : methods) {
            
        		Annotation[] methodAnnos = method.getAnnotations(); 

        		for(Annotation methodAnno: methodAnnos) {
                    
        			if (methodAnno instanceof Regx) {
        				Regx regx = (Regx) methodAnno;
        			}
          }
 	}
 	

}

}