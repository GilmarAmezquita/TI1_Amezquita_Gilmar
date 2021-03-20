package model;

public abstract class Person {
	private String name;
	private String lastname;
	private long identification;
	private boolean state;
	
	public Person(String n, String ln) {
		name = n;
		lastname = ln;
		identification = 0;
		state = true;
	}
	public Person(String n, String ln, long id) {
		name = n;
		lastname = ln;
		identification = id;
		state = true;
	}
	
	public String getName() {
		return name;
	}
	
	public void replaceName(String nn) {
		name = nn;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void replaceLastname(String nln) {
		lastname = nln;
	}
	
	public long getIdentification() {
		return identification;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void setDisableState() {
		state = false;
	}
	
	public void setEnableState() {
		state = true;
	}
}
