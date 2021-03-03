package EmployeeManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeMain {
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		EmployeeService service = new EmployeeService();
		int option,id;
		double salary;
		String d;
		boolean flag = true;
		do
		{
			System.out.println("1. Create Employee\n2. Update all Employee salary\n3. Update a Employee\n"
					+ "4.Delete Employee\n5. View Employees\n6. View a Employee\n7. Exit\n");
			option = sc.nextInt();
			switch(option)
			{
				case 1: Employee e = new Employee();
						System.out.println("Employee ID: ");
						e.setId(sc.nextInt());
						sc.nextLine();
						System.out.println("Employee First Name: ");
						e.setFname(sc.nextLine());
						System.out.println("Employee Last Name: ");
						e.setLname(sc.nextLine());
						System.out.println("Employee Age: ");
						int age = sc.nextInt();
						sc.nextLine();
						while(age <0 || age > 99)
						{
							System.out.println("Invalid Age. Age should be between 0 and 99. Try Again");
							age = sc.nextInt();
							sc.nextLine();
						}
						e.setAge(age);
						System.out.println("Employee Salary: ");
						e.setSalary(sc.nextDouble());
						sc.nextLine();
						System.out.println("Employee DOB: Format - dd/mm/yyyy");
						d = sc.nextLine();
						Date date = null;
						try {
							date = new SimpleDateFormat("dd/MM/yyyy").parse(d);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						while(date == null)
						{
							System.out.println("Invalid Date. Try Again in dd/mm/yyyy");
							d = sc.nextLine();
							try {
								date=new SimpleDateFormat("dd/MM/yyyy").parse(d);
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
						}
						e.setDob(date);
						System.out.println("Employee Designation: ");
						e.setDesignation(sc.nextLine());
						service.createEmployee(e);
						break;
				case 2: System.out.println("Enter the new Salary for all employees: ");
						salary = sc.nextDouble();
						service.updateAllEmployee(salary);
						break;
				case 3: System.out.println("Enter the Employee ID: ");
						id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter the salary: ");
						salary = sc.nextDouble();
						sc.nextLine();
						service.updateEmployeeById(id, salary);
						break;
				case 4: System.out.println("Enter the Employee ID: ");
						id = sc.nextInt();
						sc.nextLine();
						service.deleteEmployee(id);
						break;
				case 5: System.out.println("Employee List: ");
						ArrayList<Employee> list = (ArrayList<Employee>) service.getAllEmployee();
						for(Employee e1 : list)
						{
							System.out.println(e1);
						}
						break;
				case 6: System.out.println("Employee ID: ");
						id = sc.nextInt();
						sc.nextLine();
						e = service.getEmployeeByID(id);
						if(e==null)
						{
							System.out.println("Could not find the employee!");
						}
						else
						{
							System.out.println(e);
						}
						break;
				case 7: flag=false;
						break;
				default: System.out.println("Invalid Option.");
						break;
			}
		}
		while(flag);
		sc.close();
		
	}

}
