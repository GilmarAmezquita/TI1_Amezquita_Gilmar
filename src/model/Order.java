package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private int code;
	private OrderState status;
	private List<Product> productsList;
	private List<Long> productsQuantity;
	private List<ProductSize> productsSize;
	private long price;
	private Client clientOrder;
	private Employee employeeDelivers;
	private Date orderDate;
	private String observations;
	
	private String clientName;
	private String clientLastname;
	private String employeeName;
	private String employeeLastname;
	
	public Order(int c, List<Product> p, List<Long> q, List<ProductSize> pS, Client client, Employee employee, Date oD, String oB) {
		code = c;
		status = OrderState.SOLICITADO;
		productsList = p;
		productsQuantity = q;
		productsSize = pS;
		setPrice();
		clientOrder = client;
		employeeDelivers = employee;
		orderDate = oD;
		observations = oB;
		
		clientName = client.getName();
		clientLastname = client.getLastname();
		employeeName = employee.getName();
		employeeLastname = employee.getLastname();
	}
	public int getCode() {
		return code;
	}
	public List<Product> getProductsList(){
		return productsList;
	}
	public List<Long> getQuantityList(){
		return productsQuantity;
	}
	public List<ProductSize> getProductsSize(){
		return productsSize;
	}
	public Client getClient() {
		return clientOrder;
	}
	public Employee getEmployee() {
		return employeeDelivers;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setPrice() {
		long p = 0;
		for(int i = 0; i<productsList.size(); i++) {
			p += productsSize.get(i).getPrice()*productsQuantity.get(i);
		}
		price = p;
	}
	public long getPrice() {
		return price;
	}
	public OrderState getStatus() {
		return status;
	}
	public boolean updateState() {
		boolean updated = false;
		if(status == OrderState.SOLICITADO) {
			status = OrderState.EN_PROCESO;
			updated = true;
		}else if(status == OrderState.EN_PROCESO) {
			 status = OrderState.ENVIADO;
			 updated = true;
		}else if(status == OrderState.ENVIADO){
			status = OrderState.ENTREGADO;
			updated = true;
		}
		return updated;
	}
	public String getObservations() {
		return observations;
	}
	public void setNewObservations(String newOb) {
		observations = newOb;
	}
	public String getClientName() {
		return clientName;
	}
	public String getClientLastname() {
		return clientLastname;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public String getEmployeeLastname() {
		return employeeLastname;
	}
	
}
