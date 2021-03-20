package model;

public class User extends Employee {
	private String username;
	private String password;
	
	public User(String n, String ln, long i, String un,String ps) {
		super(n, ln, i);
		username = un;
		password = ps;
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
}
