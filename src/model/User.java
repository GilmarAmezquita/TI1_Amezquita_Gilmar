package model;

public class User extends Employee implements Comparable<User>{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public User(String n, String ln, long i, User creator, String un, String ps) {
		super(n, ln, i, creator);
		username = un;
		password = ps;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String un) {
		username = un;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String ps) {
		password = ps;
	}
	@Override
	public int compareTo(User o) {
		return username.compareTo(o.getUsername());
	}
}
