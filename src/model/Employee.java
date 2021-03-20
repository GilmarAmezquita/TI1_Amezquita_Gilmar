package model;

public class Employee extends Person{
	private int orders;
	private boolean haveUser;
	public Employee(String n, String ln, long id) {
		super(n, ln, id);
		orders = 0;
		haveUser = false;
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
