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
    private ChoiceBox<Long> txtEmployeeIdentificationSignUp;

    @FXML
    private TextField txtUsernameSignUp;

    @FXML
    private PasswordField txtFirstPasswordSignUp;

    @FXML
    private PasswordField txtSecondPasswordSignUp;
    
    @FXML
    private TextField txtEmployeeNameNewEmployee;

    @FXML
    private TextField txtEmployeeLastnameNewEmployee;

    @FXML
    private TextField txtEmployeeIdentificationNewEmployee;
    
	private RestaurantManager restaurantManager;
	private boolean loged;
	
	public void showScreenLogIn() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in-pane.fxml"));
		fxmlLoader.setController(this);
		Parent logInScreenPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
		mainPanel.setCenter(logInScreenPane);
	}
	
	private void showScreenMenuOption() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-options.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuOptionsPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(menuOptionsPane);
	}
	
	@FXML
    void showScreenRegisterEmployee(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-employee-pane.fxml"));
		fxmlLoader.setController(this);
		Parent newEmployeePane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(newEmployeePane);
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
    private void accountLogIn(ActionEvent event) throws IOException {
    	boolean login = false;
    	if(!txtUsernameLogIn.getText().isEmpty() && !txtPasswordLogIn.getText().isEmpty()) {
    		login = restaurantManager.userLogIn(txtUsernameLogIn.getText(), txtPasswordLogIn.getText());
    		if(login) {
    			showScreenMenuOption();
    			loged = true;
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
    private void selectNameSignUp(MouseEvent event) {
    	txtEmployeeLastnameSignUp.getItems().clear();
    	txtEmployeeIdentificationSignUp.getItems().clear();
    }
    
    @FXML
    private void selectedNameSignUp(MouseEvent event) {
    	txtEmployeeLastnameSignUp.getItems().clear();
    	txtEmployeeIdentificationSignUp.getItems().clear();
    	String str = txtEmployeeNameSignUp.getValue();
    	for(int i = 0; i<restaurantManager.getEmployeeList().size() && str != null; i++) {
    		if(str.equals(restaurantManager.getEmployeeList().get(i).getName())) {
    			txtEmployeeLastnameSignUp.getItems().add(restaurantManager.getEmployeeList().get(i).getLastname());
    		}
    	}
    }
    
    private void initializeChoicesBoxNameEmployeeSignUp() {
    	for(int i = 0; i<restaurantManager.getEmployeeList().size(); i++) {
    		txtEmployeeNameSignUp.getItems().add(restaurantManager.getEmployeeList().get(i).getName());
    	}
    }    

    @FXML
    private void selectedEmployeeSignUp(MouseEvent event) {
    	txtEmployeeIdentificationSignUp.getItems().clear();
    	String name = txtEmployeeNameSignUp.getValue();
    	String lastname = txtEmployeeLastnameSignUp.getValue();
    	for(int i = 0; i<restaurantManager.getEmployeeList().size() && name!=null && lastname!=null; i++) {
    		if(name.equals(restaurantManager.getEmployeeList().get(i).getName())) {
    			if(lastname.equals(restaurantManager.getEmployeeList().get(i).getLastname())) {
    				txtEmployeeIdentificationSignUp.getItems().add(restaurantManager.getEmployeeList().get(i).getIdentification());
    			}
    		}
    	}
    }
    
    @FXML
    private void accountSignUp(ActionEvent event) throws IOException {
    	boolean create = checkForEmptySignUpUser();
    	boolean created = false;
    	if(create) {
    		String name = txtEmployeeNameSignUp.getValue();
    		String lastname = txtEmployeeLastnameSignUp.getValue();
    		long identification = txtEmployeeIdentificationSignUp.getValue();
    		String username = txtUsernameSignUp.getText();
    		String password = txtFirstPasswordSignUp.getText();
    		created = restaurantManager.createUser(name, lastname, identification, username, password);
    		alertAccount(created, 1);
    	}
    }
    
    private boolean checkForEmptySignUpUser() {
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
    	}else if(txtEmployeeIdentificationSignUp.getValue() == null) {
    		create = false;
    		emptyAlert.setContentText("Employee's identification is missing");
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
    	}else if(!txtFirstPasswordSignUp.getText().equals(txtSecondPasswordSignUp.getText())) {
    		create = false;
    		emptyAlert.setContentText("Passwords don't match");
    		emptyAlert.showAndWait();
    	}
    	return create;
    }

    @FXML
    void backScreenLogIn(ActionEvent event) throws IOException {
    	showScreenLogIn();
    	loged = false;
    }
    
    @FXML
    void backToPaneFromNewEmployee(ActionEvent event) throws IOException {
    	if(loged) {
    		showScreenMenuOption();
    	}else showScreenRegisterAccount(null);
    }
    
    @FXML
    void createNewEmployee(ActionEvent event) throws IOException {
    	boolean create = checkForEmptyNewEmployee();
    	boolean created = false;
    	if(create) {
    		String name = txtEmployeeNameNewEmployee.getText();
    		String lastname = txtEmployeeLastnameNewEmployee.getText();
    		long identification = Long.parseLong(txtEmployeeIdentificationNewEmployee.getText());
    		created = restaurantManager.createEmployee(name, lastname, identification);
    		alertAccount(created, 2);
    	}
    }
	
    private boolean checkForEmptyNewEmployee() {
    	boolean create = true;
    	Alert emptyAlert  =new Alert(AlertType.INFORMATION);
    	emptyAlert.setTitle("Missing Information");
    	emptyAlert.setHeaderText(null);
    	if(txtEmployeeNameNewEmployee.getText().isEmpty()) {
    		create = false;
    		emptyAlert.setContentText("Employee's name is missing");
    		emptyAlert.showAndWait();
    	}else if(txtEmployeeLastnameNewEmployee.getText().isEmpty()) {
    		create = false;
    		emptyAlert.setContentText("Employee's lastname is missing");
    		emptyAlert.showAndWait();		
    	}else if(txtEmployeeIdentificationNewEmployee.getText().isEmpty()) {
    		create = false;
    		emptyAlert.setContentText("Employee's identification is missing");
    		emptyAlert.showAndWait();	
    	}
    	return create;
    }
    

    private void alertAccount(boolean created, int toDo) throws IOException{
    	Alert alertCreated = new Alert(AlertType.INFORMATION);
    	alertCreated.setHeaderText(null);
    	switch(toDo) {
    		case 1:
    			if(created) {
    	    		alertCreated.setTitle("Account created");
    	    		alertCreated.setContentText("The new account has been created");
    	    		showScreenLogIn();
    	    	}else {
    	    		alertCreated.setTitle("Validation Error");
    	    		alertCreated.setContentText("Account couldn't be created");
    	    		txtUsernameSignUp.setText(null);
    	    		txtFirstPasswordSignUp.setText(null);
    	    		txtSecondPasswordSignUp.setText(null);
    	    	}
    			break;
    		case 2:
    			if(created) {
    	    		alertCreated.setTitle("Employee created");
    	    		alertCreated.setContentText("The new employee has been created");
    	    		showScreenLogIn();
    	    	}else {
    	    		alertCreated.setTitle("Validation Error");
    	    		alertCreated.setContentText("Employee couldn't be added");
    	    		txtUsernameSignUp.setText(null);
    	    		txtFirstPasswordSignUp.setText(null);
    	    		txtSecondPasswordSignUp.setText(null);
    	    	}
    			break;
    	}
    	alertCreated.showAndWait();
    }
    
    
	@FXML
    void showScreenClientList(ActionEvent event) {

    }

    @FXML
    void showScreenEmployeeList(ActionEvent event) {

    }

	public RestaurantManagerGUI(RestaurantManager rm){
		restaurantManager = rm;
		loged = false;
	}
}
