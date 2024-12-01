package CaseStudy;
import java.io.IOException;
import java.util.Scanner;
public class BankUser extends  CustomerAccountDetails implements BankingSystemActions {
	
	public BankUser(String customerName, String customerAddress, String customerContactNumber, String customerBirthday, String customerMPIN) {
        super(customerName, customerAddress, customerContactNumber, customerBirthday, customerMPIN);
    }
	
	public void withdraw(double withdrawAmount) {
			if (withdrawAmount > getCustomeBalance()) {
				System.out.println("Insufficient Balance hehehe");
			}
			else {
				setCustomerBalance(getCustomeBalance() -withdrawAmount);
				System.out.println("Withdraw Amount");
			}
	}
	
	public void deposit(double depositAmount) {
		setCustomerBalance(getCustomeBalance() + depositAmount);
	}
	public void checkBalance() {
		System.out.println("your Current Balance is:" + getCustomeBalance());
	}
	public void accountDetails() {
		displayAccountInfo();
	}
	public void loan() {
		   Scanner scan = new Scanner(System.in);
		    System.out.println("Welcome to the Loan Services!");
		    System.out.print("Enter the loan amount you want to apply for: ");
		    double loanAmount = scan.nextDouble();

		    double maxLoanEligibility = getCustomeBalance() * 3; // Loan eligibility is 3x the balance
		    double interestRate = 0.05; // 5% annual interest
		    int loanTerm; // in years

		    if (loanAmount > maxLoanEligibility) {
		        System.out.println("Sorry, your loan request exceeds your eligibility. "
		                + "You can apply for a maximum loan of: " + maxLoanEligibility);
		        return;
		    }

		    System.out.print("Enter the loan term in years (1-10): ");
		    loanTerm = scan.nextInt();

		    if (loanTerm < 1 || loanTerm > 10) {
		        System.out.println("Invalid loan term. Please choose a term between 1 and 10 years.");
		        return;
		    }

		    double totalRepayment = loanAmount * Math.pow((1 + interestRate), loanTerm);
		    double monthlyRepayment = totalRepayment / (loanTerm * 12);

		    System.out.println("Loan Approved!");
		    System.out.printf("Loan Amount: %.2f%n", loanAmount);
		    System.out.printf("Loan Term: %d years%n", loanTerm);
		    System.out.printf("Annual Interest Rate: %.2f%%%n", interestRate * 100);
		    System.out.printf("Total Repayment Amount: %.2f%n", totalRepayment);
		    System.out.printf("Monthly Repayment Amount: %.2f%n", monthlyRepayment);
		
	}
	public void invest(double investmentAmount, int investmentPlan){
		
		 if (investmentAmount > getCustomeBalance()) {
		        System.out.println("Insufficient investment amount. Please check your balance first.");
		        return;
		    }
		    
		    setCustomerBalance(getCustomeBalance() - investmentAmount);
		    double annualInterestRate = 0.01; // 1% interest per year
		    double investmentResult;

		    switch (investmentPlan) {
		        case 1: // Short-term investment (1-5 years)
		            investmentResult = investmentAmount * Math.pow((1 + annualInterestRate), 5) - investmentAmount;
		            System.out.printf("Short-term plan chosen. After 5 years, you will receive: %.2f%n", investmentAmount + investmentResult);
		            break;

		        case 2: // Long-term investment (5-10 years)
		            investmentResult = investmentAmount * Math.pow((1 + annualInterestRate), 10) - investmentAmount;
		            System.out.printf("Long-term plan chosen. After 10 years, you will receive: %.2f%n", investmentAmount + investmentResult);
		            break;

		        default:
		            System.out.println("Invalid investment plan. Please choose [1] or [2].");
		            setCustomerBalance(getCustomeBalance() + investmentAmount); // Refund amount
		    }
		
	}
	
	public void performAction() {
        Scanner scan = new Scanner(System.in);
        
        while (true) {
        	System.out.println("-------------------------------------------------------");
        	System.out.println("Welcome to Banco De Bom Ba Ye " + getCustomerName().toUpperCase());
            System.out.println("");
            System.out.println("\t 1. Withdraw");
            System.out.println("\t 2. Deposit");
            System.out.println("\t 3. Loan");
            System.out.println("\t 4. Invest");
            System.out.println("\t 5. Check Balance");
            System.out.println("\t 6. Account Details");
            System.out.println("\t 7. Exit");
            System.out.println("-------------------------------------------------------");
            System.out.print("Please Choose an action: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                	System.out.println("Press 1 to continue on withdrawing");
                	System.out.println("Press 2 if you wish to go bakc to menu");
                	int withdrawChoice = scan.nextInt();
                	if (withdrawChoice == 1) {
                	System.out.println("Note:" + "\n " + "\t Please Check Your Balance First Before Withdrawing Nigga");
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scan.nextDouble();
                    withdraw(withdrawAmount);
                    System.out.print("Press any key to go back: ");
				try {
					int input = System.in.read();
					if (input != -1 && input != '\n' && input != '\r') {
						break;
					}
					
				} catch (IOException e) {
				
					e.printStackTrace();
				} 
                	} else if( withdrawChoice == 2) {
                		break;
                	}
                    
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scan.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    loan();
                    break;
                case 4:
                	System.out.println("Enter the investment plan you want to avail: ");
                	System.out.println("\t [1] short term investment (1-5years) ");
                	System.out.println("\t [2] long term investment (5-10 years)");
                	int investPlan = scan.nextInt();
                	System.out.println("Note: the investment amount thatyou will invest will be directly deducted to the current balnce you have in the system.");
                	System.out.println("Enter the amount you want to invest: ");
                	double investAmount = scan.nextDouble();
                    invest(investAmount, investPlan);
                    break;
                  
                case 5:
                	checkBalance();
                    break;
                case 6: 
                	accountDetails();
                	break;
                case 7:
                	System.out.println("Exiting.......");
                	return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
	}

	
}
