package labs.lab9;

import java.util.ArrayList;

import javax.swing.JCheckBox;

public class Customer {
	// implement sometime of binary for pet string
	private String name;
	private String email;
	private ArrayList<JCheckBox> pets;
	private String spent;
	private int location;
	private String notes;
	
	
	public Customer(String name, String email, ArrayList<JCheckBox> pets, String spent, int location, String notes) {
		this.name = name;
		this.email = email;
		this.pets = pets;
		this.spent = spent;
		this.location = location;
		this.notes = notes;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public ArrayList<JCheckBox> getPets() {
		return this.pets;
	}
	
	public String getSpent() {
		return this.spent;
	}
	
	public int getLocation() {
		return this.location;
	}
	
	public String getNotes() {
		return this.notes;
	}
	
	public String toString() {
		return this.getName();
	}



	

	
}

