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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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

import JDBC.JDBC_addroom;
import JDBC.JDBC_booking;
import JDBC.JDBC_service;
import library.Global;
import library.booking2_library;
import library.booking_library;
import library.room_global;
import library.room_library;
import library.service_library;

public class reception implements ActionListener, MouseListener ,ItemListener{

	JFrame frame;
	JLabel pic, roomno, bookstatus, checkin, checkout;
	JTextField troomno, tcheckin, tcheckout, tbookingid,txtuserid,t1,t2,t3,t4,t5,z1,z2,z3,z4,z5,txtbookingid;
	JPanel panel, panel1, panel2, panel3;
	JButton Room, addFood, updateFood, searchFood,logout,chkin,chkout;
	JButton SearchRoom,addstaff,servicebook;
	JButton  confirm,searchRoom;
	JComboBox tbooktatus,txtbookingstatus;
	JDateChooser calen1, calen2;
	JTable table1,table2,table3;
	DefaultTableModel model,model2,model3;
	JPanel west, center, tab1, tab2, tab3, tab4, tab5,p1,p2,p3;
	JTabbedPane tab;
	
	JLabel lblType, lblRoomNO, lblrate;
	JTextField txtRate, txtRoomno,txtservice;
	JComboBox cmbType,cmbsrch;
	JButton btnSearch, btnAdd, btnUpdate,btnservice;
	JPanel pane;
	Random random;
    JCheckBox b1,b2,b3,b4;
	Object[] columnsName,columnsRoom,columnservice;
	ArrayList<booking2_library> a1;
	ArrayList<room_library>a2;
	ArrayList<service_library>a3;
	public reception() {
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

		

		tab2 = new JPanel();
		tab2.setLayout(null);
		tab2.setBackground(new Color(255, 153, 51));
		tab.add("Room",tab2);

		
		tab3 = new JPanel();
		tab3.setLayout(null);
		tab3.setBackground(Color.white);
		tab.add("Add room",tab3);

		 tab4 = new JPanel();
			tab4.setLayout(null);
			tab4.setBackground(Color.gray);
			tab.add("Service activation",tab4);
		
        tab5 = new JPanel();
		tab5.setLayout(null);
		tab5.setBackground(Color.white);
		tab.add("Service",tab5);

	   
		
		p1 = new JPanel();// panel for booking
		p1.setBounds(0, 0, 1900, 400);
		p1.setLayout(null);
		p1.setBackground(new Color(255, 153, 51));
        tab1.add(p1);
		
		

        p2 = new JPanel();// panel for booking
		p2.setBounds(0, 400, 1700, 450);
		p2.setBackground(Color.white);
		p2.setLayout(null);
		
        tab1.add(p2);

        txtuserid = new JTextField("");
		txtuserid.setText(Integer.toString(Global.currentUser.getUserid()));

		columnsName = new Object[8];
		columnsName[0] = "User Name" ;
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
		scroll1.setBackground(Color.white);
		scroll1.setBounds(10,10, 1510, 380);
		p1.add(scroll1, BorderLayout.CENTER);
		table1.addMouseListener(this);

		tbookingid=new JTextField();
		
		calen1 = new JDateChooser();
		calen1.setDateFormatString("yyyy-MM-dd");
		calen1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		calen1.setFont(new Font("classic", Font.BOLD, 16));
		calen1.setBounds(200, 170, 200, 30);
		p2.add(calen1);

		calen2 = new JDateChooser();
		calen2.setDateFormatString("yyyy-MM-dd");
		calen2.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		calen2.setFont(new Font("classic", Font.BOLD, 16));
		calen2.setBounds(200, 250, 200, 30);
		p2.add(calen2);

		

		roomno = new JLabel("Room no:");
		roomno.setBounds(20, 10, 150, 30);
		roomno.setFont(new Font("classic", Font.BOLD, 22));
		roomno.setForeground(Color.black);
		p2.add(roomno);

		troomno = new JTextField("");
		troomno.setBounds(200, 10, 200, 30);
		troomno.setFont(new Font("classic", Font.BOLD, 22));
		troomno.setForeground(Color.black);
		p2.add(troomno);

		bookstatus = new JLabel("Booking Status:");
		bookstatus.setBounds(20, 90, 150, 30);
		bookstatus.setFont(new Font("classic", Font.BOLD, 22));
		bookstatus.setForeground(Color.black);
		p2.add(bookstatus);

		String b[] = { "booked", "available","active" };
		tbooktatus = new JComboBox(b);
		tbooktatus.setBounds(200, 90, 200, 30);
		tbooktatus.setFont(new Font("classic", Font.BOLD, 20));
		tbooktatus.setForeground(Color.black);
		p2.add(tbooktatus);

		checkin = new JLabel("Check in:");
		checkin.setBounds(20, 170, 150, 30);
		checkin.setFont(new Font("classic", Font.BOLD, 22));
		checkin.setForeground(Color.black);
		p2.add(checkin);

		checkout = new JLabel("Check out:");
		checkout.setBounds(20, 250, 150, 30);
		checkout.setFont(new Font("classic", Font.BOLD, 22));
		checkout.setForeground(Color.black);
		p2.add(checkout);

		confirm = new JButton("Confirm");
		confirm.setBackground(Color.black);
		confirm.setForeground(Color.white);
		confirm.setBounds(10, 310, 150, 40);
		confirm.addActionListener(this);
		p2.add(confirm);

		chkin = new JButton("checkin");
		chkin.setBackground(Color.black);
		chkin.setForeground(Color.white);
		chkin.setBounds(180, 310, 150, 40);
		chkin.addActionListener(this);
		p2.add(chkin);
	
		chkout = new JButton("cancel");
		chkout.setBackground(Color.black);
		chkout.setForeground(Color.white);
		chkout.setBounds(350, 310, 150, 40);
		chkout.addActionListener(this);
		p2.add(chkout);
		
        pic=new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/hihh.jpg"));
        pic.setBounds(650,0,1000,410);
       p2.add(pic);
		
		
		
    	logout = new JButton("logout");
    	logout.setBackground(Color.black);
    	logout.setForeground(Color.white);
    	logout.setBounds(520, 310, 150, 40);
    	logout.addActionListener(this);
		p2.add(logout);
		
		
		
		
		
		
		
		
		
		
		
		///////////////////////////// for search room/////////////////////////////
		
		
		
		
		
		
		
         searchRoom=new JButton("Refresh");
         searchRoom.setBounds(700,10,100,30);
         searchRoom.addActionListener(this);
         tab2.add(searchRoom);
         
         String p[]= {"Single","Twin","Double"};
          cmbsrch=new JComboBox(p);
         cmbsrch.setBounds(500,10,150,30);
         cmbsrch.addItemListener(this);
         tab2.add(cmbsrch);
        
        
    	
    	
    	columnsRoom = new Object[4];
    	columnsRoom[0] = "Room no";
    	columnsRoom[1] = "Room type";
    	columnsRoom[2] = "Rate";
    	columnsRoom[3] = "Room status";
    	
    	table2 = new JTable();
    	table2.setBackground(Color.white);
    	table2.setForeground(new Color(255, 153, 51));
    	model2 = (DefaultTableModel) table2.getModel();
    	model2.setColumnIdentifiers(columnsRoom);

    	updateTable2();
    	JScrollPane scroll2 = new JScrollPane(table2);
    	scroll2.setBounds(10,100,1510,500);
    	tab2.add(scroll2, BorderLayout.CENTER);
        
        
    	
    	//////////////////////////////////////////////////////////////////////
    	
    	

		JLabel lblminibar = new JLabel("Mini bar");
		lblminibar.setBounds(140, 100, 100, 30);
		lblminibar.setFont(new Font("classic", Font.BOLD, 20));
		lblminibar.setForeground(Color.white);
		tab4.add(lblminibar);

		JLabel lbllaundry = new JLabel("Laundry");
		lbllaundry.setBounds(140, 170, 100, 30);
		lbllaundry.setFont(new Font("classic", Font.BOLD, 20));
		lbllaundry.setForeground(Color.white);
		tab4.add(lbllaundry);

		JLabel lblgym = new JLabel("Gym");
		lblgym.setBounds(140, 230, 100, 30);
		lblgym.setFont(new Font("classic", Font.BOLD, 20));
		lblgym.setForeground(Color.white);
		tab4.add(lblgym);

		JLabel lblpool = new JLabel("Pool");
		lblpool.setFont(new Font("classic", Font.BOLD, 20));
		lblpool.setForeground(Color.white);
		lblpool.setBounds(140, 300, 200, 30);
		tab4.add(lblpool);

		b1 = new JCheckBox("rs 500");
		b1.setForeground(Color.white);
		b1.setBounds(250, 110, 10, 10);
		b1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		b1.setFont(new Font("classic", Font.BOLD, 16));
		tab4.add(b1);

		b2 = new JCheckBox("rs 500");
		b2.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		b2.setFont(new Font("classic", Font.BOLD, 16));
		b2.setBounds(250, 180, 10, 10);
		tab4.add(b2);

		b3 = new JCheckBox("rs 500");
		b3.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		b3.setFont(new Font("classic", Font.BOLD, 16));
		b3.setBounds(250, 240, 10, 10);
		tab4.add(b3);

		b4 = new JCheckBox("rs 500");
		b4.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		b4.setFont(new Font("classic", Font.BOLD, 16));
		b4.setBounds(250, 315, 10, 10);
		tab4.add(b4);

		servicebook = new JButton("Add");
		servicebook.setBounds(120, 380, 120, 40);
		servicebook.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		servicebook.addActionListener(this);
		tab4.add(servicebook);

		JLabel serpic = new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/sevice2.jpg"));
		serpic.setBounds(400, 0, 1300, 863);
		tab4.add(serpic);

		JLabel msg = new JLabel("Each service cost rs 125 ");
		msg.setBounds(30, 720, 300, 30);
		msg.setFont(new Font("classic", Font.BOLD, 15));
		msg.setForeground(Color.white);
		tab4.add(msg);

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();

		t5 = new JTextField();
		t5.setBounds(60, 600, 100, 30);

		z1 = new JTextField();
		z2 = new JTextField();
		z3 = new JTextField();
		z4 = new JTextField();

		z5 = new JTextField();
		z5.setBounds(60, 700, 100, 30);
    	
    	
		txtbookingid=new JTextField();
		txtbookingid.setBounds(150, 40, 150, 30);
		tab4.add(txtbookingid);
    	 
		JLabel m=new JLabel("Booking ID ");
		m.setBounds(10,40,110,30);
		m.setFont(new Font("Tahoma", Font.BOLD, 22));
		m.setForeground(Color.white);
		tab4.add(m);
		
		
	    
		
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	frame.setVisible(true);
    	}

    	public void updateTable2() {
    		a2 = new JDBC_addroom().selectroomb();
    		model2.setRowCount(0);
    		for (room_library bookingLibs : a2) {
    			Object tmpRow[] = {
    					bookingLibs.getRoomno(),
    					bookingLibs.getRoomtype(),
    					bookingLibs.getRate(),
    					bookingLibs.getRoomstatus(),
    			

    			};

    			model2.addRow(tmpRow);
    		}
    		table2 = new JTable(model2);

         		
    	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		////////////////////////for add room////////////////////
		
		
		
		
		
		

		pane = new JPanel();
		pane.setBounds(400, 40, 620, 520);
		pane.setBackground(new Color(255,153,51));
		pane.setLayout(null);
		
		
		
		lblrate = new JLabel("Rate :");
		lblrate.setBounds(210, 250, 100, 30);
		lblrate.setFont(new Font("classic", Font.BOLD, 20));
		lblrate.setForeground(Color.white);
		pane.add(lblrate);

		lblType = new JLabel("Type :");
		lblType.setBounds(200, 170, 100, 30);
		lblType.setFont(new Font("classic", Font.BOLD, 20));
		lblType.setForeground(Color.white);
		pane.add(lblType);

		lblRoomNO = new JLabel("RoomNo :");
		lblRoomNO.setBounds(200, 100, 100, 30);
		lblRoomNO.setFont(new Font("classic", Font.BOLD, 20));
		lblRoomNO.setForeground(Color.white);
		pane.add(lblRoomNO);

	    cmbType=new JComboBox();
	    for (int i=0; i<room_global.RoomType.length; i++){
	    	cmbType.addItem(room_global.RoomType[i]);
	    }
		
		cmbType.setBounds(300, 170, 200, 30);
		cmbType.addItemListener(this);
		
		txtRate = new JTextField();
		txtRate.setColumns(20);
		txtRate.setBounds(300, 240, 200, 30);

		random = new Random();
		int random = (int) (Math.random() * 500 + 1);

		txtRoomno = new JTextField();
		txtRoomno.setColumns(20);
		txtRoomno.setBounds(300, 100, 200, 30);

		txtRoomno.setText(String.valueOf(random));

		// set rate of room

		
		

		btnAdd = new JButton("Add");
		btnAdd.setBounds(100, 360, 120, 40);
		btnAdd.setFont(new Font("serif", Font.BOLD, 20));
		btnAdd.setBackground(Color.white);
		btnAdd.setForeground(Color.red);
		btnAdd.addActionListener(this);
		

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(260, 360, 120, 40);
		btnUpdate.setFont(new Font("serif", Font.BOLD, 20));
		btnUpdate.setBackground(Color.white);
		btnUpdate.setForeground(Color.red);
		btnUpdate.addActionListener(this);
		

		tab3.add(pane);

		pane.add(lblType);
		pane.add(cmbType);
		pane.add(lblRoomNO);
		pane.add(txtRoomno);
		pane.add(txtRate);
		pane.add(btnAdd);
		pane.add(btnUpdate);
		
		
		////////////////////////////////////////////////////////////////////////////
		
		columnservice = new Object[6];
		columnservice[0] = "User Name";
		columnservice[1] = "Service ID";
		columnservice[2] = "Booking ID";
		columnservice[3] = "Service price";
		columnservice[4] = "Services";
		columnservice[5] = "Service status";
		

		table3 = new JTable();
		table3.setBackground(Color.white);
        table3.setForeground(new Color(255, 153, 51));
		model3 = (DefaultTableModel) table3.getModel();
		model3.setColumnIdentifiers(columnservice);
        
		
		updateTable3();

		JScrollPane scroll3 = new JScrollPane(table3);
		scroll3.setBackground(new Color(255, 153, 51));
	    scroll3.setBounds(10, 10, 1580, 200);
	    table3.addMouseListener(this);
		tab5.add(scroll3, BorderLayout.CENTER);
		
		
		btnservice=new JButton("Confirm");
		btnservice.setBounds(700,220,150,30);
		btnservice.setFont(new Font("classic", Font.BOLD, 22));
		btnservice.setBackground(Color.white);
		btnservice.setForeground(Color.black);
		btnservice.addActionListener(this);
		tab5.add(btnservice);
		
		
		
		txtservice=new JTextField();
	   //txtservice.setBounds(150,20,180,30);
		//tab5.add(txtservice);
		
		
		JLabel naya=new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/stg.png"));
		naya.setBounds(0,260,1650,450);
		tab5.add(naya);
		
		
		frame.setVisible(true);	
		
	}

	public void updateTable() {
		a1 = new JDBC_booking().selectbooking();
		model.setRowCount(0);
		for (booking2_library b : a1) {
			Object tmpRow[] = {

					b.getUsername(),b.getBookingid(), b.getUserid(), b.getRoomno(),

					b.getBookingtype(), b.getCheckin(), b.getCheckout(),

					b.getBookingstatus()

			};

			model.addRow(tmpRow);
		}
		table1 = new JTable(model);

	}

	public void updateTable3() {
		a3 = new JDBC_service().selectservice();
		model3.setRowCount(0);
		for (service_library b : a3) {
			Object tmpRow[] = {

					b.getUsername(),b.getServiceid(), b.getBookingid(), b.getServiceprice(),

					b.getServices(), b.getServicestatus()
			};

			model3.addRow(tmpRow);
		}
		table3 = new JTable(model3);

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		try {
			int h5 = table1.getSelectedRow();

			TableModel model = table1.getModel();

			String bookin = model.getValueAt(h5, 1).toString();
			tbookingid.setText(bookin);

			String room = model.getValueAt(h5, 3).toString();
			troomno.setText(room);

			String status = model.getValueAt(h5, 7).toString();
			tbooktatus.setSelectedItem(status);

			
			
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h5, 5));
			calen1.setDate(date);

			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h5, 6));
			calen2.setDate(date2);

			
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}

		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			int h7 = table3.getSelectedRow();

			TableModel model3 = table3.getModel();

			String bookin = model3.getValueAt(h7, 1).toString();
			txtservice.setText(bookin);

			

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
	
		}
		
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

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==logout) {
			frame.dispose();
			new login();
				
			
		 }
		
		///////////////////////////////////action peform for room acepting//////////////////////////
		if(e.getSource()==searchRoom) {
			 updateTable2();
			 updateTable();
				
			
		 }
		
		if (e.getSource() == confirm) {
			int id = Integer.parseInt(tbookingid.getText());
			int room_no = Integer.parseInt(troomno.getText());
			
			String date1 = ((JTextField) calen1.getDateEditor().getUiComponent()).getText();
			String date2 = ((JTextField) calen2.getDateEditor().getUiComponent()).getText();

			booking_library k = new booking_library();

			k.setRoomno(room_no);
			k.setBookingid(id);
			k.setCheckin(date1);
			k.setCheckout(date2);
			k.setBookingstatus("Booked");

			JDBC_booking hey = new JDBC_booking();
			boolean result = hey.updatebooking(k);
			
			if (result == true) {
				updateTable();
				JOptionPane.showMessageDialog(null, "Successful");}
			
			
		
			
			room_library r=new room_library();
		    r.setRoomstatus("Booked");
			r.setRoomno(room_no);
		    JDBC_addroom t = new JDBC_addroom();
			boolean resu=t.updateroom(r);
			
			if (resu == true) {
				updateTable();
				}
			
			}
			
		if (e.getSource() == chkin) {
			int id = Integer.parseInt(tbookingid.getText());
			int room_no = Integer.parseInt(troomno.getText());
			
			String date1 = ((JTextField) calen1.getDateEditor().getUiComponent()).getText();
			String date2 = ((JTextField) calen2.getDateEditor().getUiComponent()).getText();

			booking_library k = new booking_library();

			k.setRoomno(room_no);
			k.setBookingid(id);
			k.setCheckin(date1);
			k.setCheckout(date2);
			k.setBookingstatus("active");

			JDBC_booking hey = new JDBC_booking();
			boolean result = hey.updatebooking(k);
			
			if (result == true) {
				updateTable();
				JOptionPane.showMessageDialog(null, "Successfull");}
			
			
		
			
			room_library r=new room_library();
		    r.setRoomstatus("unavailable");
			r.setRoomno(room_no);
		    JDBC_addroom t = new JDBC_addroom();
			boolean resu=t.updateroom(r);
			
			if (resu == true) {
				updateTable();
				}
			
			}
		
		if (e.getSource() == chkout) {
			int id = Integer.parseInt(tbookingid.getText());
			int room_no = Integer.parseInt(troomno.getText());
			
			String date1 = ((JTextField) calen1.getDateEditor().getUiComponent()).getText();
			String date2 = ((JTextField) calen2.getDateEditor().getUiComponent()).getText();

			booking_library k = new booking_library();

			k.setRoomno(room_no);
			k.setBookingid(id);
			k.setCheckin(date1);
			k.setCheckout(date2);
			k.setBookingstatus("inactive");

			JDBC_booking hey = new JDBC_booking();
			boolean result = hey.updatebooking(k);
			
			if (result == true) {
				updateTable();
				JOptionPane.showMessageDialog(null, "Successfull");}
			
			
		
			
			room_library r=new room_library();
		    r.setRoomstatus("available");
			r.setRoomno(room_no);
		    JDBC_addroom t = new JDBC_addroom();
			boolean resu=t.updateroom(r);
			
			if (resu == true) {
				updateTable();
				}
			
			}
		
		
		/////////////////////////////////////////////action performed for add room
		
		
		if (e.getSource() == btnAdd) {

			room_library rm = new room_library();
			rm.setRoomno(Integer.parseInt(txtRoomno.getText()));
			rm.setRate(Integer.parseInt(txtRate.getText()));
			rm.setRoomtype(cmbType.getSelectedItem().toString());
			rm.setRoomstatus("available");
			JDBC_addroom j = new JDBC_addroom();
			boolean result = j.room(rm);
	         if(result==true) {
				
				JOptionPane.showMessageDialog(null, "Successfully room added");
		}

		
	/*	if (e.getSource() == btnUpdate) {
			
			room_library rm = new room_library();
			rm.setRoomno(Integer.parseInt(txtRoomno.getText()));
			rm.setRate(Integer.parseInt(txtRate.getText()));
			rm.setRoomtype(cmbType.getSelectedItem().toString());
            
			JDBC_addroom j = new JDBC_addroom();
			boolean result = j.updateroom(rm);
			
			if(result==true) {
				
				JOptionPane.showMessageDialog(null, "Successfully room updated");
			}
			
		}*/
			
			
			///////////////////////////////action performed for search room////////////////////////
			
		
			 
		
			
			 //logout
			
			 
		     
		
		}

		if(e.getSource()==btnservice) {
			
			
			
			service_library i=new service_library();
			i.setServicestatus("booked");
			i.setServiceid(Integer.parseInt(txtservice.getText()));
			
			
			
			JDBC_service o=new JDBC_service();
			boolean Result = o.updateservice(i);
			if(Result==true) {
				 
				JOptionPane.showMessageDialog(null, "Successfully service added");}
			
			
			updateTable3();
		}
			
			
		if (e.getSource() == servicebook) {

			if (b1.isSelected()) {
				z1.setText("Mini Bar, ");
				t1.setText("125");
			} else {
				t1.setText("0");
				z1.setText("");
			}

			if (b2.isSelected()) {
				z2.setText("Laundry, ");
				t2.setText("125");
			}

			else {
				t2.setText("0");
				z2.setText("");
			}

			if (b3.isSelected()) {
				z3.setText("Gym, ");
				t3.setText("125");
			}

			else {
				t3.setText("0");
				z3.setText("");
			}

			{
				if (b4.isSelected()) {
					z4.setText("Pool");
					t4.setText("125");
				}

				else {
					t4.setText("0");
					z4.setText("");
				}
			}

			int a = Integer.parseInt(t1.getText());
			int b = Integer.parseInt(t2.getText());
			int c = Integer.parseInt(t3.getText());
			int d = Integer.parseInt(t4.getText());
			int f = a + b + c + d;

			String g = z1.getText();
			String h = z2.getText();
			String i = z3.getText();
			String j = z4.getText();
			String z = g + h + i + j;

			t5.setText(Integer.toString(f));
			z5.setText(z);

			service_library s = new service_library();
			s.setBookingid(Integer.parseInt(txtbookingid.getText()));
			s.setServiceprice(Integer.parseInt(t5.getText()));
			s.setServices(z5.getText());
			s.setServicestatus("pending");

			JDBC_service js = new JDBC_service();
			boolean result = js.service(s);

			if(result=true) {
				
				JOptionPane.showMessageDialog(null, "Successfully service booked");}
			
		}

		
		
		if (e.getSource() == logout) {
			frame.dispose();
			new login();

		}
		
		if (e.getSource() == checkin) {

			booking_library f = new booking_library();
			f.setUserid(Integer.parseInt(txtuserid.getText()));
			f.setBookingid(Integer.parseInt(txtuserid.getText()));
			f.setBookingstatus("pending");

		}
	}
			
		
		
		
		
		
		
		
		
		
		
		

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbType) {
			int index = cmbType.getSelectedIndex();
			txtRate.setText(Integer.toString(room_global.Room_rate[index]));
		}
		
	}
	
	
	
	
	

	

	public static void main(String[] args) {

		new reception();

	}



}