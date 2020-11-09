package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();

	public JobsController() {

	}

	// Staff members that get paid.
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee boss = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}

	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee employee = new Employee(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		Employee manager = new Employee(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);

	}

	// Make the payment for all the employees using the IPaymentRate interface (... PaymentFactory).
	public void payAllEmployees() {
		List<AbsStaffMember> allEmployees = repository.getAllMembers();
		for (AbsStaffMember emp : allEmployees) {
			emp.pay();
		}
	}

	// Get all members in a list, then return a string with all of them.  
	public String getAllEmployees() {
		String employeesString = ""; // Text to contain all employees' info.
		
		// List to contain all the employees.
		List<AbsStaffMember> allEmployees = repository.getAllMembers();
		
		// Iterate over the employees list and create the string that will show the info.
		for (AbsStaffMember emp : allEmployees) {
			employeesString += "Id: " + emp.getId() + "\n" +
							   "Name: " + emp.getName() + "\n" +
							   "Address: " + emp.getAddress() + "\n" +
							   "Phone: " + emp.getPhone() + "\n";
			
			// Add description if the member is a volunteer.
			if (emp instanceof Volunteer) {
				employeesString += "Total Salary: " + emp.getTotalPaid() +
						           " - but " + ((Volunteer) emp).description + "\n\n";
			} else {
				// Finish the text without description.
				employeesString += "Total Salary: " + emp.getTotalPaid() + "\n\n";				
			}
			
		}

		return employeesString;
	}

	// Poor wretch members, good for the company's economy.
	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);

	}

}
