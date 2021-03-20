package model;

import java.util.ArrayList;
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
		int position = searchUser(username);
		userLogged = userList.get(position);
	}
	
	public void setuserLoggedNull() {
		userLogged = null;
	}
	
	private int searchUser(String username) {
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
	
	public int searchIdentification(long identification) {
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
	
	private boolean searchIfEmployeeHaveUser(long identification) {
		boolean founded = false;
		int start = 0;
		int end = userList.size();
		while(userList.size()>0 && start <= end && !founded) {
			int mid = (start+end)/2;
			if(userList.get(mid).getIdentification() == identification) {
				founded = true;
			}else if(userList.get(mid).getIdentification() > identification) {
				end = mid-1;
			}else start = mid+1;
		}
		return founded;
	}
	
	public boolean userLogIn(String username, String password) {
		boolean login = false;
		int position = searchUser(username);
		if(position >= 0) {
			if(username.equals(userList.get(position).getUsername()) && password.equals(userList.get(position).getPassword())) {
				login = true;
			}
		}
		return login;
	}
	
	public boolean createEmployee(String name, String lastname, long identifier) {
		boolean added = false;
		if(searchIdentification(identifier)<0) {
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
	
	public boolean removeEmployee(long identifier) {
		int position = searchIdentification(identifier);
		employeeList.remove(position);
		return true;
	}
	
	public void disableEmployee(long identification) {
		int position = searchIdentification(identification);
		employeeList.get(position).setDisableState();
	}
	
	public void enableEmployee(long identification) {
		int position = searchIdentification(identification);
		employeeList.get(position).setEnableState();
	}
	
	public boolean createUser(String name, String lastname, long identifier, String username,String password) {
		boolean noCreate = searchIfEmployeeHaveUser(identifier);
		boolean added = false;
		if(searchUser(username) < 0 && !noCreate) {
			User newUser = new User(name, lastname, identifier, username, password);
			if(userList.isEmpty()) {
				userList.add(newUser);
			}else {
				int i;
				for(i = 0; i<userList.size() && userList.get(i).getUsername().compareTo(username)<0; i++);
				userList.add(i, newUser);
			}
			added = true;
		}
		return added;
	}
	
	public void addClient(String n, String ln, String a, long p, String o) {
		Client newClient = new Client(n, ln, a, p, o);
		clientList.add(newClient);
	}
}
