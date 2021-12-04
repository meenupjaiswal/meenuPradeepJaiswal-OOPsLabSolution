package com.oops.lab.solution.service;

import java.util.Random;

import com.oops.lab.solution.model.Employee;

public class CredentialService {

	private String emailAddress;
	private String password;

	public void generateEmailAddress(Employee employeeObject, String department) {
		this.emailAddress = employeeObject.getFirstName().toLowerCase().trim().replaceAll(" ", "")
				+ employeeObject.getLastName().toLowerCase().trim().replaceAll(" ", "") + "@" + department
				+ ".oopslab.com";
	}

	public void generatePassword() {
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String digits = "0123456789";
		String specialCharacters = "!#$%^&*()";
		Random rnd = new Random();
		StringBuilder password = new StringBuilder(8);
		password = password.append(lowerCase.charAt(rnd.nextInt(lowerCase.length() - 1)));
		password = password.append(upperCase.charAt(rnd.nextInt(upperCase.length() - 1)));
		password = password.append(specialCharacters.charAt(rnd.nextInt(digits.length() - 1)));
		for (int i = 0; i < 5; i++) {
			password = password.append(digits.charAt(rnd.nextInt(digits.length() - 1)));
		}
		this.password = password.toString();
	}

	public void showCredentials() {
		System.out.println("Email-----> " + emailAddress);
		System.out.println("Password-----> " + password);
	}
}