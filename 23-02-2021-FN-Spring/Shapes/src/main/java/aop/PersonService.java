package aop;

public class PersonService {
	
	private Person p1;

	public Person getP1() {
		return p1;
	}

	public void setP1(Person p1) {
		this.p1 = p1;
	}
	
	public void myThrowFunction() {
		try
		{
			throw new Error("My custom Error");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
