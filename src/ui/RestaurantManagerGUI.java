package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.RestaurantManager;

public class RestaurantManagerGUI {
	
	@FXML
    private BorderPane mainPanel;
    
	@FXML
    private TextField txtUsernameLogIn;

    @FXML
    private PasswordField txtPasswordLogIn;
    
	private RestaurantManager restaurantManager;
	
	public void showScreenLogIn() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in-pane.fxml"));
		fxmlLoader.setController(this);
		Parent logInScreenPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
		mainPanel.setCenter(logInScreenPane);
	}
	
    @FXML
    void accountLogIn(ActionEvent event) {
    	
    }

    @FXML
    void shwoScreenRegisterAccount(ActionEvent event) {

    }
    
	public void showScreenMenuOption() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-options.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuOptionsPane = fxmlLoader.load();
    	mainPanel.setCenter(menuOptionsPane);
	}
	
	@FXML
    void showScreenClientList(ActionEvent event) {

    }

    @FXML
    void showScreenEmployeeList(ActionEvent event) {

    }

	public RestaurantManagerGUI(RestaurantManager rm){
		restaurantManager = rm;
	}
}
