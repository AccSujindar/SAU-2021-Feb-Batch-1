package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonMain {
	
	public static void main(String args[])
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		PersonService service = context.getBean("personService",PersonService.class);
		Person p = service.getP1();
		service.setP1(p);
		p.getName();
		service.myThrowFunction();
		((AbstractApplicationContext) context).close();
	}

}
