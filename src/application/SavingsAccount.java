package application;

import java.sql.SQLException;
import java.util.Random;

public class SavingsAccount {
	public int accId;
	public int saving_id;
	public double curBalance;
	private double interest;
	dbconnector dbconn=new dbconnector();
	
	public SavingsAccount(int accID) throws SQLException{
		 this.accId=accID;
		 this.saving_id=dbconn.addSavings(accID);
	}
	public SavingsAccount(int accID,int b) throws SQLException{
		 this.accId=accID;
		 this.saving_id=dbconn.addSavings(accID,b);
	}
public void deposit(double amount) {	 	
		dbconn.addTransaction("SavingDeposit", this.accId, amount);
		dbconn.updateSavingsBalance(this.saving_id, amount);
	}
	public int getId() {
		return saving_id;
	}
	public double getInterest() {
		return interest;
	}
	public void setId(int id) {
		this.saving_id = id;
	}
	public double getCurBalance() {
		return curBalance;
	}
	public void setCurBalance(double curBalance) {
		this.curBalance = curBalance;
	}
	
	
}
