package model;

import java.io.Serializable;

public abstract class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private long identification;
	private String name;
	private String lastname;
	private boolean state;
	private User whoCreate;
	private User lastEditor;
	private String lastEditorName;

	public Person(String n, String ln, long id, User creator) {
		name = n;
		lastname = ln;
		identification = id;
		state = true;
		whoCreate = creator;
		lastEditor = null;
		lastEditorName = null;
	}
	public long getIdentification() {
		return identification;
	}
	public void setNewIdentification(long newId) {
		identification = newId;
	}
	public String getName() {
		return name;
	}
	public void replaceName(String nn) {
		name = nn;
	}
	public String getLastname() {
		return lastname;
	}
	public void replaceLastname(String nln) {
		lastname = nln;
	}
	public boolean getState() {
		return state;
	}
	public void setDisableState() {
		state = false;
	}
	public void setEnableState() {
		state = true;
	}
	public User getCreator() {
		return whoCreate;
	}
	public User getLastEditor() {
		return lastEditor;
	}
	public void setLastEditor(User lEditor) {
		lastEditor = lEditor;
		lastEditorName = lastEditor.getUsername();
	}
	public String getLastEditorName() {
		return lastEditorName;
	}
	public int compareByIdentification(Person o) {
		return Long.compare(this.getIdentification(), o.getIdentification());
	}
}
