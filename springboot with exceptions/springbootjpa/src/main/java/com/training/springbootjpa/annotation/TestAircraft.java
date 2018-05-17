package com.training.springbootjpa.annotation;

import java.lang.annotation.Annotation;

/**
 * @author trainee
 *
 */
public class TestAircraft {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			Pilot pilot = new Pilot();
			Class class1 = pilot.getClass();
			Annotation annotation = class1.getAnnotation(Aircraft.class);
			Aircraft aircraft = new Aircraft() {
				
				@Override
				public String readyToLaunch() {
					// TODO Auto-generated method stub
					return "Starting";
				}
				
				@Override
				public String boomDay() {
					// TODO Auto-generated method stub
					return "Launch successfull";
				}

				@Override
				public Class<? extends Annotation> annotationType() {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
			System.out.println(aircraft.boomDay() + " "+ aircraft.readyToLaunch());
	}
}
