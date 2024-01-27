package labs.lab9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class DeleteCustomerListener implements ActionListener {
	
	private DefaultListModel<Customer> arr;
	private JList<Customer> customers;
	
	public DeleteCustomerListener(JList<Customer> customers, DefaultListModel<Customer> arr) {
		this.customers = customers;
		this.arr = arr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(this.arr);
		
		
		
		this.arr = (DefaultListModel<Customer>) this.customers.getModel();
		if (this.customers.getSelectedValue() != null) {
			this.arr.removeElementAt(this.customers.getSelectedIndex());
//			for (Object i : this.arr.toArray()) {
//				Customer j = (Customer) i;
//				if (j.getName().equals(this.customers.getSelectedValue().getName())) {
//					this.arr.remove(this.customers.getSelectedIndex());
//				}
//			}
			
		}
		
		
	}

	
	
}
