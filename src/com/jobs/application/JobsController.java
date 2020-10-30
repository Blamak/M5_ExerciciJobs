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

	public void payAllEmployeers() {
		List<AbsStaffMember> allEmployees = repository.getAllMembers();
		for (AbsStaffMember emp : allEmployees) {
			emp.pay();
		}
	}

	public String getAllEmployees() {
		String employeesString = "";
		List<AbsStaffMember> allEmployees = repository.getAllMembers();
		for (AbsStaffMember emp : allEmployees) {
			if (emp instanceof Volunteer) {
				employeesString += emp.getName() + " total salary: " + emp.getTotalPaid() + " pero "
						+ ((Volunteer) emp).description + "\n";
			} else {
				employeesString += emp.getName() + " total salary: " + emp.getTotalPaid() + "\n";
			}
		}

		return employeesString;
	}

//
	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);

	}

}
