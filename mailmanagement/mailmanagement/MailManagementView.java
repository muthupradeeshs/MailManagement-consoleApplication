package com.muthupradeesh.mailmanagement.mailmanagement;

import java.util.Scanner;

public class MailManagementView {
	public void composeNewMail(String fromId) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter To Id  : ");
		String toId = scanner.nextLine();
		System.out.print("Enetr Subject : ");
		String subject = scanner.nextLine();
		System.out.println("Enter Body Of The Message ");
		String message = scanner.nextLine();

		MailManagementViewModel mailManagementViewModel = new MailManagementViewModel();
		mailManagementViewModel.messageSending(fromId, toId, subject, message);
	}

}