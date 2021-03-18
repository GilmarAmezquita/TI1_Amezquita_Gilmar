package model;

public class User extends Employee {
	private String username;
	private String password;
	private boolean state; 
	
	public User(String n, String ln, long i, String un,String ps) {
		super(n, ln, i);
		username = un;
		password = ps;
		state = true;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String un) {
		username = un;
	}
	
	public void setPassword(String ps) {
		password = ps;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void setDisable() {
		state = false;
	}
	
	public void setEnable() {
		state = true;
	}
}
