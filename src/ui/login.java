
/* for hotel login page  */

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import JDBC.JDBC_login;
import library.Global;
import library.registration_library;

public class login implements ActionListener{

	JFrame frame;
	JLabel m, n, o, p;
	JTextField username;
	JButton btnlogin, b, reg;
	JPanel panel;
	JPasswordField password;

	public login() {

		frame = new JFrame();

		frame.setSize(350, 350);
		frame.setLayout(null);
		frame.setTitle("login");
		frame.setExtendedState(frame.MAXIMIZED_BOTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBounds(300, 150, 900, 500);
		panel.setBackground(new Color(255, 153, 51));
		panel.setLayout(null);

		m = new JLabel("Username: ");
		m.setBounds(250, 100, 100, 30);
		m.setFont(new Font("serif", Font.BOLD, 20));
		m.setForeground(Color.white);
		panel.add(m);

		username = new JTextField("");
		username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		username.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		username.setColumns(20);
		username.setBounds(400, 100, 200, 30);

		panel.add(username);

		n = new JLabel("Password: ");
		n.setForeground(Color.white);
		n.setBounds(250, 170, 100, 30);
		n.setFont(new Font("serif", Font.BOLD, 20));
		panel.add(n);

		password = new JPasswordField("");
		password.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setColumns(20);
		password.setBounds(400, 170, 200, 30);
		
		panel.add(password);

		o = new JLabel("Luton hotel");
		o.setForeground(Color.white);
		o.setBounds(618, 10, 500, 60);
		o.setFont(new Font("serif", Font.BOLD, 50));
		frame.add(o);

		btnlogin = new JButton("Login");
		btnlogin.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnlogin.setBounds(660, 420, 190, 40);
		btnlogin.setFont(new Font("serif", Font.BOLD, 20));
		btnlogin.setBackground(Color.white);
		btnlogin.setForeground(Color.black);
		frame.add(btnlogin);
		btnlogin.addActionListener(new ActionListener()

		{
         
			@Override
			public void actionPerformed(ActionEvent e) {

				if (username.getText().trim().isEmpty() && password.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter username and password");
				}
 
				else if (e.getSource() == btnlogin) {

					registration_library user = new registration_library();
					user.setUsername(username.getText());
					user.setPassword(password.getText());
					user = new JDBC_login().login(user);
					Global.currentUser = user;
					if (user.getUserid() > 0) {

						JOptionPane.showMessageDialog(null, "Welcome " + user.getUsername());
					}

					if (user.getPosition().equals("customer")) {
						new CustomerDashboard();
						frame.dispose();
					}

					if (user.getPosition().equals("Bar staff")) {
						new Bardashboard();
						frame.dispose();
					}

					if (user.getPosition().equals("Restaurant staff")) {
						new restaurantdashboard();
						frame.dispose();
					}

					if (user.getPosition().equals("corporate client")) {
						new CustomerDashboard();
						frame.dispose();
					}
					
					
					if (user.getPosition().equals("receptionist")) {
						new reception();
						frame.dispose();

					}
				}
			}
		}

		);

		reg = new JButton(" < Click here for new registration >  ");
		reg.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		reg.setBounds(0, 430, 900, 40);
		reg.setFont(new Font("serif", Font.BOLD, 15));
		reg.setBackground(Color.white);
		reg.setForeground(new Color(255, 153, 51));
		reg.addActionListener(this);
		panel.add(reg);

		frame.add(panel);
		p = new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/uffh.jpg"));
		p.setBounds(0, 0, 1600, 900);
		p.setFont(new Font("serif", Font.BOLD, 50));
		frame.add(p);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reg) {
			new registration();
		frame.dispose();}
		
		
		
		
	}

	public static void main(String[] args) {

		new login();

	}

	
}
