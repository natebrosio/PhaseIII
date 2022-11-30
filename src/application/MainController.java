package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	private Stage stage;
	private Scene scene;
	private Parent root;
@FXML
	private Label sID;
@FXML
	private TextField unID;
@FXML
	private TextField passID;


DataSingleton data=DataSingleton.getInstance();

	public void Login(ActionEvent event) throws Exception {
		
		dbconnector dbconn=new dbconnector();
		String uName=unID.getText();
		String pass=passID.getText();
		
		int[]callback=dbconn.check(uName, pass);
		int acc_id=callback[1];
		String checkB=String.valueOf(dbconn.getCheckingBalance(acc_id));
		String savingB=String.valueOf(dbconn.getSavingsBalance(acc_id));
		
		if (callback[0]==1) {//if login is good
			data.setAcc_id(acc_id);
			data.setUserName(unID.getText());
			data.setCheck(checkB);
			data.setSav(savingB);
			Stage stage=(Stage) unID.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("/application/userPage.fxml"));
			stage.setTitle("userPage");
			stage.setScene(new Scene(root));
			
		/*root = FXMLLoader.load(getClass().getResource("/application/userPage.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();*/
		
		//userName.setText("Welcome "+uName);
		//userCheckingAcc.setText("checking balance: "+checkB);
		//userSavingAcc.setText("saving balance: "+savingB);
		}else{
		sID.setText("Login Failed, incorrect password");
						}
	}	
	
	public void switchToUserPage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/application/userTest.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
	public void switchToAdminPage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/application/adminPage.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	}
	
