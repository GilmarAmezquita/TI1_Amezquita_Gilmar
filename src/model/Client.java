package model;

public class Client extends Person{
	private String address;
	private long phone;
	private String observations;
	
	public Client(String n, String ln, String a, long p, String o) {
		super(n,ln);
		address = a;
		phone = p;
		observations = o;
	}
	
	public Client(String n, String ln, long id, String a, long p, String o) {
		super(n, ln, id);
		address = a;
		phone = p;
		observations = o;
	}
	
	public String getAddress() {
		return address;
	}
	
	public long getPhone() {
		return phone;
	}
	
	public String getObservations() {
		return observations;
	}
}
