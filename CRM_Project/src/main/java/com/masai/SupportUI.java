package com.masai;

import java.util.Scanner;

import com.masai.entity.SupportRepresentative;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.NoRecordFound;
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
//				viewIssues();
				break;
			case 2:
//				assignIssue(sc);
				break;
			case 3:
//				replyToIssues(sc);
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

}
