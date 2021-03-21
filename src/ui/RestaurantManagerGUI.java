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
    private ChoiceBox<Long> txtManageCreateUserIdentification;
    @FXML
    private ChoiceBox<String> txtManageCreateUserName;
    @FXML
    private ChoiceBox<String> txtManageCreateUserLastname;
    @FXML
    private TextField txtManageCreateUserUsername;
    @FXML
    private PasswordField txtManageCreateUserPassword;
    @FXML
    private PasswordField txtManageCreateUserRePassword;
    @FXML
    private GridPane showManageUser;
    @FXML
    private ChoiceBox<String> txtManageUsername;
    @FXML
    private TextField txtManageUserIdentification;
    @FXML
    private TextField txtManageUserName;
    @FXML
    private TextField txtManageUserLastname;
    @FXML
    private TextField txtManageUserState;
    
    
    @FXML
    private GridPane showManageCreateClient;
    @FXML
    private TextField txtManageCreateClientName;
    @FXML
    private TextField txtManageCreateClientLastname;
    @FXML
    private TextField txtManageCreateClientIdentification;
    @FXML
    private TextField txtManageCreateClientAddress;
    @FXML
    private TextField txtManageCreateClientPhone;
    @FXML
    private TextField txtManageCreateClientObservations;
    @FXML
    private GridPane showManageClient;
    @FXML
    private ChoiceBox<String> txtManageClientName;
    @FXML
    private ChoiceBox<String> txtManageClientLastname;
    @FXML
    private TextField txtManageClientIdentification;
    @FXML
    private TextField txtManageClientAddress;
    @FXML
    private TextField txtManageClientPhone;
    @FXML
    private TextField txtManageClientObservations;
    
    
    @FXML
    private GridPane showManageCreateIngredient;
    @FXML
    private TextField txtManageCreateIngredientName;
    @FXML
    private GridPane showManageIngredient;
    @FXML
    private ChoiceBox<String> txtManageIngredientName;
    @FXML
    private TextField txtManageIngredientNewName;
    @FXML
    private TextField txtManageIngredientState;
    
    
    @FXML
    private GridPane showManageCreateProductTypes;
    @FXML
    private TextField txtManageCreateProductTypeName;
    @FXML
    private GridPane showManageProductTypes;
    @FXML
    private ChoiceBox<String> txtManageProductTypeName;
    @FXML
    private TextField txtManageProductTypeNewName;
    @FXML
    private TextField txtManageProductTypeState;
    @FXML
    private TextField txtManageProductTypeUses;
    
    
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
    		if(!restaurantManager.getEmployeeList().get(i).getIfHaveUser() && restaurantManager.getEmployeeList().get(i).getState()) {
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
    @FXML
    private void getNameEmployeeList(MouseEvent event) {
    	txtManageCreateUserName.getItems().clear();
    	txtManageCreateUserLastname.getItems().clear();
    	txtManageCreateUserIdentification.getItems().clear();
    	for(int i = 0; i<restaurantManager.getEmployeeList().size(); i++) {
    		if(!restaurantManager.getEmployeeList().get(i).getIfHaveUser()) {
    			String name = restaurantManager.getEmployeeList().get(i).getName();
    			txtManageCreateUserName.getItems().add(name);
    		}
    	}
    }
    @FXML
    private void getLastnameEmployeeList(MouseEvent event) {
    	txtManageCreateUserLastname.getItems().clear();
    	txtManageCreateUserIdentification.getItems().clear();
    	if(txtManageCreateUserName.getValue() != null) {
        	String name = txtManageCreateUserName.getValue();
        	for(int i = 0; i<restaurantManager.getEmployeeList().size(); i++) {
        		if(name.equals(restaurantManager.getEmployeeList().get(i).getName())) {
        			String lastname = restaurantManager.getEmployeeList().get(i).getLastname();
        			txtManageCreateUserLastname.getItems().add(lastname);
        		}
        	}
    	}
    }
    @FXML
    private void getIdentificationEmployeeList(MouseEvent event) {
    	txtManageCreateUserIdentification.getItems().clear();
    	if(txtManageCreateUserName.getValue() != null && txtManageCreateUserLastname.getValue() != null) {
    		String name = txtManageCreateUserName.getValue();
    		String lastname = txtManageCreateUserLastname.getValue();
    		for(int i = 0; i<restaurantManager.getEmployeeList().size(); i++) {
    			if(name.equals(restaurantManager.getEmployeeList().get(i).getName())) {
    				if(lastname.equals(restaurantManager.getEmployeeList().get(i).getLastname())) {
    	    			long identification = restaurantManager.getEmployeeList().get(i).getIdentification();
    	    			txtManageCreateUserIdentification.getItems().add(identification);
    				}
    			}
    		}
    	}
    }
    @FXML
    private void manageCreateNewUser(ActionEvent event) throws IOException {
    	if(txtManageCreateUserName.getValue() != null && txtManageCreateUserLastname.getValue() != null) {
    		if(txtManageCreateUserIdentification.getValue() != null && !txtManageCreateUserUsername.getText().isEmpty()) {
    			if(!txtManageCreateUserPassword.getText().isEmpty() && !txtManageCreateUserRePassword.getText().isEmpty()) {
    				String name = txtManageCreateUserName.getValue();
    				String lastname = txtManageCreateUserLastname.getValue();
    				long identification = txtManageCreateUserIdentification.getValue();
    				String username = txtManageCreateUserUsername.getText();
    				String password = txtManageCreateUserPassword.getText();
    				if(password.equals(txtManageCreateUserRePassword.getText())) {
    					boolean created = restaurantManager.createUser(name, lastname, identification, username, password);
    					if(created) {
    						txtManageCreateUserName.setValue(null);
    						txtManageCreateUserLastname.setValue(null);
    						txtManageCreateUserIdentification.setValue(null);
    						txtManageCreateUserUsername.setText(null);
    						txtManageCreateUserPassword.setText(null);
    						txtManageCreateUserRePassword.setText(null);
    					}
    				}
    			}
    		}
    	}
    }
    @FXML
    private void initializeUserList(MouseEvent event) {
    	txtManageUsername.getItems().clear();
    	txtManageUserIdentification.setText(null);
    	txtManageUserName.setText(null);
    	txtManageUserLastname.setText(null);
    	txtManageUserState.setText(null);
    	for(int i = 0; i<restaurantManager.getUserList().size(); i++) {
    		String username = restaurantManager.getUserList().get(i).getUsername();
    		if(!username.equals(restaurantManager.getUserLogged().getUsername())){
    			txtManageUsername.getItems().add(username);
    		}
    	}
    }
    @FXML
    private void getUserInfo(ActionEvent event) {
    	if(txtManageUsername.getValue() != null) {
    		String username = txtManageUsername.getValue();
    		int position = restaurantManager.searchUserByUsername(username);
    		txtManageUserIdentification.setText(""+restaurantManager.getUserList().get(position).getIdentification());
    		txtManageUserName.setText(restaurantManager.getUserList().get(position).getName());
    		txtManageUserLastname.setText(restaurantManager.getUserList().get(position).getLastname());
    		txtManageUserState.setText((restaurantManager.getUserList().get(position).getState())?"Enable":"Disable");
    	}
    }
    @FXML
    private void updateUserName(ActionEvent event) {
    	if(!txtManageUserName.getText().isEmpty() && !txtManageUserIdentification.getText().isEmpty()) {
    		long identification = Long.parseLong(txtManageUserIdentification.getText());
    		String newName = txtManageUserName.getText();
    		restaurantManager.updateEmployeeName(identification, newName);
    	}
    }
    @FXML
    private void updateUserLastname(ActionEvent event) {
    	if(!txtManageUserLastname.getText().isEmpty() && !txtManageUserIdentification.getText().isEmpty()) {
    		long identification = Long.parseLong(txtManageUserIdentification.getText());
    		String newLastname = txtManageUserLastname.getText();
    		restaurantManager.updateEmployeeLastname(identification, newLastname);
    	}
    }
    @FXML
    private void manageRemoveUser(ActionEvent event) {
    	if(!txtManageUserIdentification.getText().isEmpty()) {
    		long identification = Long.parseLong(txtManageUserIdentification.getText());
    		restaurantManager.removeUser(identification);
    	}
    }
    @FXML
    private void setUserDisable(ActionEvent event) {
    	if(!txtManageUserIdentification.getText().isEmpty()) {
    		long identification = Long.parseLong(txtManageUserIdentification.getText());
    		restaurantManager.disableUser(identification);
    		txtManageUserState.setText("Disable");
    	}
    }
    @FXML
    private void setUserEnable(ActionEvent event) {
    	if(!txtManageUserIdentification.getText().isEmpty()) {
    		long identification = Long.parseLong(txtManageUserIdentification.getText());
    		restaurantManager.enableUser(identification);
    		txtManageUserState.setText("enable");
    	}
    }
    
    //Management Client
    @FXML
    private void showManageClients(ActionEvent event) throws IOException {
    	manageAllDisable();
    	manageClient = true;
    	showManageObjectOptions.setVisible(true);
    }
    @FXML
    private void manageCreateNewClient(ActionEvent event) {
    	if(!txtManageCreateClientName.getText().isEmpty() && !txtManageCreateClientLastname.getText().isEmpty()) {
    		if(!txtManageCreateClientAddress.getText().isEmpty() && !txtManageCreateClientPhone.getText().isEmpty()) {
    			String name = txtManageCreateClientName.getText();
    			String lastname = txtManageCreateClientLastname.getText();
    			long identification = (!txtManageCreateClientIdentification.getText().isEmpty())?Long.parseLong(txtManageCreateClientIdentification.getText()):0;
    			String address = txtManageCreateClientAddress.getText();
    			long phone = Long.parseLong(txtManageCreateClientIdentification.getText());
    			String observations = txtManageCreateClientObservations.getText();
    			restaurantManager.createClient(name, lastname, identification, address, phone, observations);
    			txtManageCreateClientName.setText(null);
    			txtManageCreateClientLastname.setText(null);
    			txtManageCreateClientIdentification.setText(null);
    			txtManageCreateClientAddress.setText(null);
    			txtManageCreateClientPhone.setText(null);
    			txtManageCreateClientObservations.setText(null);
    		}
    		
    	}
    }
    @FXML
    private void initializeClientListName(MouseEvent event) {
    	txtManageClientName.getItems().clear();
    	txtManageClientLastname.setValue(null);
    	txtManageClientIdentification.setText(null);
    	txtManageClientAddress.setText(null);
    	txtManageClientPhone.setText(null);
    	txtManageClientObservations.setText(null);
    	for(int i = 0; i<restaurantManager.getClientList().size(); i++) {
    		String name = restaurantManager.getClientList().get(i).getName();
    		txtManageClientName.getItems().add(name);
    	}
    }
    @FXML
    private void initializeClientListLastname(MouseEvent event) {
    	txtManageClientLastname.getItems().clear();
    	if(txtManageClientName.getValue() != null) {
        	txtManageClientIdentification.setText(null);
        	txtManageClientAddress.setText(null);
        	txtManageClientPhone.setText(null);
        	txtManageClientObservations.setText(null);
        	for(int i = 0; i<restaurantManager.getClientList().size(); i++) {
        		String name = txtManageClientName.getValue();
        		if(name.equals(restaurantManager.getClientList().get(i).getName())) {
        			String lastname = restaurantManager.getClientList().get(i).getLastname();
        			txtManageClientLastname.getItems().add(lastname);
        		}
        	}
    	}
    }
    @FXML
    private void getClientInfo(ActionEvent event) {
    	if(txtManageClientName.getValue() != null && txtManageClientLastname.getValue() != null) {
    		String name = txtManageClientName.getValue();
    		String lastname = txtManageClientLastname.getValue();
    		int position = restaurantManager.searchClientByName(name, lastname);
    		txtManageClientIdentification.setText(""+restaurantManager.getClientList().get(position).getIdentification());
    		txtManageClientAddress.setText(restaurantManager.getClientList().get(position).getAddress());
    		txtManageClientPhone.setText(""+restaurantManager.getClientList().get(position).getPhone());
    		txtManageClientObservations.setText(restaurantManager.getClientList().get(position).getObservations());
    	}
    }
    @FXML
    private void updateClientAddress(ActionEvent event) {
    	if(txtManageClientName.getValue() != null && txtManageClientLastname.getValue() != null && !txtManageClientAddress.getText().isEmpty()) {
    		String name = txtManageClientName.getValue();
    		String lastname = txtManageClientLastname.getValue();
    		String address = txtManageClientAddress.getText();
    		restaurantManager.updateClientAddress(name, lastname, address);
    		
    	}
    }
    @FXML
    private void updateClientPhone(ActionEvent event) {
    	if(txtManageClientName.getValue() != null && txtManageClientLastname.getValue() != null && !txtManageClientPhone.getText().isEmpty()) {
    		String name = txtManageClientName.getValue();
    		String lastname = txtManageClientLastname.getValue();
    		long phone = Long.parseLong(txtManageClientPhone.getText());
    		restaurantManager.updateClientPhone(name, lastname, phone);
    	}
    }
    @FXML
    private void updateClientObservations(ActionEvent event) {
    	if(txtManageClientName.getValue() != null && txtManageClientLastname.getValue() != null && !txtManageClientObservations.getText().isEmpty()) {
    		String name = txtManageClientName.getValue();
    		String lastname = txtManageClientLastname.getValue();
    		String observations = txtManageClientObservations.getText();
    		restaurantManager.updateClientObservations(name, lastname, observations);
    	}
    }
    @FXML
    private void manageRemoveClient(ActionEvent event) {
    	if(txtManageClientName.getValue() != null && txtManageClientLastname.getValue() != null) {
    		String name = txtManageClientName.getValue();
    		String lastname = txtManageClientLastname.getValue();
    		restaurantManager.removeClient(name, lastname);
    	}
    }
    @FXML
    private void setClientEnable(ActionEvent event) {
    	if(txtManageClientName.getValue() != null && txtManageClientLastname.getValue() != null) {
    		String name = txtManageClientName.getValue();
    		String lastname = txtManageClientLastname.getValue();
    		restaurantManager.enableClient(name, lastname);
    	}
    }
    @FXML
    private void setClientDisable(ActionEvent event) {
    	if(txtManageClientName.getValue() != null && txtManageClientLastname.getValue() != null) {
    		String name = txtManageClientName.getValue();
    		String lastname = txtManageClientLastname.getValue();
    		restaurantManager.disableClient(name, lastname);
    	}
    }
    
    //Management Ingredients
    @FXML
    private void showManageIngredients(ActionEvent event) {
    	manageAllDisable();
    	manageIngredients = true;
    	showManageObjectOptions.setVisible(true);
    }
    @FXML
    private void manageCreateNewIngredient(ActionEvent event) {
    	if(!txtManageCreateIngredientName.getText().isEmpty()) {
    		String name = txtManageCreateIngredientName.getText();
    		boolean created = restaurantManager.createIngredient(name);
    		if(created) {
    			txtManageCreateIngredientName.setText(null);
    		}
    	}
    }
    @FXML
    private void initializeIngredientList(MouseEvent event) {
    	txtManageIngredientName.getItems().clear();
		txtManageIngredientNewName.setText(null);
		txtManageIngredientState.setText(null);
    	for(int i = 0; i<restaurantManager.getIngredientList().size(); i++) {
    		String name = restaurantManager.getIngredientList().get(i).getName();
    		txtManageIngredientName.getItems().add(name);
    	}
    }
    @FXML
    private void updateIngredientName(ActionEvent event) {
    	if(txtManageIngredientName.getValue() != null && !txtManageIngredientNewName.getText().isEmpty()) {
    		String name = txtManageIngredientName.getValue();
    		String newName = txtManageIngredientNewName.getText();
    		boolean updated = restaurantManager.updateIngredientName(name, newName);
    		if(updated) {
    			txtManageIngredientName.setValue(newName);
    		}
    	}
    }
    @FXML
    private void manageRemoveIngredient(ActionEvent event) {
    	if(txtManageIngredientName.getValue() != null) {
    		String name = txtManageIngredientName.getValue();
    		boolean removed = restaurantManager.removeIngredient(name);
    		if(removed) {
    			txtManageIngredientName.setValue(null);
    			txtManageIngredientNewName.setText(null);
    			txtManageIngredientState.setText(null);
    		}
    	}
    }
    @FXML
    private void setIngredientEnable(ActionEvent event) {
    	if(txtManageIngredientName.getValue() != null) {
    		String name = txtManageIngredientName.getValue();
    		restaurantManager.enableIngredient(name);
    	}
    }
    @FXML
    private void setIngredientDisable(ActionEvent event) {
    	if(txtManageIngredientName.getValue() != null) {
    		String name = txtManageIngredientName.getValue();
    		restaurantManager.disableIngredient(name);
    	}
    }

    //Management Product Types
    @FXML
    private void showManageProductTypes(ActionEvent event) {
    	manageAllDisable();
    	manageProductTypes= true;
    	showManageObjectOptions.setVisible(true);
    }
    @FXML
    private void manageCreateNewProductTypes(ActionEvent event) {
    	if(!txtManageCreateProductTypeName.getText().isEmpty()) {
    		String name = txtManageCreateProductTypeName.getText();
    		boolean created = restaurantManager.createProductTypes(name);
    		if(created) {
    			txtManageCreateProductTypeName.setText(null);
    		}
    	}
    }
    @FXML
    private void initializeProductTypesList(MouseEvent event) {
    	txtManageProductTypeName.getItems().clear();
    	txtManageProductTypeNewName.setText(null);
    	txtManageProductTypeState.setText(null);
    	for(int i = 0; i<restaurantManager.getProductTypesList().size(); i++) {
    		String name = restaurantManager.getProductTypesList().get(i).getName();
    		txtManageProductTypeName.getItems().add(name);
    	}
    }
    @FXML
    private void getProductTypeInfo(ActionEvent event) {
    	if(txtManageProductTypeName.getValue() != null) {
    		String name = txtManageProductTypeName.getValue();
    		int position = restaurantManager.searchProductTypes(name);
    		txtManageProductTypeState.setText((restaurantManager.getProductTypesList().get(position).getState())?"Enable":"Disable");
    		txtManageProductTypeUses.setText(""+restaurantManager.getProductTypesList().get(position).getUses());
    	}
    }
    @FXML
    private void updateProductTypeName(ActionEvent event){
    	if(txtManageProductTypeName.getValue() != null && !txtManageProductTypeNewName.getText().isEmpty()) {
    		String name = txtManageProductTypeName.getValue();
    		String newName = txtManageProductTypeNewName.getText();
    		boolean updated = restaurantManager.updateProductTypesName(name, newName);
    		if(updated) {
    			txtManageProductTypeName.setValue(newName);
    		}
    	}
    }
    @FXML
    private void manageRemoveProductType(ActionEvent event) {
    	if(txtManageProductTypeName.getValue() != null) {
    		String name = txtManageProductTypeName.getValue();
    		boolean removed = restaurantManager.removeProductTypes(name);
    		if(removed) {
    			txtManageProductTypeName.setValue(null);
    			txtManageProductTypeNewName.setText(null);
    			txtManageProductTypeState.setText(null);
    			txtManageProductTypeUses.setText(null);
    		}
    	}
    }
    @FXML
    private void setProductTypeEnable(ActionEvent event) {
    	if(txtManageProductTypeName.getValue() != null) {
    		String name = txtManageProductTypeName.getValue();
    		restaurantManager.enableProductType(name);
    	}
    }
    @FXML
    private void setProductTypeDisable(ActionEvent event) {
    	if(txtManageProductTypeName.getValue() != null) {
    		String name = txtManageProductTypeName.getValue();
    		restaurantManager.disableProductTypes(name);
    	}
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
