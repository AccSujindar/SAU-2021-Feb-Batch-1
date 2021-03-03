package config;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Ecommerce.Product;
import Ecommerce.ProductCategory;
import Ecommerce.Supplier;
import EmployeeManagement.Employee;
import ManyToOne.Person;
import ManyToOne.Sim;

public class SessionService {
	
	public Session getSession()
	{
		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Supplier.class)
				.addAnnotatedClass(ProductCategory.class)
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Sim.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}

}
