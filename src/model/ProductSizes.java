package model;

public class ProductSizes {
	private String name;
	private long price;
	
	public ProductSizes(String n, long p) {
		name = n;
		price = p;
	}
	public String getName() {
		return name;
	}
	public void setNewName(String newName) {
		name = newName;
	}
	public long getPrice() {
		return price;
	}
	public void setNewPrice(long newPrice) {
		price = newPrice;
	}
}
