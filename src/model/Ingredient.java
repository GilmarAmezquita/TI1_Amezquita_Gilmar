package model;

import java.io.Serializable;

public class Ingredient implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int uses;
	private boolean state;
	private User whoCreate;
	private User lastEditor;
	private String lastEditorName;
	
	public Ingredient(String n, User creator) {
		name = n;
		uses = 0;
		state = true;
		whoCreate = creator;
		lastEditor = null;
		lastEditorName = null;
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
		return lastEditor;
	}
	public void setLastEditor(User lE) {
		lastEditor = lE;
		lastEditorName = lE.getUsername();
	}
	public String getLastEditorName() {
		return lastEditorName;
	}
}
