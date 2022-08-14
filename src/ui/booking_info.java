package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class booking_info {

	JFrame frame;
	JPanel panel;
	JLabel Lroomno,Lroomtype,Lcheckin,Lcheckout;
	JLabel roomno,roomtype,checkin,checkout;
	
	
	
	public booking_info() {
		
		frame=new JFrame("booking info");
		frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);
		frame.setSize(400,500);
		
		
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(15,20,350,420);
		panel.setBackground(new Color(255,153,51));
		frame.add(panel);
		
		Lroomno=new JLabel("Room No -");
		Lroomno.setBounds(15,60,100,40);
		Lroomno.setFont(new Font("classic", Font.BOLD, 15));
		Lroomno.setForeground(Color.white);
		panel.add(Lroomno);
		
		Lroomtype=new JLabel("Room Type -");
		Lroomtype.setBounds(15,100,100,40);
		Lroomtype.setFont(new Font("classic", Font.BOLD, 15));
		Lroomtype.setForeground(Color.white);
		panel.add(Lroomtype);
		
		Lcheckin=new JLabel("Check In -");
		Lcheckin.setBounds(15,140,100,40);
		Lcheckin.setFont(new Font("classic", Font.BOLD, 15));
		Lcheckin.setForeground(Color.white);
		panel.add(Lcheckin);
		
		Lcheckout=new JLabel("Check Out -");
		Lcheckout.setBounds(15,180,100,40);
		Lcheckout.setFont(new Font("classic", Font.BOLD, 15));
		Lcheckout.setForeground(Color.white);
		panel.add(Lcheckout);
		
		frame.setVisible(true);
	}
	
	public static void main(String[]args) {
		
		new booking_info();
	}
}
