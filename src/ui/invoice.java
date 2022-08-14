package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class invoice {

	JFrame frame;
	JPanel panel;
	JLabel a,b,c,d,e,f,g;
	JTextField a1,b1,c1,d1,e1,f1,g1;
	
	
	
	public invoice() {
		
		frame=new JFrame();
		frame.setSize(600,600);
	    frame.setResizable(true);
	    frame.getContentPane().setBackground(Color.white);
	    frame.setLocation(450,100);
	    frame.setResizable(false);
	    frame.setLayout(null);
	    
	   
	    panel=new JPanel();
	    panel.setBounds(0,0,600,50);
	    panel.setBackground(new Color(255, 153, 51));
	    frame.add(panel);
	    
	    JLabel bill=new JLabel("Hotel Lutton");
	    bill.setBounds(280,15,130,30);
	    bill.setFont(new Font("Tahoma", Font.BOLD, 25));
	    bill.setForeground(Color.white);
	    panel.add(bill);
	    
	    
	    a=new JLabel("Billing id:");
	    a.setBounds(20,100,130,30);
	    a.setFont(new Font("Tahoma", Font.BOLD, 16));
	    a.setForeground(Color.black);
	    frame.add(a);
	    
	    b=new JLabel("Booking id:");
	    b.setBounds(20,150,130,30);
	    b.setFont(new Font("Tahoma", Font.BOLD, 16));
	    b.setForeground(Color.black);
	    frame.add(b);
	    
	    
	    c=new JLabel("room price:");
	    c.setBounds(20,200,130,30);
	    c.setFont(new Font("Tahoma", Font.BOLD, 16));
	    c.setForeground(Color.black);
	    frame.add(c);
	    
	    
	    
	    d=new JLabel("food price:");
	    d.setBounds(20,250,130,30);
	    d.setFont(new Font("Tahoma", Font.BOLD, 16));
	    d.setForeground(Color.black);
	    frame.add(d);
	    
	    e=new JLabel("drinks price:");
	    e.setBounds(20,300,130,30);
	    e.setFont(new Font("Tahoma", Font.BOLD, 16));
	    e.setForeground(Color.black);
	    frame.add(e);
	    
	    f=new JLabel("service price:");
	    f.setBounds(20,350,130,30);
	    f.setFont(new Font("Tahoma", Font.BOLD, 16));
	    f.setForeground(Color.black);
	    frame.add(f);
	    
	    g=new JLabel("total price:");
	    g.setBounds(20,400,130,30);
	    g.setFont(new Font("Tahoma", Font.BOLD, 16));
	    g.setForeground(Color.black);
	    frame.add(g);
	    
	    
	    a1=new JTextField();
	    a1.setBounds(140,100,100,30);
	    a1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	    a1.setFont(new Font("classic", Font.BOLD, 16));
	    frame.add(a1);
	    
	    b1=new JTextField();
	    b1.setBounds(140,150,100,30);
	    b1.setFont(new Font("classic", Font.BOLD, 16));
	    b1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	    frame.add(b1);
	    
	    c1=new JTextField();
	    c1.setBounds(140,200,100,30);
	    c1.setFont(new Font("classic", Font.BOLD, 16));
	    c1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	    frame.add(c1);
	    
	    d1=new JTextField();
	    d1.setBounds(140,250,100,30);
	    d1.setFont(new Font("classic", Font.BOLD, 16));
	    d1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	    frame.add(d1);
	    
	    e1=new JTextField();
	    e1.setBounds(140,300,100,30);
	    e1.setFont(new Font("classic", Font.BOLD, 16));
	    e1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	    frame.add(e1);
	    
	    f1=new JTextField();
	    f1.setBounds(140,350,100,30);
	    f1.setFont(new Font("classic", Font.BOLD, 16));
	    f1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	    frame.add(f1);
	    
	    g1=new JTextField();
	    g1.setBounds(140,400,100,30);
	    g1.setFont(new Font("classic", Font.BOLD, 16));
	    g1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	    frame.add(g1);
	    
	    frame.setVisible(true);
	       
	}
	    
	    
		
	public static void main(String[]args) {
		
		new invoice();
		
	}
		
		
	}
	
	
	
	
	
	
	

