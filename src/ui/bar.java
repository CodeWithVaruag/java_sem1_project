package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import library.Global_food;
import library.food_library;

public class bar extends JFrame implements ActionListener ,ItemListener{

	JLabel lblDrinks, lblQuantity,lblrate,pic;
	JComboBox cmbDrinks, cmbquantity;
	JTextField rate;
	JButton btnBook;
    JPanel panel;
	
	public bar() {
		setTitle("Search Room");
		setSize(900, 900);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		
		  panel = new JPanel();
			panel.setBounds(0, 0, 400, 900);
			panel.setBackground(Color.black);
			panel.setLayout(null);
		
			pic=new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/barro2.jpg"));
			pic.setBounds(400,0,1300,903);
			add(pic);
			
			
		lblDrinks = new JLabel("Drinks");
		lblDrinks.setBounds(40, 100, 100, 30);
		lblDrinks.setFont(new Font("classic", Font.BOLD, 20));
		lblDrinks.setForeground(Color.white);
		add(lblDrinks);
		
		
		lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(40, 170, 100, 30);
		lblQuantity.setFont(new Font("classic", Font.BOLD, 20));
		lblQuantity.setForeground(Color.white);
		
		
		lblrate=new JLabel("Rate :");
		lblrate.setBounds(40, 230, 100, 30);
		lblrate.setFont(new Font("classic", Font.BOLD, 20));
		lblrate.setForeground(Color.white);
		
		
		
		cmbDrinks=new JComboBox();
	    for (int i=0; i<Global_food.drinks.length; i++){
	    	cmbDrinks.addItem(Global_food.drinks[i]);
	    }
	    cmbDrinks.setBorder(BorderFactory.createLineBorder(Color.white,1));
	    cmbDrinks.setFont(new Font("classic", Font.BOLD, 16));
		cmbDrinks.setBounds(150, 100, 200, 30);
		cmbDrinks.addItemListener(this);
		
		
		


		
	
		
		//set rate of room
		
			
		String b[]= {"1","2","3","4","5","6","7","8","9","10"};
		cmbquantity = new JComboBox(b);
		cmbquantity.setBorder(BorderFactory.createLineBorder(Color.white,1));
		cmbquantity.setFont(new Font("classic", Font.BOLD, 16));
		cmbquantity.setBounds(150, 170, 200, 30);
		
		
		rate=new JTextField();
		rate.setBounds(150, 230, 200, 30);
		rate.setBorder(BorderFactory.createLineBorder(Color.white,1));
		rate.setFont(new Font("classic", Font.BOLD, 16));
		rate.setForeground(Color.black);
		

		
		btnBook = new JButton("Add");
		btnBook.setBounds(120, 300, 120, 40);
		btnBook.setBorder(BorderFactory.createLineBorder(Color.white,1));
		btnBook.setFont(new Font("serif", Font.BOLD, 20));
		btnBook.setBackground(Color.white);
		btnBook.setForeground(Color.black);
		btnBook.addActionListener(this);
		setLayout(null);
		
		add(panel);
		panel.add(lblDrinks);
		panel.add(cmbDrinks);
	    panel.add(lblQuantity);
	    panel.add(cmbquantity);
		panel.add(btnBook);
		panel.add(rate);
		panel.add(lblrate);
		setVisible(true);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cmbDrinks);
		int index = cmbDrinks.getSelectedIndex();
		rate.setText(Integer.toString(Global_food.drink_price[index]));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBook)
		{ JOptionPane.showMessageDialog(null, "Booked Food Succesfully");}
		
		food_library f=new food_library();
		
		
		
	}

	
	public static void main(String[] args) {
		new bar();
	}




}

