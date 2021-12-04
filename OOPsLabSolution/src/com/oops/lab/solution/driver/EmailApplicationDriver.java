package com.oops.lab.solution.driver;

import java.util.Scanner;
import com.oops.lab.solution.constants.Departments;
import com.oops.lab.solution.model.Employee;
import com.oops.lab.solution.service.CredentialService;
import static com.oops.lab.solution.constants.EmailApplicationConstants.*;

public class EmailApplicationDriver {
	public static void main(String[] args) {

		Scanner inputScan = new Scanner(System.in);

		System.out.println(WELCOME_MESSAGE);
		System.out.println(FIRST_NAME);
		String firstName = inputScan.nextLine();
		System.out.println(LAST_NAME);
		String lastName = inputScan.nextLine();
		Employee employeeObject = new Employee(firstName, lastName);
		int userInput = 0;
		do {
			displayDepartments();
			userInput = inputScan.nextInt();
			String department = null;
			switch (userInput) {
			case 1:
				department = Departments.TECHNICAL.getDepartmentName();
				break;
			case 2:
				department = Departments.ADMIN.getDepartmentName();
				break;
			case 3:
				department = Departments.HUMAN_RESOURCE.getDepartmentName();
				break;
			case 4:
				department = Departments.LEGAL.getDepartmentName();
				break;
			case 5: 
				department = "";
				break;
			default:
				department = null;
				break;

			}
			if (department != null) {
				generateCredentials(employeeObject, department);
				userInput = 5;
			} else {
				System.out.println(VALID_INPUT_ERROR);
			}
		} while (userInput != 5);

		inputScan.close();
	}

	private static void generateCredentials(final Employee employeeObject, final String department) {
		CredentialService credentialService = new CredentialService();
		credentialService.generateEmailAddress(employeeObject, department);
		credentialService.generatePassword();
		System.out.println(String.format(DEAR_MESSAGE, employeeObject.getFirstName()));
		credentialService.showCredentials();
	}

	private static void displayDepartments() {
		System.out.println("Please enter the department from the following");

		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		System.out.println("5. Cancel");

	}

}
