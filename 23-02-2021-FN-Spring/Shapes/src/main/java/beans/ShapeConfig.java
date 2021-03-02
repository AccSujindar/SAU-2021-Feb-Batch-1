package beans;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShapeConfig {
	
	@Bean(name="rectangle")
	public Rectangle rectangle()
	{
		return new Rectangle(100,100);
	}
	@Bean(name="p1")
	public Point point1() {
		return new Point(0,0);
	}
	@Bean(name="p2")
	public Point point2() {
		return new Point(0,10);
	}
	@Bean(name="p3")
	public Point point3() {
		return new Point(10,0);
	}
	@Bean(name="p4")
	public Point point4() {
		return new Point(10,10);
	}
	@Bean
	public ArrayList<String> fruits() {
		return new ArrayList<String>(Arrays.asList("apple", "orange", "banana"));
	}
}
