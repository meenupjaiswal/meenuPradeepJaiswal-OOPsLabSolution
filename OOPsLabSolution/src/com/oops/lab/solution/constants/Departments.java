package com.oops.lab.solution.constants;

public enum Departments {
		
	TECHNICAL("tech"),
	ADMIN("admin"),
	HUMAN_RESOURCE("hr"),
	LEGAL("legal");
	
	private final String departmentName;

	private Departments(String name) {
		this.departmentName = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}
	
	
	

}
