package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import JDBC.JDBC_bill;
import library.bill1_library;

public class bill implements MouseListener{
	
	
	JFrame frame;
	JLabel lblbookingid,lblusername,lbldrinksrate,lblfoodrate,lblserviceprice,lblroomrate;
	JTextField bookingid,username,drinksrate,foodrate,serviceprice,roomno,roomrate, noofdays,roomfinal,total;
	JDateChooser checkin,checkout;
	DefaultTableModel model;
	Object[] columnsName;
	ArrayList<bill1_library> a1;
	JTable table1;
	
	public bill() {
		
		frame=new JFrame();
		frame.setSize(1600,900);
		frame.setLayout(null);
		
		JLabel lblbookingid=new JLabel("booking id");
		lblbookingid.setBounds(10,50,130,30);
		frame.add(lblbookingid);
			
		
		JLabel lblusername=new JLabel("user name");
		lblusername.setBounds(10,100,130,30);
		frame.add(lblusername);
		
		
		JLabel lbldrinksrate=new JLabel("drinks rate");
		lbldrinksrate.setBounds(10,150,130,30);
		frame.add(lbldrinksrate);
		
		
		JLabel lblfoodrate=new JLabel("food rate");
		lblfoodrate.setBounds(10,200,130,30);
		frame.add(lblfoodrate);
		
		JLabel  lblserviceprice=new JLabel("service price");
		lblserviceprice.setBounds(10,250,130,30);
		frame.add(lblserviceprice);
		
		
		JLabel lblcheckin=new JLabel("Check in");
		lblcheckin.setBounds(10,300,130,30);
		frame.add(lblcheckin);
		
		JLabel lblcheckout=new JLabel("Check out");
		lblcheckout.setBounds(10,350,130,30);
		frame.add(lblcheckout);
		
		JLabel lblroomrate=new JLabel("room rate");
		lblroomrate.setBounds(10,450,130,30);
		frame.add(lblroomrate);
		
		
		JLabel lblnoofdays=new JLabel("no of days");
		lblroomrate.setBounds(10,450,130,30);
		frame.add(lblnoofdays);
		
		JLabel lblroomfinal=new JLabel("room final");
		lblroomfinal.setBounds(10,500,130,30);
		frame.add(lblroomfinal);
		
		JLabel lbltotal=new JLabel("Total");
		lbltotal.setBounds(10,550,130,30);
		frame.add(lbltotal);
		
		
		
		bookingid=new JTextField();
		bookingid.setBounds(150,50,150,35);
		frame.add(bookingid);
		
		
		
		username=new JTextField();
		username.setBounds(150,100,150,35);
		frame.add(username);
		
		drinksrate=new JTextField();
		drinksrate.setBounds(150,150,150,35);
		frame.add(drinksrate);
		
		
		foodrate=new JTextField();
		foodrate.setBounds(150,200,150,35);
		frame.add(foodrate);
		
		serviceprice=new JTextField();
		serviceprice.setBounds(150,250,150,35);
		frame.add(serviceprice);
		
		checkin = new JDateChooser();
		checkin.setDateFormatString("yyyy-MM-dd");
		checkin.setBounds(150, 300, 200, 30);
		frame.add(checkin);
        
		
		checkout = new JDateChooser();
		checkout.setDateFormatString("yyyy-MM-dd");
		checkout.setBounds(150, 350, 200, 30);
		frame.add(checkout);

		roomrate=new JTextField();
		roomrate.setBounds(150,400,150,35);
		frame.add(roomrate);
		
		noofdays=new JTextField();
		noofdays.setBounds(150,450,150,35);
		frame.add(noofdays);
		
		roomfinal=new JTextField();
		roomfinal.setBounds(150,500,150,35);
		frame.add(roomfinal);
		
		total=new JTextField();
		total.setBounds(150,550,150,35);
		frame.add(total);
		
		
		columnsName = new Object[9];
		columnsName[0] = "Booking id" ;
		columnsName[1] = "check in";
		columnsName[2] = "check out";
		columnsName[3] = "user name ";
		columnsName[4] = "drinks rate";
		columnsName[5] = "food Rate";
		columnsName[6] = "service price";
		columnsName[7] = "Room no";
		columnsName[8] = "Room Rate";
		columnsName[8] = "User type";
		table1 = new JTable();
		table1.setBackground(Color.white);
		
		//table1.setForeground(new Color(255, 153, 51));
		model = (DefaultTableModel) table1.getModel();
		model.setColumnIdentifiers(columnsName);

	
		updateTable();
		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setBackground(new Color(255, 153, 51));
		scroll1.setBounds(350,10 , 1110, 320);
		table1.addMouseListener(this);
		frame.add(scroll1, BorderLayout.CENTER);
	
		
		
	  frame.setVisible(true);	
	}
	
	public void updateTable() {
		a1= new JDBC_bill().bill();
		model.setRowCount(0);
		for (bill1_library b : a1) {
			Object tmpRow[] = {

					b.getBookingid(),b.getCheckin(),b.getCheckout(),b.getUsername(),b.getDrinksrate(),b.getFoodrate(),b.getServiceprice(),b.getRoomno(),b.getRate()
			};

			model.addRow(tmpRow);
		}
		table1 = new JTable(model);

	}
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
			
			try {
				int h = table1.getSelectedRow();

				TableModel model = table1.getModel();

				String bookin = model.getValueAt(h, 0).toString();
				bookingid.setText(bookin);

				
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h, 1));
				checkin.setDate(date);

				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h, 2));
				checkout.setDate(date2);
				
				String user = model.getValueAt(h, 3).toString();
				username.setText(user);
				
				String drinkrate = model.getValueAt(h, 4).toString();
				drinksrate.setText(drinkrate);

				String foodprice = model.getValueAt(h, 5).toString();
				foodrate.setText(foodprice);

				String servicerate = model.getValueAt(h, 6).toString();
				serviceprice.setText(servicerate);
				
				String roomprice = model.getValueAt(h, 8).toString();
				roomrate.setText(roomprice);

				


			} catch (Exception ex) {
				System.out.println("Error" + ex.getMessage());
	
			}
		}
	
				
				
		
			

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	
	
	public static void main(String[]args) {
		
		
		new bill();
	}

	
	
	
}