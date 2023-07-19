package com.masai;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Scanner sc = new Scanner(System.in); 
    	int choice;
    	
    	do {
    		System.out.println("press 1 to register customer");
        	System.out.println("press 2 to login customer");
        	System.out.println("press 3 to register support representative");
        	System.out.println("press 4 to login support representative");
        	System.out.println("press 0 to exit");

        	choice = sc.nextInt();
        	
        	switch(choice) {
        	case 1:
        		CustomerUI.addCustomer(sc);
        		break;
        	case 2:
        		CustomerUI.loginCustomer(sc);
        		break;
        	case 3:
        		SupportUI.addCSR(sc);
        		break;
        	case 4: 
        		SupportUI.loginCSR(sc);
        		break;
        	case 0:
        		System.out.println("Thankyou visit again");
        		break;
        	default:
        		System.out.println("Please enter valid choice");
        		
        	}
    	}while(choice!=0);
    }

	
}
