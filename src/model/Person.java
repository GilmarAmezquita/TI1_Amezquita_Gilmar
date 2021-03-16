package model;

public abstract class Person {
	private String name;
	private String lastname;
	private long identification;
	
	public Person(String n, String ln) {
		name = n;
		lastname = ln;
		identification = 0;
	}
	public Person(String n, String ln, long id) {
		name = n;
		lastname = ln;
		identification = id;
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
}
