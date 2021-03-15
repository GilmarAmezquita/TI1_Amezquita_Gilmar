package model;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
	private List<Client> clientList;
	private List<Employee> employeeList;
	private List<User> userList;
	
	public RestaurantManager() {
		clientList = new ArrayList<>();
		employeeList = new ArrayList<>();
		userList = new ArrayList<>();
	}
	
	private int searchUser(String username) {
		boolean founded = false;
		int position = 0;
		int start = 0;
		int end = userList.size();
		while(start <= end && !founded) {
			int mid = (start+end)/2;
			if(userList.get(mid).getUsername().compareTo(username) == 0) {
				founded = true;
				position = mid;
			}else if(userList.get(mid).getUsername().compareTo(username)>0) {
				end = mid-1;
			}else start = mid+1;
		}
		if(!founded) {
			position = -1;
		}
		return position;
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
	
	public boolean addUser(String name, String lastname, int identifier, String username,String password) {
		boolean added = false;
		if(searchUser(username) < 0) {
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
	
	private int defineEmployeeIdentifier() {
		int identifier = 0;
		identifier = employeeList.size();
		return identifier;
	}
	
	public void addEmployee(String n, String ln) {
		int i = defineEmployeeIdentifier();
		Employee newEmployee = new Employee(n, ln, i);
		employeeList.add(newEmployee);
	}
	
	public void addClient(String n, String ln, String a, long p, String o) {
		Client newClient = new Client(n, ln, a, p, o);
		clientList.add(newClient);
	}
}
