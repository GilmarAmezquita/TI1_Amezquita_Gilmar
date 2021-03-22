package model;

import java.util.Date;
import java.util.List;

public class Order {
	private int code;
	private OrderState state;
	private List<Product> productsList;
	private List<Long> productsQuantity;
	private Client clientOrder;
	private Employee employeeDelivers;
	private Date orderDate;
	
	public Order(int c, List<Product> p, List<Long> q, Client client, Employee employee, Date oD) {
		code = c;
		state = OrderState.SOLICITADO;
		productsList = p;
		productsQuantity = q;
		clientOrder = client;
		employeeDelivers = employee;
		orderDate = oD;
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
	public Client getClient() {
		return clientOrder;
	}
	public Employee getEmployee() {
		return employeeDelivers;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public long getPrice() {
		long price = 0;
		for(int i = 0; i<productsList.size(); i++) {
			price += productsList.get(i).getPrice()*productsQuantity.get(i);
		}
		return price;
	}
	public void updateState() {
		if(state == OrderState.SOLICITADO) {
			state = OrderState.EN_PROCESO;
		}else if(state == OrderState.EN_PROCESO) {
			 state = OrderState.ENVIADO;
		}else state = OrderState.ENTREGADO;
	}
}
