package ManyToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;

import config.SessionService;

public class ManyToOneMain {
	
	public static void main(String args[])
	{
		Person p1 = new Person();
		p1.setId(1);p1.setName("p1");
		
		Person p2 = new Person();
		p2.setId(2);p2.setName("p2");
		
		Sim s1 = new Sim();
		s1.setNumber("1234567890");
		
		Sim s2 = new Sim();
		s2.setNumber("3452671891");
		
		Sim s3 = new Sim();
		s3.setNumber("6512437810");
		
		Sim s4 = new Sim();
		s4.setNumber("2342323512");
		
		p1.getSims().add(s2);p1.getSims().add(s3);
		p2.getSims().add(s1);p2.getSims().add(s4);
		
		s1.setPerson(p2); s2.setPerson(p1);
		s3.setPerson(p1); s4.setPerson(p2);
		
		SessionService service = new SessionService();
		Session session = service.getSession();
		Transaction tx = session.beginTransaction();
		session.save(p1);session.save(p2);
		session.save(s1);session.save(s2);
		session.save(s3);session.save(s4);
		tx.commit();
		session.close();
		
		
		
	}

}
