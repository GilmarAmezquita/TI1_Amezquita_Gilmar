package model;

public class Employee extends Person {
	private int orders;
	private boolean haveUser;
	
	public Employee(String n, String ln, long id, User creator) {
		super(n, ln, id, creator);
		orders = 0;
	}
	public void increaseOrders() {
		orders++;
	}
	public int getOrders() {
		return orders;
	}
	public void setHaveUserTrue() {
		haveUser = true;
	}
	public void setHaveUserFalse() {
		haveUser = false;
	}
	public boolean getIfHaveUser() {
		return haveUser;
	}
}
