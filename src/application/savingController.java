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

public class savingController implements Initializable {
@FXML
	private Label balance;


DataSingleton data=DataSingleton.getInstance();

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {

		balance.setText(data.getSav());
}
@FXML
public void logOut(ActionEvent event)throws IOException {
	Stage stage=(Stage) balance.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("/application/LoginView.fxml"));
	stage.setTitle("login");
	stage.setScene(new Scene(root));
}
@FXML
public void deposit(ActionEvent event)throws IOException {
	Stage stage=(Stage) balance.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("/application/savingDepView.fxml"));
	stage.setTitle("deposit");
	stage.setScene(new Scene(root));
}
@FXML
public void backButton(ActionEvent event)throws IOException {
	Stage stage=(Stage) balance.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("/application/userPage.fxml"));
	stage.setTitle("Personal Page");
	stage.setScene(new Scene(root));
}

}
