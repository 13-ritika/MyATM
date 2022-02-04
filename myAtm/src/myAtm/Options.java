package myAtm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
public class Options extends Account {  // inheritance.
	
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$' ###, ##0.00");
	HashMap<Integer,Integer> data = new HashMap<Integer,Integer>(); // to store our data entries.
	
	public void getLogin() throws IOException{
		int x = 1;
		// do while loop to continue to use our ATM app. can stop the execution after exit, to do so, just add x=2 at the end of try block 
		do {
			try {
				data.put(131313, 5678);
				data.put(313131, 3333);
				System.out.println("\n"+ "***** Welcome to ATM *****"+"\n");
				System.out.println("Enter your Customer Number: ");
				setCustomerNumber(menuInput.nextInt()); // setter method to set Customer number
				System.out.println("Enter your PIN Number");
				setPinNumber(menuInput.nextInt()); //setter method to set Pin number
				menuInput.nextLine();
				
			}
			catch( Exception e) {
				System.out.println("\n" + "Invalid Character(s)"); // occurs when we put any character except for a number
				x=2;
			}
			int cn = getCustomerNumber();
			int pn = getPinNumber();
			if(data.containsKey(cn)&& data.get(cn)==pn) {
				getAccountType(); // called if Customer id and pin are correct. Then we display our features for the account
			    x =2;
			}
			
			else
				System.out.println("\n"+ "Wrong Customer Number or Pin Number"+ "\n");
		}
		while(x==1);
	}
	
	public void getAccountType() throws IOException{

		
		System.out.println("\n"+ "Select the Account you want to access: ");
		System.out.println("Type 1 - Checking  Account");
		System.out.println("Type 2 - Savings  Account");
		System.out.println("Type 3 - Exit");
		
		try {
			
			String inStr = menuInput.nextLine();
	        int selection = Integer.parseInt(inStr);
			
		switch(selection) {  // using Switch we pick the option entered by the customer.
		case 1:
			getChecking(); // function for checking account type
			break;
			
		case 2:
			getSaving(); // function for saving account type
			break;
		
		case 3:
			System.out.println("\n"+"Thank you for using the ATM" +"\n" + "Have a nice day "+"\n");  // simple exit
			break;
		
		default: 
			System.out.println("\n"+ "Please select a VALID Type "); 
		}	}
		
		catch( Exception e) {
			
			System.out.println("\n" + "Invalid Character(s)"); // occurs when we put any character except for a number

			getAccountType();
		}
		
		
	}
	
	public void getChecking() throws IOException{
		
		try {
		System.out.println("\n"+ "Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Back");
		System.out.println("Choice:  ");
		
		
		
		String inStr = menuInput.nextLine();
        int selection = Integer.parseInt(inStr);
		
		switch(selection) {
		
		case 1:
			System.out.println("\n"+"Checking Account Balance: " + moneyFormat.format(getCheckingBalance())); 
			getChecking(); // getCheckingBalance() is in Account class. it returns a float value of the current amount present in the checking account
			break;
			
		case 2:
			getCheckingWithdrawInput(); 
			getChecking();
			break;
		
		case 3:
			getCheckingDepositInput();
			getChecking();
			break;
			
		case 4:
			getAccountType();
			break;
		
		default: 
			System.out.println("\n"+ "Please select a VALID Type ");
			getChecking();
			
		}
		}
		catch( Exception e) {
			System.out.println("\n" + "Invalid Character(s)"); // occurs when we put any character except for a number
			getChecking() ;
		} 
		
	}
	
    public void getSaving() throws IOException{
    	
		System.out.println("\n"+ "Saving Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Back");
		System.out.println("Choice:  ");
		try {
		
		String inStr = menuInput.nextLine();
        int selection = Integer.parseInt(inStr);
		switch(selection) {
		case 1:
			System.out.println("\n"+ "Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getSaving();  // getSavingBalance() is in Account class. it returns a float value of the current amount present in the saving account
			break;
			
		case 2:
			getSavingWithdrawInput();
			getSaving();
			break;
		
		case 3:
			getSavingDepositInput();
			getSaving();
			break;
			
		case 4:
			getAccountType();
			break;
		
		default: 
			System.out.println("\n"+ "Please select a VALID Type ");
			getChecking();
			
		}
    	}
    	catch( Exception e) {
			System.out.println("\n" + "Invalid Character(s)"); // occurs when we put any character except for a number
			getSaving();
		}
    	
	}

}

