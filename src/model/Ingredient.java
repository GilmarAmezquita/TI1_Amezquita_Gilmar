package model;

public class Ingredient {
	private String name;
	private int uses;
	private boolean state;
	private User whoCreate;
	private User lastEdit;
	
	public Ingredient(String n, User creator) {
		name = n;
		uses = 0;
		state = true;
		whoCreate = creator;
		lastEdit = null;
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
	public User getCreator() {
		return whoCreate;
	}
	public User getLastEditor() {
		return lastEdit;
	}
	public void setLastEditor(User lastEditor) {
		lastEdit = lastEditor;
	}
}
