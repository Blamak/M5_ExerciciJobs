package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Pepe Boss", "Direcci�n molona", "666666666", 10000.0);
		controller.createEmployee("Pedro Employee", "Direcci�n molona 2", "665266666", 1000.0);
		controller.createEmployee("Laura Employee", "Direcci�n molona 3", "625266666", 1200.0);
		controller.createVolunteer("Juan Volunteer", "Direcci�n molona 4", "614266666", "he's a very nice guy.");
		controller.createManagerEmployee("Macarena Manager", "Direcci�n molona 5", "665226666", 5000.0);
	
		controller.payAllEmployees();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES:\n\n" + allEmployees + " \n");
		
	}

}
