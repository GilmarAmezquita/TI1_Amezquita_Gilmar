package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RestaurantManager {
	private List<Employee> employeeList;
	private List<User> userList;
	private List<Client> clientList;
	private List<Ingredient> ingredientList;
	private List<ProductTypes> productTypesList;
	private User userLogged;
		
	public RestaurantManager() {
		employeeList = new ArrayList<>();
		userList = new ArrayList<>();
		clientList = new ArrayList<>();
		ingredientList = new ArrayList<>();
		productTypesList = new ArrayList<>();
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
	private void orderUsersByUsername() {
		Collections.sort(userList);
	}
	private void orderUsersByIdentification() {
		for(int i = 1; i<userList.size(); i++) {
			for(int j = i; j>0 && userList.get(j).getIdentification()<userList.get(j-1).getIdentification(); j--) {
				User temp = userList.get(j);
				userList.set(j, userList.get(j-1));
				userList.set(j-1, temp);
			}
		}
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
	
	public int searchUserByUsername(String username) {
		orderUsersByUsername();
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = userList.size();
		while(userList.size()>0 && start <= end && !founded) {
			int mid = (start+end)/2;
			if(userList.get(mid).getUsername().compareTo(username) == 0) {
				founded = true;
				position = mid;
			}else if(userList.get(mid).getUsername().compareTo(username)>0) {
				end = mid-1;
			}else start = mid+1;
		}
		return position;
	}
	private int searchUserByIdentification(long identification) {
		orderUsersByIdentification();
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = userList.size();
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
	public int searchEmployeeByIdentification(long identification) {
		boolean founded= false;
		int position = -1;
		int start = 0;
		int end = employeeList.size();
		while(employeeList.size()>0 && start <= end && !founded) {
			int mid = (start+end)/2;
			if(employeeList.get(mid).getIdentification() == identification) {
				founded = true;
				position = mid;
			}else if(employeeList.get(mid).getIdentification() > identification){
				end = mid-1;
			}else start = mid+1;
		}
		return position;
	}
	public int searchClientByName(String name, String lastname) {
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = clientList.size();
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
	public int searchIngredient(String name) {
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = ingredientList.size();
		while(ingredientList.size()>0 && start <= end && !founded) {
			int mid = (start+end)/2;
			if(ingredientList.get(mid).getName().compareTo(name)==0) {
				position = mid;
				founded = true;
			}else if(ingredientList.get(mid).getName().compareTo(name)>0) {
				end = mid-1;
			}else start = mid+1;
		}
		return position;
	}
	public int searchProductTypes(String name) {
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = productTypesList.size();
		while(productTypesList.size()>0 && start <= end && !founded) {
			int mid = (start+end)/2;
			if(productTypesList.get(mid).getName().compareTo(name)==0) {
				position = mid;
				founded = true;
			}else if(productTypesList.get(mid).getName().compareTo(name)>0) {
				end = mid-1;
			}else start = mid+1;
		}
		return position;
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
		return login;
	}
	
	public boolean createEmployee(String name, String lastname, long identifier) {
		boolean added = false;
		if(searchEmployeeByIdentification(identifier)<0) {
			Employee newEmployee = new Employee(name, lastname, identifier);
			if(employeeList.isEmpty()) {
				employeeList.add(newEmployee);
			}else {
				int i = 0;
				for(i = 0; i<employeeList.size() && employeeList.get(i).getIdentification()<identifier; i++);
				employeeList.add(i, newEmployee);
			}
			added = true;
		}
		return added;
	}
	public void updateEmployeeName(long identification, String newName) {
		int position = searchEmployeeByIdentification(identification);
		employeeList.get(position).replaceName(newName);
		if(employeeList.get(position).getIfHaveUser()) {
			updateUserName(identification, newName);
		}
	}
	public void updateEmployeeLastname(long identification, String newLastname) {
		int position = searchEmployeeByIdentification(identification);
		employeeList.get(position).replaceLastname(newLastname);
		if(employeeList.get(position).getIfHaveUser()) {
			updateUserLastname(identification, newLastname);
		}
	}
	public void removeEmployee(long identification) {
		int position = searchEmployeeByIdentification(identification);
		if(employeeList.get(position).getIfHaveUser()) {
			removeUser(identification);
		}
		employeeList.remove(position);
	}	
	public void disableEmployee(long identification) {
		int position = searchEmployeeByIdentification(identification);
		employeeList.get(position).setDisableState();
		if(employeeList.get(position).getIfHaveUser()) {
			disableUser(identification);
		}
	}
	public void enableEmployee(long identification) {
		int position = searchEmployeeByIdentification(identification);
		employeeList.get(position).setEnableState();
		if(employeeList.get(position).getIfHaveUser()) {
			enableUser(identification);
		}
	}
	
	public boolean createUser(String name, String lastname, long identifier, String username,String password) {
		boolean noCreate = employeeList.get(searchEmployeeByIdentification(identifier)).getIfHaveUser();
		boolean added = false;
		if(searchUserByUsername(username) < 0 && !noCreate) {
			User newUser = new User(name, lastname, identifier, username, password);
			if(userList.isEmpty()) {
				userList.add(newUser);
				employeeList.get(0).setHaveUserTrue();
			}else {
				int i;
				for(i = 0; i<userList.size() && userList.get(i).getUsername().compareTo(username)<0; i++);
				userList.add(i, newUser);
				employeeList.get(i).setHaveUserTrue();
			}
			added = true;
		}
		return added;
	}
	public void updateUserName(long identification, String newName) {
		int position = searchUserByIdentification(identification);
		userList.get(position).replaceName(newName);
	}
	public void updateUserLastname(long identification, String newLastname) {
		int position = searchUserByIdentification(identification);
		userList.get(position).replaceLastname(newLastname);
	}
	public void removeUser(long identification) {
		int position = searchUserByIdentification(identification);
		int employeePosition = searchEmployeeByIdentification(identification);
		employeeList.get(employeePosition).setHaveUserFalse();
		userList.remove(position);
	}
	public void disableUser(long identification) {
		int position = searchUserByIdentification(identification);
		userList.get(position).setDisableState();
	}
	public void enableUser(long identification) {
		int position = searchUserByIdentification(identification);
		userList.get(position).setEnableState();
	}
	
	public void createClient(String name, String lastname, long identification,String address, long phone, String observations) {
		Client newClient = new Client(name, lastname, identification,address, phone, observations);
		if(clientList.isEmpty()) {
			clientList.add(newClient);
		}else{
			int i = 0;
			for(i = 0; i<clientList.size() && orderLastnameAndName.compare(clientList.get(i), newClient)<0; i++);
			clientList.add(i, newClient);
		}
	}
	public void updateClientName(String name, String lastname, String newName) {
		int position = searchClientByName(name, lastname);
		clientList.get(position).replaceName(newName);
		orderClientsByLastnameAndName();
	}
	public void updateClientLastname(String name, String lastname, String newLastname) {
		int position = searchClientByName(name, lastname);
		clientList.get(position).replaceLastname(newLastname);
		orderClientsByLastnameAndName();
	}
	public void updateClientAddress(String name, String lastname, String newAddress) {
		int position = searchClientByName(name, lastname);
		clientList.get(position).setNewAddress(newAddress);
	}
	public void updateClientPhone(String name, String lastname, long newPhone) {
		int position = searchClientByName(name, lastname);
		clientList.get(position).setNewPhone(newPhone);
	}
	public void updateClientObservations(String name, String lastname, String newObservations) {
		int position = searchClientByName(name, lastname);
		clientList.get(position).setNewObservations(newObservations);
	}
	public void removeClient(String name, String lastname) {
		int position = searchClientByName(name, lastname);
		clientList.remove(position);
	}
	public void disableClient(String name, String lastname) {
		int position = searchClientByName(name, lastname);
		clientList.get(position).setDisableState();
	}
	public void enableClient(String name, String lastname) {
		int position = searchClientByName(name, lastname);
		clientList.get(position).setEnableState();
	}
	
	public boolean createIngredient(String name) {
		boolean created = false;
		if(searchIngredient(name)<0) {
			Ingredient newIngredient = new Ingredient(name);
			if(ingredientList.isEmpty()) {
				ingredientList.add(newIngredient);
			}else {
				int i = 0;
				for(i = 0; i<ingredientList.size() && ingredientList.get(i).getName().compareTo(name)<0; i++);
				ingredientList.add(newIngredient);
			}
			created = true;
		}
		return created;
	}
	public boolean updateIngredientName(String name, String newName) {
		boolean updated = false;
		if(searchIngredient(newName)<0 && ingredientList.get(searchIngredient(name)).getUses()==0) {
			int position = searchIngredient(name);
			ingredientList.get(position).setNewName(newName);
			updated = true;
		}
		return updated;
	}
	public boolean removeIngredient(String name) {
		boolean removed = false;
		int position = searchIngredient(name);
		if(ingredientList.get(position).getUses() == 0) {
			ingredientList.remove(position);
			removed = true;
		}
		return removed;
	}
	public void disableIngredient(String name) {
		int position = searchIngredient(name);
		ingredientList.get(position).setDisable();
	}
	public void enableIngredient(String name) {
		int position = searchIngredient(name);
		ingredientList.get(position).setEnable();
	}

	public boolean createProductTypes(String name) {
		boolean created = false;
		if(searchProductTypes(name)<0) {
			ProductTypes newProductTypes = new ProductTypes(name);
			if(productTypesList.isEmpty()) {
				productTypesList.add(newProductTypes);
			}else {
				int i = 0;
				for(i = 0; i<productTypesList.size() && productTypesList.get(i).getName().compareTo(name)<0; i++);
				productTypesList.add(i,newProductTypes);
			}
			created = true;
		}
		return created;
	}
	public boolean updateProductTypesName(String name, String newName) {
		boolean updated = false;
		if(searchProductTypes(newName)<0 && productTypesList.get(searchProductTypes(name)).getUses() == 0) {
			int position = searchProductTypes(name);
			productTypesList.get(position).setNewName(newName);
			updated = true;
		}
		return updated;
	}
	public boolean removeProductTypes(String name) {
		boolean removed = false;
		int position = searchProductTypes(name);
		if(productTypesList.get(position).getUses() == 0) {
			productTypesList.remove(position);
			removed = true;
		}
		return removed;
	}
	public void disableProductTypes(String name) {
		int position = searchProductTypes(name);
		productTypesList.get(position).setDisable();
	}
	public void enableProductType(String name) {
		int position = searchProductTypes(name);
		productTypesList.get(position).setEnable();
	}
}
