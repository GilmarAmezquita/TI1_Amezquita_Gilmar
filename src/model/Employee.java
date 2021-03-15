package model;

public class Employee extends Person{
	private int identifier;
	
	public Employee(String n, String ln, int i) {
		super(n, ln);
		defineIdentifier(i);
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	private void defineIdentifier(int i) {
		identifier = i;
	}
}
