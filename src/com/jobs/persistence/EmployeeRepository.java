package com.jobs.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;

public class EmployeeRepository {
	/**
	 * To store and retrieve company members.
	 */

	private static List<AbsStaffMember> members=new ArrayList<>();
	
	public EmployeeRepository() {
		
	}
	
	// Returns a list with all the people working at the company, volunteers included.
	public List<AbsStaffMember> getAllMembers(){
		return new ArrayList<>(members);
	}
	
	// Adds a person to the members list.
	public void addMember(AbsStaffMember member) throws Exception{
		if(member==null) throw new Exception();
		members.add(member);
	}
	
	
}
