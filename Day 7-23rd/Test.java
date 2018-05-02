package SpringDemo.DayOne;

import java.applet.AppletContext;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {  
    public static void main(String[] args) {  
          
    	ApplicationContext context =   new ClassPathXmlApplicationContext("applicationContext.xml"); 
    	Customer customer=(Customer)context.getBean(Customer.obj);
          
          
    }  
}  