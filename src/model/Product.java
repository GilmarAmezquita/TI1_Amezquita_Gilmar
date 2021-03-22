package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private ProductTypes productType;
	private List<Ingredient> ingredientsList;
	private String size;
	private long price;
	private User whoCreated;
	private User lastEdited;
	
	public Product(String n, User creator, ProductTypes pT, ArrayList<Ingredient> i, String s, long p) {
		name = n;
		productType = pT;
		ingredientsList = i;
		size = s;
		price = p;
		whoCreated = creator;
		lastEdited = null;
	}
	public String getName() {
		return name;
	}
	public void setNewName(String newName) {
		name = newName;
	}
	public User getCreator() {
		return whoCreated;
	}
	public User getLastEditor() {
		return lastEdited;
	}
	public void setLastEditor(User lastEditor) {
		lastEdited = lastEditor;
	}	
	public ProductTypes getProductType() {
		return productType;
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
	public String getSize() {
		return size;
	}
	public void setNewSize(String newSize) {
		size = newSize;
	}
	public long getPrice() {
		return price;
	}
	public void setNewPrice(long newPrice) {
		price = newPrice;
	}
}
