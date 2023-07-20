package com.masai;

import java.util.Scanner;

import com.masai.entity.SupportRepresentative;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomethingWentWrong;
import com.masai.service.SupportService;
import com.masai.service.SupportServiceImpl;

public class SupportUI {

	public static void addCSR(Scanner sc) {
		
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter username");
		String username = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		SupportRepresentative csr = new SupportRepresentative(email, username, password,1);
		
		SupportService service = new SupportServiceImpl();
		
		try {
			service.addCSR(csr);
			System.out.println("Representative account registered successfully");
		}
		catch(DuplicateDataException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void loginCSR(Scanner sc) {
		
		System.out.println("Enter username");
		String username = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		SupportService service = new SupportServiceImpl();
		
		try {
			service.logIn(username,password);
			supportMenu(sc);
		}catch(NoRecordFound e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void supportMenu(Scanner sc) {
		
		
		
		int choice;
		
		do {
			System.out.println("press 1 to view issue");
			System.out.println("press 2 to assign issue");
			System.out.println("press 3 to Reply to issue");
			System.out.println("press 4 to Close the issue");
			System.out.println("press 5 to view feedback");
			System.out.println("press 6 to change password");
			System.out.println("press 7 to delete account");;
			System.out.println("press 8 to log_out");
			
			System.out.println("enter your choice");
			choice = sc.nextInt();
			
			
			switch (choice) {
			case 1:
				viewIssue();
				break;
			case 2:
				assignIssue(sc);
				break;
			case 3:
				replyToIssues(sc);
				break;
			case 4:
//				closeIssue(sc);
				break;
			case 5:
//                viewFeedback();
				break;
			case 6:
//				changePassword(sc);
				break;
			case 7:
//				deleteAccount(sc);
				break;
			case 8:
				System.out.println("Thankyou, visit again");
				break;
			default:
				System.out.println("Invalid input");
				
			}
			
			
		}while(choice!=0);
		
	}

	private static void viewIssue() {
		
		SupportService service = new SupportServiceImpl();
		try {
			service.viewIssue();
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void assignIssue(Scanner sc) {
		
		int choice;
		do {
			System.out.println("==============================");
			System.out.println("Press 1 to Assign to self");
			System.out.println("Press 2 to Assign to other");
			System.out.println("Press 0 to exit");
			System.out.println("==============================");
			System.out.println("Enter your choice");
			System.out.println("==============================");
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				assignToSelf();
				break;
			case 2:
				assignToOther(sc);
				break;
			case 0:
				System.out.println("Thankyou");
				break;
			default:
				System.out.println("Invalid input");
				
				
			}
			
		}while(choice!=0);
		
	}

	private static void assignToSelf() {
		
		SupportService service = new SupportServiceImpl();
		try {
			service.assignToSelf();
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("Issue assigned to self successfully");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
		}catch(SomethingWentWrong e) {
			e.getMessage();
		}
		
	}
	
	private static void assignToOther(Scanner sc) {
		System.out.println("Enter id to assign");
		int id = sc.nextInt();
		
		SupportService service = new SupportServiceImpl();
		try {
			service.assignToOther(id);
			System.out.println("Issue assigned to entered id successfully");
		}catch(SomethingWentWrong e) {
			e.getMessage();
		}
		
	}

	private static void replyToIssues(Scanner sc) {
		
		int id = 0;
		SupportService service = new SupportServiceImpl();
		
		try {
			service.replyToIssue(id,sc);
			System.out.println("Reply to the issue is submitted");
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
