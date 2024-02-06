package com.muthupradeesh.mailmanagement.loginpage;

import java.util.Map;
import java.util.Scanner;

import com.muthupradeesh.mailmanagement.dto.Mail;
import com.muthupradeesh.mailmanagement.mailmanagement.MailManagementView;
import com.muthupradeesh.mailmanagement.mailmanagement.MailManagementViewModel;
import com.muthupradeesh.mailmanagement.repository.MailRepository;
import com.muthupradeesh.mailmanagement.usermanagement.UserManagementView;

public class LoginPageView {

	LoginPageViewModel loginPageViewModel;
	public void dashBoard() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("  *  Welcome To Mail Application  * ");
		System.out.println(" 1 > Login \n 2 > Create New Account \n 3 > Exit ");
		int selection = scanner.nextInt();
		switch (selection) {
		case 1:
			loginPageViewModel = new LoginPageViewModel();
			loginview();
			break;
		case 2:
			UserManagementView userManagementView=new UserManagementView();
			userManagementView.createNewAccount();
			break;
		}
		if (selection != 3) {
			dashBoard();
		}

	}

	private void loginview() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("__________________________________________________________ \n ");
		UserManagementView user = new UserManagementView();
		LoginPageViewModel loginPageViewModel = new LoginPageViewModel();
		System.out.print("Enter Mail Id : ");
		String mailId = scanner.nextLine();
		System.out.print("Enter Password : ");
		String password = scanner.nextLine();

		if (loginPageViewModel.userLogInCheck(mailId, password)) {
			menu(mailId);
		}

	}

	private void menu(String mailId) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"1 > Compose Mail\n 2 > View SendMail \n 3 > View Recived Mail \n 4 > delete SendMail\n 5 > Delect recived Mail \n 6 > Logout");
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			new MailManagementView().composeNewMail(mailId);
			break;
		case "2":
			loginPageViewModel.viewSendMessage(mailId);
			break;
		case "3":
			loginPageViewModel.viewRecivedMessage(mailId);
			break;
		case "4":
			loginPageViewModel.deleteSendMessage(mailId);
			break;
		case "5":
			loginPageViewModel.deleteReviveMessage(mailId);
			break;
		}
		if (!option.equals("6")) {
			menu(mailId);
		}
	}

}