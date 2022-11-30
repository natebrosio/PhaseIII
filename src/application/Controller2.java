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

public class Controller2 implements Initializable {
@FXML
	private Label userName;
@FXML
	private Label userCheckingAcc;
@FXML
	private Label userSavingAcc;

DataSingleton data=DataSingleton.getInstance();

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
		userName.setText("Welcome back "+data.getUserName());
		userCheckingAcc.setText("Checking account: $"+data.getCheck());
		userSavingAcc.setText("Saving account: $"+data.getSav());
}
@FXML
public void logOut(ActionEvent event)throws IOException {
	Stage stage=(Stage) userName.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("/application/LoginView.fxml"));
	stage.setTitle("login");
	stage.setScene(new Scene(root));
}
@FXML
public void checkButton(ActionEvent event)throws IOException {
	Stage stage=(Stage) userName.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("/application/checkingAcc.fxml"));
	stage.setTitle("checking account");
	stage.setScene(new Scene(root));
}
@FXML
public void savingButton(ActionEvent event)throws IOException {
	Stage stage=(Stage) userName.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("/application/savingAcc.fxml"));
	stage.setTitle("saving account");
	stage.setScene(new Scene(root));
}

}
