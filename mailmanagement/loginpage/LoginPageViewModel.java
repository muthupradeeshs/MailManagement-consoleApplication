package com.muthupradeesh.mailmanagement.loginpage;

import java.util.Map;
import java.util.Scanner;

import com.muthupradeesh.mailmanagement.dto.Mail;
import com.muthupradeesh.mailmanagement.mailmanagement.MailManagementViewModel;
import com.muthupradeesh.mailmanagement.repository.MailRepository;

public class LoginPageViewModel {

	public boolean userLogInCheck(String userId, String password) {
		if (userNameCheck(userId)) {
			if (passwordCheck(userId, password)) {
				return true;
			} else {
				System.out.println("Password Incorrect ! ");
			}
		}
		System.out.println("UserId Incorrect ! ");

		return false;

	}

	private boolean userNameCheck(String userId) {
		if (MailRepository.getDb().getUserDetails().containsKey(userId)) {
			return true;
		}
		return false;

	}

	public boolean passwordCheck(String userId, String password) {
		if (MailRepository.getDb().getUser(userId).getPassword().equals(password)) {
			return true;
		}
		return false;

	}

	public void viewSendMessage(String userId) {
		for (Map.Entry<Long, Mail> mail : MailRepository.getDb().getSendMessage(userId).entrySet()) {
			System.out.println("Message Id " + mail.getKey() + "\n from : " + mail.getValue().getFromId() + "\n To : "
					+ mail.getValue().getToId() + "\n Subject : " + mail.getValue().getSubject() + "\n Message : "
					+ mail.getValue().getMessage() + "\n ");
		}

	}

	public void viewRecivedMessage(String userId) {
		for (Map.Entry<Long, Mail> mail : MailRepository.getDb().getRecividMail(userId).entrySet()) {
			System.out.println("Message Id " + mail.getKey() + "\n from : " + mail.getValue().getFromId() + "\n To : "
					+ mail.getValue().getToId() + "\n Subject : " + mail.getValue().getSubject() + "\n Message : "
					+ mail.getValue().getMessage() + "\n ");
		}

	}

	public void deleteSendMessage(String userId) {
		Scanner scanner = new Scanner(System.in);
		viewSendMessage(userId);
		System.out.println("\n Enter Message Id ");
		long messageId = scanner.nextLong();
		deleteMessage(userId, messageId, "Send");

	}

	public void deleteReviveMessage(String userId) {
		Scanner scanner = new Scanner(System.in);
		viewRecivedMessage(userId);
		System.out.println("\n Enetr Message Id ");
		long messageId = scanner.nextLong();
		deleteMessage(userId, messageId, "Recived");
	}
	public void deleteMessage(String userId, long messageId, String type) {
		if (type.equals("Recived")) {
			MailRepository.getDb().getRecividMail(userId).remove(messageId);
		} else if (type.equals("Send")) {
			MailRepository.getDb().getSendMessage(userId).remove(messageId);
		}
	}


}
