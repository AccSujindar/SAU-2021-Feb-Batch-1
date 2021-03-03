package Ecommerce;



import org.hibernate.Session;
import org.hibernate.Transaction;

import config.SessionService;

public class EcommerceMain {

	public static void main(String args[])
	{
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		Product p4 = new Product();
		Product p5 = new Product();
		
		p1.setId(1);p1.setName("p1");
		p2.setId(2);p2.setName("p2");
		p3.setId(3);p3.setName("p3");
		p4.setId(4);p4.setName("p4");
		p5.setId(5);p5.setName("p5");
		
		Supplier s1 = new Supplier();
		Supplier s2 = new Supplier();
		Supplier s3 = new Supplier();
		Supplier s4 = new Supplier();
		Supplier s5 = new Supplier();
		
		s1.setId(1);s1.setName("s1");
		s2.setId(2);s2.setName("s2");
		s3.setId(3);s3.setName("s3");
		s4.setId(4);s4.setName("s4");
		s5.setId(5);s5.setName("s5");
		
		
		ProductCategory pc1 = new ProductCategory();
		ProductCategory pc2 = new ProductCategory();
		ProductCategory pc3 = new ProductCategory();
		ProductCategory pc4 = new ProductCategory();
		ProductCategory pc5 = new ProductCategory();
		ProductCategory pc6 = new ProductCategory();
		ProductCategory pc7 = new ProductCategory();
		ProductCategory pc8 = new ProductCategory();
		ProductCategory pc9 = new ProductCategory();
		ProductCategory pc10 = new ProductCategory();
		
		pc1.setId(1);pc1.setName("pc1");
		pc2.setId(2);pc2.setName("pc2");
		pc3.setId(3);pc3.setName("pc3");
		pc4.setId(4);pc4.setName("pc4");
		pc5.setId(5);pc5.setName("pc5");
		pc6.setId(6);pc6.setName("pc6");
		pc7.setId(7);pc7.setName("pc7");
		pc8.setId(8);pc8.setName("pc8");
		pc9.setId(9);pc9.setName("pc9");
		pc10.setId(10);pc10.setName("pc10");
		
		p1.setCategory(pc1);p2.setCategory(pc5);
		p3.setCategory(pc10);p4.setCategory(pc8);
		p5.setCategory(pc3);

		
		pc1.addProduct(p1);pc5.addProduct(p2);
		pc10.addProduct(p3);pc8.addProduct(p4);
		pc3.addProduct(p5);
		
		
		s1.addCategory(pc1);s1.addCategory(pc9);
		s2.addCategory(pc2);s2.addCategory(pc5);
		s3.addCategory(pc10);s3.addCategory(pc4);
		s4.addCategory(pc8);s4.addCategory(pc6);
		s5.addCategory(pc7);s5.addCategory(pc3);
		
		pc1.addSupplier(s1);pc2.addSupplier(s2);pc3.addSupplier(s5);
		pc4.addSupplier(s3);pc5.addSupplier(s2);pc6.addSupplier(s4);
		pc7.addSupplier(s5);pc8.addSupplier(s4);pc9.addSupplier(s1);
		pc10.addSupplier(s3);
		
		
		SessionService service = new SessionService();
		Session session = service.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(p1);session.save(p2);session.save(p3);session.save(p4);session.save(p5);
		session.save(s1);session.save(s2);session.save(s3);session.save(s4);session.save(s5);
		session.save(pc1);session.save(pc2);session.save(pc3);session.save(pc4);session.save(pc5);
		session.save(pc6);session.save(pc7);session.save(pc8);session.save(pc9);session.save(pc10);
		
		tx.commit();
		session.close();
	}
	
}
