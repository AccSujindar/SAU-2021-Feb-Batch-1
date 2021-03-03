package EmployeeManagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import config.SessionService;

public class EmployeeService {
	
	
	Session getSession()
	{
		SessionService service = new SessionService();
		return service.getSession();
	}
	
	void createEmployee(Employee e) 
	{
		Session session = getSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(e);
		tx.commit();
		session.close();
	}
	
	void updateAllEmployee(double x)
	{
		Session session = getSession();
		Transaction tx = (Transaction) session.beginTransaction();
		Query q = session.createQuery("update Employee set salary = :salary");
		q.setParameter("salary", x);
		q.executeUpdate();
		tx.commit();
		session.close();
	}
	void updateEmployeeById(int id,double x)
	{
		Session session = getSession();
		Transaction tx = (Transaction) session.beginTransaction();
		Employee e = (Employee)session.get(Employee.class,id);
		e.setSalary(x);
		session.saveOrUpdate(e);
		tx.commit();
		session.close();
	}
	void deleteEmployee(int id)
	{
		Session session = getSession();
		Transaction tx = (Transaction) session.beginTransaction();
		Employee e = (Employee)session.load(Employee.class,id);
		session.delete(e);
		tx.commit();
		session.close();
		
	}
	
	List<Employee> getAllEmployee()
	{
		Session session = getSession();
		Transaction tx = (Transaction) session.beginTransaction();
		Query q = session.createQuery("from Employee");
		ArrayList<Employee> list = (ArrayList<Employee>) q.list();
		tx.commit();
		session.close();
		return list;
	}
	
	Employee getEmployeeByID(int id)
	{
		Session session = getSession();
		Transaction tx = (Transaction) session.beginTransaction();
		Employee e = (Employee)session.get(Employee.class,id);
		tx.commit();
		session.close();
		return e;
	}

}
