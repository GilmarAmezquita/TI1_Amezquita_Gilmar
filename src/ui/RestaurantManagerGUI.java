package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.Client;
import model.Employee;
import model.Ingredient;
import model.Order;
import model.OrderState;
import model.Product;
import model.ProductTypes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.RestaurantManager;
import model.User;

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
    private TableView<Employee> tvEmployeeList;
    @FXML
    private TableColumn<Employee, String> tcEmployeeName;
    @FXML
    private TableColumn<Employee, String> tcEmployeeLastname;
    @FXML
    private TableColumn<Employee, Long> tcEmployeeIdentification;
    @FXML
    private TableColumn<Employee, Integer> tcEmployeeOrders;
    @FXML
    private TableColumn<Employee, Boolean> tcEmployeeState;
    @FXML
    private TableColumn<Employee, String> tcEmployeeLastModified;
    @FXML
    private TextField txtEmployeeId;
    @FXML
    private TextField txtEmployeeLastname;
    @FXML
    private TextField txtEmployeeName;
    @FXML
    private TextField txtEmployeeState;
    
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
    private TableView<User> tvUserList;
    @FXML
    private TableColumn<User, String> tcUserUsername;
    @FXML
    private TableColumn<User, Long> tcUserIdentification;
    @FXML
    private TableColumn<User, String> tcUserLastname;
    @FXML
    private TableColumn<User, String> tcUserName;
    @FXML
    private TableColumn<User, Boolean> tcUserState;
    @FXML
    private TableColumn<User, String> tcUserLastModified;
    @FXML
    private TextField txtUserUsername;
    @FXML
    private TextField txtUserId;
    @FXML
    private TextField txtUserLastname;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtUserState;    
    
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
    private TableView<Client> tvClientList;
    @FXML
    private TableColumn<Client, String> tcClientLastname;
    @FXML
    private TableColumn<Client, String> tcClientName;
    @FXML
    private TableColumn<Client, Long> tcClientIdentification;
    @FXML
    private TableColumn<Client, Long> tcClientPhone;
    @FXML
    private TableColumn<Client, Boolean> tcClientState;
    @FXML
    private TextField txtClientId;
    @FXML
    private TextField txtClientLastname;
    @FXML
    private TextField txtClientName;
    @FXML
    private TextField txtClientState;
    @FXML
    private TextField txtClientPhone;
    @FXML
    private TextField txtClientAddress;
    @FXML
    private TextField txtClientObservations;
    
    @FXML
    private GridPane showManageCreateIngredient;
    @FXML
    private TextField txtManageCreateIngredientName;
    @FXML
    private TableView<Ingredient> tvIngredientList;
    @FXML
    private TableColumn<Ingredient, String> tcIngredientName;
    @FXML
    private TableColumn<Ingredient, Integer> tcIngredientUses;
    @FXML
    private TableColumn<Ingredient, Boolean> tcIngredientState;
    @FXML
    private TableColumn<Ingredient, String> tcIngredientLastModified;
    @FXML
    private TextField txtIngredientName;
    
    @FXML
    private GridPane showManageCreateProductTypes;
    @FXML
    private TextField txtManageCreateProductTypeName;
    @FXML
    private TableView<ProductTypes> tvProductTypeList;
    @FXML
    private TableColumn<ProductTypes, String> tcProductTypeName;
    @FXML
    private TableColumn<ProductTypes, Integer> tcProductTypeUses;
    @FXML
    private TableColumn<ProductTypes, Boolean> tcProductTypeState;
    @FXML
    private TableColumn<ProductTypes, String> tcProductTypeLastModified;
    @FXML
    private TextField txtProductTypeName;
    
    @FXML
    private GridPane showManageCreateProduct;
    @FXML
    private TextField txtManageCreateProductName;
    @FXML
    private ChoiceBox<String> txtManageCreateProductProductType;
    @FXML
    private ChoiceBox<String> txtManageCreateProductIngredients;
    @FXML
    private ChoiceBox<String> txtManageCreateProductAddIngredient;
    @FXML
    private TextField txtManageCreateProductSize;
    @FXML
    private TextField txtManageCreateProductPrice;
    @FXML
    private TableView<Product> tvProductList;
    @FXML
    private TableColumn<Product, String> tcProductName;
    @FXML
    private TableColumn<Product, Integer> tcProductOrders;
    @FXML
    private TableColumn<Product, Boolean> tcProductState;
    @FXML
    private TextField txtProductName;
    @FXML
    private TextField txtProductProductType;
    @FXML
    private ChoiceBox<String> cbProductNewProductType;
    @FXML
    private ChoiceBox<String> cbProductIngredients;
    @FXML
    private ChoiceBox<String> cbProductAddIngredient;
    @FXML
    private ChoiceBox<String> cbProductSize;
    @FXML
    private TextField txtProductSize;
    @FXML
    private TextField txtProductPrice;
    
    @FXML
    private GridPane showManageCreateOrder;
    @FXML
    private ChoiceBox<String> txtManageCreateOrderClientLn;
    @FXML
    private ChoiceBox<String> txtManageCreateOrderClientN;
    @FXML
    private ChoiceBox<String> txtManageCreateOrderProducts;
    @FXML
    private ChoiceBox<String> txtManageCreateOrderProductSizes;
    @FXML
    private ChoiceBox<Long> txtManageCreateOrderProductQuantities;
    //Ui
    @FXML
    private ChoiceBox<String> txtManageCreateOrderAddProduct;
    @FXML
    private TextField txtManageCreateOrderAddQuantity;
    @FXML
    private ChoiceBox<String> txtManageCreateOrderAddSize;
    @FXML
    private ChoiceBox<Long> txtManageCreateOrderEmployee;
    @FXML
    private TextField txtManageCreateOrderObservations;
    
    @FXML
    private TableView<Order> tvOrderList;
    @FXML
    private TableColumn<Order, Integer> tcOrderCode;
    @FXML
    private TableColumn<Order, Long> tcOrderPrice;
    @FXML
    private TableColumn<Order, OrderState> tcOrderStatus;
    @FXML
    private TableColumn<Order, String> tcOrderClientLastname;
    @FXML
    private TableColumn<Order, String> tcOrderClientName;
    @FXML
    private TableColumn<Order, String> tcOrderEmployeeLastname;
    @FXML
    private TableColumn<Order, String> tcOrderEmployeeName;
    @FXML
    private TextField txtOrderCode;
    @FXML
    private TextField txtOrderObservations;
    @FXML
    private TextField txtOrderState;
    
    @FXML
    private BorderPane managementPane;
    
	private RestaurantManager restaurantManager;
    private int indexSelection;
	private boolean manageEmployee;
	private boolean manageUser;
	private boolean manageClient;
	private boolean manageIngredients;
	private boolean manageProductTypes;
	private boolean manageProducts;
	
	 public RestaurantManagerGUI(RestaurantManager rm){
			restaurantManager = rm;
			indexSelection = -1;
			manageEmployee = false;
			manageUser = false;
			manageClient = false;
			manageIngredients = false;
			manageProductTypes = false;
			manageProducts = false;
			manageOrders = false;
	 }
	
	private boolean manageOrders;
	
	public void showScreenLogIn() throws IOException {
		restaurantManager.setuserLoggedNull();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in-pane.fxml"));
		fxmlLoader.setController(this);
		Parent logInScreenPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
		mainPanel.setCenter(logInScreenPane);
	}
	@FXML
	private void showScreenMenuOption(ActionEvent event) throws IOException {
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
    			showScreenMenuOption(null);
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
		showManageCreateUser.setVisible(false);
		showManageCreateClient.setVisible(false);
		showManageCreateIngredient.setVisible(false);
		showManageCreateProductTypes.setVisible(false);
		showManageCreateProduct.setVisible(false);
		showManageCreateOrder.setVisible(false);
    }
    private void manageAllDisable() {
		manageEmployee = false;
		manageUser = false;
		manageClient = false;
		manageIngredients = false;
		manageProductTypes = false;
		manageProducts = false;
		manageOrders = false;

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
    	}else if(manageOrders) {
    		choice = 7;
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
    		case 6:
    			manageOptionsDisable();
    			showManageCreateProduct.setVisible(true);
    			break;
    		case 7:
    			manageOptionsDisable();
    			showManageCreateOrder.setVisible(true);
    			break;
    	}
    }
    @FXML
    private void showManageManageObject(ActionEvent event) throws IOException {
    	int choice = objectToManage();
    	switch(choice) {
    		case 1:
    	    	manageOptionsDisable();
    	    	loadEmployeeList(null);
    	    	break;
    		case 2:
    			manageOptionsDisable();
    			loadUserList(null);
    			break;
    		case 3:
    			manageOptionsDisable();
    			loadClientList(null);
    			break;
    		case 4:
    			manageOptionsDisable();
    			loadIngredientList(null);
    			break;
    		case 5:
    			manageOptionsDisable();
    			loadProductTypeList(null);
    			break;
    		case 6:
    			manageOptionsDisable();
    			loadProductList(null);
    			break;
    		case 7:
    			manageOptionsDisable();
    			loadOrderList(null);
    			break;
    	}
    }
    
    @FXML
    private void showManageEmployees(ActionEvent event) throws IOException {
    	manageAllDisable();
    	manageEmployee = true;
    	showScreenMenuOption(null);
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
    private void loadEmployeeList(ActionEvent event) throws IOException {
    	indexSelection = -1;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employee-table-view-pane.fxml"));
    	fxmlLoader.setController(this);
    	Parent employeeList = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(employeeList);
    	initializeEmployeeTableView();
    }
    private void initializeEmployeeTableView() {
    	ObservableList<Employee> observableList;
    	observableList = FXCollections.observableArrayList(restaurantManager.getEmployeeList());
		tvEmployeeList.setItems(observableList);
		tcEmployeeName.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
		tcEmployeeLastname.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastname")); 
		tcEmployeeIdentification.setCellValueFactory(new PropertyValueFactory<Employee,Long>("identification"));
		tcEmployeeOrders.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("orders"));
		tcEmployeeState.setCellValueFactory(new PropertyValueFactory<Employee, Boolean>("state"));
		tcEmployeeLastModified.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastEditorName"));
    }
    @FXML
    private void getEmployeeSelected(MouseEvent event) {
    	indexSelection = tvEmployeeList.getSelectionModel().getSelectedIndex();
    	if(indexSelection <= -1) {
    		return;
    	}
    	txtEmployeeId.setText(tcEmployeeIdentification.getCellData(indexSelection).toString());
    	txtEmployeeLastname.setText(tcEmployeeLastname.getCellData(indexSelection));
    	txtEmployeeName.setText(tcEmployeeName.getCellData(indexSelection));
    	txtEmployeeState.setText((tcEmployeeState.getCellData(indexSelection))?"Enable":"Disable");
    }
    @FXML
    private void updateEmployee(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtEmployeeId.getText().isEmpty() && !txtEmployeeName.getText().isEmpty() && !txtEmployeeLastname.getText().isEmpty()) {
    		long identification = tcEmployeeIdentification.getCellData(indexSelection);
    		long newId = Long.parseLong(txtEmployeeId.getText());
    		String newName = txtEmployeeName.getText();
    		String newLastname = txtEmployeeLastname.getText();
    		boolean updated = restaurantManager.updateEmployee(identification, newId, newName, newLastname);
    		Alert updateEmployee = new Alert(AlertType.INFORMATION);
    		updateEmployee.setTitle("Actualizar empleado");
    		if(updated) {
        		loadEmployeeList(null);
        		updateEmployee.setHeaderText(null);
        		updateEmployee.setContentText("La información del empleado se ha actualizado");
        	}else {
        		updateEmployee.setHeaderText("No se pudo actualizar");
        		updateEmployee.setContentText("Puede que:\n1. El empleado está logeado\n2. Ya existe un empleado diferente con el nuevo Id");
        	}
    		updateEmployee.showAndWait();
    	}
    }
    @FXML
    private void enableEmployee(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtEmployeeId.getText().isEmpty()) {
    		long identification = Long.parseLong(txtEmployeeId.getText());
    		restaurantManager.enableEmployee(identification);
    		Alert enableEmployee = new Alert(AlertType.INFORMATION);
    		enableEmployee.setHeaderText(null);
    		enableEmployee.setTitle("Estado de empleado");
    		enableEmployee.setContentText("El estado del empleado ahora es: habilitado");
    		enableEmployee.showAndWait();
    		loadEmployeeList(null);
    	}
    }
    @FXML
    private void disableEmployee(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtEmployeeId.getText().isEmpty()) {
    		long identification = Long.parseLong(txtEmployeeId.getText());
    		boolean disabled = restaurantManager.disableEmployee(identification);
    		Alert disableEmployee = new Alert(AlertType.INFORMATION);
    		disableEmployee.setTitle("Estado de empleado");
    		if(disabled) {
    			loadEmployeeList(null);
    			disableEmployee.setHeaderText(null);
        		disableEmployee.setContentText("El estado del empleado ahora es: deshabilitado");
    		}else {
    			disableEmployee.setHeaderText("No se pudo deshabilitar");
        		disableEmployee.setContentText("El estado del empleado no pudo ser modificado debido a que:\n- El empleado se encuentra logeado");
    		}
    		disableEmployee.showAndWait();
    	}
    }
    @FXML
    private void removeEmployee(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtEmployeeId.getText().isEmpty()) {
    		long identification = Long.parseLong(txtEmployeeId.getText());
    		boolean removed = restaurantManager.removeEmployee(identification);
    		Alert removeEmployee = new Alert(AlertType.INFORMATION);
			removeEmployee.setTitle("Eliminar empleado");
    		if(removed) {
    			loadEmployeeList(null);
    			removeEmployee.setHeaderText(null);
    			removeEmployee.setContentText("El empleado ha sido eliminado");
    		}else {
    			removeEmployee.setHeaderText("No se pudo eliminar");
    			removeEmployee.setContentText("El empleado no pudo eliminarse debido a que:\n- El empleado se encuentra logeado");
    		}
    		removeEmployee.showAndWait();
    	}
    }
    
    @FXML
    private void showManageUsers(ActionEvent event) throws IOException {
    	manageAllDisable();
    	manageUser = true;
    	showScreenMenuOption(null);
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
    private void loadUserList(ActionEvent event) throws IOException {
    	indexSelection = -1;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("user-table-view-pane.fxml"));
    	fxmlLoader.setController(this);
    	Parent userList = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(userList);
    	initializeUserTableView();
    }
    private void initializeUserTableView() {
    	ObservableList<User> observableList;
    	observableList = FXCollections.observableArrayList(restaurantManager.getUserList());
    	tvUserList.setItems(observableList);
    	tcUserUsername.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
    	tcUserIdentification.setCellValueFactory(new PropertyValueFactory<User, Long>("identification"));
    	tcUserLastname.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
    	tcUserName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
    	tcUserState.setCellValueFactory(new PropertyValueFactory<User, Boolean>("state"));
    	tcUserLastModified.setCellValueFactory(new PropertyValueFactory<User, String>("lastEditorName"));
    }
    @FXML
    private void getUserSelected(MouseEvent event) {
    	indexSelection = tvUserList.getSelectionModel().getSelectedIndex();
    	if(indexSelection <= -1) {
    		return;
    	}
    	txtUserUsername.setText(tcUserUsername.getCellData(indexSelection));
    	txtUserId.setText(tcUserIdentification.getCellData(indexSelection).toString());
    	txtUserLastname.setText(tcUserLastname.getCellData(indexSelection));
    	txtUserName.setText(tcUserName.getCellData(indexSelection));
    	txtUserState.setText((tcUserState.getCellData(indexSelection))?"Enable":"Disable");
    }
    @FXML
    private void updateUser(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtUserUsername.getText().isEmpty() && !txtUserId.getText().isEmpty()) {
    		if(!txtUserLastname.getText().isEmpty() && !txtUserName.getText().isEmpty()) {
    			String username = tcUserUsername.getCellData(indexSelection);
    			long identification = tcUserIdentification.getCellData(indexSelection);
    			long newId = Long.parseLong(txtUserId.getText());
        		String newName = txtUserName.getText();
        		String newLastname = txtUserLastname.getText();
        		boolean updated = restaurantManager.updateUser(username, identification, newId, newName, newLastname);
        		Alert updateUser = new Alert(AlertType.INFORMATION);
        		updateUser.setTitle("Actualizar usuario");
        		if(updated) {
        			loadUserList(null);
            		updateUser.setHeaderText(null);
            		updateUser.setContentText("La información del usuario se ha actualizado");
        		}else {
        			updateUser.setHeaderText("No se pudo actualizar la información");
            		updateUser.setContentText("Puede que:\n1. El usuario está logeado\n2. Ya existe un usuario diferente con el nuevo Id\n3. Ya existe un usuario con el nuevo username");
        		}
        		updateUser.showAndWait();
        	}
    	}
    }
    @FXML
    private void enableUser(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtUserId.getText().isEmpty()) {
    		long identification = Long.parseLong(txtUserId.getText());
    		restaurantManager.enableUser(identification);
    		Alert enableEmployee = new Alert(AlertType.INFORMATION);
    		enableEmployee.setHeaderText(null);
    		enableEmployee.setTitle("Estado de usuario");
    		enableEmployee.setContentText("El estado del usuario ahora es: habilitado");
    		enableEmployee.showAndWait();
    		loadUserList(null);
    	}
    }
    @FXML
    private void disableUser(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtUserId.getText().isEmpty()) {
    		long identification = Long.parseLong(txtUserId.getText());
    		boolean disabled = restaurantManager.disableUser(identification);
    		Alert disableEmployee = new Alert(AlertType.INFORMATION);
    		disableEmployee.setTitle("Estado de usuario");
    		if(disabled) {
    			loadUserList(null);
    			disableEmployee.setHeaderText(null);
        		disableEmployee.setContentText("El estado del usuario ahora es: deshabilitado");
    		}else {
    			disableEmployee.setHeaderText("No se pudo deshabilitar");
        		disableEmployee.setContentText("El estado del usuario no pudo ser modificado debido a que:\n- El empleado se encuentra logeado");
    		}
    		disableEmployee.showAndWait();
    	}
    }
    @FXML
    private void removeUser(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtUserId.getText().isEmpty()) {
    		long identification = Long.parseLong(txtUserId.getText());
    		boolean removed = restaurantManager.removeUser(identification);
    		Alert removeEmployee = new Alert(AlertType.INFORMATION);
			removeEmployee.setTitle("Eliminar Usuario");
    		if(removed) {
    			loadUserList(null);
    			removeEmployee.setHeaderText(null);
    			removeEmployee.setContentText("El usuario ha sido eliminado");
    		}else {
    			removeEmployee.setHeaderText("No se pudo eliminar");
    			removeEmployee.setContentText("El usuario no pudo eliminarse debido a que:\n- El usuario se encuentra logeado");
    		}
    		removeEmployee.showAndWait();
    	}
    }
  
    @FXML
    private void showManageClients(ActionEvent event) throws IOException {
    	manageAllDisable();
    	manageClient = true;
    	showScreenMenuOption(null);
    	showManageObjectOptions.setVisible(true);
    }
    @FXML
    private void manageCreateNewClient(ActionEvent event) throws FileNotFoundException, IOException {
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
    private void loadClientList(ActionEvent event) throws IOException {
    	indexSelection = -1;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client-table-view-pane.fxml"));
    	fxmlLoader.setController(this);
    	Parent clientList = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(clientList);
    	initializeClientTableView();
    }
    private void initializeClientTableView() {
    	ObservableList<Client> observableList;
    	observableList = FXCollections.observableArrayList(restaurantManager.getClientList());
    	tvClientList.setItems(observableList);
    	tcClientLastname.setCellValueFactory(new PropertyValueFactory<Client, String>("lastname"));
    	tcClientName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
    	tcClientIdentification.setCellValueFactory(new PropertyValueFactory<Client, Long>("identification"));
    	tcClientPhone.setCellValueFactory(new PropertyValueFactory<Client, Long>("phone"));
    	tcClientState.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("state"));
    }
    @FXML
    private void getClientSelected(MouseEvent event) {
    	indexSelection = tvClientList.getSelectionModel().getSelectedIndex();
    	if(indexSelection <= -1) {
    		return;
    	}
    	txtClientId.setText(tcClientIdentification.getCellData(indexSelection).toString());
    	txtClientName.setText(tcClientName.getCellData(indexSelection));
    	txtClientLastname.setText(tcClientLastname.getCellData(indexSelection));
    	txtClientPhone.setText(tcClientPhone.getCellData(indexSelection).toString());
    	txtClientState.setText((tcClientState.getCellData(indexSelection))?"Enable":"Disable");
    	int position = restaurantManager.searchClientByName(txtClientName.getText(), txtClientLastname.getText());
    	txtClientAddress.setText(restaurantManager.getClientList().get(position).getAddress());
    	txtClientObservations.setText(restaurantManager.getClientList().get(position).getObservations());
    }
    @FXML
    private void updateClient(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtClientId.getText().isEmpty() && !txtClientLastname.getText().isEmpty() && !txtClientLastname.getText().isEmpty()) {
    		if(!txtClientPhone.getText().isEmpty() && !txtClientAddress.getText().isEmpty()) {
    			String name =  tcClientName.getCellData(indexSelection);
    			String lastname = tcClientLastname.getCellData(indexSelection);
    			String newN = txtClientName.getText();
    			String newLn = txtClientLastname.getText();
    			Long iD = Long.parseLong(txtClientId.getText());
    			Long ph = Long.parseLong(txtClientPhone.getText());
    			String ad = txtClientAddress.getText();
    			String ob = txtClientObservations.getText();
    			boolean updated = restaurantManager.updateClient(name, lastname, newN, newLn, iD, ph, ad, ob);
    			Alert updateClient = new Alert(AlertType.INFORMATION);
    			updateClient.setTitle("Actualizar cliente");
    			if(updated) {
    				loadClientList(null);
    				updateClient.setHeaderText(null);
    				updateClient.setContentText("Información de cliente actualizada");
    			}else {
    				updateClient.setHeaderText("No se pudo actualizar");
    				updateClient.setContentText("No se pudo actualizar la información del cliente porque\nya existe otro cliente con el nombre que quieres asignar");
    			}
    			updateClient.showAndWait();
    		}
    	}
    }
    @FXML
    private void enableClient(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtClientName.getText().isEmpty() && !txtClientLastname.getText().isEmpty()) {
    		String name = txtClientName.getText();
    		String lastname = txtClientLastname.getText();
    		boolean enable = restaurantManager.enableClient(name, lastname);
    		Alert enableClient = new Alert(AlertType.INFORMATION);
    		enableClient.setTitle("Estado de cliente");
    		if(enable) {
    			loadClientList(null);
    			enableClient.setHeaderText(null);
    			enableClient.setContentText("El estado del cliente ahora es: habilitado");
    		}else {
    			enableClient.setHeaderText("No se pudo habilitar");
    			enableClient.setContentText("El cliente no existe");
    		}
    		enableClient.showAndWait();
    	}
    }
    @FXML
    private void disableClient(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtClientName.getText().isEmpty() && !txtClientLastname.getText().isEmpty()) {
    		String name = txtClientName.getText();
    		String lastname = txtClientLastname.getText();
    		boolean disable = restaurantManager.disableClient(name, lastname);
    		Alert disableClient = new Alert(AlertType.INFORMATION);
    		disableClient.setTitle("Estado de cliente");
    		if(disable) {
    			loadClientList(null);
    			disableClient.setHeaderText(null);
    			disableClient.setContentText("El estado del cliente ahora es: deshabilitado");
    		}else {
    			disableClient.setHeaderText("No se pudo deshabilitar");
    			disableClient.setContentText("El cliente no existe");
    		}
    		disableClient.showAndWait();
    	}
    }
    @FXML
    private void removeClient(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtClientName.getText().isEmpty() && !txtClientLastname.getText().isEmpty()) {
    		String name = txtClientName.getText();
    		String lastname = txtClientLastname.getText();
    		boolean remove = restaurantManager.removeClient(name, lastname);
    		Alert removeClient = new Alert(AlertType.INFORMATION);
    		removeClient.setTitle("Eliminar cliente");
    		if(remove) {
    			loadClientList(null);
    			removeClient.setHeaderText(null);
    			removeClient.setContentText("El cliente se ha eliminado");
    		}else {
    			removeClient.setHeaderText("No se pudo eliminar");
    			removeClient.setContentText("El cliente no existe");
    		}
    		removeClient.showAndWait();
    	}
    }
    
    @FXML
    private void showManageIngredients(ActionEvent event) throws IOException {
    	manageAllDisable();
    	manageIngredients = true;
    	showScreenMenuOption(null);
    	showManageObjectOptions.setVisible(true);
    }
    @FXML
    private void manageCreateNewIngredient(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtManageCreateIngredientName.getText().isEmpty()) {
    		String name = txtManageCreateIngredientName.getText();
    		boolean created = restaurantManager.createIngredient(name);
    		if(created) {
    			txtManageCreateIngredientName.setText(null);
    		}
    	}
    }
    @FXML
    private void loadIngredientList(ActionEvent event) throws IOException {
    	indexSelection = -1;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ingredient-table-view-pane.fxml"));
    	fxmlLoader.setController(this);
    	Parent ingredientList = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(ingredientList);
    	initializeIngredientTableView();
    }
    private void initializeIngredientTableView() {
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(restaurantManager.getIngredientList());
    	tvIngredientList.setItems(observableList);
    	tcIngredientName.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
    	tcIngredientUses.setCellValueFactory(new PropertyValueFactory<Ingredient, Integer>("uses"));
    	tcIngredientState.setCellValueFactory(new PropertyValueFactory<Ingredient, Boolean>("state"));
    	tcIngredientLastModified.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("lastEditorName"));
    }
    @FXML
    private void getIngredientSelected(MouseEvent event) {
    	indexSelection = tvIngredientList.getSelectionModel().getSelectedIndex();
    	if(indexSelection <= -1) {
    		return;
    	}
    	txtIngredientName.setText(tcIngredientName.getCellData(indexSelection));
    }
    @FXML
    private void updateIngredient() throws FileNotFoundException, IOException {
    	if(!txtIngredientName.getText().isEmpty()) {
    		String name = tcIngredientName.getCellData(indexSelection); 
    		String newN = txtIngredientName.getText();
    		boolean updated = restaurantManager.updateIngredient(name, newN);
    		Alert updateIngredient = new Alert(AlertType.INFORMATION);
    		updateIngredient.setTitle("Actualizar ingrediente");
    		if(updated) {
    			loadIngredientList(null);
    			updateIngredient.setHeaderText(null);
    			updateIngredient.setContentText("El nombre del ingrediente se ha actualizado");
    		}else {
    			updateIngredient.setHeaderText("No se pudo actualizar");
    			updateIngredient.setContentText("No se puede actualizar, puede ser que:\n1. El ingrediente no existe\n2. El ingrediente pertenece a un producto");
    		}
    		updateIngredient.showAndWait();
    	}
    }
    @FXML
    private void enableIngredient() throws FileNotFoundException, IOException {
    	if(!txtIngredientName.getText().isEmpty()) {
    		String name= txtIngredientName.getText();
    		boolean enable = restaurantManager.enableIngredient(name);
    		Alert enableIngredient = new Alert(AlertType.INFORMATION);
    		enableIngredient.setTitle("Estado de ingrediente");
    		if(enable) {
    			loadIngredientList(null);
    			enableIngredient.setHeaderText(null);
    			enableIngredient.setContentText("El estado del ingrediente ahora es: habilitado");
    		}else {
    			enableIngredient.setHeaderText("No se pudo habilitar");
    			enableIngredient.setContentText("El ingrediente no existe");
    		}
    		enableIngredient.showAndWait();
    	}
    }
    @FXML
    private void disableIngredient() throws FileNotFoundException, IOException {
    	if(!txtIngredientName.getText().isEmpty()) {
    		String name = txtIngredientName.getText();
    		boolean disable = restaurantManager.disableIngredient(name);
    		Alert disableIngredient = new Alert(AlertType.INFORMATION);
    		disableIngredient.setTitle("Estado de ingrediente");
    		if(disable) {
    			loadIngredientList(null);
    			disableIngredient.setHeaderText(null);
    			disableIngredient.setContentText("El estado del ingrediente ahora es: deshabilitado");
    		}else {
    			disableIngredient.setHeaderText("No se pudo deshabilitar");
    			disableIngredient.setContentText("El ingrediente no existe");
    		}
    		disableIngredient.showAndWait();
    	}
    }
    @FXML
    private void removeIngredient() throws FileNotFoundException, IOException {
    	if(!txtIngredientName.getText().isEmpty()) {
    		String name = txtIngredientName.getText();
    		boolean removed = restaurantManager.removeIngredient(name);
    		Alert removeIngredient = new Alert(AlertType.INFORMATION);
    		removeIngredient.setTitle("Eliminar ingrediente");
    		if(removed) {
    			loadIngredientList(null);
    			removeIngredient.setHeaderText(null);
    			removeIngredient.setContentText("El ingrediente se ha eliminado");
    		}else {
    			removeIngredient.setHeaderText("No se pudo eliminar");
    			removeIngredient.setContentText("El ingrediente no se pudo eliminar, puede que por:\n1. El ingrediente no existe\n2. El ingrediente pertene a un producto");
    		}
    		removeIngredient.showAndWait();
    	}
    }
    
    @FXML
    private void showManageProductTypes(ActionEvent event) throws IOException {
    	manageAllDisable();
    	manageProductTypes= true;
    	showScreenMenuOption(null);
    	showManageObjectOptions.setVisible(true);
    }
    @FXML
    private void manageCreateNewProductTypes(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtManageCreateProductTypeName.getText().isEmpty()) {
    		String name = txtManageCreateProductTypeName.getText();
    		boolean created = restaurantManager.createProductTypes(name);
    		if(created) {
    			txtManageCreateProductTypeName.setText(null);
    		}
    	}
    }
    @FXML
    private void loadProductTypeList(ActionEvent event) throws IOException {
    	indexSelection = -1;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-type-table-view-pane.fxml"));
    	fxmlLoader.setController(this);
    	Parent productTypeList = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(productTypeList);
    	initializeProducTypeTableView();
    }
    private void initializeProducTypeTableView() {
       	ObservableList<ProductTypes> observableList;
    	observableList = FXCollections.observableArrayList(restaurantManager.getProductTypesList());
    	tvProductTypeList.setItems(observableList);
    	tcProductTypeName.setCellValueFactory(new PropertyValueFactory<ProductTypes, String>("name"));
    	tcProductTypeUses.setCellValueFactory(new PropertyValueFactory<ProductTypes, Integer>("uses"));
    	tcProductTypeState.setCellValueFactory(new PropertyValueFactory<ProductTypes, Boolean>("state"));
    	tcProductTypeLastModified.setCellValueFactory(new PropertyValueFactory<ProductTypes, String>("lastEditorName"));
    }
    @FXML
    private void getProductTypeSelected(MouseEvent event) {
      	indexSelection = tvProductTypeList.getSelectionModel().getSelectedIndex();
    	if(indexSelection <= -1) {
    		return;
    	}
    	txtProductTypeName.setText(tcProductTypeName.getCellData(indexSelection));
    }
    @FXML
    private void updateProductType() throws FileNotFoundException, IOException {
    	if(!txtProductTypeName.getText().isEmpty()) {
    		String name = tcIngredientName.getCellData(indexSelection);
    		String newN = txtProductTypeName.getText();
    		boolean updated = restaurantManager.updateProductTypes(name, newN);
    		Alert updateProductType = new Alert(AlertType.INFORMATION);
    		updateProductType.setTitle("Actualizar tipo de producto");
    		if(updated) {
    			loadProductTypeList(null);
    			updateProductType.setHeaderText(null);
    			updateProductType.setContentText("El nombre del tipo de producto se ha actualizado");
    		}else {
    			updateProductType.setHeaderText("No se pudo actualizar");
    			updateProductType.setContentText("No se pudo actualizar, puede ser que:\n1. El tipo de producto no existe\n2. El tipo de producto pertenece a un prodcuto");
    		}
    		updateProductType.showAndWait();
    	}
    }
    @FXML
    private void enableProductType() throws FileNotFoundException, IOException {
    	if(!txtProductTypeName.getText().isEmpty()) {
    		String name = txtProductTypeName.getText();
    		boolean enabled = restaurantManager.enableProductType(name);
    		Alert enableProductType = new Alert(AlertType.INFORMATION);
    		enableProductType.setTitle("Estado de tipo de producto");
    		if(enabled) {
    			loadProductTypeList(null);
    			enableProductType.setHeaderText(null);
    			enableProductType.setContentText("El del tipo de producto ahora es: habilitado");
    		}else {
    			enableProductType.setHeaderText("No se pudo habilitar");
    			enableProductType.setContentText("El tipo de producto no existe");
    		}
    		enableProductType.showAndWait();
    	}
    }
    @FXML
    private void disableProductType() throws FileNotFoundException, IOException {
    	if(!txtProductTypeName.getText().isEmpty()) {
    		String name = txtProductTypeName.getText();
    		boolean disabled = restaurantManager.disableProductTypes(name);
    		Alert disableProductType = new Alert(AlertType.INFORMATION);
    		disableProductType.setTitle("Estado de tipo de producto");
    		if(disabled) {
    			loadProductTypeList(null);
    			disableProductType.setHeaderText(null);
    			disableProductType.setContentText("El estado del tipo de producto ahora es: deshabilitado");
    		}else {
    			disableProductType.setHeaderText("No se pudo deshabilitar");
    			disableProductType.setContentText("El tipo de producto no existe");
    		}
    		disableProductType.showAndWait();
    	}
    }
    @FXML
    private void removeProductType() throws FileNotFoundException, IOException {
    	if(!txtProductTypeName.getText().isEmpty()) {
    		String name = txtProductTypeName.getText();
    		boolean removed = restaurantManager.removeProductTypes(name);
    		Alert removeProductType = new Alert(AlertType.INFORMATION);
    		removeProductType.setTitle("Eliminar tipo de producto");
    		if(removed) {
    			loadProductTypeList(null);
    			removeProductType.setHeaderText(null);
    			removeProductType.setContentText("El tipo de producto se ha eliminado");
    		}else {
    			removeProductType.setHeaderText("No se pudo eliminar");
    			removeProductType.setContentText("El tipo de producto no se pudo eliminar, puede que por:\n1. El tipo de producto no existe\n2. El tipo de producto pertenece a un producto");
    		}
    		removeProductType.showAndWait();
    	}
    }
    
    @FXML
    private void showManageProducts(ActionEvent event) throws IOException {
    	manageAllDisable();
    	manageProducts= true;
    	showScreenMenuOption(null);
    	showManageObjectOptions.setVisible(true);
    }
    @FXML
    private void manageCreateNewProduct(ActionEvent event) throws IOException {
    	if(!txtManageCreateProductName.getText().isEmpty() && txtManageCreateProductProductType.getValue() != null) {
    		if(!txtManageCreateProductIngredients.getItems().isEmpty() && !txtManageCreateProductPrice.getText().isEmpty() && !txtManageCreateProductSize.getText().isEmpty()) {
    			String name = txtManageCreateProductName.getText();
    			String productType = txtManageCreateProductProductType.getValue();
    			List<String> ingredients = txtManageCreateProductIngredients.getItems();
    			String size = txtManageCreateProductSize.getText();
    			long price = Long.parseLong(txtManageCreateProductPrice.getText());
    			boolean created = restaurantManager.createProduct(name, productType, ingredients, size, price);
    			if(created) {
    				txtManageCreateProductName.setText(null);
    				txtManageCreateProductProductType.setValue(null);
    				txtManageCreateProductIngredients.getItems().clear();
    				txtManageCreateProductAddIngredient.getItems().clear();
    				txtManageCreateProductSize.setText(null);
    				txtManageCreateProductPrice.setText(null);
    			}
    		}
    		
    	}
    }
    @FXML
    private void addIngredientToNewProduct(ActionEvent event) {
    	if(txtManageCreateProductAddIngredient.getValue() != null) {
    		txtManageCreateProductIngredients.getItems().add(txtManageCreateProductAddIngredient.getValue());
    		txtManageCreateProductAddIngredient.setValue(null);
    	}
    }
    @FXML
    private void initializeCreateProductProductTypeList(MouseEvent event) {
    	txtManageCreateProductProductType.getItems().clear();
    	for(int i = 0; i<restaurantManager.getProductTypesList().size(); i++) {
    		if(restaurantManager.getProductTypesList().get(i).getState()) {
    			txtManageCreateProductProductType.getItems().add(restaurantManager.getProductTypesList().get(i).getName());
    		}
    	}
    }
    @FXML
    private void initializeCreateProductIngredientList(MouseEvent event) {
    	txtManageCreateProductAddIngredient.getItems().clear();
    	for(int i = 0; i<restaurantManager.getIngredientList().size(); i++) {
    		if(restaurantManager.getIngredientList().get(i).getState()) {
    			boolean founded = false;
    			for(int j = 0; j<txtManageCreateProductIngredients.getItems().size() && !founded; j++) {
        			if(restaurantManager.getIngredientList().get(i).getName().equals(txtManageCreateProductIngredients.getItems().get(j))) {
        				founded = true;
        			}
    			}
    			if(!founded) {
    				txtManageCreateProductAddIngredient.getItems().add(restaurantManager.getIngredientList().get(i).getName());
    			}
    		}
    	}
    }    
    @FXML
    private void loadProductList(ActionEvent event) throws IOException {
    	indexSelection = -1;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-table-view-pane.fxml"));
    	fxmlLoader.setController(this);
    	Parent productList = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(productList);
    	initializeProductTableView();
    }
    private void initializeProductTableView() {
    	ObservableList<Product> observableList;
		observableList = FXCollections.observableArrayList(restaurantManager.getProductList());
    	tvProductList.setItems(observableList);
    	tcProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
    	tcProductOrders.setCellValueFactory(new PropertyValueFactory<Product, Integer>("orders"));
    	tcProductState.setCellValueFactory(new PropertyValueFactory<Product, Boolean>("state"));
    }
    @FXML
    private void getProductSelected(MouseEvent event) {
    	indexSelection = tvProductList.getSelectionModel().getSelectedIndex();
    	if(indexSelection <= -1) {
    		return;
    	}
    	txtProductName.setText(tcProductName.getCellData(indexSelection));
    	int position = restaurantManager.searchProduct(txtProductName.getText());
    	Product actual = restaurantManager.getProductList().get(position);
    	txtProductProductType.setText(actual.getProductType().getName());
        cbProductNewProductType.getItems().clear();
        for(int i = 0; i<restaurantManager.getProductTypesList().size(); i++) {
        	if(restaurantManager.getProductTypesList().get(i).getState()) {
        		 cbProductNewProductType.getItems().add(restaurantManager.getProductTypesList().get(i).getName());
        	}
        }
        cbProductIngredients.getItems().clear();
        for(int i = 0; i<actual.getIngredients().size(); i++) {
        	cbProductIngredients.getItems().add(actual.getIngredients().get(i).getName());
        }
        cbProductAddIngredient.getItems().clear();
        for(int i = 0; i<restaurantManager.getIngredientList().size(); i++) {
        	boolean founded = false;
        	for(int j = 0; j<actual.getIngredients().size(); j++) {
        		if(restaurantManager.getIngredientList().get(i).getState() || restaurantManager.getIngredientList().get(i).getName().equals(actual.getIngredients().get(j).getName())) {
        			founded = true;
        		}
        	}
        	if(!founded) {
        		cbProductAddIngredient.getItems().add(restaurantManager.getIngredientList().get(i).getName());
        	}
        }
        cbProductSize.getItems().clear();
        for(int i = 0; i<actual.getProductSizes().size(); i++) {
        	cbProductSize.getItems().add(actual.getProductSizes().get(i).getName());
        }
    }
    @FXML
    private void removeIngredient(ActionEvent event) throws IOException {
    	if(!txtProductName.getText().isEmpty() && cbProductIngredients.getValue() != null) {
    		String name = txtProductName.getText();
    		String ingredient = cbProductIngredients.getValue();
    		restaurantManager.removeProductIngredient(name, ingredient);
    		loadProductList(null);
    	}
    }
    @FXML
    private void addIngredient(ActionEvent event) throws IOException {
    	if(!txtProductName.getText().isEmpty() && cbProductAddIngredient.getValue() != null) {
    		String name = txtProductName.getText();
    		String ingredient = cbProductAddIngredient.getValue();
    		restaurantManager.addProductIngredient(name, ingredient);
    		loadProductList(null);
    	}
    }
    @FXML
    private void removeProductSize(ActionEvent event) throws IOException {
    	if(!txtProductName.getText().isEmpty() && cbProductSize.getValue() != null) {
    		String productName = txtProductName.getText();
    		String name = cbProductSize.getValue();
    		restaurantManager.removeProductSize(productName, name);
    		loadProductList(null);
    	}
    }
    @FXML
    private void addProductSize(ActionEvent event) throws IOException {
    	if(!txtProductName.getText().isEmpty() && !txtProductSize.getText().isEmpty() && !txtProductPrice.getText().isEmpty()) {
    		String productName = txtProductName.getText();
    		String name = txtProductSize.getText();
    		long price = Long.parseLong(txtProductPrice.getText());
    		restaurantManager.addProductSize(productName, name, price);
    		loadProductList(null);
    	}
    } 
    @FXML
    private void updateProduct() throws IOException {
    	if(!txtProductName.getText().isEmpty() && cbProductNewProductType.getValue() != null) {
    		String name = tcProductName.getCellData(indexSelection);
    		String newN = txtProductName.getText();
    		String productType = cbProductNewProductType.getValue();
    		boolean updated = restaurantManager.updateProduct(name, newN, productType);
    		Alert updatedProduct = new Alert(AlertType.INFORMATION);
    		updatedProduct.setTitle("Actualizar producto");
    		if(updated) {
    			loadProductList(null);
    			updatedProduct.setHeaderText(null);
    			updatedProduct.setContentText("La información del producto se ha actualizado");
    		}else {
    			updatedProduct.setHeaderText("No se pudo actualizar");
    			updatedProduct.setContentText("El producto no se pudo actualizar");
    		}
    		updatedProduct.showAndWait();
    	}
    }
    @FXML
    private void enableProduct() throws IOException {
    	if(!txtProductName.getText().isEmpty()) {
    		String name = txtProductName.getText();
    		boolean enabled = restaurantManager.enableProduct(name);
    		Alert enableProduct = new Alert(AlertType.INFORMATION);
    		enableProduct.setTitle("Estado de producto");
    		if(enabled) {
    			loadProductList(null);
    			enableProduct.setHeaderText(null);
    			enableProduct.setContentText("El estado del producto ahora es: habilitado");
    		}else {
    			enableProduct.setHeaderText("No se pudo habilitar");
    			enableProduct.setContentText("El producto no existe");
    		}
    		enableProduct.showAndWait();
    	}
    }
    @FXML
    private void disableProduct() throws IOException {
    	if(!txtProductName.getText().isEmpty()) {
    		String name = txtProductName.getText();
    		boolean disabled = restaurantManager.disableProduct(name);
    		Alert disableProduct = new Alert(AlertType.INFORMATION);
    		disableProduct.setTitle("Estado de producto");
    		if(disabled) {
    			loadProductList(null);
    			disableProduct.setHeaderText(null);
    			disableProduct.setContentText("El estado del producto ahora es: deshabilitado");
    		}else {
    			disableProduct.setHeaderText("No se pudo deshabilitar");
    			disableProduct.setContentText("El producto no existe");
    		}
    		disableProduct.showAndWait();
    	}
    }
    @FXML
    private void removeProduct() throws IOException {
    	if(!txtProductName.getText().isEmpty()) {
    		String name = txtProductName.getText();
    		boolean removed = restaurantManager.removeProduct(name);
    		Alert removeProduct = new Alert(AlertType.INFORMATION);
    		removeProduct.setTitle("Eliminar producto");
    		if(removed) {
    			loadProductList(null);
    			removeProduct.setHeaderText(null);
    			removeProduct.setContentText("El producto ha sido eliminado");
    		}else {
    			removeProduct.setHeaderText("No se pudo eliminar");
    			removeProduct.setContentText("El producto no se pudo eliminar");
    		}
    		removeProduct.showAndWait();
    	}
    }
    
    @FXML
    private void showManageOrders(ActionEvent event) throws IOException {
    	manageAllDisable();
    	manageOrders = true;
    	showScreenMenuOption(null);
    	showManageObjectOptions.setVisible(true);
    }
    @FXML
    private void manageCreateNewOrder(ActionEvent event) throws FileNotFoundException, IOException {
    	if(!txtManageCreateOrderProducts.getItems().isEmpty() && !txtManageCreateOrderProductSizes.getItems().isEmpty() && !txtManageCreateOrderProductQuantities.getItems().isEmpty()) {
    		if(txtManageCreateOrderClientLn.getValue() != null && txtManageCreateOrderClientN.getValue()!= null && txtManageCreateOrderEmployee.getValue() != null) {
    			List<String> pName = txtManageCreateOrderProducts.getItems();
    			List<String> pSizeNames = txtManageCreateOrderProductSizes.getItems();
    			List<Long> quantities = txtManageCreateOrderProductQuantities.getItems();
    			String cName = txtManageCreateOrderClientN.getValue();
    			String cLastname = txtManageCreateOrderClientLn.getValue();
    			long eIdentification = txtManageCreateOrderEmployee.getValue();
    			String ob = txtManageCreateOrderObservations.getText();
    			boolean created = restaurantManager.createOrder(pName, quantities, pSizeNames, cName, cLastname, eIdentification, ob);
    			if(created) {
    				txtManageCreateOrderProducts.getItems().clear();
    				txtManageCreateOrderProductSizes.getItems().clear();
    				txtManageCreateOrderProductQuantities.getItems().clear();;
    				txtManageCreateOrderClientN.getItems().clear();
    				txtManageCreateOrderClientLn.getItems().clear();
    				txtManageCreateOrderEmployee.getItems().clear();
    				txtManageCreateOrderObservations.setText(null);
    			}
    		}
    	}
    }
    @FXML
    private void initializeCreateOrderClientLn(MouseEvent event) {
    	txtManageCreateOrderClientLn.getItems().clear();
    	txtManageCreateOrderClientN.getItems().clear();
    	for(int i = 0; i<restaurantManager.getClientList().size(); i++) {
    		if(restaurantManager.getClientList().get(i).getState()) {
    			txtManageCreateOrderClientLn.getItems().add(restaurantManager.getClientList().get(i).getLastname());
    		}
    	}
    }
    @FXML
    private void initializeCreateOrderClientN(MouseEvent event) {
    	txtManageCreateOrderClientN.getItems().clear();
    	if(txtManageCreateOrderClientLn.getValue() != null) {
    		String lastname = txtManageCreateOrderClientLn.getValue();
    		for(int i = 0; i<restaurantManager.getClientList().size(); i++) {
    			if(restaurantManager.getClientList().get(i).getState() && restaurantManager.getClientList().get(i).getLastname().equals(lastname)) {
    				txtManageCreateOrderClientN.getItems().add(restaurantManager.getClientList().get(i).getName());
    			}
    		}
    	}
    }
    @FXML
    private void initializeCreateOrderAddProduct(MouseEvent event) {
    	txtManageCreateOrderAddProduct.getItems().clear();
    	for(int i = 0; i<restaurantManager.getProductList().size(); i++) {
    		if(restaurantManager.getProductList().get(i).getState()) {
    			txtManageCreateOrderAddProduct.getItems().add(restaurantManager.getProductList().get(i).getName());
    		}
    	}
    }
    @FXML
    private void initializeCreateAddSize(MouseEvent event) {
    	if(txtManageCreateOrderAddProduct.getValue() != null) {
    		String product = txtManageCreateOrderAddProduct.getValue();
    		int position = restaurantManager.searchProduct(product);
    		for(int i = 0; i<restaurantManager.getProductList().get(position).getProductSizes().size(); i++) {
    			txtManageCreateOrderAddSize.getItems().add(restaurantManager.getProductList().get(position).getProductSizes().get(i).getName());
    		}
    	}
    }
    @FXML
    private void addProductToOrder(ActionEvent event) {
    	if(txtManageCreateOrderAddProduct.getValue() != null && txtManageCreateOrderAddSize.getValue() != null && !txtManageCreateOrderAddQuantity.getText().isEmpty()) {
    		String product = txtManageCreateOrderAddProduct.getValue();
    		String productSize = txtManageCreateOrderAddSize.getValue();
    		long productQuantity = Long.parseLong(txtManageCreateOrderAddQuantity.getText());
    		txtManageCreateOrderProducts.getItems().add(product);
    	    txtManageCreateOrderProductSizes.getItems().add(productSize);
    	    txtManageCreateOrderProductQuantities.getItems().add(productQuantity);
    	    txtManageCreateOrderAddProduct.setValue(null);
    	    txtManageCreateOrderAddSize.setValue(null);
    	    txtManageCreateOrderAddQuantity.setText(null);
    	}
    }
    @FXML
    private void initializeCreateAddEmployee(MouseEvent event) {
    	txtManageCreateOrderEmployee.getItems().clear();
    	for(int i = 0; i<restaurantManager.getEmployeeList().size(); i++) {
    		if(restaurantManager.getEmployeeList().get(i).getState()) {
    			long identification = restaurantManager.getEmployeeList().get(i).getIdentification();
    			txtManageCreateOrderEmployee.getItems().add(identification);
    		}
    	}
    }
    @FXML
    private void loadOrderList(ActionEvent event) throws IOException {
    	indexSelection = -1;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order-table-view-pane.fxml"));
    	fxmlLoader.setController(this);
    	Parent orderList = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(orderList);
    	initializeOrderTableView();
    }
    private void initializeOrderTableView() {
    	ObservableList<Order> observableList;
		observableList = FXCollections.observableArrayList(restaurantManager.getOrderList());
    	tvOrderList.setItems(observableList);
    	tcOrderCode.setCellValueFactory(new PropertyValueFactory<Order, Integer>("code"));
    	tcOrderPrice.setCellValueFactory(new PropertyValueFactory<Order, Long>("price"));
    	tcOrderStatus.setCellValueFactory(new PropertyValueFactory<Order, OrderState>("status"));
    	tcOrderClientLastname.setCellValueFactory(new PropertyValueFactory<Order, String>("clientLastname"));
    	tcOrderClientName.setCellValueFactory(new PropertyValueFactory<Order, String>("clientName"));
    	tcOrderEmployeeLastname.setCellValueFactory(new PropertyValueFactory<Order, String>("employeeLastname"));
    	tcOrderEmployeeName.setCellValueFactory(new PropertyValueFactory<Order, String>("employeeName"));
    }
    @FXML
    private void getOrderSelected(MouseEvent event) {
    	indexSelection = tvOrderList.getSelectionModel().getSelectedIndex();
    	if(indexSelection <= -1) {
    		return;
    	}
    	txtOrderCode.setText(tcOrderCode.getCellData(indexSelection).toString());
    	int code = Integer.parseInt(txtOrderCode.getText());
    	int position = restaurantManager.searchOrder(code);
    	txtOrderObservations.setText(restaurantManager.getOrderList().get(position).getObservations());
    	txtOrderState.setText(restaurantManager.getOrderList().get(position).getStatus().toString());
    }
    @FXML
    private void updateOrder() throws FileNotFoundException, IOException {
    	if(!txtOrderCode.getText().isEmpty()) {
    		int code = Integer.parseInt(txtOrderCode.getText());
    		String observations = txtOrderObservations.getText();
    		boolean updated = restaurantManager.updateOrder(code, observations);
    		Alert updateOrder = new Alert(AlertType.INFORMATION);
    		updateOrder.setTitle("Actualizar pedido");
    		if(updated) {
        		loadOrderList(null);
        		updateOrder.setHeaderText(null);
        		updateOrder.setContentText("Se ha actualizado el estado del pedido");
        	}else {
        		updateOrder.setHeaderText("Error al actualizar");
        		updateOrder.setContentText("No se pudo actualizar el pedido, puede que:\n1. El pedido no existe\n2. El pedido ya fue entregado");
        	}
    		updateOrder.showAndWait();
    	}
    }
    @FXML
    private void removeOrder() throws IOException {
    	if(!txtOrderCode.getText().isEmpty()) {
    		int code = Integer.parseInt(txtOrderCode.getText());
    		boolean removed = restaurantManager.removeOrder(code);
    		Alert removeOrder = new Alert(AlertType.INFORMATION);
    		removeOrder.setTitle("Eliminar pedido");
    		if(removed) {
    			loadOrderList(null);
    			removeOrder.setHeaderText(null);
    			removeOrder.setContentText("Se ha eliminado el pedido");
    		}else {
    			removeOrder.setHeaderText("No se pudo eliminar");
    			removeOrder.setContentText("El pedido no se pudo eliminar, puede ser porque no existe\nun pedido con ese codigo");
    		}
    		removeOrder.showAndWait();
    	}
    }
    
	
}
