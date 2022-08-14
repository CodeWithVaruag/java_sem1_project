package ui;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import library.service_library;

public class service extends JFrame implements ActionListener {

	JLabel lblServices, lblTime;
	JComboBox cmbServices, cmbTime;
	JButton btnAdd;
    JPanel panel;
	
	public service() {
		setTitle("Search Room");
		setSize(900, 900);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	    getContentPane().setBackground(Color.white);
		
	    panel = new JPanel();
		panel.setBounds(0, 0, 400, 900);
		panel.setBackground(new Color(255,153,51));
		panel.setLayout(null);
		
		lblServices = new JLabel("Services :");
		lblServices.setBounds(40, 100, 100, 30);
		lblServices.setFont(new Font("classic", Font.BOLD, 20));
		lblServices.setForeground(Color.white);
		
		
		
		lblTime = new JLabel("Time :");
		lblTime.setBounds(40, 170, 100, 30);
		lblTime.setFont(new Font("classic", Font.BOLD, 20));
		lblTime.setForeground(Color.white);
		
		
		
		String a[]= {"dry cleaning","laundry","gym","casino","spa","swimming","long tennis"};
        cmbServices = new JComboBox(a);
		cmbServices.setBounds(150, 100, 200, 30);
		
		
		


		
	
		
		//set rate of room
		
			
		String b[]= {"1 day","2 day","3 day","4 day","5 day","6 day","7 day","8 day","9 day","10 day"};
		cmbTime = new JComboBox(b);
		cmbTime.setBounds(150, 170, 200, 30);
		
		
		
		

		
		btnAdd = new JButton("add");
		btnAdd.setBounds(150, 220, 120, 40);
		btnAdd.setFont(new Font("serif", Font.BOLD, 20));
		btnAdd.setBackground(Color.white);
		btnAdd.setForeground(Color.black);
		btnAdd.addActionListener(this);
		setLayout(null);
		
		add(panel);
		panel.add(lblServices);
		panel.add(cmbServices);
	    panel.add(lblTime);
	    panel.add(cmbTime);
		panel.add(btnAdd);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAdd) {
			{ JOptionPane.showMessageDialog(null, "Added service Succesfully");}
			
			service_library s=new service_library();
			
		}
	}

	
	public static void main(String[] args) {
		new service();
	}
}
