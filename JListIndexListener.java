package labs.lab9;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JListIndexListener implements MouseListener {
	
	private JList<Customer> customers;
	private JTextField name;
	private JTextField email;
	private ArrayList<JCheckBox> pets;
	private JTextField spent; 
	private JComboBox<String> location;
	private JTextArea note;

	public JListIndexListener(JList<Customer> customers, JTextField name, JTextField email, ArrayList<JCheckBox> pets, JTextField spent, JComboBox<String> location, JTextArea note) {
		this.customers = customers;
		
		this.name = name;
		this.email = email;
		this.pets = pets;
		this.spent = spent;
		this.location = location;
		this.note = note;
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Customer c = this.customers.getSelectedValue();
		
		if (c != null) {
			
			this.name.setText(c.getName());
			this.email.setText(c.getEmail());
			
			for (int i = 0; i < this.pets.size(); i++) {
				this.pets.get(i).setSelected(false);
				if (c.getPets().get(i).isSelected()) {
					this.pets.get(i).setSelected(true);
				}
			}
				
			
			this.spent.setText(c.getSpent());
			
			// TODO
			// set location
			this.location.setSelectedIndex(c.getLocation());
			
			this.note.setText(c.getNotes());
		}
		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
