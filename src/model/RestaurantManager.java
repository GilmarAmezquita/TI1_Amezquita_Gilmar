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
	
	public List<Employee> getEmployeeList(){
		return employeeList;
	}
	
	private int searchUser(String username) {
		boolean founded = false;
		int position = 0;
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
		if(!founded) {
			position = -1;
		}
		return position;
	}
	
	private boolean searchIfEmployeeHaveUser(String name, String lastname) {
		boolean founded = false;
		int start = 0;
		int end = userList.size();
		while(userList.size()>0 && start <= end && !founded) {
			int mid = (start+end)/2;
			if(userList.get(mid).getName().compareTo(name) == 0) {
				if(userList.get(mid).getLastname().compareTo(lastname)==0) {
					founded = true;
				}
			}else if(userList.get(mid).getName().compareTo(name) > 0) {
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
	
	public boolean createUser(String name, String lastname, long identifier, String username,String password) {
		boolean noCreate = searchIfEmployeeHaveUser(name, lastname);
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
		
	public void addEmployee(String n, String ln, long id) {
		Employee newEmployee = new Employee(n, ln, id);
		employeeList.add(newEmployee);
	}
	
	public void addClient(String n, String ln, String a, long p, String o) {
		Client newClient = new Client(n, ln, a, p, o);
		clientList.add(newClient);
	}
}
