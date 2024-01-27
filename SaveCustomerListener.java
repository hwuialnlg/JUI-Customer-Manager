package labs.lab9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SaveCustomerListener implements ActionListener{
	
	private DefaultListModel<Customer> arr;
	private JTextField name;
	private JTextField email;
	private ArrayList<JCheckBox> pets;
	private JTextField spent; 
	private JComboBox<String> location;
	private JTextArea note;
//	private DefaultListModel<String> arrNames;
	private JList<Customer> customers;
//	private TreeMap<String> sorting;
	
	public SaveCustomerListener(JList<Customer> customers, DefaultListModel<Customer> arr, JTextField name, JTextField email, ArrayList<JCheckBox> pets, JTextField spent, JComboBox<String> location, JTextArea note) {
		this.arr = arr;
		this.name = name;
		this.email = email;
		this.pets = pets;
		this.spent = spent;
		this.location = location;
		this.note = note;
//		this.arrNames = arrNames;
		this.customers = customers;
	}
	

	public void actionPerformed(ActionEvent event) {
		Customer x = null;
		if (this.customers.getSelectedValue() != null) {
			
//			System.out.println("TEST");
			
			for (Object i : this.arr.toArray()) {
				Customer j = (Customer) i;
				if ((j != this.customers.getSelectedValue() && (this.name.getText().equals(j.getName()))) || this.name.getText().equals("") || this.email.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			
			JOptionPane.showMessageDialog(null, "Customer saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Customer saved!");
			ArrayList<JCheckBox> temp = new ArrayList<>();
			for (JCheckBox i : this.pets) {
				JCheckBox j = new JCheckBox();
				if (i.isSelected()) {
					j.setSelected(true);
				}
				else {
					j.setSelected(false);
				}
				temp.add(j);
			}
			
			Customer add = new Customer(this.name.getText(), this.email.getText(), temp, this.spent.getText(), this.location.getSelectedIndex(), this.note.getText());
			this.arr.set(this.customers.getSelectedIndex(), add);
			x = add;
			
		}
		
		else if (this.validCustomer()) {
			JOptionPane.showMessageDialog(null, "Customer saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Customer saved!");
			ArrayList<JCheckBox> temp = new ArrayList<>();
			for (JCheckBox i : this.pets) {
				JCheckBox j = new JCheckBox();
				if (i.isSelected()) {
					j.setSelected(true);
				}
				else {
					j.setSelected(false);
				}
				temp.add(j);
			}
			
			Customer add = new Customer(this.name.getText(), this.email.getText(), temp, this.spent.getText(), this.location.getSelectedIndex(), this.note.getText());
			this.arr.addElement(add);
			x = add;
			
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Invalid input!");
			return;
		}
		
		TreeSet<String> sorting = new TreeSet<>();
		DefaultListModel<Customer> nw = new DefaultListModel<>();
		
		for (Object i : this.arr.toArray()) {
			Customer j = (Customer) i;
			sorting.add(j.getName());
		}
		
		for (String i : sorting) {
			for (Object j : this.arr.toArray()) {
				Customer n = (Customer) j;
				if (i.equals(n.getName())) {
					nw.addElement(n);
				}
			}
		}
//		System.out.println("TEST");
		this.customers.setModel(nw);
		this.arr = nw;
		
		if (x != null) {
			for (int i = 0; i < this.arr.size(); i++) {
				if (this.arr.get(i).getName().equals(x.getName())) {
					this.customers.setSelectedIndex(i);
					break;
				}
			}
		}
		
//		System.out.println(this.arrNames);
	}
	
	public boolean validCustomer() {
		if (this.name.getText().equals("") || this.email.getText().equals("")) {
			return false;
		}
		
		try {
			double d = Double.parseDouble(this.spent.getText());
			if (d < 0) {
				return false;
			}
		}
		
		catch (NumberFormatException ex) {
			return false;
		}
		
		if (this.arr != null) {
			for (Object i : this.arr.toArray()) {
				Customer j = (Customer) i;
				if (j.getName().equals(this.name.getText())) {
					return false;
				}
				
			}
		}
		
		
		return true;
	}


	
}
