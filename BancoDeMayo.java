package CaseStudy;
import java.util.Scanner;

import java.util.ArrayList;
public class BancoDeMayo {
	 private static final ArrayList<BankUser> USERSLIST = new ArrayList<>();
	    private static BankUser loggedInUser = null;
	public static void main(String[] args) {
		start();
	}
	
	public static boolean validateMpin(String mpin) {
        return mpin.length() == 4 && mpin.matches("\\d{4}");
    }
	public static boolean validateName(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public static boolean validateNumber(String phoneNumber) {
        return phoneNumber.length() == 11 && phoneNumber.matches("\\d{11}");
    }
    
    
    public static void register() {
    	 String name; 
    	 String address;
    	 String contactNumber;
    	 String mpin;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        while(!validateName(name)) {
            System.out.println("Invalid name. Only alphabets are allowed.");
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            System.out.println("");
        }
        
        System.out.print("Enter your address: ");
        address = sc.nextLine();

        System.out.print("Enter your contact number: ");
        contactNumber = sc.nextLine();
        while (!validateNumber(contactNumber)) {
            System.out.println("Invalid contact Number. Only 11 numbers are allowed.");
            System.out.print("Enter your contact number: ");
            contactNumber = sc.nextLine();
            System.out.println("");
        } 

        System.out.print("Enter your birthday (dd/MM/yyyy): ");
        String birthday = sc.nextLine();
        
        System.out.print("Enter a 4-digit MPIN: ");
        mpin = sc.nextLine();
        while (!validateMpin(mpin)) {
            System.out.println("Invalid MPIN. It should be exactly 4 digits.");
            System.out.print("Enter a 4-digit MPIN: ");
            mpin = sc.nextLine();
            System.out.println("");
        }

        BankUser newUser = new BankUser(name, address, contactNumber, birthday, mpin);
        USERSLIST.add(newUser);
        System.out.println("Registration successful!");
    }
    
    public static boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your MPIN: ");
        String mpin = scanner.nextLine();

        for (BankUser user : USERSLIST) {
            if (user.getCustomerName().equals(name) && user.getCustomerMPIN().equals(mpin)) {
                loggedInUser = user;
                return true;
            }
        }

        System.out.println("Invalid login credentials.");
        return false;
    }
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        
        try {
        	  System.out.println("-------------------------------------------------------------");
              System.out.println("|\t \tWelcome to Banco De Bom Ba Ye \t \t    |");
              System.out.println("-------------------------------------------------------------");
              System.out.println("| \t [1] Continue to Bank \t \t\t \t    |");
              System.out.println("| \t [2] Exit \t \t\t \t   \t    |");
              System.out.println("-------------------------------------------------------------");
              System.out.print("What to do you want to do?: ");
              int act = scanner.nextInt();
        	if (act ==1 ) {
        		
        		while (true) {
        			System.out.println();
                    System.out.println("Welcome to the Bank");
                    System.out.println("Note: If first time running the system, please regiter first");
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.println();
                    System.out.print("What would you like to do?: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            register();
                            break;
                        case 2:
                            if (login()) {
                                System.out.println("Login successful!");
                                loggedInUser.performAction();
                            }
                            break;
                        case 3:
                            System.out.println("Exiting the Banco De Bom Ba Ye........");
                            return;
                        default:
                            System.out.println("Invalid choice.");
                    }
        	}
        } else {
        	System.out.println("Thank and visit again");
        	return;
        }
        
        }catch(Exception e) {
        	System.out.println("Nag Error Ma'am");
        }
    }

}
