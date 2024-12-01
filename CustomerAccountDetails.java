package CaseStudy;
import java.util.Random;

public abstract class CustomerAccountDetails {
	private String customerName;
    private String customerAddress;
    private String customerContactNumber;
    private String customerBirthday;
    private String customerMPIN;
    private double customerBalance;
    private String customerAccountNumber;
    
	public CustomerAccountDetails(String customerName, String customerAddress, String customerContactNumber, String customerBirthday, String customerMPIN) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContactNumber = customerContactNumber;
        this.customerBirthday = customerBirthday;
        this.customerMPIN = customerMPIN;
        this.customerBalance = 0.0; 
        this.customerAccountNumber = generateRandomAccountNumber();
    }
	
		private String generateRandomAccountNumber() {
	       
	        return "AC" + (1000 + new Random().nextInt(9000));
	    }

	    public String getCustomerMPIN() {
	        return customerMPIN;
	    }

	    public String getAccountNumber() {
	        return customerAccountNumber;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }
	    public String getCustomerAddress() {
	        return customerAddress;
	    }
	    public String getCustomeContanctNumber() {
	        return customerContactNumber;
	    }
	    public String getCustomerBirthdate() {
	        return customerBirthday;
	    }

	    public double getCustomeBalance() {
	        return customerBalance;
	    }

	    public void setCustomerBalance(double balance) {
	        this.customerBalance = balance;
	    }

	    public void displayAccountInfo() {
	    	System.out.println("-----------------------------------------------------------------------");
	        System.out.println("Account Number: " + getAccountNumber());
	        System.out.println("Account Name: " + customerName);
	        System.out.println("Customer Address: " + getCustomerAddress());
	        System.out.println("Customer Contact Number: " + getCustomeContanctNumber());
	        System.out.println("Customer Birthday: " + getCustomerBirthdate());
	        System.out.println("Balance: " + getCustomeBalance());
	        System.out.println("-----------------------------------------------------------------------");
	    }

	    public abstract void performAction();
	    
}
