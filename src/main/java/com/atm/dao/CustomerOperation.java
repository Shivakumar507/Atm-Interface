package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Date;
import java.util.Random;


public class CustomerOperation {
	DatabaseConnecivity ob=new DatabaseConnecivity();
	Connection conn=ob.dbConnection();
	private double withdrawAmount;
	private int affectedRows;
	private PreparedStatement ps3;
	private long cid;
	private Object changePin;
	
	public boolean login(long cid,String Pin) throws SQLException 
	{
		
		PreparedStatement ps=conn.prepareStatement("select * from Customer where c_id=? && Pin=?");
		ps.setLong(1, cid);
		ps.setString(2, Pin);
		ResultSet result=ps.executeQuery();
		
		
			if(result.next())
			{
				return true; 
			}
			else
			{
				return false;
			}
			
		
	}		
	
	
	public void withdraw(long cid,double withdrawAmount) 
	{
		try
		{
		PreparedStatement ps=conn.prepareStatement("select * from Customer where c_id=?");
		ps.setLong(1, cid);
		
		ResultSet result=ps.executeQuery();
		double availableBalance=0.0;
		
			while(result.next())
			{
				availableBalance=result.getDouble(6);
			}
			
		
		
		
		if(withdrawAmount<=availableBalance)
		{
			availableBalance=availableBalance-withdrawAmount;
			PreparedStatement ps1=conn.prepareStatement("update Customer set available_balance=? where c_id=?");
			ps1.setDouble(1, availableBalance);
			ps1.setLong(2, cid);
			ps1.executeUpdate();
			
			System.out.println("Withdrawal Successfull!!!");
			System.out.println("Remaining Balance:"+availableBalance);
			
			
			
		}
		else
		{
			System.out.println("Sufficient Balance not available!!");
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
	
	
	public void deposit(long cid,double depositAmount)
	{
		try
		{
		PreparedStatement ps=conn.prepareStatement("select * from Customer where c_id=?");
		ps.setLong(1, cid);
		
		ResultSet result=ps.executeQuery();
		double availableBalance=0.0;
		
			while(result.next())
			{
				availableBalance=result.getDouble(6);
			}
			
			availableBalance=availableBalance+depositAmount;
		
			PreparedStatement ps1=conn.prepareStatement("update Customer set available_balance=? where c_id=?");
			ps1.setDouble(1, availableBalance);
			ps1.setLong(2, cid);
			ps1.executeUpdate();
			
			System.out.println("Deposit Successfull!!!");
			System.out.println("New Balance:"+availableBalance);

			
		}
		catch(Exception e)
		{
			System.out.println("Problem in execution!!");
		}
	}
	
	
	public void balanceCheck(long uid)
	{
		try
		{
		PreparedStatement ps=conn.prepareStatement("select * from Customer where c_id=?");
		ps.setLong(1, cid);
		
		ResultSet result=ps.executeQuery();
		double availableBalance=0.0;
		
			while(result.next())
			{
				availableBalance=result.getDouble(6);
			}
		System.out.println("Available Balance:"+availableBalance);	
		}
		catch(Exception e)
		{
			System.out.println("Problem in balance check!!");
		}
	}

	
	public boolean logout() throws SQLException
	{
		conn.close();
		return true;
	}
	
	public void fundTransfer(long sid,long rid,double amount) throws SQLException
	{
		Savepoint s1=null,s2=null,s3=null;
		try
		{
			//Receiver balance updation
			conn.setAutoCommit(false);
		PreparedStatement ps=conn.prepareStatement("select * from Customer where c_id=? ");
		ps.setLong(1, rid);
		ResultSet result=ps.executeQuery();
		double receiverBalance=0.0;
		
			while(result.next())
			{
				receiverBalance=result.getDouble(6);
			}
			
			receiverBalance=receiverBalance+amount;
			 s1=conn.setSavepoint();
			PreparedStatement ps1=conn.prepareStatement("update Customer set available_balance=? where c_id=? ");
			ps1.setDouble(1, receiverBalance);
			ps1.setLong(2, rid);
			int affectedRows=ps1.executeUpdate();
			
			//Sender Account Balance Updation
			
			
			PreparedStatement ps3=conn.prepareStatement("select * from Customer where c_id=? ");
			ps3.setLong(1, sid);
			ResultSet result1=ps3.executeQuery();
			double senderBalance=0.0;
			
				while(result1.next())
				{
					senderBalance=result1.getDouble(6);
				}
				senderBalance=senderBalance-amount;
				 s2=conn.setSavepoint();
				PreparedStatement ps4=conn.prepareStatement("update Customer set available_balance=? where c_id=? ");
				ps4.setDouble(1, senderBalance);
				ps4.setLong(2, sid);
				int a=ps4.executeUpdate();
				
				
				Random r=new Random();
				long tid=r.nextInt();
				
				java.util.Date now=new java.util.Date();
				Date d=new Date(now.getDate());
				
				s3=conn.setSavepoint();
				PreparedStatement ps5=conn.prepareStatement("insert into transaction values(?,?,?,?,?) ");
				ps5.setLong(1, tid);
				ps5.setDouble(2, amount);
				ps5.setDate(3,(java.sql.Date) d);
				ps5.setLong(4, rid);
				ps5.setLong(5, sid);
				affectedRows=ps5.executeUpdate();
				
				if(affectedRows>0)
				{
					System.out.println("Transaction Successfull!!");
				}
				else
				{
					System.out.println("Transaction Failed!!");
				}
				conn.commit();
									
		}
		catch(Exception e)
		{
			conn.rollback(s1);
			conn.commit();
			System.out.println(e.getMessage());
			System.out.println("Something went wrong!!");
		}
				
		
	}
	
	public ResultSet transaction(long accId)
	{
		ResultSet result=null;
		try
		{
		PreparedStatement ps=conn.prepareStatement("select * from transaction where sender_id=? ");
		ps.setLong(1, accId);
		result=ps.executeQuery();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Something went wrong!!");
		}
		return result;
	}

	public boolean login1(long sid,String Pin) throws SQLException 
	{
		
		PreparedStatement ps=conn.prepareStatement("select * from Customer where c_id=? && Pin=?");
		ps.setLong(1, sid);
		ps.setString(2, Pin);
		ResultSet result=ps.executeQuery();
		
		
			if(result.next())
			{
				return true; 
			}
			else
			{
				return false;
			}
			
	}
}
	


	 


	
	


	


	




