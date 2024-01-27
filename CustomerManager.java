package labs.lab9;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private DefaultListModel<Customer> arr;
	
	private JTextField email;
	private JTextField name;
	private ArrayList<JCheckBox> pets;
	private JTextField spent;
	private JComboBox<String> location;
	private JTextArea note;
	private DefaultListModel<String> arrNames;
	private JList<Customer> customers;
	
	
	public CustomerManager() {
	
		this.frame = new JFrame();
		this.frame.setSize(800,600);
		this.frame.setTitle("Will Huang - 59099769");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.arr = new DefaultListModel<>();
//		this.arrNames = new DefaultListModel<>();
		this.customers = new JList<>(this.arr);
		this.mp();
		this.frame.add(this.mainPanel);
		this.frame.setVisible(true);
	}
	
	public void mp() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new GridLayout(1, 2));
//		this.mainPanel.setBounds(new Rectangle(700, 500));
		this.rp();
		this.lp();
		
		this.mainPanel.add(this.leftPanel);
		this.mainPanel.add(this.rightPanel);

	}
	
	public void rp() {
		// Initialize main right panel
		this.rightPanel = new JPanel();
		this.rightPanel.setLayout(new GridLayout(6,1));
		
		// Initialize name and email panel
//		JPanel nameEmail = new JPanel(new GridLayout(6,1));
//		nameEmail.setLayout(new BorderLayout(0, 10));
		
		// Components of email
		JTextField nameField = new JTextField(20);
		JLabel nameLabel = new JLabel("Name: ");
		JPanel innerName = new JPanel();
		innerName.add(nameLabel);
		innerName.add(nameField);
		
		// Components of email
		JTextField emailField = new JTextField(20);
		JLabel emailLabel = new JLabel("Email: ");
		JPanel innerEmail = new JPanel();
		innerEmail.add(emailLabel);
		innerEmail.add(emailField);
		
		this.email = emailField;
		this.name = nameField;
		
		
		// Add inner panels to nameEmail panel
		this.rightPanel.add(innerName);
		this.rightPanel.add(innerEmail);
		this.rightPanel.add(this.petBoxes());
		this.rightPanel.add(this.amountSpent());
		this.rightPanel.add(this.location());
		this.rightPanel.add(this.note());
		
		
		// add all sub-panels + components into main right panel
//		this.rightPanel.add(nameEmail, BorderLayout.CENTER);
		
	}
	
	public JPanel petBoxes() {
		JCheckBox dog = new JCheckBox("Dog(s)");
		JCheckBox cat = new JCheckBox("Cat(s)");
		JCheckBox fish = new JCheckBox("Bird(s)");
		JCheckBox bird = new JCheckBox("Fish(s)");
		JCheckBox other = new JCheckBox("Other");
		JLabel pet = new JLabel("Pets:");
		
		this.pets = new ArrayList<JCheckBox>();
		this.pets.add(dog);
		this.pets.add(cat);
		this.pets.add(fish);
		this.pets.add(bird);
		this.pets.add(other);
		
		JPanel pets = new JPanel();
		pets.add(pet);
		pets.add(dog);
		pets.add(cat);
		pets.add(fish);
		pets.add(bird);
		pets.add(other);
		
		return pets;
		
	}
	
	public JPanel amountSpent() {
		JPanel spent = new JPanel();
//		spent.setLayout(new GridLayout(1,3));
		
		JLabel aSpent = new JLabel("Total Amount Spent: ");
		JTextField dSpent = new JTextField("0.0", 10);
		
		spent.add(aSpent);
		spent.add(dSpent);
		
		this.spent = dSpent;
		
		return spent;
	}
	
	public JPanel location() {
		JPanel lp = new JPanel();
		
		JLabel lt = new JLabel("Home Store Location: ");
		JComboBox<String> locations = new JComboBox<String>();
		locations.addItem("Irvine");
		locations.addItem("Los Angeles");
		locations.addItem("Paris");
		locations.addItem("Shanghai");
		locations.addItem("New York");
		locations.addItem("London");
		
		this.location = locations;
		
		lp.add(lt);
		lp.add(locations);
		return lp;
	}
	
	public JPanel note() {
		JPanel n = new JPanel();
		
		JLabel notes = new JLabel("Note: ");
		JTextArea jt = new JTextArea(3, 25);
		JScrollPane sp = new JScrollPane(jt);
		sp.setVerticalScrollBarPolicy(sp.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton save = new JButton("Save Customer");
		SaveCustomerListener scl = new SaveCustomerListener(this.customers, this.arr, this.name, this.email, this.pets, this.spent, this.location, jt);
//		save.addActionListener(scl);
		save.addActionListener(scl);
		JButton nc = new JButton("New Customer");
		NewCustomerListener ncl = new NewCustomerListener(this.customers, this.name, this.email, this.pets, this.spent, this.location, jt);
		nc.addActionListener(ncl);
		
		this.note = jt;
		n.add(notes);
		n.add(sp);
		n.add(save);
		n.add(nc);
		
		return n;
	}
	
	public void lp() {
		
		this.leftPanel = new JPanel();
		
//		JList<String> customers = new JList<String>(this.arrNames); // fix this
		this.customers.setPreferredSize(new Dimension(350, 500));
		JListIndexListener jcl = new JListIndexListener(this.customers, this.name, this.email, this.pets, this.spent, this.location, this.note);
//		this.customers.setVisible(true);
//		this.customers.addListSelectionListener(jcl);
		this.customers.addMouseListener(jcl);
		
		
		JButton delete = new JButton("Delete");
		// add action
		
//		this.customers.setmodel
		
		DeleteCustomerListener dcl = new DeleteCustomerListener(this.customers, this.arr);
		delete.addActionListener(dcl);
		
		this.leftPanel.add(this.customers);
		this.leftPanel.add(delete);
		
	}
	
	public static void main(String[] args) {
		CustomerManager cm = new CustomerManager();
//		cm.closeWindow();
	}
	
	
	
	
}
