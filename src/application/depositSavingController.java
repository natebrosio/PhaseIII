package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class depositSavingController implements Initializable {
dbconnector db=new dbconnector();
@FXML
	private TextField amount;
@FXML
	private Label name;

DataSingleton data=DataSingleton.getInstance();

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
		name.setText(data.getUserName());	
}
@FXML
public void logOut(ActionEvent event)throws IOException {
	
	Stage stage=(Stage) name.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("/application/LoginView.fxml"));
	stage.setTitle("login");
	stage.setScene(new Scene(root));
}
@FXML
public void depositS(ActionEvent event)throws IOException {
	db.updateSavingsBalance(data.getAcc_id(), Double.valueOf(amount.getText()));
	data.updateSaving();
	Stage stage=(Stage) name.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("/application/userPage.fxml"));
	stage.setTitle("checking account");
	stage.setScene(new Scene(root));
}



}
