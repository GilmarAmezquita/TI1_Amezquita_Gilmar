package model;

import java.io.Serializable;

public class ProductSize implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private long price;
	private int orders;
	
	public ProductSize(String n, long p) {
		name = n;
		price = p;
		orders  = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String newN) {
		name = newN;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long newP) {
		price = newP;
	}
	public int getOrders() {
		return orders;
	}
	public void increaseOrders() {
		orders++;
	}
	public void decreaseOrders() {
		orders--;
	}
}
