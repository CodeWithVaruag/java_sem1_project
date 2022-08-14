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
import library.room_global;

public class food extends JFrame implements ActionListener,ItemListener {

	JLabel lblfood, lblQuantity,pic,lblrate;
	JComboBox cmbfood, cmbquantity;
	JTextField rate;
	JButton btnBook;
    JPanel panel;
	
	public food() {
		setTitle("Search Room");
		setSize(900, 900);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	
		getContentPane().setBackground(Color.white);
		
		  panel = new JPanel();
			panel.setBounds(0, 0, 400, 900);
			panel.setBackground(new Color(255,153,51));
			panel.setLayout(null);
		
		lblfood = new JLabel("food :");
		lblfood.setBounds(40, 100, 100, 30);
		lblfood.setFont(new Font("classic", Font.BOLD, 20));
		lblfood.setForeground(Color.white);
		add(lblfood);
		
		
		lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(40, 170, 100, 30);
		lblQuantity.setFont(new Font("classic", Font.BOLD, 20));
		lblQuantity.setForeground(Color.white);
		
		lblrate=new JLabel("Rate :");
		lblrate.setBounds(40, 230, 100, 30);
		lblrate.setFont(new Font("classic", Font.BOLD, 20));
		lblrate.setForeground(Color.white);
		
		
		cmbfood=new JComboBox();
		    for (int i=0; i<Global_food.foods.length; i++){
		    	cmbfood.addItem(Global_food.foods[i]);
		    }
	    cmbfood.setBounds(150, 100, 200, 30);
	    cmbfood.setBorder(BorderFactory.createLineBorder(Color.white,1));
	    cmbfood.setFont(new Font("classic", Font.BOLD, 16));
	    cmbfood.setForeground(Color.black);
	    cmbfood.addItemListener(this);
	
		
		//set rate of room
		
			
		String b[]= {"1","2","3","4","5","6","7","8","9","10"};
		cmbquantity = new JComboBox(b);
		cmbquantity.setBounds(150, 170, 200, 30);
		cmbquantity.setBorder(BorderFactory.createLineBorder(Color.white,1));
		cmbquantity.setFont(new Font("classic", Font.BOLD, 16));
		cmbquantity.setForeground(Color.black);
		
	  
		rate=new JTextField();
		rate.setBounds(150, 230, 200, 30);
		rate.setBorder(BorderFactory.createLineBorder(Color.white,1));
		rate.setFont(new Font("classic", Font.BOLD, 16));
		rate.setForeground(Color.black);
		
        		
		
		
		

		
		btnBook = new JButton("Add");
		btnBook.setBounds(140, 320, 120, 40);
		btnBook.setFont(new Font("serif", Font.BOLD, 20));
		btnBook.setBackground(Color.white);
		btnBook.setForeground(Color.red);
		btnBook.addActionListener(this);
		setLayout(null);
		
		add(panel);
		panel.add(lblfood);
		panel.add(cmbfood);
	    panel.add(lblQuantity);
	    panel.add(cmbquantity);
		panel.add(btnBook);
		panel.add(lblrate);
		panel.add(rate);
		
		
		pic = new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/food.jpg"));
		pic.setBounds(400,0,1300,863);
		
		add(pic);
		
		
		setVisible(true);

	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cmbfood);
		int index = cmbfood.getSelectedIndex();
		rate.setText(Integer.toString(Global_food.food_price[index]));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBook)
		{ JOptionPane.showMessageDialog(null, "Booked Food Succesfully");}
		
		food_library f=new food_library();
		
		
		
	}

	
	public static void main(String[] args) {
		new food();
	}


	
}
