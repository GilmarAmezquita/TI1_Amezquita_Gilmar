package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.RestaurantManager;

public class RestaurantManagerGUI {
	
	@FXML
    private BorderPane mainPanel;
	@FXML
    private TextField txtUsernameLogIn;
    @FXML
    private PasswordField txtPasswordLogIn;
    @FXML
    private ImageView imgLaCasaDorada;
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
    
    
    @FXML
    private GridPane showManageObjectOptions;
    
    @FXML
    private GridPane showManageCreateEmployee;
    @FXML
    private TextField txtCreateManageEmployeeName;
    @FXML
    private TextField txtCreateManageEmployeeLastname;
    @FXML
    private TextField txtCreateManageEmployeeIdentification;
    @FXML
    private GridPane showManageEmployee;
    @FXML
    private ChoiceBox<Long> txtManageEmployeeIdentification;
    @FXML
    private TextField txtManageEmployeeName;
    @FXML
    private TextField txtManageEmployeeLastname;
    @FXML
    private TextField txtManageEmployeeState;

    @FXML
    private GridPane showManageCreateUser;
    @FXML
    private GridPane showManageUser;
    
    @FXML
    private GridPane showManageCreateClient;
    @FXML
    private GridPane showManageClient;
    
    @FXML
    private GridPane showManageCreateIngredient;
    @FXML
    private GridPane showManageIngredient;
    
    @FXML
    private GridPane showManageCreateProductTypes;
    @FXML
    private GridPane showManageProductTypes;
    
    @FXML
    private BorderPane managementPane;
    
	private RestaurantManager restaurantManager;
	private boolean manageEmployee;
	private boolean manageUser;
	private boolean manageClient;
	private boolean manageIngredients;
	private boolean manageProductTypes;
	private boolean manageProducts;
	
	public void showScreenLogIn() throws IOException {
		restaurantManager.setuserLoggedNull();
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
    private void showScreenRegisterEmployee(ActionEvent event) throws IOException {
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
    }
    @FXML
    private void accountLogIn(ActionEvent event) throws IOException {
    	boolean login = false;
    	if(!txtUsernameLogIn.getText().isEmpty() && !txtPasswordLogIn.getText().isEmpty()) {
    		login = restaurantManager.userLogIn(txtUsernameLogIn.getText(), txtPasswordLogIn.getText());
    		if(login) {
    			restaurantManager.setUserLogged(txtUsernameLogIn.getText());
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
    private void selectNameSignUp(MouseEvent event) {
    	txtEmployeeNameSignUp.getItems().clear();
    	for(int i = 0; i<restaurantManager.getEmployeeList().size(); i++) {
    		if(!restaurantManager.getEmployeeList().get(i).getIfHaveUser()) {
    			txtEmployeeNameSignUp.getItems().add(restaurantManager.getEmployeeList().get(i).getName());
    		}
    	}
    	txtEmployeeLastnameSignUp.getItems().clear();
    	txtEmployeeIdentificationSignUp.getItems().clear();
    }
    @FXML
    private void selectLastnameSignUp(MouseEvent event) {
    	txtEmployeeLastnameSignUp.getItems().clear();
    	txtEmployeeIdentificationSignUp.getItems().clear();
    	String str = txtEmployeeNameSignUp.getValue();
    	for(int i = 0; i<restaurantManager.getEmployeeList().size() && str != null; i++) {
    		if(str.equals(restaurantManager.getEmployeeList().get(i).getName())) {
    			txtEmployeeLastnameSignUp.getItems().add(restaurantManager.getEmployeeList().get(i).getLastname());
    		}
    	}
    }
    @FXML
    private void selectIdentificationSignUp(MouseEvent event) {
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
    private void createNewEmployee(ActionEvent event) throws IOException {
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
    	    		showScreenRegisterAccount(null);
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
    
    private void manageOptionsDisable() {
		showManageCreateEmployee.setVisible(false);
		showManageEmployee.setVisible(false);
		showManageCreateUser.setVisible(false);
		showManageUser.setVisible(false);
		showManageCreateClient.setVisible(false);
		showManageClient.setVisible(false);
		showManageCreateIngredient.setVisible(false);
		showManageIngredient.setVisible(false);
		showManageCreateProductTypes.setVisible(false);
		showManageProductTypes.setVisible(false);
    }
    private void manageAllDisable() {
		manageEmployee = false;
		manageUser = false;
		manageClient = false;
		manageIngredients = false;
		manageProductTypes = false;
		manageProducts = false;

    	manageOptionsDisable();
    }
    
    private int objectToManage() {
    	int choice = 0;
    	if(manageEmployee) {
    		choice = 1;
    	}else if(manageUser) {
    		choice = 2;
    	}else if(manageClient) {
    		choice = 3;
    	}else if(manageIngredients) {
    		choice = 4;
    	}else if(manageProductTypes) {
    		choice = 5;
    	}else if(manageProducts) {
    		choice = 6;
    	}
    	return choice;
    }
    
    @FXML
    private void showManageCreateObject(ActionEvent event) {
    	int choice = objectToManage();
    	switch(choice) {
    		case 1:
    	    	manageOptionsDisable();
    	    	showManageCreateEmployee.setVisible(true);
    	    	break;
    		case 2:
    			manageOptionsDisable();
    			showManageCreateUser.setVisible(true);
    			break;
    		case 3:
    			manageOptionsDisable();
    			showManageCreateClient.setVisible(true);
    			break;
    		case 4:
    			manageOptionsDisable();
    			showManageCreateIngredient.setVisible(true);
    			break;
    		case 5:
    			manageOptionsDisable();
    			showManageCreateProductTypes.setVisible(true);
    			break;
    	    	/*
    			showManageCreateProducts.setVisible(true);
    			break;
    			*/
    	}
    }
    
    @FXML
    private void showManageManageObject(ActionEvent event) {
    	int choice = objectToManage();
    	switch(choice) {
    		case 1:
    	    	manageOptionsDisable();
    	    	showManageEmployee.setVisible(true);
    	    	break;
    		case 2:
    			manageOptionsDisable();
    			showManageUser.setVisible(true);
    			break;
    		case 3:
    			manageOptionsDisable();
    			showManageClient.setVisible(true);
    			break;
    		case 4:
    			manageOptionsDisable();
    			showManageIngredient.setVisible(true);
    			break;
    		case 5:
    			manageOptionsDisable();
    			showManageProductTypes.setVisible(true);
    			break;
    	    	/*
    		case 5:
    			showManageRemoveProducts.setVisible(true);
    			break;
    			*/
    	}
    }
    //Management Employee
    @FXML
    private void showManageEmployees(ActionEvent event) {
    	manageAllDisable();
    	manageEmployee = true;
    	showManageObjectOptions.setVisible(true);
    }
    @FXML
    private void manageCreateNewEmployee(ActionEvent event) throws IOException {
    	boolean created = false;
    	if(!txtCreateManageEmployeeName.getText().isEmpty() && !txtCreateManageEmployeeLastname.getText().isEmpty() && !txtCreateManageEmployeeIdentification.getText().isEmpty()) {
    		String name = txtCreateManageEmployeeName.getText();
    		String lastname = txtCreateManageEmployeeLastname.getText();
    		long identification = Long.parseLong(txtCreateManageEmployeeIdentification.getText());
    		created = restaurantManager.createEmployee(name, lastname, identification);
    		if(created) {
    			txtCreateManageEmployeeName.setText(null);
    			txtCreateManageEmployeeLastname.setText(null);
    			txtCreateManageEmployeeIdentification.setText(null);
    		}
    	}
    }
    @FXML
    private void getEmployeeInfo(ActionEvent event) {
    	if(txtManageEmployeeIdentification.getValue() != null) {
    		long identification = txtManageEmployeeIdentification.getValue();
    		int position = restaurantManager.searchEmployeeByIdentification(identification);
    		txtManageEmployeeName.setText(restaurantManager.getEmployeeList().get(position).getName());
    		txtManageEmployeeLastname.setText(restaurantManager.getEmployeeList().get(position).getLastname());
    		txtManageEmployeeState.setText((restaurantManager.getEmployeeList().get(position).getState())?"Enable":"Disable");
    	}
    }
    @FXML
    private void initializeEmployeeList(MouseEvent event) {
    	txtManageEmployeeIdentification.getItems().clear();
    	for(int i = 0; i<restaurantManager.getEmployeeList().size(); i++) {
    		long identification = restaurantManager.getEmployeeList().get(i).getIdentification();
    		if(identification != restaurantManager.getUserLogged().getIdentification()) {
    			txtManageEmployeeIdentification.getItems().add(identification);
    		}
    	}
    	txtManageEmployeeName.setText(null);
		txtManageEmployeeLastname.setText(null);
		txtManageEmployeeState.setText(null);
    }
    @FXML
    private void updateEmployeeName(ActionEvent event) {
    	if(txtManageEmployeeIdentification.getValue() != null && !txtManageEmployeeName.getText().isEmpty()) {
    		long identification = txtManageEmployeeIdentification.getValue();
    		String newName = txtManageEmployeeName.getText();
    		restaurantManager.updateEmployeeName(identification, newName);
    	}
    }
    @FXML
    private void updateEmployeeLastname(ActionEvent event) {
    	if(txtManageEmployeeIdentification.getValue() != null && !txtManageEmployeeLastname.getText().isEmpty()) {
    		long identification = txtManageEmployeeIdentification.getValue();
    		String newLastname = txtManageEmployeeLastname.getText();
    		restaurantManager.updateEmployeeLastname(identification, newLastname);
    	}
    }
    @FXML
    private void manageRemoveEmployee(ActionEvent event) {
    	if(txtManageEmployeeIdentification.getValue() != null) {
    		restaurantManager.removeEmployee(txtManageEmployeeIdentification.getValue());
    		txtManageEmployeeIdentification.setValue(null);
    		txtManageEmployeeName.setText(null);
    		txtManageEmployeeLastname.setText(null);
    		txtManageEmployeeState.setText(null);
    	}
    }
    @FXML
    private void setEmployeeDisable(ActionEvent event) {
    	if(txtManageEmployeeIdentification.getValue() != null) {
    		long identification = txtManageEmployeeIdentification.getValue();
    		restaurantManager.enableEmployee(identification);
    		txtManageEmployeeState.setText("Disable");
    	}
    }
    @FXML
    private void setEmployeeEnable(ActionEvent event) {
    	if(txtManageEmployeeIdentification.getValue() != null) {
    		long identification = txtManageEmployeeIdentification.getValue();
    		restaurantManager.disableEmployee(identification);
    		txtManageEmployeeState.setText("Enable");
    	}
    }
    
    //Management User
    @FXML
    private void showManageUsers(ActionEvent event) {
    	manageAllDisable();
    	manageUser = true;
    	showManageObjectOptions.setVisible(true);
    }
    //Management Client
    @FXML
    private void showManageClients(ActionEvent event) throws IOException {
    	manageAllDisable();
    	manageClient = true;
    	showManageObjectOptions.setVisible(true);
    }
    
    //Management Ingredients
    @FXML
    private void showManageIngredients(ActionEvent event) {
    	manageAllDisable();
    	manageIngredients = true;
    	showManageObjectOptions.setVisible(true);
    }

    //Management Product Types
    @FXML
    private void showManageProductTypes(ActionEvent event) {
    	manageAllDisable();
    	manageProductTypes= true;
    	showManageObjectOptions.setVisible(true);
    }

    //Management Products
    @FXML
    private void showManageProducts(ActionEvent event) {
    	manageAllDisable();
    	manageProducts= true;
    	showManageObjectOptions.setVisible(true);
    }

    
	public RestaurantManagerGUI(RestaurantManager rm){
		restaurantManager = rm;
		manageEmployee = false;
		manageUser = false;
		manageClient = false;
		manageIngredients = false;
		manageProductTypes = false;
		manageProducts = false;
	}
}
