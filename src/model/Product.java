package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private ProductTypes productType;
	private List<Ingredient> ingredientsList;
	private List<ProductSizes> productSizes;
	
	public Product(String n, ProductTypes pT, ArrayList<Ingredient> i) {
		name = n;
		productType = pT;
		ingredientsList = i;
	}
	public String getName() {
		return name;
	}
	public void setNewName(String newName) {
		name = newName;
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
	public void removeIngredient(Ingredient removeIngredient) {
		
		
	}
	public List<ProductSizes> getProductSizes(){
		return productSizes;
	}
	public void addNewSize(ProductSizes newProductSizes) {
		productSizes.add(newProductSizes);
	}
}
