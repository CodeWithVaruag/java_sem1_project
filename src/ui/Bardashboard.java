package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import JDBC.JDBC_bar;
import library.Global;
import library.bar2_library;
import library.bar_library;

public class Bardashboard implements ActionListener,MouseListener{

JFrame frame;
JTabbedPane tab;
JPanel tab1,tab2,tab3,tab4,tab5,p1,p2;
JButton confirm,logout;
DefaultTableModel model;
JTextField txtorderid,txtuserid;
Object[] columnsName;
ArrayList<bar2_library> a1;
JTable table1;

public Bardashboard() {
	
	frame = new JFrame("Reception");
	frame.setLayout(null);
	frame.getContentPane().setBackground(Color.white);
	frame.setExtendedState(frame.MAXIMIZED_BOTH);
	


	tab = new JTabbedPane();
	tab.setBackground(Color.white);
	tab.setForeground(Color.black);
	tab.setBounds(0, 0, 1700, 900);
	tab.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	tab.setFont(new Font("classic", Font.BOLD, 18));
	frame.add(tab);



	tab1 = new JPanel();
	tab1.setLayout(null);
	tab1.setBackground(Color.white);
	tab.add("Main",tab1);

	
	
	
	p1=new JPanel();
	p1.setLayout(null);
	p1.setBounds(0,0,1600,450);
	p1.setBackground(new Color(255, 153, 51));
	tab1.add(p1);
	
	p2=new JPanel();
	p2.setBounds(0,450,1600,450);
	p2.setBackground(Color.white);
	p2.setLayout(null);
	tab1.add(p2);
	
	txtuserid = new JTextField("");
	txtuserid.setText(Integer.toString(Global.currentUser.getUserid()));
	
	columnsName = new Object[7];
	columnsName[0] = "User Name" ;
	columnsName[1] = "Order ID";
	columnsName[2] = "booking id";
	columnsName[3] = "drinks ";
	columnsName[4] = "Quantity";
	columnsName[5] = "Rate";
	columnsName[6] = "Order status";
	

	table1 = new JTable();
	table1.setBackground(Color.white);
	
	table1.setForeground(new Color(255, 153, 51));
	model = (DefaultTableModel) table1.getModel();
	model.setColumnIdentifiers(columnsName);

	

	JScrollPane scroll1 = new JScrollPane(table1);
	scroll1.setBackground(new Color(255, 153, 51));
	scroll1.setBounds(10,10 , 1510, 320);
	p1.add(scroll1, BorderLayout.CENTER);
	updateTable();
	table1.addMouseListener(this);
	
	confirm=new JButton("confirm");
	confirm.setBounds(550,350,150,50);
	confirm.setBackground(Color.white);
	confirm.setForeground(Color.black);
	confirm.addActionListener(this);
	p1.add(confirm);
	
	logout=new JButton("logout");
	logout.setBounds(800,350,150,50);
	logout.setBackground(Color.white);
	logout.setForeground(Color.black);
	logout.addActionListener(this);
	p1.add(logout);
	
	txtorderid=new JTextField();
	txtorderid.setBounds(150,200,100,30);

	
	
	
	
	
	JLabel naya=new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/qqj.jpg"));
	naya.setBounds(0,0,1650,450);
	p2.add(naya);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	frame.setVisible(true);
	
}


public void updateTable() {
	a1= new JDBC_bar().drinkselect();
	
	model.setRowCount(0);
	for (bar2_library b : a1) {
		Object tmpRow[] = {

				b.getUsername(),b.getBarorderid(),b.getBookingid(),b.getDrinks(),b.getDrinksquantity(),b.getDrinksrate(),b.getDrinksstatus()
		};

		model.addRow(tmpRow);
	}
	table1 = new JTable(model);

}
@Override
public void mouseClicked(MouseEvent e) {

	try {
		int h5 = table1.getSelectedRow();

		TableModel model = table1.getModel();

		String order = model.getValueAt(h5, 1).toString();
		txtorderid.setText(order);

	} catch (Exception ex) {
		System.out.println("Error" + ex.getMessage());
	}

	
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==confirm)
	{
		bar_library o=new bar_library();
		o.setBarorderid(Integer.parseInt(txtorderid.getText()));
		o.setDrinksstatus("booked");
		
		JDBC_bar q=new JDBC_bar();
	    boolean result=q.confirmdrinks(o);
	    updateTable();
	
	    
	    if (result=true) {
	    	
	    	JOptionPane.showMessageDialog(null, " drinks is ready to be served ");
	    }
	    
	   
	      
	}
	if(e.getSource()==logout) {
		
		new login();
		frame.dispose();
	
		
	}
	
	
}











public static void main(String[]args) {
	
	new Bardashboard();
}




@Override
public void mousePressed(MouseEvent e) {
	
	
}


@Override
public void mouseReleased(MouseEvent e) {

	
}


@Override
public void mouseEntered(MouseEvent e) {
	
	
}


@Override
public void mouseExited(MouseEvent e) {

}


}
