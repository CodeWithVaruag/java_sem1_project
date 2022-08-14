package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class customer_info {

	JFrame frame;
	JPanel panel,panel2;
	JLabel userid,username,email,contact,lgo;
	JLabel userid1,username1,email1,contact1;
	
	
	
	public customer_info() {
		
		frame=new JFrame("Customer info");
		frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);
		frame.setSize(400,500);
		
		
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(15,20,350,420);
		panel.setBackground(new Color(255,153,51));
		frame.add(panel);
		
		panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(8,180,333,232);
		panel2.setBackground(Color.white);
		panel.add(panel2);
		
		
		lgo=new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/logo.jpg"));
		lgo.setBounds(123,20,120,120);
		panel.add(lgo);
		
		
		userid=new JLabel("User ID -");
		userid.setBounds(17,20,100,40);
		userid.setFont(new Font("classic", Font.BOLD, 15));
		userid.setForeground(new Color(255,153,51));
		panel2.add(userid);
		
		username=new JLabel("Username -");
		username.setBounds(17,54,100,40);
		username.setFont(new Font("classic", Font.BOLD, 15));
		username.setForeground(new Color(255,153,51));
		panel2.add(username);
		
		email=new JLabel("Email -");
		email.setBounds(17,87,100,40);
		email.setFont(new Font("classic", Font.BOLD, 15));
		email.setForeground(new Color(255,153,51));
		panel2.add(email);
		
		contact=new JLabel("Contact -");
		contact.setBounds(17,120,100,40);
		contact.setFont(new Font("classic", Font.BOLD, 15));
		contact.setForeground(new Color(255,153,51));
		panel2.add(contact);
		
		frame.setVisible(true);
		
		
		
		
		
	}
	
	public static void main(String[]args) {
		
		new customer_info();
	}
}
