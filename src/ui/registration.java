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

import JDBC.JDBC_registartion;
import library.registration_library;

public class registration implements ActionListener,ItemListener{

	JFrame frame;
	JPanel panel;
	JLabel username,address,contact,email,g,registeras,age,password,repassword,userid,hotel1,lbl;
	JTextField age1,username1,address1,contact1,email1,password1,repassword1,userid1;
	JComboBox gender,position;
	JButton register,login,reg;
	
	
	public registration() {
		frame=new JFrame("registration");
		frame.setLayout(null);
		 frame.setSize(350,350);
		 frame.getContentPane().setBackground(new Color(	
				 255, 255,51));
	
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
			
	
		
		
		 panel=new JPanel();
		 panel.setBackground(new Color(255,153,51));
		 panel.setBounds(180,80,1200,600);
		 panel.setLayout(null);
		 frame.add(panel);
		
			hotel1=new JLabel(new ImageIcon("/C:/Users/ACER/eclipse-workspace/app/src/ui/regs.jpg"));
			hotel1.setBounds(0,0,1700,900);
			frame.add(hotel1);
		
			lbl=new JLabel("Registration");
			 lbl.setFont(new Font("Tahoma",Font.BOLD,40));
			 lbl.setBounds(480,10,250,80);
			 lbl.setForeground(Color.white);
			 
			 panel.add(lbl);
			
		username=new JLabel("username");
		 username.setFont(new Font("classic",Font.BOLD,25));
		 username.setBounds(150,110, 120,100);
		 username.setForeground(Color.white);
		 panel.add(username);
		 
		 username1= new JTextField("");
		username1.setFont(new Font("Tahoma",Font.PLAIN,18));
		
		username1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		username1.setColumns(20);
         username1.setBounds(350,150,250,32);
         panel.add(username1);
         
		address=new JLabel("address");
		address.setFont(new Font("classic",Font.BOLD,25));
		address.setBounds(150,200, 120,50);
		address.setForeground(Color.white);
		 panel.add(address);
		 
		 address1= new JTextField("");
		 address1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		 
	     address1.setFont(new Font("Tahoma",Font.PLAIN,18));
		 address1.setColumns(20);
         address1.setBounds(350,200,250,32);
         panel.add(address1);
		
		contact=new JLabel("contact");
		contact.setFont(new Font("classic",Font.BOLD,25));
		contact.setBounds(150,250, 120,50);
		contact.setForeground(Color.white);
		 panel.add(contact);
		 
		 contact1= new JTextField("");
		 contact1.setColumns(20);
		 contact1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		 contact1.setFont(new Font("Tahoma",Font.PLAIN,18));
         contact1.setBounds(350,250,250,32);
         
		 panel.add(contact1);
		 
		email=new JLabel("email");
		email.setFont(new Font("classic",Font.BOLD,25));
		email.setBounds(150,300, 120,50);
		email.setForeground(Color.white);
		 panel.add(email);
		 
		 email1= new JTextField("");
		 email1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		
		 email1.setColumns(20);
		 email1.setFont(new Font("Tahoma",Font.PLAIN,18));
         email1.setBounds(350,300,250,32);
         
		 panel.add(email1);
		 
		 age=new JLabel("age");
		 age.setFont(new Font("classic",Font.BOLD,25));
		 age.setBounds(150,350, 120,50);
		age.setForeground(Color.white);
			 panel.add(age);
		 
		 
			 
			 age1= new JTextField("");
			 age1.setBorder(BorderFactory.createLineBorder(Color.white,1));
			;
			 age1.setColumns(20);
			 age1.setFont(new Font("Tahoma",Font.PLAIN,18));
	         age1.setBounds(350,350,250,32);
	         panel.add(age1);
		 
		
	         
		 
	

		 
		 register=new JButton("register");
		 register.setBorder(BorderFactory.createLineBorder(Color.white,1));
		 register.setBounds(700,410,190,30);
		 register.setFont(new Font("serif",Font.BOLD,20));
		 register.setBackground(Color.white);
		 register.setForeground(Color.red);
		 register.addActionListener(this);
		 panel.add(register);	
		 
		 login=new JButton("login");
		 login.setBorder(BorderFactory.createLineBorder(Color.white,1));
		 login.setBounds(900,410,190,30);
		 login.setFont(new Font("serif",Font.BOLD,20));
		 login.setBackground(Color.white);
		 login.setForeground(Color.red);
	     login.addActionListener(this); 
		 panel.add(login);	
		 
		 

			g=new JLabel("gender");
			 g.setFont(new Font("classic",Font.BOLD,25));
		
			 g.setBounds(670,210, 120,50);
			g.setForeground(Color.white);
			 panel.add(g);
			 
		 
		 String i[]= {"male","female"};
		 gender=new JComboBox(i);
		 gender.setBorder(BorderFactory.createLineBorder(Color.white,1));
		 gender.setFont(new Font("Tahoma",Font.PLAIN,18));
		 gender.setBounds(860,220,250,32);
		 gender.addItemListener(this);
		 panel.add(gender);
		 
		 password=new JLabel("password");
		 password.setBounds(670,270,190,30);
		 password.setFont(new Font("classic",Font.BOLD,25));
	     password.setForeground(Color.white);
		 panel.add(password);
		 
		 
		 
		 password1= new JTextField("");
		 password1.setColumns(20);
		
		password1.setBorder(BorderFactory.createLineBorder(Color.white,1));
	     password1.setFont(new Font("Tahoma",Font.PLAIN,18));
         password1.setBounds(860,270,250,32);
         panel.add(password1);
		 
		 
		 
		 
		 repassword=new JLabel("repassword");
		 repassword.setBounds(670,320,190,30);
		 repassword.setFont(new Font("classic",Font.BOLD,25));
		 repassword.setForeground(Color.white);
		 panel.add(repassword);
		 
		 

		 repassword1= new JTextField("");
		 repassword1.setColumns(20);
		 repassword1.setBorder(BorderFactory.createLineBorder(Color.white,1));
	     repassword1.setFont(new Font("Tahoma",Font.PLAIN,18));
         repassword1.setBounds(860,320,250,32);
         panel.add(repassword1);
 
		 
		 registeras=new JLabel("register as");
		 registeras.setFont(new Font("classic",Font.BOLD,25));
		 registeras.setBounds(150,410,250,32);
		registeras.setForeground(Color.white);
		 panel.add(registeras);
		 
		 
		 
        String j[]= {"corporate client","customer","receptionist"};
		position=new JComboBox(j);
		position.setBorder(BorderFactory.createLineBorder(Color.white,1));
		position.setFont(new Font("Tahoma",Font.PLAIN,18));
		position.setBounds(350,410,250,32);
		position.addItemListener(this);
		panel.add(position);
		 

		reg = new JButton(" < Click here for staff registration >  ");
		reg.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		reg.setBounds(0, 550, 1300, 40);
		reg.setFont(new Font("serif", Font.BOLD, 15));
		reg.setBackground(Color.white);
		reg.setForeground(new Color(255, 153, 51));
		reg.addActionListener(this);
		panel.add(reg);
		 
		 
		frame.setVisible(true);
		
	}

	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
	if(e.getSource()==gender) {
		;
	}
		
	
	if(e.getSource()==position) {
	    ;
	
	}
	
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==register)
		{  JOptionPane.showMessageDialog(null, "registered sucessfully");
			
		registration_library rl=new registration_library();
			
			rl.setUsername(username1.getText());
			rl.setAge(Integer.parseInt(age1.getText()));
			rl.setAddress(address1.getText());
			rl.setContact(contact1.getText());
			rl.setPassword(password1.getText());
			rl.setEmail(email1.getText());
			rl.setPosition(position.getSelectedItem().toString());
			rl.setGender(gender.getSelectedItem().toString());
			JDBC_registartion jdbc=new JDBC_registartion();
			  boolean result= jdbc.save(rl);
			 
		}
	
		if(ae.getSource()==login) {
		
		new login();
		frame.dispose();}
		
	
	
		if(ae.getSource()==reg) {
			
			new staff_registration();
			frame.dispose();}
	
	
	
	
	
	
	
	
	
	
	}
		
		
		
		
	
	public static void main(String args[]){
		new registration();
		
	}

}
