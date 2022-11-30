package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbconnector {
	public void connect() throws SQLException {
		try {
	// Establishing connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
			ResultSet rs;
			String name;
			String pass;
			String userPass="1234";
			System.out.println("Connected With the database successfully");
	//Connection completed

			String query ="SELECT * FROM users WHERE username=?";

			PreparedStatement prep=connection.prepareStatement(query);

	//setting values for the statement	
			prep.setString(1, "Dima");
	//prep.setString(3,"pass");
			rs=prep.executeQuery();
			while (rs.next()) {               // Position the cursor                  4 
				name = rs.getString(2);        // Retrieve the first column value
				pass = rs.getString(3);   
				if (pass.equals(userPass)){// Retrieve the second column value
					System.out.println("Employee name = " + name +  "pass = " + pass);
				}	else {System.out.println("login failed, name = " + name +  "pass = " + pass);}                                  // Print the column values
			}
	//System.out.println(row);
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
			} 
		}
	
	public void addCustomer(String f, String l, String em, String pass) throws SQLException {
		try {
	// Establishing connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
			
	//Connection complete
			String query ="INSERT INTO customers (fName, lName, email, pass) VALUES(?,?,?,?)";
			PreparedStatement prep=connection.prepareStatement(query);
	//setting values for the statement	
			prep.setString(1, f);
			prep.setString(2, l);
			prep.setString(3, em);
			prep.setString(4, pass);
	//prep.setString(3,"pass");
			int row = prep.executeUpdate();

            // rows affected
			System.out.println("Added customer");
	//System.out.println(row);
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
			} 
		}
	public int getCustomerId(String em) throws SQLException{
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
			ResultSet rs;
			String query ="SELECT customer_id FROM customers WHERE email=?";
			PreparedStatement prep=connection.prepareStatement(query);
			prep.setString(1, em);
			rs=prep.executeQuery();
			rs.next();
			int x=rs.getInt("customer_id");
			//String a=rs.getString(2);
			//System.out.println("Is a string "+a);
			return x;
		} catch(SQLException e) {
			System.out.println("Error while connecting to the database:EMAIL");
		}
		return 0; 
		}
	
	public int addAccount(int customerId, int accountId) throws SQLException {
		try {
			// Establishing connection
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
					
			//Connection complete
					String query ="INSERT INTO accounts (user_id) VALUES(?)";
					PreparedStatement prep=connection.prepareStatement(query);
			//setting values for the statement and adding account	
					prep.setInt(1, customerId);
					int row = prep.executeUpdate();
		            // rows affected
					System.out.println("Added account");
			//getting user id 
					ResultSet rs;
					query="SELECT acc_id FROM accounts WHERE user_id=?";
					prep=connection.prepareStatement(query);
					prep.setInt(1, customerId);
					rs=prep.executeQuery();
					rs.next();
					int x=rs.getInt("acc_id");
			//updating customer(acc_id)		
					query="UPDATE customers SET acc_id = ? WHERE customer_id=?";
					prep=connection.prepareStatement(query);
					prep.setInt(1, x);
					prep.setInt(2, customerId);
					prep.executeUpdate();
				return x;
			//System.out.println(row);
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database");
					}
		return 0;
				}
	
	
	public int addSavings(int accID) throws SQLException {
		try {
			// Establishing connection
			
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
					ResultSet rs;
			//Connection complete
					String query ="INSERT INTO savingaccs(acc_id, balance) VALUES(?,?)";
					PreparedStatement prep=connection.prepareStatement(query);
			//setting values for the statement	
					prep.setInt(1, accID);
					prep.setInt(2, 0);
					prep.executeUpdate();
					
			//Getting savings id 
					query ="SELECT saving_id FROM savingaccs WHERE acc_id=?";
					prep=connection.prepareStatement(query);
					prep.setInt(1, accID);
					rs=prep.executeQuery();
					rs.next();
					int x=rs.getInt("saving_id");
			//Updating account(saving_id)
					query="UPDATE accounts SET savings_id = ? WHERE acc_id=?";
					prep=connection.prepareStatement(query);
					prep.setInt(1, x);
					prep.setInt(2, accID);
					prep.executeUpdate();
					System.out.println("Inserted savings successfully");
					return x;
			//System.out.println(row);
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database");
					} 
		return 0;
			}
	public int addSavings(int accID, double balance) throws SQLException {
		try {
			// Establishing connection
			
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
					ResultSet rs;
			//Connection complete
					String query ="INSERT INTO savingaccs(acc_id, balance) VALUES(?,?)";
					PreparedStatement prep=connection.prepareStatement(query);
			//setting values for the statement	
					prep.setInt(1, accID);
					prep.setDouble(2, balance);
					prep.executeUpdate();
					
			//Getting savings id 
					query ="SELECT saving_id FROM savingaccs WHERE acc_id=?";
					prep.setInt(1, accID);
					rs=prep.executeQuery();
					rs.next();
					int x=rs.getInt("saving_id");
			//Updating account(saving_id)
					query="UPDATE accounts SET savings_id = ? WHERE acc_id=?";
					prep=connection.prepareStatement(query);
					prep.setInt(1, x);
					prep.setInt(2, accID);
					prep.executeUpdate();
					System.out.println("Inserted savings successfully");
					return x;
					
			//System.out.println(row);
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database");
					} 
		return 0;
			}
		
	
	public int addChecking(int accID) throws SQLException {
		try {
			// Establishing connection
			
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
					ResultSet rs;
			//Connection complete
					String query ="INSERT INTO checkingaccs(acc_id,balance) VALUES(?,?)";
					PreparedStatement prep=connection.prepareStatement(query);
			//setting values for the statement	
					prep.setInt(1, accID);
					prep.setInt(2, 0);
					prep.executeUpdate();
			//Getting savings id 
					query ="SELECT check_id FROM checkingaccs WHERE acc_id=?";
					prep=connection.prepareStatement(query);
					prep.setInt(1, accID);
					rs=prep.executeQuery();
					rs.next();
					int x=rs.getInt("check_id");
			//Updating account(saving_id)
					query="UPDATE accounts SET checking_id = ? WHERE acc_id=?";
					prep=connection.prepareStatement(query);
					prep.setInt(1, x);
					prep.setInt(2, accID);
					prep.executeUpdate();
					System.out.println("inserted checking");
					return x;
			//System.out.println(row);
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database");
					} 
		return 0;
			}
	public int addChecking(int accID, double balance) throws SQLException {
		try {
			// Establishing connection
			
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
					ResultSet rs;
			//Connection complete
					String query ="INSERT INTO checkingaccs(acc_id, balance) VALUES(?,?)";
					PreparedStatement prep=connection.prepareStatement(query);
			//setting values for the statement	
					prep.setInt(1, accID);
					prep.setDouble(2, balance);
					prep.executeUpdate();
			//Getting savings id 
					query ="SELECT check_id FROM checkingaccs WHERE acc_id=?";
					prep.setInt(1, accID);
					rs=prep.executeQuery();
					rs.next();
					int x=rs.getInt("saving_id");
			//Updating account(saving_id)
					query="UPDATE accounts SET savings_id = ? WHERE acc_id=?";
					prep=connection.prepareStatement(query);
					prep.setInt(1, x);
					prep.setInt(2, accID);
					prep.executeUpdate();
					System.out.println("inserted checking ");
					return x;
					
			//System.out.println(row);
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database");
					} 
		return 0;
			}
	
	
	public double getCheckingBalance(int acc_id) {
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
			ResultSet rs;
	//Getting checking balance
			String query;
			query ="SELECT balance FROM checkingaccs WHERE acc_id=?";
			PreparedStatement prep=connection.prepareStatement(query);
			prep.setInt(1, acc_id);
			System.out.println(prep);
			rs=prep.executeQuery();
			System.out.println("executed querry");
			double x=-1;
			while (rs.next()) {
				x=rs.getDouble("balance");
			}
	
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public double getSavingsBalance(int acc_id) {
		try {
			double x=-1;
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
			ResultSet rs;
	//Getting checking balance
			String query;
			query ="SELECT balance FROM savingaccs WHERE acc_id=?";
			PreparedStatement prep=connection.prepareStatement(query);
			prep.setInt(1, acc_id);
			rs=prep.executeQuery();
			
			while (rs.next()) {
				x=rs.getDouble("balance");
			}
	
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void addTransaction(String name,int acc_id, double amount) {
		
		try {
		//Connection complete
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
				String query ="INSERT INTO transactions (transaction_name, amount, acc_id) VALUES(?,?,?)";
				PreparedStatement prep=connection.prepareStatement(query);
		//setting values for the statement	
				prep.setString(1, name);
				prep.setInt(2, acc_id);
				prep.setDouble(3, amount);
		//prep.setString(3,"pass");
				prep.executeUpdate();

	            // rows affected
				System.out.println("Added transaction");
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
			} 
		}
	
	public void updateCheckingBalance(int acc_id, double amount) {
		try {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
		ResultSet rs;
		//get curBalance of the check_id
		double curBalance=getCheckingBalance(acc_id);
		double res=curBalance+amount;
//Connection complete
		String query ="UPDATE checkingaccs SET balance = ? WHERE acc_id=?";
		PreparedStatement prep=connection.prepareStatement(query);
		prep.setDouble(1, res);
		prep.setInt(2, acc_id);
		prep.executeUpdate();
		System.out.println("updated balance in checking ");
		
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
			} 
	}
	public void updateSavingsBalance(int acc_id, double amount) {
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
			ResultSet rs;
			double curBalance=getSavingsBalance(acc_id);
			double res=curBalance+amount;
	//Connection complete
			String query ="UPDATE savingaccs SET balance =? WHERE acc_id=?";
			PreparedStatement prep=connection.prepareStatement(query);
			prep.setDouble(1, res);
			prep.setInt(2, acc_id);
			prep.executeUpdate();
			System.out.println("updated balance in saving ");
			
			} catch (SQLException e) {
				System.out.println("Error while connecting to the database SAVINGS");
				} 
		}
	
	public int[] check(String em, String pass) {
		int[] callback=new int[]{0,0};
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnector", "root","cs380");
			ResultSet rs;
			
			boolean  bool=false;
	//Connection complete
			String query ="SELECT pass, acc_id FROM customers WHERE email=? AND pass=?";
			PreparedStatement prep=connection.prepareStatement(query);
			prep.setString(1, em);
			prep.setString(2, pass);
			
			rs=prep.executeQuery();
			System.out.println("login successful");
			while (rs.next()) {   
				System.out.println("Inside while");// Position the cursor                  4 
				String password = rs.getString(1);
				int acc_id=rs.getInt(2); 
				
				 if (pass.equals(password)){// Retrieve the second column value
					 bool=true;
					 callback[0]=1; callback[1]=acc_id;
					 System.out.println("login succeede, acc_id: "+acc_id+" and the password is ");
				 }	else {System.out.println("login failedd"); bool=false;}                                  // Print the column values
			}
			
			
			return callback;            // Position the cursor                  4 
			/*dbName = rs.getString(2);  
			if(em==dbName)return true; else return false;
			*/
			} catch (SQLException e) {
				System.out.println("Error while connecting to the database");
				}
		return callback;
	}


}


