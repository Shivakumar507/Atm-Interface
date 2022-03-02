package atm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.atm.dao.CustomerOperation;
/**
 * Hello world!
 *
 */
public class App 
{
private static Object ob;
private static Object newPin;
private static int userType;
private static long cid;
private static String Pin;
private static long sid;

	public static void main( String[] args ) throws SQLException
	    {
	    	boolean status=true;
	    	try
	    	{
	    		do
	    		{
	        Scanner scan=new Scanner(System.in);
	        System.out.println("=======================================================================");
	        System.out.println("                   WElCOME TO THE INDIAN BANK OF ATM                   ");
	        System.out.println("=======================================================================");
	        System.out.println("1 -> Checking Account");
	        System.out.println("2 -> Saving  Account");
	        System.out.println("Enter your account type:");
	        int userType=scan.nextInt();
	        
	        if(userType==1)
	        {   
	        	System.out.println("Enter your Customer id:");
	        	int cid=scan.nextInt();
	        	System.out.println("Enter Pin:");
	        	String Pin=scan.next();
	        	CustomerOperation ob=new CustomerOperation();
	        	if(ob.login(cid,Pin))
	        	{
	        		System.out.println("=======================================================================");
	        		System.out.println("Login Successfull!!");
	        		System.out.println("=======================================================================");

	        		System.out.println("1.Withdraw\r\n"
	        				+ "2.Deposit\r\n"
	        				+ "3.Check Balance\r\n"
	        				+ "4.Fund Transfer\r\n"
	        				+ "5.Recent Transactions\r\n"
	        				+ "6.Logout");
	        		int operation=scan.nextInt();
	        		
	        		
	        		if(operation==1)
	        		{
	        					
	        			System.out.println("Enter the withdrawal amounnt:");
	        			double withdrawAmount=scan.nextDouble();      			
	        			ob.withdraw(cid, withdrawAmount);
	       			
	        		}
	        		else if(operation==2)
	        		{
	        			System.out.println("Enter deposit amount:");
	        			double depositAmount=scan.nextDouble();
	        			ob.deposit(cid, depositAmount);
	        		}
	        		else if(operation==3)
	        		{
	        			
	        			ob.balanceCheck(cid);
	        		}
	        		
	        		else if(operation==4)
	        		{
	        			
	        			System.out.println("Receiver account id:");
	            		Long rid=scan.nextLong();
	            		System.out.println("Amount:");
	            		Double amount=scan.nextDouble();
	            		
	            		System.out.println("=======================================================================");
	            		ob.fundTransfer(cid, rid, amount);
	            		System.out.println("=======================================================================");

	        		}
	        		else if(operation==5)
	        		{
	        			
	        			
	            		System.out.println("=======================================================================");
	            		ResultSet r=ob.transaction(cid);
	        			System.out.println("Transaction Id"+ "\t"+"Amount"+"\t"+"Date"+"\t"+"Receiver Id"+"\t"+"Sender Id");
	            		System.out.println("=======================================================================");

	            		while(r.next())
	            		{
	            			System.out.println(r.getLong(1)+ "\t"+r.getDouble(2)+"\t"+r.getDate(3)+"\t"+r.getLong(4)+"\t"+r.getLong(5));
	            		}
	            		System.out.println("=======================================================================");

	        		}
	        		
	        		
	        		else if(operation==6)
	        		{
	        			ob.logout();
	        			status=false;
	            		System.out.println("=======================================================================");
	        			System.out.println("Logged Out!!");
	            		System.out.println("=======================================================================");

	        		}
	        	
	        	else
	        	{
	        		System.out.println("=======================================================================");
	        		System.out.println("Wrong Id or password!!");
	        		System.out.println("=======================================================================");

	        	}
	        	}
	        }
	        else
	        {
	        	System.out.println("Please provide a valid input..!!");
	        }
	        }
	        while(status);		
	    		}
	    	
	    	catch(Exception e)
	    	{
	    		System.out.println(e.getMessage());
	    	}
	        	
	    	
	    	 Scanner scan=new Scanner(System.in);
	        	 if(userType==2)
	 	        {   
	 	        	
	 	        	System.out.println("Enter your Customer id:");
	 	        	int cid=scan.nextInt();
	 	        	System.out.println("Enter Pin:");
	 	        	String Pin=scan.next();
	 	   
	 	        	CustomerOperation ob1=new CustomerOperation();
	 	        	if(ob1.login(sid,Pin))
	 	        	{
	 	        		System.out.println("=======================================================================");
	 	        		System.out.println("Login Successfull!!");
	 	        		System.out.println("=======================================================================");

	 	        		System.out.println("1.Withdraw\r\n"
	 	        				+ "2.Deposit\r\n"
	 	        				+ "3.Check Account Balance\r\n"
	 	        				+ "4.Fund Transfer\r\n"
	 	        				+ "5.Recent Transactions\r\n"
	 	        				+ "6.Logout");
	 	        		int operation=scan.nextInt();
	 	        		
	 	        		
	 	        		if(operation==1)
	 	        		{
	 	        					
	 	        			System.out.println("Enter the withdrawal amounnt:");
	 	        			double withdrawAmount=scan.nextDouble();      			
	 	        			ob1.withdraw(sid, withdrawAmount);
	 	       			
	 	        		}
	 	        		else if(operation==2)
	 	        		{
	 	        			System.out.println("Enter deposit amount:");
	 	        			double depositAmount=scan.nextDouble();
	 	        			ob1.deposit(sid, depositAmount);
	 	        		}
	 	        		else if(operation==3)
	 	        		{
	 	        			
	 	        			ob1.balanceCheck(sid);
	 	        		}
	 	        		
	 	        		else if(operation==4)
	 	        		{
	 	        			
	 	        			System.out.println("Receiver account id:");
	 	            		Long rid=scan.nextLong();
	 	            		System.out.println("Amount:");
	 	            		Double amount=scan.nextDouble();
	 	            		
	 	            		System.out.println("=======================================================================");
	 	            		ob1.fundTransfer(sid, rid, amount);
	 	            		System.out.println("=======================================================================");

	 	        		}
	 	        		
	 	        		else if(operation==5)
	 	        		{
	 	        			
	 	        			
	 	            		System.out.println("=======================================================================");
	 	            		ResultSet r=ob1.transaction(cid);
	 	        			System.out.println("Transaction Id"+ "\t"+"Amount"+"\t"+"Date"+"\t"+"Receiver Id"+"\t"+"Sender Id");
	 	            		System.out.println("=======================================================================");

	 	            		while(r.next())
	 	            		{
	 	            			System.out.println(r.getLong(1)+ "\t"+r.getDouble(2)+"\t"+r.getDate(3)+"\t"+r.getLong(4)+"\t"+r.getLong(5));
	 	            		}
	 	            		System.out.println("=======================================================================");

	 	        		}
	 	        		
	 	        		
	 	        		else if(operation==6)
	 	        		{
	 	        			ob1.logout();
	 	        			status=false;
	 	            		System.out.println("=======================================================================");
	 	        			System.out.println("Logged Out!!");
	 	            		System.out.println("=======================================================================");

	 	        		}
	 	        	
	 	        	else
	 	        	{
	 	        		System.out.println("=======================================================================");
	 	        		System.out.println("Wrong Id or password!!");
	 	        		System.out.println("=======================================================================");

	 	        	}
	 	        	}
	        	
	        }
	        else
	        {
	        	System.out.println("Please provide a valid input..!!");
	        }
	        
	        while(status);		
	    		}
	
}
	

