package annotation.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/anno.xml");
		ServiceImpl obj  = (ServiceImpl) factory.getBean("service");
		obj.testService();

	}

}
