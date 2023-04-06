package testclass;
import java.util.*;
import bankapp.*;
import exceptionhandling.InvalidInputDetailsException;
import utils.ValidationRules;
/*Create Tester application : TestBanking
1.Use try-with-resources for creating scanner.
2. Accept  inputs for creating new account. 
i/ps : acct number,customer name, account type  , account balance
Validate inputs . In case of success , create the account n display it's details using toString (of BankAccount)
In case of failure , display error message , using catch-all
(centralized exc handling)
Create 2 accounts (at least)
3. Use equals method , to check if they are same or different.
4. Test withdraw n deposit methods.*/


public class TestAccount {
	//main method
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){	//try with resources
			System.out.println("Enter the no. of accounts::");
		
			BankAccount[] accounts = new BankAccount[sc.nextInt()];
			boolean exit = false;
			int counter = 0;
			while(!exit) {
				
				System.out.println("Enter your choice!!!!");
				System.out.println("1. Create a new account /// 2. Display all accounts /// 3. Deposit funds /// 4. Withdraw Funds /// 5. Exit ");
				try{
				
				switch(sc.nextInt()) {
					case 1: 
						
						if(counter < accounts.length) {
							System.out.println("Enter the account details:: 1.ACC NO 2.NAME 3.ACCTYPE 4.BALANCE");
							BankAccount b = ValidationRules.validateInputs(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),accounts);
							accounts[counter++] = b;
							System.out.println(b);
							System.out.println("Account created successfully");
						}
						else System.out.println("Can't add any more accounts!!!!");
						break;
					
					case 2: if(counter!=0) {
								for(BankAccount acc:accounts) {
							
										System.out.println(acc);

						
								}
					
							}
							else System.out.println("No accounts available to display");
							
							break;
							
					case 3:	
							System.out.println("Enter the amount to be desposited");
							double d = sc.nextDouble();
							System.out.println("Enter the account no to deposit funds");
					        BankAccount tmp = new BankAccount(sc.nextInt());
					        
					        boolean match = false;
					        for(BankAccount b1:accounts) {
					        	if(b1.getAccNo() == tmp.getAccNo()) {
					        		match = true;
					        		System.out.println("The current balance before withdrawal is:: "+b1.getAccBal());
					        		b1.setAccBal(b1.depositAmount(d));
					        		System.out.println("Amount deposited successfully!!!");
					        		System.out.println("The new balance after withdrawal is::"+b1.getAccBal());
					        	}
					        }
					        if(match == false) {
					        	System.out.println("Wrong account number entered");
					        }
					        break;
					        
					case 4: 
						
							System.out.println("Enter the amount to be withdrawed");
							double d1 = sc.nextDouble();
							System.out.println("Enter the account no to withdraw funds from");
							BankAccount tmp1 = new BankAccount(sc.nextInt());
							
							boolean flag = false;
							for(BankAccount b1:accounts) {
								if(b1!=null) {
									if(b1.getAccNo() == tmp1.getAccNo()) {
										flag = true;
										System.out.println("The current balance is:: "+b1.getAccBal());
										b1.setAccBal(b1.withdrawAmount(d1));
										System.out.println("Amount withdrawed successfully!!!");
										System.out.println("The new balance is::"+b1.getAccBal());
									}
								}
								else {
										System.out.println("No accounts are there!");
										flag = true;
								}
								
							}
							if(flag == false) {
								System.out.println("Wrong account number entered");
							}
			        
							break;
					case 5:
						exit = true;
						break;
						
					default: System.out.println("Wrong choice entered!!!");
						break;
				}}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			
			}}
		/*catch(InvalidInputDetailsException e) {
			System.out.println(e.getMessage());
		}*/
		
	}
}
