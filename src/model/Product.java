package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private ProductTypes productType;
	private List<Ingredient> ingredientsList;
	private List<ProductSize> productSizesList;
	private boolean state;
	private int orders;
	private User whoCreated;
	private User lastEditor;
	private String lastEditorName;
	
	public Product(String n, User creator, ProductTypes pT, ArrayList<Ingredient> i, String s, long p) {
		name = n;
		productType = pT;
		ingredientsList = i;
		ProductSize newProductSize = new ProductSize(s, p);
		productSizesList = new ArrayList<>();
		productSizesList.add(newProductSize);
		state = true;
		orders = 0;
		whoCreated = creator;
		lastEditor = null;
		lastEditorName = null;
	}
	public String getName() {
		return name;
	}
	public void setNewName(String newName) {
		name = newName;
	}
	public void setNewProductType(ProductTypes newProductType) {
		productType = newProductType;
	}
	public List<Ingredient> getIngredients(){
		return ingredientsList;
	}
	public void addNewIngredient(Ingredient newIngredient) {
		ingredientsList.add(newIngredient);
	}
	public void removeIngredient(String removeIngredient) {
		boolean removed = false;
		for(int i = 0; i<ingredientsList.size() && !removed; i++) {
			if(ingredientsList.get(i).getName().equals(removeIngredient)) {
				ingredientsList.remove(i);
				removed = true;
			}
		}
		
	}
	public int searchSize(String name) {
		boolean founded = false;
		int position = -1;
		int start = 0;
		int end = productSizesList.size()-1;
		if(end == 0) {
			if(productSizesList.get(end).getName().compareTo(name)==0) {
				position = end;
			}
		}else {
			while(productSizesList.size()>0 && start <= end && !founded) {
				int mid = (start+end)/2;
				if(productSizesList.get(mid).getName().compareTo(name)==0) {
					position = mid;
					founded = true;
				}else if(productSizesList.get(mid).getName().compareTo(name)>0) {
					end = mid-1;
				}else start = mid+1;
			}
		}
		return position;
	}
	public List<ProductSize> getProductSizes(){
		return productSizesList;
	}
	public void addNewSize(String n, long p) {
		ProductSize newProductSize = new ProductSize(n, p);
		productSizesList.add(newProductSize);
	}
	public boolean removeSize(String n) {
		boolean removed = false;
		for(int i = 0; i<productSizesList.size() && !removed; i++) {
			if(productSizesList.get(i).getName().equals(n) && productSizesList.get(i).getOrders()==0) {
				productSizesList.remove(i);
				removed = true;
			}
		}
		return removed;
	}
	public boolean getState() {
		return state;
	}
	public void setStateEnable() {
		state = true;
	}
	public void setStateDisable() {
		state = false;
	}
	public void increaseSizeOrders(String name) {
		int position = searchSize(name);
		productSizesList.get(position).increaseOrders();
		updateOrders();
	}
	public void decreaseSizeOrders(String name) {
		int position = searchSize(name);
		productSizesList.get(position).decreaseOrders();
		updateOrders();
	}
	public void updateOrders() {
		int o = 0;
		for(int i = 0; i<productSizesList.size(); i++) {
			o += productSizesList.get(i).getOrders();
		}
		orders = o;
	}
	public int getOrders() {
		return orders;
	}
	public User getCreator() {
		return whoCreated;
	}
	public User getLastEditor() {
		return lastEditor;
	}
	public void setLastEditor(User lE) {
		lastEditor = lE;
		lastEditorName = lE.getUsername();
	}
	public String getLastEditorName() {
		return lastEditorName;
	}
	public ProductTypes getProductType() {
		return productType;
	}
}
