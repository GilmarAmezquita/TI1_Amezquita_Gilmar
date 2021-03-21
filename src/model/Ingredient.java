package model;

public class Ingredient {
	private String name;
	private int uses;
	private boolean state;
	
	public Ingredient(String n) {
		name = n;
		uses = 0;
		state = true;
	}
	public String getName() {
		return name;
	}
	public void setNewName(String nn) {
		name = nn;
	}
	public int getUses() {
		return uses;
	}
	public void increaseUses() {
		uses++;
	}
	public void decreaseUses() {
		uses--;
	}
	public boolean getState() {
		return state;
	}
	public void setEnable() {
		state = true;
	}
	public void setDisable() {
		state = false;
	}
}
