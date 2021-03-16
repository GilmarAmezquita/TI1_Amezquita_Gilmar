package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import model.RestaurantManager;

public class RestaurantManagerGUI {
	
	@FXML
    private BorderPane mainPanel;
    
	@FXML
    private TextField txtUsernameLogIn;

    @FXML
    private PasswordField txtPasswordLogIn;
    
    @FXML
    private ChoiceBox<String> txtEmployeeNameSignUp;
    
    @FXML
    private ChoiceBox<String> txtEmployeeLastnameSignUp;

    @FXML
    private TextField txtUsernameSignUp;

    @FXML
    private PasswordField txtFirstPasswordSignUp;

    @FXML
    private PasswordField txtSecondPasswordSignUp;
    
	private RestaurantManager restaurantManager;
	
	public void showScreenLogIn() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in-pane.fxml"));
		fxmlLoader.setController(this);
		Parent logInScreenPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
		mainPanel.setCenter(logInScreenPane);
	}
	
    @FXML
    private void accountLogIn(ActionEvent event) throws IOException {
    	boolean login = false;
    	if(!txtUsernameLogIn.getText().isEmpty() && !txtPasswordLogIn.getText().isEmpty()) {
    		login = restaurantManager.userLogIn(txtUsernameLogIn.getText(), txtPasswordLogIn.getText());
    		if(login) {
    			showScreenMenuOption();
    		}else incorrectInformation();
    	}else missingInformation();
    	
    }
    
    private void incorrectInformation() {
    	Alert incorrectInformation = new Alert(AlertType.INFORMATION);
		incorrectInformation.setTitle("Incorrect Information");
		incorrectInformation.setHeaderText(null);
		incorrectInformation.setContentText("The username and password given are incorrect");
		incorrectInformation.showAndWait();
    }
    
    private void missingInformation(){
    	Alert missingInformation = new Alert(AlertType.INFORMATION);
		missingInformation.setTitle("Missing Information");
		missingInformation.setHeaderText(null);
		missingInformation.setContentText("There are missing information in the form.");
		missingInformation.showAndWait();
    }

    @FXML
    private void showScreenRegisterAccount(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-up-pane.fxml"));
		fxmlLoader.setController(this);
		Parent signUpScreenPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
		mainPanel.setCenter(signUpScreenPane);
		initializeChoicesBoxNameEmployeeSignUp();
    }
    
    @FXML
    private void selectNameSignUp(MouseEvent event) {
    	txtEmployeeLastnameSignUp.getItems().clear();
    }
    
    @FXML
    private void selectedNameSignUp(MouseEvent event) {
    	initializeChoiceBoxLastnameEmployeeSignUp();
    }
    
    private void initializeChoicesBoxNameEmployeeSignUp() {
    	for(int i = 0; i<restaurantManager.getEmployeeList().size(); i++) {
    		txtEmployeeNameSignUp.getItems().add(restaurantManager.getEmployeeList().get(i).getName());
    	}
    }
    
    private void initializeChoiceBoxLastnameEmployeeSignUp() {
    	txtEmployeeLastnameSignUp.getItems().clear();
    	String str = txtEmployeeNameSignUp.getValue();
	    for(int i = 0; i<restaurantManager.getEmployeeList().size() && str != null; i++) {
	       	if(str.equals(restaurantManager.getEmployeeList().get(i).getName())) {
	    		txtEmployeeLastnameSignUp.getItems().add(restaurantManager.getEmployeeList().get(i).getLastname());
	    	}
		}
    }
    
    @FXML
    private void accountSignUp(ActionEvent event) {
    	boolean create = checkForEmpty();
    	boolean created = false;
    	if(create) {
    		String name = txtEmployeeNameSignUp.getValue();
    		String lastname = txtEmployeeLastnameSignUp.getValue();
    	}
    	if(restaurantManager.searchIfEmployeeHaveUser(txtEmployeeNameSignUp.getValue(), txtEmployeeLastnameSignUp.getValue())) {
    		
    	}
    }
    
    private boolean checkForEmpty() {
    	boolean create = true;
    	Alert emptyAlert  =new Alert(AlertType.INFORMATION);
    	emptyAlert.setTitle("Missing Information");
    	emptyAlert.setHeaderText(null);
    	if(txtEmployeeNameSignUp.getValue() == null) {
    		create = false;
    		emptyAlert.setContentText("Employee's name is missing");
    		emptyAlert.showAndWait();
    	}else if(txtEmployeeLastnameSignUp.getValue()== null) {
    		create = false;
    		emptyAlert.setContentText("Employee's lastname is missing");
    		emptyAlert.showAndWait();		
    	}else if(txtUsernameSignUp.getText().isEmpty()) {
    		create = false;
    		emptyAlert.setContentText("Username is missing");
    		emptyAlert.showAndWait();
    	}else if(txtFirstPasswordSignUp.getText().isEmpty()) {
    		create = false;
    		emptyAlert.setContentText("Password is missing");
    		emptyAlert.showAndWait();
    	}else if(txtSecondPasswordSignUp.getText().isEmpty()) {
    		create = false;
    		emptyAlert.setContentText("Validate password is missing");
    		emptyAlert.showAndWait();
    	}
    	return create;
    }
    
    @FXML
    void showScreenRegisterEmployee(ActionEvent event) {

    }
    
	public void showScreenMenuOption() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-options.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuOptionsPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
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
		restaurantManager.addEmployee("Gilmar", "Amezquita", 1006351546);
		restaurantManager.addEmployee("Ana", "Romero", 1006351545);
	}
}
