package main;

import java.util.Scanner;

public class Runner {

	public static void goToLogin(){
		System.out.println("Go To Login");
	}
	public static void invalidLogin(){
		System.out.println("Invalid Login");
	}
	public static void validLogin(){
		System.out.println("EVENTLOGTYPE : 5");
	}
	public static void navigateScreens(){
		System.out.println("Navigating Screens");
	}
	public static void viewingAlerts(){
		System.out.println("EVENTLOGTYPE : 7");
	}
	public static void logOut(){
		System.out.println("EVENTLOGTYPE : 6");
	}
	
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		boolean loggedIn = false;
		boolean viewingAlerts = false;
        int num = 0;
        int choice = 0;
        do{
            System.out.println("--MENU--");
            System.out.println("1. Go To Login");
            System.out.println("2. View Alerts");
            System.out.println("3. Navigate Screens");
            System.out.println("4. Log Out");
            System.out.println("5. Exit");
            System.out.println("Enter choice: ");
            num = sc.nextInt();
            
            if(num == 1){
            	try{
            		if(!loggedIn){
            			goToLogin();
            			do{
            				System.out.println("--LOGIN TYPE MENU--");
            	            System.out.println("1. Invalid Login");
            	            System.out.println("2. Valid Login");
            	            System.out.println("3. Back");
            	            System.out.println("Enter choice: ");
            	            choice = sc.nextInt();
            	            
            	            if(choice == 1){
            	            	try{
            	            		if(!loggedIn){
            	            			invalidLogin();
            	            		}else{
            	                		System.out.println("Violation");
            	                		System.out.println("Tried to do an invalid login but loggedIn = " +loggedIn);
            	                	}
            	            	}catch(Exception e){
            	            		System.out.println("Not Allowed");
            	            	}
            	            }else if(choice == 2){
            	            	try{
            	            		if(!loggedIn){
            	            			validLogin();
            	            			viewingAlerts();
            	            			loggedIn = true;
            	            			viewingAlerts = true;
            	            			break;
            	            		}else{
            	                		System.out.println("Violation");
            	                		System.out.println("Tried to go do a valid login but loggedIn = " +loggedIn);
            	                	}
            	            	}catch(Exception e){
            	            		System.out.println("Not Allowed");
            	            	}
         
            	            }else if(choice == 3){
            	            	break;
            	            }else{
            	            	System.out.println("Wrong Input.");
            	            }
            				
            			}while(choice !=3);
                	}else{
                		System.out.println("Violation");
                		System.out.println("Tried to go to login but loggedIn = " +loggedIn);
                	}
            	}catch(Exception e){
            		System.out.println("Not Allowed");
            	}
            }else if(num == 2){
            	try{
            		if(loggedIn){
            			viewingAlerts();
            			viewingAlerts = true;
            		}else if(!loggedIn){
            			System.out.println("Violation");
                		System.out.println("Tried to view alerts but loggedIn = " +loggedIn);
                		System.out.println("Go to login instead");
            		}
            	}catch(Exception e){
            		System.out.println("Not Allowed");
            	}
            }else if(num == 3){
            	try{
            		if(!loggedIn){
            			navigateScreens();
            		}else if (loggedIn && viewingAlerts){
            			navigateScreens();
            			viewingAlerts = false;
            		}else{
            			navigateScreens();
            			viewingAlerts = false;
            		}
            	}catch(Exception e){
            		System.out.println("Not Allowed");
            	}
            }else if(num == 4){
            	try{
            		if(loggedIn){
            			logOut();
            			loggedIn = false;
            		}else{
            			System.out.println("Violation");
                		System.out.println("Tried to logout but loggedIn = " +loggedIn);
            		}
            	}catch(Exception e){
            		System.out.println("Not Allowed");
            	}
            }else if(num == 5){
            	break;
            }else{
                System.out.println("Wrong Input.");
            }
        }while(num != 5);
		
	}
	
}
