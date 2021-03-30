package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class RestaurantManager {
	private final static String SAVE_PATH_FILE_EMPLOYEES = "data/employees.lcd";
	private final static String SAVE_PATH_FILE_USERS = "data/users.lcd";
	private final static String SAVE_PATH_FILE_CLIENTS = "data/clients.lcd";
	private final static String SAVE_PATH_FILE_INGREDIENTS = "data/ingredients.lcd";
	private final static String SAVE_PATH_FILE_PRODUCT_TYPES = "data/product-types.lcd";
	private final static String SAVE_PATH_FILE_PRODUCTS = "data/products.lcd";
	private final static String SAVE_PATH_FILE_ORDERS = "data/orders.lcd";
	
	private List<Employee> employeeList;
	private List<User> userList;
	private List<Client> clientList;
	private List<Ingredient> ingredientList;
	private List<ProductTypes> productTypesList;
	private List<Product> productList;
	private List<Order> orderList;
	private User userLogged;
	
	public RestaurantManager() throws ClassNotFoundException, IOException {
		employeeList = new ArrayList<>();
		userList = new ArrayList<>();
		clientList = new ArrayList<>();
		ingredientList = new ArrayList<>();
		productTypesList = new ArrayList<>();
		productList = new ArrayList<>();
		orderList = new ArrayList<>();
		loadDataEmployee();
		loadDataUsers();
		loadDataClients();
		loadDataIngredients();
		loadDataProductTypes();
		loadDataProducts();
		loadDataOrders();
	}
	public void saveDataEmployee() throws FileNotFoundException, IOException {
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_EMPLOYEES));
		oss.writeObject(employeeList);
		oss.close();
	}
	public void saveDataUsers() throws FileNotFoundException, IOException {
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_USERS));
		oss.writeObject(userList);
		oss.close();
	}
	public void saveDataClients() throws FileNotFoundException, IOException{
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_CLIENTS));
		oss.writeObject(clientList);
		oss.close();
	}
	public void saveDataIngredients() throws FileNotFoundException, IOException {
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_INGREDIENTS));
		oss.writeObject(ingredientList);
		oss.close();
	}
	public void saveDataProductTypes() throws FileNotFoundException, IOException {
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PRODUCT_TYPES));
		oss.writeObject(productTypesList);
		oss.close();
	}
	public void saveDataProducts() throws IOException {
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PRODUCTS));
		oss.writeObject(productList);
		oss.close();
	}
	public void saveDataOrders() throws FileNotFoundException, IOException {
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_ORDERS));
		oss.writeObject(orderList);
		oss.close();
	}
	@SuppressWarnings("unchecked")
	public void loadDataEmployee() throws ClassNotFoundException, IOException {
		File f = new File(SAVE_PATH_FILE_EMPLOYEES);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			employeeList = (ArrayList<Employee>) ois.readObject();
			ois.close();
		}
	}
	@SuppressWarnings("unchecked")
	public void loadDataUsers() throws ClassNotFoundException, IOException {
		File f = new File(SAVE_PATH_FILE_USERS);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			userList = (ArrayList<User>) ois.readObject();
			ois.close();
		}
	}
	@SuppressWarnings("unchecked")
	public void loadDataClients() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(SAVE_PATH_FILE_CLIENTS);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			clientList = (ArrayList<Client>) ois.readObject();
			ois.close();
		}
	}
	@SuppressWarnings("unchecked")
	public void loadDataIngredients() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(SAVE_PATH_FILE_INGREDIENTS);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			ingredientList = (ArrayList<Ingredient>) ois.readObject();
			ois.close();
		}
	}
	@SuppressWarnings("unchecked")
	public void loadDataProductTypes() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(SAVE_PATH_FILE_PRODUCT_TYPES);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			productTypesList = (ArrayList<ProductTypes>) ois.readObject();
			ois.close();
		}
	}
	@SuppressWarnings("unchecked")
	public void loadDataProducts() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(SAVE_PATH_FILE_PRODUCTS);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			productList = (ArrayList<Product>) ois.readObject();
			ois.close();
		}
	}
	@SuppressWarnings("unchecked")
	public void loadDataOrders() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(SAVE_PATH_FILE_ORDERS);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			orderList = (ArrayList<Order>) ois.readObject();
			ois.close();
		}
	}
	
	public List<Employee> getEmployeeList(){
		return employeeList;
	}
	public List<User> getUserList(){
		return userList;
	}
	public List<Client> getClientList(){
		return clientList;
	}
	public List<Ingredient> getIngredientList(){
		return ingredientList;
	}
	public List<ProductTypes> getProductTypesList(){
		return productTypesList;
	}
	public List<Product> getProductList(){
		return productList;
	}
	public List<Order> getOrderList(){
		return orderList;
	}
	public User getUserLogged() {
		return userLogged;
	}
	public void setUserLogged(String username) {
		int position = searchUserByUsername(username);
		userLogged = userList.get(position);
	}
	public void setuserLoggedNull() {
		userLogged = null;
	}
	
	private void orderEmployeeByIdentification() {
		for(int i = 1; i<employeeList.size(); i++) {
			for(int j = i; j>0 && employeeList.get(j).compareByIdentification(employeeList.get(j-1))<0; j--) {
				Employee temp = employeeList.get(j);
				employeeList.set(j, employeeList.get(j-1));
				employeeList.set(j-1, temp);
			}
		}
	}
	public int searchEmployeeByIdentification(long identification) {
		boolean founded= false;
		int position = -1;
		int start = 0;
		int end = employeeList.size()-1;
		if(end == 0) {
			if(employeeList.get(end).getIdentification() == identification) {
				position = end;
			}
		}else {
			while(employeeList.size()>0 && start <= end && !founded) {
				int mid = (start+end)/2;
				if(employeeList.get(mid).getIdentification() == identification) {
					founded = true;
					position = mid;
				}else if(employeeList.get(mid).getIdentification() > identification){
					end = mid-1;
				}else start = mid+1;
			}
		}
		return position;
	}
	public boolean createEmployee(String name, String lastname, long identifier) throws FileNotFoundException, IOException {
		boolean added = false;
		if(searchEmployeeByIdentification(identifier)<0) {
			Employee newEmployee = new Employee(name, lastname, identifier, userLogged);
			if(employeeList.isEmpty()) {
				employeeList.add(newEmployee);
			}else {
				int i = 0;
				for(i = 0; i<employeeList.size() && employeeList.get(i).getIdentification()<identifier; i++);
				employeeList.add(i, newEmployee);
			}
			saveDataEmployee();
			added = true;
		}
		return added;
	}
	public boolean updateEmployee(long identification, long newId, String newN, String newLn) throws FileNotFoundException, IOException {
		boolean updated = false;
		int position = searchEmployeeByIdentification(identification);
		int newPosition = searchEmployeeByIdentification(newId);
		if((newPosition<0 || newPosition == position) && identification != userLogged.getIdentification()) {
			employeeList.get(position).replaceName(newN);
			employeeList.get(position).replaceLastname(newLn);
			employeeList.get(position).setNewIdentification(newId);
			employeeList.get(position).setLastEditor(userLogged);
			if(employeeList.get(position).getIfHaveUser()) {
				updateUser(identification, newId, newN, newLn);
			}
			updated = true;
			orderEmployeeByIdentification();
			saveDataEmployee();
		}
		return updated;
	}
	public boolean removeEmployee(long identification) throws FileNotFoundException, IOException {
		boolean removed = false;
		if(identification != userLogged.getIdentification()) {
			int position = searchEmployeeByIdentification(identification);
			if(employeeList.get(position).getIfHaveUser()) {
				removeUser(identification);
			}
			employeeList.remove(position);
			removed = true;
			saveDataEmployee();
		}
		return removed;
	}	
	public boolean disableEmployee(long identification) throws FileNotFoundException, IOException {
		boolean disabled = false;
		if(identification != userLogged.getIdentification()) {
			int position = searchEmployeeByIdentification(identification);
			employeeList.get(position).setDisableState();
			employeeList.get(position).setLastEditor(userLogged);
			if(employeeList.get(position).getIfHaveUser()) {
				disableUser(identification);
			}
			disabled = true;
			saveDataEmployee();
		}
		return disabled;
	}
	public void enableEmployee(long identification) throws FileNotFoundException, IOException {
		int position = searchEmployeeByIdentification(identification);
		employeeList.get(position).setEnableState();
		employeeList.get(position).setLastEditor(userLogged);
		if(employeeList.get(position).getIfHaveUser()) {
			enableUser(identification);
		}
		saveDataEmployee();
	}
	
	private void orderUsersByIdentification() {
		for(int i = 1; i<userList.size(); i++) {
			for(int j = i; j>0 && userList.get(j).compareByIdentification(userList.get(j-1))<0; j--) {
				User temp = userList.get(j);
				userList.set(j, userList.get(j-1));
				userList.set(j-1, temp);
			}
		}
	}
	public int searchUserByUsername(String username) {
		Collections.sort(userList);
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = userList.size() -1;
		if(end == 0) {
			if(userList.get(end).getUsername().compareTo(username) == 0) {
				position = end;
			}
		}else {
			while(userList.size()>0 && start <= end && !founded) {
				int mid = (start+end)/2;
				if(userList.get(mid).getUsername().compareTo(username) == 0) {
					founded = true;
					position = mid;
				}else if(userList.get(mid).getUsername().compareTo(username)>0) {
					end = mid-1;
				}else start = mid+1;
			}
		}
		return position;
	}
	private int searchUserByIdentification(long identification) {
		orderUsersByIdentification();
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = userList.size() -1;
		while(userList.size()>0 && start<=end && !founded) {
			int mid = (start+end)/2;
			if(userList.get(mid).getIdentification()==identification) {
				founded = true;
				position = mid;
			}else if(userList.get(mid).getIdentification()>identification) {
				end = mid-1;
			}else start = mid+1;
		}
		return position;
	}
	public boolean createUser(String name, String lastname, long identification, String username,String password) throws FileNotFoundException, IOException {
		boolean added = false;
		int employeePosition = searchEmployeeByIdentification(identification);
		int usernamePosition = searchUserByUsername(username);
		orderUsersByIdentification();
		if(usernamePosition<0) {
			User newUser = new User(name, lastname, identification, userLogged, username, password);
			if(userList.isEmpty()) {
				userList.add(newUser);
				employeeList.get(employeePosition).setHaveUserTrue();
			}else {
				int i = 0;
				for(i = 0; i<userList.size() && userList.get(i).getIdentification()<identification; i++);
				userList.add(i, newUser);
				employeeList.get(employeePosition).setHaveUserTrue();
			}
			saveDataUsers();
			added = true;
		}
		return added;
	}
	public void updateUser(long identification, long newId, String newN, String newLn) throws FileNotFoundException, IOException {
		int position = searchUserByIdentification(identification);
		userList.get(position).setNewIdentification(newId);
		userList.get(position).replaceName(newN);
		userList.get(position).replaceLastname(newLn);
		userList.get(position).setLastEditor(userLogged);
		saveDataUsers();
	}
	public boolean updateUser(String username,long identification, long newId, String newN, String newLn) throws FileNotFoundException, IOException {
		boolean updated = false;
		int position = searchUserByIdentification(identification);
		int employeePosition = searchEmployeeByIdentification(identification);
		int newPosition = searchUserByIdentification(newId);
		int newPositionUsername = searchUserByUsername(username);
		if((newPosition<0 || newPosition == position) && identification != userLogged.getIdentification()) {
			if(username.equals(userList.get(position).getUsername()) || newPositionUsername<0) {
				userList.get(position).setNewIdentification(newId);
				userList.get(position).replaceLastname(newLn);
				userList.get(position).replaceName(newN);
				userList.get(position).setUsername(username);
				userList.get(position).setLastEditor(userLogged);
				employeeList.get(employeePosition).setNewIdentification(newId);
				employeeList.get(employeePosition).replaceLastname(newLn);
				employeeList.get(employeePosition).replaceName(newN);
				employeeList.get(employeePosition).setLastEditor(userLogged);
				updated = true;
				orderEmployeeByIdentification();
				orderUsersByIdentification();
				saveDataEmployee();
				saveDataUsers();
			}
		}
		return updated;
	}
	public boolean removeUser(long identification) throws FileNotFoundException, IOException {
		boolean removed = false;
		if(identification != userLogged.getIdentification()) {
			int position = searchUserByIdentification(identification);
			int employeePosition = searchEmployeeByIdentification(identification);
			employeeList.get(employeePosition).setHaveUserFalse();
			employeeList.get(employeePosition).setLastEditor(userLogged);
			userList.remove(position);
			removed = true;
			saveDataEmployee();
			saveDataUsers();
		}
		return removed;
	}
	public boolean disableUser(long identification) throws FileNotFoundException, IOException {
		boolean disabled = false;
		if(identification != userLogged.getIdentification()) {
			int position = searchUserByIdentification(identification);
			userList.get(position).setDisableState();
			userList.get(position).setLastEditor(userLogged);
			disabled = true;
			saveDataUsers();
		}
		return disabled;
	}
	public void enableUser(long identification) throws FileNotFoundException, IOException {
		int position = searchUserByIdentification(identification);
		userList.get(position).setEnableState();
		userList.get(position).setLastEditor(userLogged);
		saveDataUsers();
	}
	public boolean userLogIn(String username, String password) {
		boolean login = false;
		int position = searchUserByUsername(username);
		if(position >= 0) {
			if(userList.get(position).getState()) {
				if(username.equals(userList.get(position).getUsername()) && password.equals(userList.get(position).getPassword())) {
					login = true;
				}
			}
		}
		orderUsersByIdentification();
		return login;
	}
	
	public void orderClientsByLastnameAndName(){
		Collections.sort(clientList, orderLastnameAndName);
	}
	Comparator<Client> orderLastnameAndName = new Comparator<Client>(){
		@Override
		public int compare(Client c1, Client c2) {
			if(c1.getLastname().compareTo(c2.getLastname()) != 0) {
				return c1.getLastname().compareTo(c2.getLastname());
			}else return c1.getName().compareTo(c2.getName());
		}
	};
	public int searchClientByName(String name, String lastname) {
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = clientList.size();
		if(end == 0) {
			if(clientList.get(end).getLastname().compareTo(lastname) == 0 && clientList.get(end).getName().compareTo(name)==0) {
				position = end;
			}
		}
		while(clientList.size()>0 && start <= end && !founded) {
			int mid = (start+end)/2;
			if(clientList.get(mid).getLastname().compareTo(lastname) == 0) {
				if(clientList.get(mid).getName().compareTo(name) == 0) {
					position = mid;
					founded = true;
				}else if(clientList.get(mid).getName().compareTo(name)>0) {
					end = mid-1;
				}else start = mid+1;
			}else if(clientList.get(mid).getLastname().compareTo(lastname)>0) {
				end = mid-1;
			}else start = mid+1; 
		}
		return position;
	}
	public void createClient(String name, String lastname, long identification,String address, long phone, String observations) throws FileNotFoundException, IOException {
		Client newClient = new Client(name, lastname, identification, userLogged,address, phone, observations);
		if(clientList.isEmpty()) {
			clientList.add(newClient);
		}else{
			int i = 0;
			for(i = 0; i<clientList.size() && orderLastnameAndName.compare(clientList.get(i), newClient)<0; i++);
			clientList.add(i, newClient);
		}
		saveDataClients();
	}
	public boolean updateClient(String name, String lastname, String newN, String newLn, long iD, long ph, String ad, String ob) throws FileNotFoundException, IOException {
		boolean updated = false;
		int position = searchClientByName(name, lastname);
		int newPPosition = searchClientByName(newN, newLn);
		if(newPPosition<0 || newPPosition == position) {
			clientList.get(position).setNewIdentification(iD);
			clientList.get(position).setNewPhone(ph);
			clientList.get(position).setNewAddress(ad);
			clientList.get(position).setNewObservations(ob);
			clientList.get(position).replaceName(newN);
			clientList.get(position).replaceLastname(newLn);
			clientList.get(position).setLastEditor(userLogged);
			updated = true;
			orderClientsByLastnameAndName();
			saveDataClients();
		}
		return updated;
	}
	public boolean removeClient(String name, String lastname) throws FileNotFoundException, IOException {
		boolean removed = false;
		int position = searchClientByName(name, lastname);
		if(position>=0) {
			clientList.remove(position);
			removed = true;
			saveDataClients();
		}
		return removed;
	}
	public boolean disableClient(String name, String lastname) throws FileNotFoundException, IOException {
		boolean disabled = false;
		int position = searchClientByName(name, lastname);
		if(position>=0) {
			clientList.get(position).setDisableState();
			clientList.get(position).setLastEditor(userLogged);
			disabled = true;
			saveDataClients();
		}
		return disabled;
	}
	public boolean enableClient(String name, String lastname) throws FileNotFoundException, IOException {
		boolean enabled = false;
		int position = searchClientByName(name, lastname);
		if(position>=0) {
			clientList.get(position).setEnableState();
			clientList.get(position).setLastEditor(userLogged);
			enabled = true;
			saveDataClients();
		}
		return enabled;
	}
	
	public void orderIngredientsByName() {
		for(int i = 1; i<ingredientList.size(); i++) {
			for(int j = i; j>0 && ingredientList.get(j).getName().compareTo(ingredientList.get(j-1).getName())<0; j--) {
				Ingredient temp = ingredientList.get(j);
				ingredientList.set(j, ingredientList.get(j-1));
				ingredientList.set(j-1, temp);
			}
		}
	}
	public int searchIngredient(String name) {
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = ingredientList.size() -1;
		if(end == 0) {
			if(ingredientList.get(end).getName().compareTo(name)==0) {
				position = end;
			}
		}else {
			while(ingredientList.size()>0 && start <= end && !founded) {
				int mid = (start+end)/2;
				if(ingredientList.get(mid).getName().compareTo(name)==0) {
					position = mid;
					founded = true;
				}else if(ingredientList.get(mid).getName().compareTo(name)>0) {
					end = mid-1;
				}else start = mid+1;
			}
		}
		return position;
	}
	public boolean createIngredient(String name) throws FileNotFoundException, IOException {
		boolean created = false;
		if(searchIngredient(name)<0) {
			Ingredient newIngredient = new Ingredient(name, userLogged);
			if(ingredientList.isEmpty()) {
				ingredientList.add(newIngredient);
			}else {
				int i = 0;
				for(i = 0; i<ingredientList.size() && ingredientList.get(i).getName().compareTo(name)<0; i++);
				ingredientList.add(i,newIngredient);
			}
			created = true;
			saveDataIngredients();
		}
		return created;
	}
	public boolean updateIngredient(String name, String newName) throws FileNotFoundException, IOException {
		boolean updated = false;
		if(searchIngredient(newName)<0 && ingredientList.get(searchIngredient(name)).getUses()==0) {
			int position = searchIngredient(name);
			ingredientList.get(position).setNewName(newName);
			ingredientList.get(position).setLastEditor(userLogged);
			updated = true;
			orderIngredientsByName();
			saveDataIngredients();
		}
		return updated;
	}
	public boolean removeIngredient(String name) throws FileNotFoundException, IOException {
		boolean removed = false;
		int position = searchIngredient(name);
		if(position>=0 && ingredientList.get(position).getUses() == 0) {
			ingredientList.remove(position);
			removed = true;
			saveDataIngredients();
		}
		return removed;
	}
	public boolean disableIngredient(String name) throws FileNotFoundException, IOException {
		boolean disable = false;
		int position = searchIngredient(name);
		if(position>=0) {
			ingredientList.get(position).setDisable();
			ingredientList.get(position).setLastEditor(userLogged);
			disable = true;
			saveDataIngredients();
		}
		return disable;
	}
	public boolean enableIngredient(String name) throws FileNotFoundException, IOException {
		boolean enable = false;
		int position = searchIngredient(name);
		if(position >= 0) {
			ingredientList.get(position).setEnable();
			ingredientList.get(position).setLastEditor(userLogged);
			enable = true;
			saveDataIngredients();
		}
		return enable;
	}
	
	public void orderProducTypesByName() {
		for(int i = 1; i<productTypesList.size(); i++) {
			for(int j = i; j>0 && productTypesList.get(j).getName().compareTo(productTypesList.get(j-1).getName())<0; j--) {
				ProductTypes temp = productTypesList.get(j);
				productTypesList.set(j, productTypesList.get(j-1));
				productTypesList.set(j-1, temp);
			}
		}
	}
	public int searchProductTypes(String name) {
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = productTypesList.size() -1;
		if(end == 0) {
			if(productTypesList.get(end).getName().compareTo(name)==0) {
				position = end;
			}
		}else {
			while(productTypesList.size()>0 && start <= end && !founded) {
				int mid = (start+end)/2;
				if(productTypesList.get(mid).getName().compareTo(name)==0) {
					position = mid;
					founded = true;
				}else if(productTypesList.get(mid).getName().compareTo(name)>0) {
					end = mid-1;
				}else start = mid+1;
			}
		}
		return position;
	}
	public boolean createProductTypes(String name) throws FileNotFoundException, IOException {
		boolean created = false;
		if(searchProductTypes(name)<0) {
			ProductTypes newProductTypes = new ProductTypes(name, userLogged);
			if(productTypesList.isEmpty()) {
				productTypesList.add(newProductTypes);
			}else {
				int i = 0;
				for(i = 0; i<productTypesList.size() && productTypesList.get(i).getName().compareTo(name)<0; i++);
				productTypesList.add(i,newProductTypes);
			}
			created = true;
			saveDataProductTypes();
		}
		return created;
	}
	public boolean updateProductTypes(String name, String newName) throws FileNotFoundException, IOException {
		boolean updated = false;
		if(searchProductTypes(newName)<0 && productTypesList.get(searchProductTypes(name)).getUses() == 0) {
			int position = searchProductTypes(name);
			productTypesList.get(position).setNewName(newName);
			productTypesList.get(position).setLastEditor(userLogged);
			updated = true;
			orderProducTypesByName();
			saveDataProductTypes();
		}
		return updated;
	}
	public boolean removeProductTypes(String name) throws FileNotFoundException, IOException {
		boolean removed = false;
		int position = searchProductTypes(name);
		if(position>=0 && productTypesList.get(position).getUses() == 0) {
			productTypesList.remove(position);
			removed = true;
			saveDataProductTypes();
		}
		return removed;
	}
	public boolean disableProductTypes(String name) throws FileNotFoundException, IOException {
		boolean disable = false;
		int position = searchProductTypes(name);
		if(position>=0) {
			productTypesList.get(position).setDisable();
			productTypesList.get(position).setLastEditor(userLogged);
			disable = true;
			saveDataProductTypes();
		}
		return disable;
	}
	public boolean enableProductType(String name) throws FileNotFoundException, IOException {
		boolean enable = false;
		int position = searchProductTypes(name);
		if(position >= 0) {
			productTypesList.get(position).setEnable();
			productTypesList.get(position).setLastEditor(userLogged);
			enable = true;
			saveDataProductTypes();
		}
		return enable;
	}

	public int searchProduct(String name) {
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = productList.size()-1;
		if(end == 0) {
			if(productList.get(end).getName().equals(name)) {
				position = end;
			}
		}else {
			while(productList.size()>0 && start <= end && !founded) {
				int mid = (start+end)/2;
				if(productList.get(mid).getName().compareTo(name) == 0) {
					position = mid;
					founded = true;
				}else if(productList.get(mid).getName().compareTo(name)>0) {
					end = mid-1;
				}else start = mid+1;
			}
		}
		return position;
	}
	public boolean createProduct(String name, String pT, List<String> ingredients, String size, long price) throws IOException {
		boolean created = false;
		if(searchProduct(name)<0) {
			int productTypePosition = searchProductTypes(pT);
			ProductTypes productType = productTypesList.get(productTypePosition);
			productTypesList.get(productTypePosition).increaseUses();
			ArrayList<Ingredient> ingredientsArray = new ArrayList<>();
			for(int i = 0; i<ingredients.size(); i++) {
				int ingredientPosition = searchIngredient(ingredients.get(i));
				ingredientsArray.add(ingredientList.get(ingredientPosition));
				ingredientList.get(ingredientPosition).increaseUses();
			}
			Product newProduct = new Product(name, userLogged, productType, ingredientsArray, size, price);
			if(productList.isEmpty()) {
				productList.add(newProduct);
			}else {
				int i = 0;
				for(i = 0; i<productList.size() && productList.get(i).getName().compareTo(name)<0; i++);
				productList.add(i, newProduct);
			}
			saveDataProducts();
			saveDataProductTypes();
			saveDataIngredients();
			created = true;
		}
		return created;
	}
	public boolean updateProduct(String name, String newN, String newProductType) throws IOException {
		boolean updated = false;
		int position = searchProduct(name);
		int newPosition = searchProduct(newN);
		if(position >=0 && (newPosition<0 || position == newPosition)) {
			int oldProductTypePosition = searchProductTypes(productList.get(position).getProductType().getName());
			productTypesList.get(oldProductTypePosition).decreaseUses();
			int newProductTypePosition = searchProductTypes(newProductType);
			productTypesList.get(newProductTypePosition).increaseUses();
			productList.get(position).setNewProductType(productTypesList.get(newProductTypePosition));
			productList.get(position).setNewName(newN);
			productList.get(position).setLastEditor(userLogged);
			updated = true;
			saveDataProductTypes();
			saveDataProducts();
		}
		return updated;
	}
	public void addProductIngredient(String name, String ingredient) throws IOException {
		int positionIngredient = searchIngredient(ingredient);
		int position = searchProduct(name);
		productList.get(position).addNewIngredient(ingredientList.get(positionIngredient));
		productList.get(position).setLastEditor(userLogged);
		ingredientList.get(positionIngredient).increaseUses();
		saveDataIngredients();
		saveDataProducts();
	}
	public void removeProductIngredient(String name, String ingredient) throws IOException {
		int positionIngredient = searchIngredient(ingredient);
		int position = searchProduct(name);
		productList.get(position).removeIngredient(ingredient);
		productList.get(position).setLastEditor(userLogged);
		ingredientList.get(positionIngredient).decreaseUses();
		saveDataIngredients();
		saveDataProducts();
	}
	public void addProductSize(String productName, String name, long price) throws IOException {
		int position = searchProduct(productName);
		productList.get(position).addNewSize(name, price);
		productList.get(position).setLastEditor(userLogged);
		saveDataProducts();
	}
	public void removeProductSize(String productName, String name) throws IOException {
		int position = searchProduct(productName);
		productList.get(position).removeSize(name);
		productList.get(position).setLastEditor(userLogged);
		saveDataProducts();
	}
	public boolean removeProduct(String name) throws IOException {
		boolean removed = false;
		int position = searchProduct(name);
		if(position>=0 && productList.get(position).getOrders()==0) {
			for(int i = 0; i<productList.get(position).getIngredients().size(); i++) {
				int ingredientPosition = searchIngredient(productList.get(position).getIngredients().get(i).getName());
				ingredientList.get(ingredientPosition).decreaseUses();
			}
			int productTypePosition = searchProductTypes(productList.get(position).getProductType().getName());
			productTypesList.get(productTypePosition).decreaseUses();
			productList.remove(position);
			removed = true;
			saveDataIngredients();
			saveDataProductTypes();
			saveDataProducts();
		}
		return removed;
	}
	public boolean disableProduct(String name) throws IOException {
		boolean disabled = false;
		int position = searchProduct(name);
		if(position >= 0) {
			productList.get(position).setStateDisable();
			productList.get(position).setLastEditor(userLogged);
			disabled = true;
			saveDataProducts();
		}
		return disabled;
	}
	public boolean enableProduct(String name) {
		boolean enabled = false;
		int position = searchProduct(name);
		if(position >= 0) {
			productList.get(position).setStateEnable();
			productList.get(position).setLastEditor(userLogged);
			enabled = true;
		}
		return enabled;
	}
	
	public int searchOrder(int code) {
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = orderList.size()-1;
		if(end == 0) {
			if(orderList.get(end).getCode() == code) {
				position = end;
			}
		}else {
			while(orderList.size()>0 && start <= end && !founded) {
				int mid = (start+end)/2;
				if(orderList.get(mid).getCode() == code) {
					position = mid;
					founded = true;
				}else if(orderList.get(mid).getCode()>code) {
					end = mid-1;
				}else start = mid+1;
			}
		}
		return position;
	}
	public boolean createOrder(List<String> pNames, List<Long> quantities, List<String> pSizesNames, String cName, String cLastname, long eIdentification, String ob) throws FileNotFoundException, IOException {
		int orderCode = (orderList.size()+1)*((orderList.size()+1)-(orderList.size()/4));
		List<Product> products = new ArrayList<>();
		List<ProductSize> produtcsSize = new ArrayList<>();
		List<Long> productQuantities = new ArrayList<>();
		for(int i = 0; i<pNames.size(); i++) {
			int productPosition = searchProduct(pNames.get(i));
			products.add(productList.get(productPosition));
			productList.get(productPosition).increaseSizeOrders(pSizesNames.get(i));
			int pSizePosition = productList.get(productPosition).searchSize(pSizesNames.get(i));
			produtcsSize.add(productList.get(productPosition).getProductSizes().get(pSizePosition));
			productQuantities.add(quantities.get(i));
		}
		int clientPosition = searchClientByName(cName, cLastname);
		Client clientOrder = clientList.get(clientPosition);
		int employeePosition = searchEmployeeByIdentification(eIdentification);
		employeeList.get(employeePosition).increaseOrders();
		Employee employeeOrder = employeeList.get(employeePosition);
		Date oD = new Date();
		Order newOrder = new Order(orderCode, products, productQuantities, produtcsSize, clientOrder, employeeOrder, oD, ob);
		int i = 0;
		for(i = 0; i<orderList.size() && orderList.get(i).getCode()<orderCode; i++);
		orderList.add(i,newOrder);
		saveDataProducts();
		saveDataOrders();
		return true;
	}
	public boolean updateOrder(int code, String ob) throws FileNotFoundException, IOException {
		boolean updated = false;
		int orderPosition = searchOrder(code);
		if(orderPosition >= 0) {
			updated = orderList.get(orderPosition).updateState();
			orderList.get(orderPosition).setNewObservations(ob);
			saveDataOrders();
		}
		return updated;
	}
	public boolean removeOrder(int code) throws FileNotFoundException, IOException {
		boolean removed = false;
		int position = searchOrder(code);
		if(position >= 0) {
			int positionEmployee = searchEmployeeByIdentification(orderList.get(position).getEmployee().getIdentification());
			employeeList.get(positionEmployee).decreaseOrders();
			for(int i = 0; i<orderList.get(position).getProductsList().size(); i++) {
				int positionProduct = searchProduct(orderList.get(position).getProductsList().get(i).getName());
				String tempProductSize = orderList.get(position).getProductsSize().get(i).getName();
				productList.get(positionProduct).decreaseSizeOrders(tempProductSize);
			}
			orderList.remove(position);
			removed = true;
			saveDataOrders();
		}
		return removed;
	}
}
