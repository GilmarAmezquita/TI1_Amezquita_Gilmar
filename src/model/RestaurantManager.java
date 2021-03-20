package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestaurantManager {
	private List<Client> clientList;
	private List<Employee> employeeList;
	private List<User> userList;
	private User userLogged;
		
	public RestaurantManager() {
		clientList = new ArrayList<>();
		employeeList = new ArrayList<>();
		userList = new ArrayList<>();
	}
	public List<Employee> getEmployeeList(){
		return employeeList;
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
	
	private int searchUserByUsername(String username) {
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
	
	public boolean userLogIn(String username, String password) {
		boolean login = false;
		int position = searchUserByUsername(username);
		if(position >= 0) {
			if(username.equals(userList.get(position).getUsername()) && password.equals(userList.get(position).getPassword())) {
				login = true;
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

	
	public void addClient(String n, String ln, String a, long p, String o) {
		Client newClient = new Client(n, ln, a, p, o);
		clientList.add(newClient);
	}
}
