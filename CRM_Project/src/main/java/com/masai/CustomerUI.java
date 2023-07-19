package com.masai;

import java.util.Scanner;

import com.masai.entity.Customer;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomethingWentWrong;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;

public class CustomerUI {

	public static void addCustomer(Scanner sc) {
		
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter username");
		String username = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		Customer customer = new Customer(email, username, password, 1);
		CustomerService service = new CustomerServiceImpl();
		
		try {
			service.addCustomer(customer);
			System.out.println("Customer registered successfully");
		} catch (DuplicateDataException | SomethingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

	public static void loginCustomer(Scanner sc) {
		
		System.out.println("Enter username");
		String username = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		CustomerService service = new CustomerServiceImpl();
		
		try {
			service.logIn(username,password);
			customerMenu(sc);
		} catch (NoRecordFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	private static void customerMenu(Scanner sc) {
		// TODO Auto-generated method stub
		
		int choice;
		do {
			System.out.println("Press 1 to Raise Issue");
			System.out.println("Press 2 to view issue status");
			System.out.println("Press 3 to provide feedback");
			System.out.println("Press 4 to change password");
			System.out.println("Press 5 to log_out");
			System.out.println("Press 6 to delete account");
			
			System.out.println("enter choice");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
//				raiseIssue(sc);
				break;
			case 2:
//				viewStatus();
				break;
			case 3:
//				giveFeedback();
				break;
			case 4:
//				changePassword(sc);
				break;
			case 5:
				System.out.println("Thankyou, visit again");
				break;
			case 6:
//				deleteAcc(sc);
				break;
			default:
				System.out.println("Invalid input");
				
			}
		}while(choice!=0);
	}

}
