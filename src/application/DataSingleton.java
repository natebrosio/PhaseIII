package application;

public class DataSingleton {
private static final DataSingleton instance = new DataSingleton();
private String userName;
private String userCheckingAcc;
private String userSavingAcc;
private int acc_id;
dbconnector db= new dbconnector();


private DataSingleton(){}

	public static DataSingleton getInstance() {
		return instance;
	}
	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}
	public void updateCheck() {
		this.userCheckingAcc= String.valueOf(db.getCheckingBalance(this.acc_id));
	}
	public void updateSaving() {
		this.userSavingAcc= String.valueOf(db.getSavingsBalance(this.acc_id));
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public String getCheck() {
		return userCheckingAcc;
	}
	public String getSav() {
		return userSavingAcc;
	}
	public void setCheck(String balance) {
		this.userCheckingAcc=balance;
	}
	public void setSav(String balance) {
		this.userSavingAcc=balance;
	}
	
}

