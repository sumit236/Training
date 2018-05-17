/**
 * 
 */
package com.training.springbootjpa.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ TYPE, METHOD })
/**
 * @author trainee
 *
 */
public @interface Aircraft {
	
	
	String readyToLaunch() default "Starting";
	String boomDay() default "Launch successfull";
}
