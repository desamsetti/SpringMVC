package com.desamsettih.aopdemo;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.desamsettih.aopdemo.dao.AccountDAO;
import com.desamsettih.aopdemo.dao.MembershipDAO;
import com.desamsettih.aopdemo.dao.SwimmingDAO;
import com.desamsettih.aopdemo.service.TrafficFortuneService;


public class AroundHandleExceptionDemoApp{

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
			
		myLogger.info("\nMain Program : AroundDemoApp");
		
		boolean tripWire = true;
 		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("Calling getFortune");
		
		myLogger.info("\nThe print is: "+data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();
	}
}