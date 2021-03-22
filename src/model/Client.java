package model;

public class Client extends Person{
	private static final long serialVersionUID = 1;
	private String address;
	private long phone;
	private String observations;

	public Client(String n, String ln, long id, User creator, String a, long p, String o) {
		super(n, ln, id, creator);
		address = a;
		phone = p;
		observations = o;
	}
	public String getAddress() {
		return address;
	}
	public void setNewAddress(String newAddress) {
		address = newAddress;
	}
	public long getPhone() {
		return phone;
	}
	public void setNewPhone(long newPhone) {
		phone = newPhone;
	}
	public String getObservations() {
		return observations;
	}
	public void setNewObservations(String newObservations) {
		observations = newObservations;
	}
}
