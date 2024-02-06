package com.muthupradeesh.mailmanagement.usermanagement;

import java.util.HashMap;
import java.util.Scanner;

import com.muthupradeesh.mailmanagement.dto.Mail;
import com.muthupradeesh.mailmanagement.dto.User;
import com.muthupradeesh.mailmanagement.repository.MailRepository;

public class UserManagementView {
	Scanner scanner=new Scanner(System.in);
	public void createNewAccount() {
		   
		   System.out.print("Enter Your Name : ");
		   String name=scanner.nextLine();
		   System.out.print("Enetr Date Of Birth : ");
		   String dateOfBirth=scanner.nextLine();
		   System.out.print("Create UserId use Special character  : ");
		   String userId=scanner.nextLine();
		  
		   System.out.println("Create New Password  : ");
		   String password=scanner.nextLine();
		   System.out.println("Enter Mobile Number : ");
		   long mobileNumber=scanner.nextLong();
		   User user=new User(name,userId,password,mobileNumber,dateOfBirth);
		   MailRepository.getDb().getUserDetails().put(userId, user);
		   MailRepository.getDb().getComposeMails().put(userId, new HashMap<Long,Mail>());
		   MailRepository.getDb().getRecivedMail().put(userId,new HashMap<Long,Mail>());
		   
		   }
	}