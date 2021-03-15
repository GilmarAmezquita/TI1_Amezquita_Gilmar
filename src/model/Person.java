package model;

public abstract class Person {
	private String name;
	private String lastname;
	
	public Person(String n, String ln) {
		name = n;
		lastname = ln;
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
}
