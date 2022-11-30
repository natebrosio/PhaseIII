package application;

import java.sql.SQLException;

public class CheckingAccount {
	public int accId;
	public int check_id;
	public double curBalance;
	dbconnector dbconn=new dbconnector();
	
	public CheckingAccount(int accID) throws SQLException{
		 this.accId=accID;
		 this.check_id=dbconn.addChecking(accID);
		 this.curBalance=dbconn.getCheckingBalance(this.check_id);
	}
	public CheckingAccount(int accID,int b) throws SQLException{
		 this.accId=accID;
		 this.check_id=dbconn.addChecking(accID,b);
		 this.curBalance=dbconn.getCheckingBalance(accID);
	}
	public void deposit(double amount) {
		
		dbconn.addTransaction("CheckingDeposit", this.accId, amount);
		dbconn.updateCheckingBalance(this.check_id, amount);
	}
	public void update() {
		
	}
	public int getcheck_id() {
		return check_id;
	}
	public void setId(int id) {
		this.check_id = id;
	}
	public double getCurBalance() {
		return curBalance;
	}
	public void setCurBalance(double curBalance) {
		this.curBalance = curBalance;
	}
}
