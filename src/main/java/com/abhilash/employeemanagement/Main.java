package com.abhilash.employeemanagement;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n1. Add 2. View All 3. Search 4. Update 5. Delete 0. Exit");
			choice=sc.nextInt();
			
			sc.nextLine();
			
			switch(choice) {
			case 1:
				Employee e1 = new Employee();
				System.out.print("Name: ");
				e1.setName(sc.nextLine());
				System.out.println("Email: ");
				e1.setEmail(sc.nextLine());
				System.out.println("Salary: ");
				e1.setSalary(sc.nextDouble());
				dao.addEmployee(e1);
				break;
			case 2:
				List<Employee> employees=dao.getAllEmployees();
				for(Employee emp: employees) {
					System.out.println(emp.getId()+" "+emp.getName());
				}
				break;
			case 3:
				System.out.print("Enter ID: ");
				int searchID=sc.nextInt();
				Employee emp =dao.getEmployeeByID(searchID);
				if(emp!=null) {
					System.out.println(emp.getName()+", "+emp.getEmail()+", "+emp.getSalary());
				}else {
					System.out.println("Not Found.");
				}
				break;
			case 4:
				Employee e2 = new Employee();
				System.out.print("Enter the ID to be updated");
				e2.setId(sc.nextInt());
				sc.nextLine();
				System.out.print("New Name: ");
				e2.setName(sc.nextLine());
				System.out.print("New EMail: ");
				e2.setEmail(sc.nextLine());
				System.out.print("New Salary: ");
				e2.setSalary(sc.nextDouble());
				dao.UpdateEmployee(e2);
				break;
			case 5:
				System.out.println("Enter the Id to be deleted");
				int deleteID=sc.nextInt();
				dao.deleteEmployee(deleteID);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid Choice. Try Again");
				
			}
		}while(choice!=0);
		
	}

}
