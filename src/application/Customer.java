package application;
import java.sql.SQLException;
import java.util.Random;

public class Customer {
	public int cusId;
	public String fName;
	public String lName;
	public int age;
	public Account acc;
	private int creditScore;
	public int accNum;
	public String email;
	public String pass;
	Random random = new Random();
	dbconnector dbconn=new dbconnector();
	
	public Customer(String f, String l, String em, String pass) throws SQLException {
		this.fName=f;
		this.lName=l;
		this.email=em;
		this.pass=pass;
		dbconn.addCustomer(this.fName,this.lName,this.email,this.pass);
		this.cusId=dbconn.getCustomerId(email);
	}
	
	public void addAccount()throws SQLException {
		this.acc=new Account(this.cusId);
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
