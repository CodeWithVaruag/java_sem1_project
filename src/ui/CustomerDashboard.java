package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

import com.toedter.calendar.JDateChooser;

import JDBC.JDBC_booking;
import library.Global;
import library.bill1_library;
import library.booking2_library;
import library.booking_library;
import library.room_global;

public class CustomerDashboard implements ActionListener, ItemListener,MouseListener {

	JFrame frame;
	JPanel west, center, tab1, tab2, tab3, tab4, tab5, p1, p2, p3, barpanel, d1;
	JTabbedPane tab;
	JLabel lblRate, lblType, lblCheckin, lblCheckout, lblfood, lblQuantity, lblrate, pic, barlblDrinks, barlblQuantity,
			barlblrate, barpic, bookingpic, titlebook, lbltotalfood, lbltotalbar, lblminibar, lbllaundry, lblgym,
			lblpool;
	JTextField txtRate, txtuserid, barrate, foodrate, txttotalfood, txttotalbar, t1, t2, t3, t4, t5, z1, z2, z3, z4, z5,txtbookingid,txtbookingstatus;
	JButton btnBook, btnfoodBook, BarbtnBook, logout, servicebook, proceed;
	JComboBox cmbType, cmbfood, barcmbDrinks, txtquantity, txtcmbquantity, cmbminibar, cmbpool, cmblaundry, cmbgym;
	JDateChooser calen1, calen2, bcheckin, bcheckout;
	DefaultTableModel model,model2;
	Object[] columnsName,columnsbill;
	ArrayList<booking2_library> a1;
	ArrayList<bill1_library> a2;
	JTable table1,tbl2;
	JCheckBox b1, b2, b3, b4;
	JTextField bvat, bname, bbookingid, btotaldays, broomrate,bfinalrate,bfoodrate,bdrinkrate,bserviceprice,btotal,bdiscount;
	JComboBox paidstatus;
	
	public CustomerDashboard() {

		frame = new JFrame();
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setSize(1050, 650);
		frame.setLayout(new BorderLayout());

		center = new JPanel();
		center.setBackground(Color.white);
		center.setLayout(null);
		frame.add(center, BorderLayout.CENTER);

		tab = new JTabbedPane();
		tab.setBackground(Color.white);
		tab.setForeground(Color.black);
		tab.setBounds(0, 0, 1700, 900);
		tab.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		tab.setFont(new Font("classic", Font.BOLD, 18));
		center.add(tab);

		/******************************************* for booking panel */

		tab1 = new JPanel();
		tab1.setLayout(null);
		tab1.setBackground(Color.white);
		tab.add("Room booking", tab1);

		/*
		 * .......................................for food panel........................
		 */

		p1 = new JPanel();// panel for booking
		p1.setBounds(0, 0, 400, 900);
		p1.setBackground(new Color(255, 153, 51));

		p2 = new JPanel();// panel for booking
		p2.setBounds(400, 0, 1200, 100);
		p2.setLayout(null);
		p2.setBackground(new Color(255, 153, 51));

		p3 = new JPanel();// panel for booking
		p3.setBounds(0, 10, 1200, 70);
		p3.setBackground(Color.white);
		
		
		
		

	/////////////////////////////////////////////////////////////////////////////////////	///////////////////////////////////// booking////////////////////////////////////////////////////

		
		
		
		
		lblType = new JLabel("Type :");
		lblType.setBounds(20, 100, 100, 30);
		lblType.setFont(new Font("classic", Font.BOLD, 20));
		lblType.setForeground(Color.white);
		tab1.add(lblType);

		lblCheckin = new JLabel("check in:");
		lblCheckin.setBounds(20, 170, 100, 30);
		lblCheckin.setFont(new Font("classic", Font.BOLD, 20));
		lblCheckin.setForeground(Color.white);
		tab1.add(lblCheckin);

		lblCheckout = new JLabel("Check out:");
		lblCheckout.setBounds(20, 230, 120, 30);
		lblCheckout.setFont(new Font("classic", Font.BOLD, 20));
		lblCheckout.setForeground(Color.white);
		tab1.add(lblCheckout);

		lblRate = new JLabel("Rate :");
		lblRate.setBounds(20, 300, 100, 30);
		lblRate.setFont(new Font("classic", Font.BOLD, 20));
		lblRate.setForeground(Color.white);
		tab1.add(lblRate);

		cmbType = new JComboBox();
		for (int i = 0; i < room_global.RoomType.length; i++) {
			cmbType.addItem(room_global.RoomType[i]);
		}
		cmbType.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		cmbType.setForeground(Color.black);
		cmbType.setBackground(Color.white);
		cmbType.setFont(new Font("classic", Font.BOLD, 16));
		cmbType.setBounds(150, 100, 200, 30);
		cmbType.addItemListener(this);
		tab1.add(cmbType);

		calen1 = new JDateChooser();
		calen1.setDateFormatString("yyyy-MM-dd");
		calen1.setBorder(BorderFactory.createLineBorder(Color.white, 1));

		calen1.setFont(new Font("classic", Font.BOLD, 16));
		calen1.setBounds(150, 170, 200, 30);
		tab1.add(calen1);

		calen2 = new JDateChooser();
		calen2.setDateFormatString("yyyy-MM-dd");
		calen2.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		calen2.setFont(new Font("classic", Font.BOLD, 16));
		calen2.setBounds(150, 230, 200, 30);
		tab1.add(calen2);

		txtRate = new JTextField("");
		txtRate.setBounds(150, 300, 200, 30);
		txtRate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtRate.setFont(new Font("classic", Font.BOLD, 16));
		txtRate.setForeground(Color.black);
		tab1.add(txtRate);

		txtuserid = new JTextField("");
	    txtuserid.setText(Integer.toString(Global.currentUser.getUserid()));

	    txtbookingid=new JTextField();
	    txtbookingid.setBounds(150, 600, 200, 30);
	  //  tab1.add(txtbookingid);
	    
	    txtbookingstatus=new JTextField();
	    txtbookingid.setBounds(150, 600, 200, 30);
	  //  tab1.add(txtbookingid);
	    
		btnBook = new JButton("Book");
		btnBook.setBounds(140, 420, 120, 40);
		btnBook.addActionListener(this);
		btnBook.setFont(new Font("serif", Font.BOLD, 20));
		btnBook.setBackground(Color.white);
		btnBook.setForeground(Color.black);

		logout = new JButton("logout");
		logout.setFont(new Font("serif", Font.BOLD, 20));
		logout.setBackground(Color.white);
		logout.setForeground(Color.black);
		logout.setBounds(140, 550, 120, 40);
		logout.addActionListener(this);
		tab1.add(logout);

		
		tab1.add(btnBook);
		tab1.add(p1);
		tab1.add(p2);
		p2.add(p3);

		titlebook = new JLabel("Hotel Luton");
		titlebook.setBounds(150, 10, 130, 60);
		titlebook.setForeground(new Color(255, 153, 51));
		titlebook.setFont(new Font("Tahoma", Font.BOLD, 50));
		p3.add(titlebook);

		columnsName = new Object[8];
		columnsName[0] = "User Name";
		columnsName[1] = "Booking ID";
		columnsName[2] = "User ID";
		columnsName[3] = "Room NO";
		columnsName[4] = "Booking TYPE";
		columnsName[5] = "Check IN";
		columnsName[6] = "Check OUT";
		columnsName[7] = "Booking STATUS";

		table1 = new JTable();
		table1.setBackground(Color.white);
        
		table1.setForeground(new Color(255, 153, 51));
		model = (DefaultTableModel) table1.getModel();
		model.setColumnIdentifiers(columnsName);

		updateTable();

		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setBackground(new Color(255, 153, 51));
		scroll1.setBounds(400, 560, 1150, 120);
		table1.addMouseListener(this);
		tab1.add(scroll1, BorderLayout.CENTER);

		bookingpic = new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/heyyo.jpg"));
		bookingpic.setBounds(630, 100, 612, 408);
		tab1.add(bookingpic);

		proceed = new JButton("proceed");
		proceed.setBounds(950, 700, 130, 40);
		proceed.addActionListener(this);
		tab1.add(proceed);
		
		
		
		frame.setVisible(true);
		
			
	}
	
	

	
	
	
	public void updateTable() {
		a1 = new JDBC_booking().selectbookingcust();
		model.setRowCount(0);
		for (booking2_library b : a1) {
			Object tmpRow[] = {

					b.getUsername(), b.getBookingid(), b.getUserid(), b.getRoomno(),

					b.getBookingtype(), b.getCheckin(), b.getCheckout(),

					b.getBookingstatus() };

			model.addRow(tmpRow);
		}
		table1 = new JTable(model);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		

		///////// action event for room booking//////////////////

		if (e.getSource() == btnBook) {

			int customerid = Integer.parseInt(txtuserid.getText());
			String date1 = ((JTextField) calen1.getDateEditor().getUiComponent()).getText();
			String date2 = ((JTextField) calen2.getDateEditor().getUiComponent()).getText();

			booking_library j = new booking_library();

			j.setUserid(customerid);
			j.setBookingtype(cmbType.getSelectedItem().toString());
			j.setCheckin(date1);
			j.setCheckout(date2);
			j.setBookingstatus("Pending");

			JDBC_booking hey = new JDBC_booking();
			boolean result = hey.booking(j);

			if (result == true) {

				JOptionPane.showMessageDialog(null, "Successfully booked");
			}
			updateTable();
		}


		if (e.getSource() == proceed) {
			
			booking_library book = new booking_library();
			book.setBookingid(Integer.parseInt(txtbookingid.getText()));
			
			book = new JDBC_booking().bookin(book);
			Global.obj2 = book;
			
			
			if(book.getBookingstatus().equals("active"))
			{
			new features();
			frame.dispose();
			
			}
			 
			else {
				     JOptionPane.showMessageDialog(null, "sorry you havent checkedin in our hotel");
			}
			
	
		}
		if (e.getSource() == logout) {
			frame.dispose();
			new login();

		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		//////////////////////////////// item event for booking to match value of room
		//////////////////////////////// type with room rate ////////////////////////

		if (e.getSource() == cmbType) {
			int index = cmbType.getSelectedIndex();
			txtRate.setText(Integer.toString(room_global.Room_rate[index]));
		}

	
		
		
	}

	
		
	public static void main(String[] args) {
		new CustomerDashboard();
	}






	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void mousePressed(MouseEvent e) {
		try{
			int h5 = table1.getSelectedRow();

		TableModel model = table1.getModel();

		String bookin = model.getValueAt(h5, 1).toString();
		txtbookingid.setText(bookin);

		

		
	} catch (Exception ex) {
		System.out.println("Error" + ex.getMessage());
	}
		
	}






	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}