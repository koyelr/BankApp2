package bankapp;
import exceptionhandling.InvalidInputDetailsException;
import utils.*;
/*Every Bank Account must have acct number(int) , customer name(string), account type (string) , account balance(double)
Unique ID of bank account is : account no.*/


public class BankAccount {
	//private data members
	private int accNo;
	private String name;
	private String accType;
	private double accBal;
	
	//paramterized constructor with all datamembers
	public BankAccount(int accNo, String name, String accType, double accBal) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.accType = accType;
		this.accBal = accBal;
	}

	//for wrapping class with accno
	public BankAccount(int accNo) {
		super();
		this.accNo = accNo;
	}

	//getters and setters for all the data members
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}

	//toString to display the account details
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", name=" + name + ", accType=" + accType + ", accBal=" + accBal + "]";
	}

	//overriding equals()
	@Override
	public boolean equals(Object obj) {
		//downcasting from object class to BankAccount class
		BankAccount b = (BankAccount)obj;
		
		//returns true if both the account no. are equal
		return this.accNo == b.accNo;
	
	}
	
	//deposit amount to account
	public double depositAmount(double amt) {
		
		return this.accBal+amt;
	}
	
	//withdraw double from account
	public double withdrawAmount(double amt) throws InvalidInputDetailsException {
		
		double amount = this.accBal-amt;
		if(amount < 0)
			throw new InvalidInputDetailsException("Please enter a valid withrawal amount");
		return amount;
			
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
