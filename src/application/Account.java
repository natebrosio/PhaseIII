package application;

import java.sql.SQLException;
import java.util.Random;

public class Account {
	public int customerId;
	public int accId;
	SavingsAccount savAcc;
	CheckingAccount checkAcc;
	int[] transactions;
	Random random = new Random();
	dbconnector dbconn=new dbconnector();
	
	public Account(int cusID) throws SQLException {
		this.customerId=cusID;
		this.accId=dbconn.addAccount(this.customerId,this.accId);
		this.savAcc=new SavingsAccount(accId);
		this.checkAcc=new CheckingAccount(accId);
	}
	
}
