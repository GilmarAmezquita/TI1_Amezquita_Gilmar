package model;

public abstract class Person {
	private long identification;
	private String name;
	private String lastname;
	private boolean state;

	public Person(String n, String ln, long id) {
		name = n;
		lastname = ln;
		identification = id;
		state = true;
	}
	public long getIdentification() {
		return identification;
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
