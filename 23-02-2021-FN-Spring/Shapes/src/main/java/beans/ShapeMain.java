package beans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ShapeMain {
		
	public static void main(String args[])
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(ShapeConfig.class);
		Rectangle rectangle = (Rectangle)context.getBean("rectangle");
		System.out.println(rectangle);
		((AbstractApplicationContext) context).close();
	}

}
