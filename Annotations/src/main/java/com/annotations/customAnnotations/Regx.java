package com.annotations.customAnnotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Documented
@Retention(RUNTIME)
@Target(FIELD)

public @interface Regx {
	
	Class[] PreValidators() default {NotNull.class};
	
	Length length() default @Length(min=10,max=10);
	
	String expression();
	

}
