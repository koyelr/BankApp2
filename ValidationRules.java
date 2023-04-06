package utils;
import exceptionhandling.*;
import bankapp.*;
public class ValidationRules {
	
	//constant static data members
	private static final double MIN_BAL;
	
	//static initialiser block
	static {
		MIN_BAL = 1000.0;
	}
	
	public static BankAccount validateInputs(int accNo, String name, String accType, double accBal, BankAccount[] acc) throws InvalidInputDetailsException {
		
		String type = validateAccType(accType);
		double bal = validateBalance(accBal);

		int no = validateAccNo(acc, accNo);
		return new BankAccount(no,name,type,bal);
		
	}
	//1. account balance > min balance
	public static double validateBalance(double bal) throws InvalidInputDetailsException {
		if(bal< MIN_BAL)
			throw new InvalidInputDetailsException("Minimum balance should be 1000 atleast");
		return bal;
	}
	
	//2. account type can be either : SAVING | CHECKING | LOAN | FD 

	public static String validateAccType(String accType) throws InvalidInputDetailsException{
		if(accType.equals( "FD") || accType.equals("SAVINGS") || accType.equals("LOAN") || accType.equals("CHECKING"))
			return accType;

		throw new InvalidInputDetailsException("Invalid Account Type. It could only be FD/SAVINGS/LOAN/CHECKING");
		 
		
			
	}
	public static int validateAccNo(BankAccount[] acc,int accNo) throws InvalidInputDetailsException{
		
		BankAccount tmp = new BankAccount(accNo);
		for(BankAccount b : acc) {
			if(b!=null)
				if(b.equals(tmp))
					throw new InvalidInputDetailsException("This account number already exists!!");
		
		}
		return accNo;
        
	}


}
