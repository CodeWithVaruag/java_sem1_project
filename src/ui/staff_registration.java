

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import JDBC.JDBC_registartion;
import library.registration_library;

public class staff_registration implements ActionListener{

	JFrame frame;
	JPanel panel;
	JLabel username,address,contact,email,g,registeras,age,password,repassword,userid,foto;
	JTextField age1,username1,address1,contact1,email1,userid1;
	JComboBox gender,position;
	JButton register,login;
	JPasswordField password1,repassword1;
	
	public staff_registration() {
		frame=new JFrame("registration");
		frame.setLayout(null);
		 frame.setSize(350,350);
		 frame.getContentPane().setBackground(Color.white);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
			
		
		
		 panel=new JPanel();
		 panel.setBackground(new Color(255,153,51));
		 panel.setBounds(200,70,1200,600);
		 panel.setLayout(null);
		 frame.add(panel);
		
		
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
		 address1.setColumns(20);
		 address1.setFont(new Font("Tahoma",Font.PLAIN,18));
		 address1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		 address1.setBounds(350,200,250,32);
         
		 panel.add(address1);
		
		contact=new JLabel("contact");
		contact.setFont(new Font("classic",Font.BOLD,25));
		contact.setBounds(150,250, 120,50);
		contact.setForeground(Color.white);
		 panel.add(contact);
		 
		 contact1= new JTextField("");
		 contact1.setColumns(20);
		 contact1.setFont(new Font("Tahoma",Font.PLAIN,18));
		 contact1.setBorder(BorderFactory.createLineBorder(Color.white,1));
         contact1.setBounds(350,250,250,32);
         
		 panel.add(contact1);
		 
		email=new JLabel("email");
		email.setFont(new Font("classic",Font.BOLD,25));
		email.setBounds(150,300, 120,50);
		email.setForeground(Color.white);
		 panel.add(email);
		 
		 email1= new JTextField("");
		 email1.setColumns(20);
		 email1.setFont(new Font("Tahoma",Font.PLAIN,18));
		 email1.setBorder(BorderFactory.createLineBorder(Color.white,1));
         email1.setBounds(350,300,250,32);
         
		 panel.add(email1);
		 
		 age=new JLabel("age");
		 age.setFont(new Font("classic",Font.BOLD,25));
		 age.setBounds(150,350, 120,50);
		age.setForeground(Color.white);
			 panel.add(age);
		 
		 
			 
			 age1= new JTextField("");
			 age1.setColumns(20);
	         age1.setBounds(350,350,250,32);
	         age1.setFont(new Font("Tahoma",Font.PLAIN,18));
	         age1.setBorder(BorderFactory.createLineBorder(Color.white,1));
			 panel.add(age1);
		 
			
			 
			 
				 
				 userid1= new JTextField("");
				
				
		 
		 
	

		 
		 register=new JButton("register");
		 register.setBounds(350,500,190,30);
		 register.setFont(new Font("serif",Font.BOLD,20));
		 register.setBackground(Color.white);
		 register.setForeground(Color.red);
		 register.addActionListener(this);
		 panel.add(register);	
		 
		 login=new JButton("login");
		 login.setBounds(550,500,190,30);
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
		 gender.setBounds(860,220,250,32);
		 gender.setFont(new Font("Tahoma",Font.PLAIN,18));
		 gender.setBorder(BorderFactory.createLineBorder(Color.white,1));
		 panel.add(gender);
		 
		 password=new JLabel("password");
		 password.setBounds(670,270,190,30);
		 password.setFont(new Font("classic",Font.BOLD,25));
	     password.setForeground(Color.white);
		 panel.add(password);
		 
		 
		 
		 password1= new JPasswordField("");
		 password1.setColumns(20);
		 password1.setFont(new Font("Tahoma",Font.PLAIN,18));
		 password1.setBorder(BorderFactory.createLineBorder(Color.white,1));
         password1.setBounds(860,270,250,32);
         panel.add(password1);
		 
		 
		 
		 
		 repassword=new JLabel("repassword");
		 repassword.setBounds(670,320,190,30);
		 repassword.setFont(new Font("classic",Font.BOLD,25));
		 repassword.setForeground(Color.white);
		 panel.add(repassword);
		 
		 

		 repassword1= new JPasswordField("");
		 repassword1.setColumns(20);
		 repassword1.setFont(new Font("Tahoma",Font.PLAIN,18));
		 repassword1.setBorder(BorderFactory.createLineBorder(Color.white,1));
         repassword1.setBounds(860,320,250,32);
         panel.add(repassword1);
 
		 
		 registeras=new JLabel("register as");
		 registeras.setFont(new Font("classic",Font.BOLD,25));
		 registeras.setBounds(150,410,250,32);
		registeras.setForeground(Color.white);
		 panel.add(registeras);
		 
		 
		 
        String j[]= {"Receptionist","Restaurant staff","Bar staff"};
		position=new JComboBox(j);
		position.setBounds(350,410,250,32);
		position.setFont(new Font("Tahoma",Font.PLAIN,18));
		position.setBorder(BorderFactory.createLineBorder(Color.white,1));
		panel.add(position);
		 

		
		 foto=new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/light.jpg"));
		 foto.setBounds(0,0,1700,906);
		 frame.add(foto);
		 
		frame.setVisible(true);
		
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
			rl.setRepassword(repassword1.getText());
			rl.setEmail(email1.getText());
			rl.setPosition(position.getSelectedItem().toString());
			rl.setGender(gender.getSelectedItem().toString());
			JDBC_registartion jdbc=new JDBC_registartion();
			  boolean result= jdbc.save(rl);
			 
		}
	
		if(ae.getSource()==login) ;
		new login();
		frame.dispose();
		
	}
	public static void main(String args[]){
		new staff_registration();
		
	}

	
		
}