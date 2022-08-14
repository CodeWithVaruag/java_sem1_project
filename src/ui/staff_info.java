package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class staff_info {

	JFrame frame;
	JPanel panel;
	JLabel staffid,staffname,email,contact;
	JLabel userid1,username1,email1,contact1;
	
	
	
	public staff_info() {
		
		frame=new JFrame("staff info");
		frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);
		frame.setSize(400,500);
		frame.setResizable(false);
		
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(15,20,350,420);
		panel.setBackground(new Color(255,153,51));
		frame.add(panel);
		
		staffid=new JLabel("Staff ID -");
		staffid.setBounds(15,100,100,40);
		staffid.setFont(new Font("classic", Font.BOLD, 15));
		staffid.setForeground(Color.white);
		panel.add(staffid);
		
		staffname=new JLabel("Staff Name -");
		staffname.setBounds(15,140,100,40);
		staffname.setFont(new Font("classic", Font.BOLD, 15));
		staffname.setForeground(Color.white);
		panel.add(staffname);
		
		email=new JLabel("Email -");
		email.setBounds(17,180,100,40);
		email.setFont(new Font("classic", Font.BOLD, 15));
		email.setForeground(Color.white);
		panel.add(email);
		
		contact=new JLabel("Contact -");
		contact.setBounds(15,220,100,40);
		contact.setFont(new Font("classic", Font.BOLD, 15));
		contact.setForeground(Color.white);
		panel.add(contact);
		
		frame.setVisible(true);
	}
	
	public static void main(String[]args) {
		
		new staff_info();
	}
}
