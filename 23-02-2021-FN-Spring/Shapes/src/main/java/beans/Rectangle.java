package beans;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Rectangle {
	
	private int width,height;
	@Autowired
	@Qualifier("p1")
	private Point point1;
	@Autowired
	@Qualifier("p2")
	private Point point2;
	@Autowired
	@Qualifier("p3")
	private Point point3;
	@Autowired
	@Qualifier("p4")
	private Point point4;
	
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", point1=" + point1 + ", point2=" + point2
				+ ", point3=" + point3 + ", point4=" + point4 + ", fruits=" + fruits + "]";
	}
	@Autowired
	ArrayList<String> fruits;
	
	public ArrayList<String> getFruits() {
		return fruits;
	}
	public void setFruits(ArrayList<String> fruits) {
		this.fruits = fruits;
	}
	public Rectangle(int i, int j) {
		this.height = i;
		this.width = j;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Point getPoint1() {
		return point1;
	}
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
	public Point getPoint3() {
		return point3;
	}
	public void setPoint3(Point point3) {
		this.point3 = point3;
	}
	public Point getPoint4() {
		return point4;
	}
	public void setPoint4(Point point4) {
		this.point4 = point4;
	}
}
