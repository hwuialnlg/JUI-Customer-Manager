package labs.lab9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.ArrayList;

public class NewCustomerListener implements ActionListener {
	
	private JTextField name;
	private JTextField email;
	private ArrayList<JCheckBox> pets;
	private JTextField spent; 
	private JComboBox<String> location;
	private JTextArea note;
	private JList<Customer> customers;
	
	public NewCustomerListener(JList<Customer> customers, JTextField name, JTextField email, ArrayList<JCheckBox> pets, JTextField spent, JComboBox<String> location, JTextArea note) {
		this.name = name;
		this.email = email;
		this.pets = pets;
		this.spent = spent;
		this.location = location;
		this.note = note;
		this.customers = customers;
	}
	
	public void actionPerformed(ActionEvent event) {
		this.defaultEmail();
		this.defaultName();
		this.defaultLocation();
		this.defaultSpent();
		this.defaultPets();
		this.defaultNote();
		this.customers.clearSelection();
		
	}
	
	public void defaultName() {
		this.name.setText("");
	}
	
	public void defaultEmail() {
		this.email.setText("");
	}
	
	public void defaultPets() {
		for (JCheckBox i : this.pets) {
			i.setSelected(false);
		}
		
//		this.pets.setSelected(false);
		// might need to fix
	}
	
	public void defaultSpent() {
		this.spent.setText("0.0");
	}
	
	public void defaultLocation() {
		this.location.setSelectedIndex(0);
	}
	
	public void defaultNote() {
		this.note.setText("");
	}
}
