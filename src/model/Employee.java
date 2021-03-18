package model;

public class Employee extends Person{
	private int orders;
	public Employee(String n, String ln, long id) {
		super(n, ln, id);
		orders = 0;
	}
	
	public void increaseOrders() {
		orders++;
	}
	
	public int getOrders() {
		return orders;
	}
}
