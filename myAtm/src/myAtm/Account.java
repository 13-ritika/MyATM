package myAtm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Account {

	// private variables to achieve encapsulation 
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance;
	private double savingBalance;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$' ###, ##0.00");
	
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
    public double getSavingBalance() {
		return savingBalance;
	}
    
    public double calcCheckingWithdraw(double amount) {
    	checkingBalance  = (checkingBalance - amount);
		 return checkingBalance;
	}
    public double calcSavingWithdraw(double amount) {
    	 savingBalance= (savingBalance - amount);
		return savingBalance;
	}
    public double calcCheckingDeposit(double amount) {
    	checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}
    public double calcSavingDeposit(double amount) {
    	savingBalance = (savingBalance + amount);
		return savingBalance;
	}
    
    public void getCheckingWithdrawInput() throws IOException{
    	System.out.println("\n"+ "Account balance:  "+ moneyFormat.format(checkingBalance));
    	System.out.println("Amount you want to withdraw from Checking Account: ");
    	
    	try {
    		String inStr = input.nextLine();
    		double amount = Double.parseDouble(inStr);
    	if(amount>=0 &&(checkingBalance - amount)>=0) { // a checker to ensure final balance after withdrawal is never -ve.
    		calcCheckingWithdraw(amount);
    		System.out.println("\n"+ "New Checking-Account Balance: "+ moneyFormat.format(checkingBalance));
    	}else if(amount <0) {
    		System.out.println("Please Enter Valid Amount."+ "\n");
    		getCheckingWithdrawInput() ;
    	} else {
    		System.out.println("Not Enough Funds."+ "\n");
    	}}
    catch(Exception e) {
		System.out.println("\n" + "Invalid Character(s)");
	}
    	
    }
    public void getSavingWithdrawInput()throws IOException {
    	System.out.println("\n"+ " Account balance:  "+ moneyFormat.format(savingBalance));
    	System.out.println("Amount you want to withdraw from Saving Account: ");
    	
    	try {
    		String inStr = input.nextLine();
    		double amount = Double.parseDouble(inStr);
    	if(amount>=0 && (savingBalance - amount)>=0) { // a checker to ensure final balance after withdrawal is never -ve.
    		calcSavingWithdraw(amount);
    		System.out.println("\n"+ "New Saving-Account Balance: "+ moneyFormat.format(savingBalance));
    	} else if(amount <0) {
    		System.out.println("Please Enter Valid Amount."+ "\n");
    		getSavingWithdrawInput();
    	}
    	else {
    		System.out.println("Not Enough FUNDS."+ "\n");
    	}}
    	catch(Exception e) {
    		System.out.println("\n" + "Invalid Character(s)");
    	}
    	
    }
    
    public void getCheckingDepositInput() throws IOException{
    	System.out.println("\n"+ "Account balance:  "+ moneyFormat.format(checkingBalance));
    	System.out.println("Amount you want to deposit to Checking Account: ");
    	
    	try {
    		String inStr = input.nextLine();
    		double amount = Double.parseDouble(inStr);
    	if(amount>=0) { // a checker in case  the user enters a negative value.
    		calcCheckingDeposit(amount);
    		System.out.println("\n"+ "New Checking-Account Balance: "+ moneyFormat.format(checkingBalance +amount));
    	} 
    	
    	else {
    		System.out.println("Please Enter Valid Amount."+ "\n");
    		getCheckingDepositInput();
    	}}
    	catch(Exception e) {
    		System.out.println("\n" + "Invalid Character(s)");
    	}
    	
    }
    
    public void getSavingDepositInput() throws IOException{
    	
    	System.out.println("Checking account balance:  "+ moneyFormat.format(savingBalance));
    	System.out.println("Amount you want to deposit to Saving Account: ");
    	try {
    		String inStr = input.nextLine();
    		double amount = Double.parseDouble(inStr);
    	
    	
    	if(amount>=0) { // a checker in case  the user enters a negative value.
    		calcSavingDeposit(amount);
    		System.out.println("\n"+ "New Saving-Account Balance: "+ moneyFormat.format(savingBalance + amount));
    	}
    	else {
    		System.out.println("Please Enter Valid Amount."+ "\n");
    		getSavingDepositInput();
    	}
    	}
    	catch(Exception e) {
    		System.out.println("\n" + "Invalid Character(s)");
    	}
    	
    }
}

