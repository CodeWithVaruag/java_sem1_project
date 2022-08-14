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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

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
import JDBC.JDBC_bar;
import JDBC.JDBC_bill;
import JDBC.JDBC_booking;
import JDBC.JDBC_food;
import library.Global;
import library.Global_food;
import library.bar_library;
import library.bill1_library;
import library.bill2_library;
import library.booking2_library;
import library.booking_library;
import library.food_library;
import library.room_library;

public class features implements ActionListener,ItemListener,MouseListener{

	JFrame frame;
	JPanel west, center, tab1, tab2, tab3, tab4, tab5, p1, p2, p3, barpanel, d1,pp;
	JTabbedPane tab;
	JLabel lblRate, lblType, lblCheckin, lblCheckout, lblfood, lblQuantity, lblrate, pic, barlblDrinks, barlblQuantity,
			barlblrate, barpic, bookingpic, titlebook, lbltotalfood, lbltotalbar, lblminibar, lbllaundry, lblgym,
			lblpool;
	JTextField card,txtRate, txtuserid, barrate, jfoodrate, txttotalfood, txttotalbar, t1, t2, t3, t4, t5, z1, z2, z3, z4, z5,txtbookingid,txtbookingstatus,vat,position;
	JButton btnBook,pay, btnfoodBook, BarbtnBook, logout, servicebook, jcheckin,ref;
	JComboBox cmbType, cmbfood, barcmbDrinks, txtquantity, txtcmbquantity, cmbminibar, cmbpool, cmblaundry, cmbgym;
	JDateChooser calen1, calen2, bcheckin, bcheckout;
	DefaultTableModel jmodel,model2;
	Object[] jcolumnsName,columnsbill;
	ArrayList<booking2_library> ja1;
	ArrayList<bill1_library> a2;
	JTable jtable1,tbl2;
	JCheckBox b1, b2, b3, b4;
	JTextField bvat, bname, bbookingid, btotaldays, broomrate,bfinalrate,bfoodrate,bdrinkrate,bserviceprice,btotal,bdiscount,txtroomno;
	JComboBox paidstatus;

	
	JLabel lblbookingid,lblusername,lbldrinksrate,lblfoodrate,lblserviceprice,lblroomrate;
	JTextField bookingid,username,drinksrate,foodrate,serviceprice,roomno,roomrate, noofdays,roomfinal,total;
	JDateChooser checkin,checkout;
	DefaultTableModel model;
	Object[] columnsName;
	ArrayList<bill1_library> a1;
	JTable table1;

public features() {

	
	
	frame = new JFrame();
	frame.setExtendedState(frame.MAXIMIZED_BOTH);

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

	

	/*
	 * .......................................for food panel........................
	 */

	tab2 = new JPanel();
	tab2.setLayout(null);
	tab2.setBackground(new Color(255, 153, 51));
	tab.add("Restaurant ", tab2);

	/* ..............................for bar panel............... */
	tab3 = new JPanel();
	tab3.setLayout(null);
	tab3.setBackground(new Color(255, 153, 51));
	tab.add("Bars", tab3);



	tab5 = new JPanel();
	tab5.setLayout(null);
	tab5.setBackground(new Color(255, 153, 51));
	tab.add("Bill", tab5);
	
	
	
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	txtbookingid=new JTextField();
	txtbookingid.setText(Integer.toString(Global.obj2.getBookingid()));
	txtbookingid.setBounds(40, 450, 100, 30);
	//tab2.add(txtbookingid);
	
	txtuserid = new JTextField("");
    txtuserid.setText(Integer.toString(Global.currentUser.getUserid()));
    txtuserid.setBounds(40, 500, 100, 30);
    //tab2.add(txtuserid);
	
	
	
	lblfood = new JLabel("food :");
	lblfood.setBounds(40, 100, 100, 30);
	lblfood.setFont(new Font("classic", Font.BOLD, 20));
	lblfood.setForeground(Color.white);
	tab2.add(lblfood);

	lblQuantity = new JLabel("Quantity :");
	lblQuantity.setBounds(40, 170, 100, 30);
	lblQuantity.setFont(new Font("classic", Font.BOLD, 20));
	lblQuantity.setForeground(Color.white);
	tab2.add(lblQuantity);

	lblrate = new JLabel("Rate :");
	lblrate.setBounds(40, 230, 100, 30);
	lblrate.setFont(new Font("classic", Font.BOLD, 20));
	lblrate.setForeground(Color.white);
	tab2.add(lblrate);

	lbltotalfood = new JLabel("Total :");
	lbltotalfood.setBounds(40, 300, 100, 30);
	lbltotalfood.setFont(new Font("classic", Font.BOLD, 20));
	lbltotalfood.setForeground(Color.white);
	tab2.add(lbltotalfood);

	cmbfood = new JComboBox();
	for (int i = 0; i < Global_food.foods.length; i++) {
		cmbfood.addItem(Global_food.foods[i]);
	}
	cmbfood.setBounds(150, 100, 200, 30);
	cmbfood.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	cmbfood.setFont(new Font("classic", Font.BOLD, 16));
	cmbfood.setForeground(Color.black);
	cmbfood.addItemListener(this);
	tab2.add(cmbfood);

	Object[] h1 = { 1, 2, 3, 4, 5, 6 };
	txtquantity = new JComboBox(h1);
	txtquantity.setBounds(150, 170, 200, 30);
	txtquantity.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	txtquantity.setFont(new Font("classic", Font.BOLD, 16));
	txtquantity.setForeground(Color.black);
	tab2.add(txtquantity);
	txtquantity.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			int quantityfood = Integer.parseInt(txtquantity.getSelectedItem().toString());
			int ratefood = Integer.parseInt(jfoodrate.getText());

			int resultfood = quantityfood * ratefood;

			txttotalfood.setText(Integer.toString(resultfood));

		}
	});


	jfoodrate = new JTextField(); // its actually food rate due to some error i cant rename it
	jfoodrate.setBounds(150, 230, 200, 30);
	jfoodrate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	jfoodrate.setFont(new Font("classic", Font.BOLD, 16));
	jfoodrate.setForeground(Color.blue);
	tab2.add(jfoodrate);

	txttotalfood = new JTextField(); //
	txttotalfood.setBounds(150, 300, 200, 30);
	txttotalfood.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	txttotalfood.setFont(new Font("classic", Font.BOLD, 16));
	txttotalfood.setForeground(Color.blue);
	tab2.add(txttotalfood);

	btnfoodBook = new JButton("Add");
	btnfoodBook.setBounds(120, 380, 120, 40);
	btnfoodBook.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	btnfoodBook.setFont(new Font("serif", Font.BOLD, 20));
	btnfoodBook.setBackground(Color.white);
	btnfoodBook.setForeground(Color.black);
	btnfoodBook.addActionListener(this);
	tab2.add(btnfoodBook);

	pic = new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/food.jpg"));
	pic.setBounds(400, 0, 1300, 863);

	tab2.add(pic);
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	barlblDrinks = new JLabel("Mini Bar");
	barlblDrinks.setBounds(40, 100, 100, 30);
	barlblDrinks.setFont(new Font("classic", Font.BOLD, 20));
	barlblDrinks.setForeground(Color.white);
	tab3.add(barlblDrinks);

	barlblQuantity = new JLabel("Quantity :");
	barlblQuantity.setBounds(40, 170, 100, 30);
	barlblQuantity.setFont(new Font("classic", Font.BOLD, 20));
	barlblQuantity.setForeground(Color.white);
	tab3.add(barlblQuantity);

	barlblrate = new JLabel("Rate :");
	barlblrate.setBounds(40, 230, 100, 30);
	barlblrate.setFont(new Font("classic", Font.BOLD, 20));
	barlblrate.setForeground(Color.white);
	tab3.add(barlblrate);

	lbltotalbar = new JLabel("Total :");
	lbltotalbar.setFont(new Font("classic", Font.BOLD, 16));
	lbltotalbar.setForeground(Color.white);
	lbltotalbar.setBounds(40, 300, 200, 30);
	tab3.add(lbltotalbar);
	
	
	
	

	barcmbDrinks = new JComboBox();
	for (int i = 0; i < Global_food.drinks.length; i++) {
		barcmbDrinks.addItem(Global_food.drinks[i]);
	}
	barcmbDrinks.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	barcmbDrinks.setFont(new Font("classic", Font.BOLD, 16));
	barcmbDrinks.setBounds(150, 100, 200, 30);
	barcmbDrinks.addItemListener(this);
	tab3.add(barcmbDrinks);

	Object[] h2 = { 1, 2, 3, 4, 5, 6 };
	txtcmbquantity = new JComboBox(h2);
	txtcmbquantity.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	txtcmbquantity.setFont(new Font("classic", Font.BOLD, 16));
	txtcmbquantity.setBounds(150, 170, 200, 30);
	tab3.add(txtcmbquantity);
	txtcmbquantity.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			int quantitybar = Integer.parseInt(txtcmbquantity.getSelectedItem().toString());
			int ratebar = Integer.parseInt(barrate.getText());

			int resultbar = quantitybar * ratebar;

			txttotalbar.setText(Integer.toString(resultbar));

		}
	});

	barrate = new JTextField();
	barrate.setBounds(150, 230, 200, 30);
	barrate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	barrate.setFont(new Font("classic", Font.BOLD, 16));
	barrate.setForeground(Color.black);
	tab3.add(barrate);

	txttotalbar = new JTextField();
	txttotalbar.setBounds(150, 300, 200, 30);
	txttotalbar.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	txttotalbar.setFont(new Font("classic", Font.BOLD, 16));
	txttotalbar.setForeground(Color.black);
	tab3.add(txttotalbar);

	BarbtnBook = new JButton("Book");
	BarbtnBook.setBounds(120, 380, 120, 40);
	BarbtnBook.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	BarbtnBook.setFont(new Font("serif", Font.BOLD, 20));
	BarbtnBook.setBackground(Color.black);
	BarbtnBook.setForeground(Color.white);
	BarbtnBook.addActionListener(this);
	tab3.add(BarbtnBook);

	barpic = new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/app/src/ui/b2.jpg"));
	barpic.setBounds(400, 0, 1300, 863);
	tab3.add(barpic);

	
	
	//////////////////////////////////////////////////bills////////////////////////////////////////////////////////////////////////////////////
	
	
	pp=new JPanel();
	pp.setBounds(350,0,1200,900);
	pp.setLayout(null);
	pp.setBackground(Color.white);
	tab5.add(pp);
	
	
	JLabel lblbookingid=new JLabel("booking id");
	lblbookingid.setBounds(10,50,130,30);
	lblbookingid.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblbookingid.setForeground(Color.white);
	tab5.add(lblbookingid);
		
	
	JLabel lblusername=new JLabel("user name");
	lblusername.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblusername.setForeground(Color.white);
	lblusername.setBounds(10,100,130,30);
	tab5.add(lblusername);
	
	
	JLabel lbldrinksrate=new JLabel("drinks rate");
	lbldrinksrate.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbldrinksrate.setForeground(Color.white);
	lbldrinksrate.setBounds(10,150,130,30);
	tab5.add(lbldrinksrate);
	
	
	JLabel lblfoodrate=new JLabel("food rate");
	lblfoodrate.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblfoodrate.setForeground(Color.white);
	lblfoodrate.setBounds(10,200,130,30);
	tab5.add(lblfoodrate);
	
	JLabel  lblserviceprice=new JLabel("service price");
	lblserviceprice.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblserviceprice.setForeground(Color.white);
	lblserviceprice.setBounds(10,250,130,30);
	tab5.add(lblserviceprice);
	
	
	JLabel lblcheckin=new JLabel("Check in");
	lblcheckin.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblcheckin.setForeground(Color.white);
	lblcheckin.setBounds(10,300,130,30);
	tab5.add(lblcheckin);
	
	JLabel lblcheckout=new JLabel("Check out");
	lblcheckout.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblcheckout.setForeground(Color.white);
	lblcheckout.setBounds(10,350,130,30);
	tab5.add(lblcheckout);
	
	JLabel lblroomratel=new JLabel("room rate");
	lblroomratel.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblroomratel.setForeground(Color.white);
	lblroomratel.setBounds(10,400,130,30);
	tab5.add(lblroomratel);
	
	
	JLabel lblnoofdays=new JLabel("no of days");
	lblnoofdays.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblnoofdays.setForeground(Color.white);
	lblnoofdays.setBounds(10,450,130,30);
	tab5.add(lblnoofdays);
	
	JLabel lblroomfinal=new JLabel("room final");
	lblroomfinal.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblroomfinal.setForeground(Color.white);
	lblroomfinal.setBounds(10,500,130,30);
	tab5.add(lblroomfinal);
	
	JLabel lbltotal=new JLabel("Total");
	lbltotal.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbltotal.setForeground(Color.white);
	lbltotal.setBounds(10,550,130,30);
	tab5.add(lbltotal);
	
	JLabel lblvat=new JLabel("Vat");
	lblvat.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblvat.setForeground(Color.white);
	lblvat.setBounds(10,600,130,30);
	tab5.add(lblvat);
	
	bookingid=new JTextField();
	bookingid.setBounds(150,50,150,35);
	bookingid.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	bookingid.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(bookingid);
	
	
	
	username=new JTextField();
	username.setBounds(150,100,150,35);
	username.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	username.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(username);
	
	drinksrate=new JTextField();
	drinksrate.setBounds(150,150,150,35);
	drinksrate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	drinksrate.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(drinksrate);
	
	
	foodrate=new JTextField();
	foodrate.setBounds(150,200,150,35);
	foodrate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	foodrate.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(foodrate);
	
	serviceprice=new JTextField();
	serviceprice.setBounds(150,250,150,35);
	serviceprice.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	serviceprice.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(serviceprice);
	
	checkin = new JDateChooser();
	checkin.setDateFormatString("yyyy-MM-dd");
	checkin.setBounds(150, 300, 150, 30);
	checkin.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	checkin.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(checkin);
    
	
	checkout = new JDateChooser();
	checkout.setDateFormatString("yyyy-MM-dd");
	checkout.setBounds(150, 350, 150, 30);
	checkout.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	checkout.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(checkout);

	roomrate=new JTextField();
	roomrate.setBounds(150,400,150,35);
	roomrate.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	roomrate.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(roomrate);
	
	noofdays=new JTextField();
	noofdays.setBounds(150,450,150,35);
	noofdays.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	noofdays.setFont(new Font("classic", Font.BOLD, 16));
	
	tab5.add(noofdays);
	
	roomfinal=new JTextField();
	roomfinal.setBounds(150,500,150,35);
	roomfinal.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	roomfinal.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(roomfinal);
	
	total=new JTextField();
	total.setBounds(150,550,150,35);
	total.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	total.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(total);
	
	vat=new JTextField();
	vat.setBounds(150,600,150,35);
	vat.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	vat.setFont(new Font("classic", Font.BOLD, 16));
	tab5.add(vat);
	
	JLabel lposition=new JLabel("position");
	lposition.setBounds(850,600,150,30);
	lposition.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lposition.setForeground(Color.black);
	pp.add(lposition);
	
	position=new JTextField();
	position.setBounds(950,600,200,30);
	position.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	position.setFont(new Font("classic", Font.BOLD, 16));
	pp.add(position);
	
	JLabel lblcard=new JLabel("card no");
	lblcard.setBounds(850,650,200,30);
	lblcard.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblcard.setForeground(Color.black);
	pp.add(lblcard);
	
	card=new JTextField();
	card.setBounds(950,650,150,30);
	card.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	card.setFont(new Font("classic", Font.BOLD, 16));
	pp.add(card);
	
	pay=new JButton("Pay");
	pay.setBounds(650,700,120,30);
	pay.setFont(new Font("Tahoma", Font.PLAIN, 18));
	pay.setForeground(Color.white);
	pay.setBackground(Color.black);
	pay.addActionListener(this);
	pp.add(pay);
	
	
	logout=new JButton("logout");
	logout.setBounds(850,700,120,30);
	logout.setFont(new Font("Tahoma", Font.PLAIN, 18));
	logout.setForeground(Color.white);
	logout.setBackground(Color.black);
	logout.addActionListener(this);
	pp.add(logout);
	
	
	txtroomno=new JTextField();
	
	columnsName = new Object[10];
	columnsName[0] = "Booking id" ;
	columnsName[1] = "check in";
	columnsName[2] = "check out";
	columnsName[3] = "user name ";
	columnsName[4] = "drinks rate";
	columnsName[5] = "food Rate";
	columnsName[6] = "service price";
	columnsName[7] = "Room no";
	columnsName[8] = "Room Rate";
	columnsName[9] = "customer position";
     
	
	table1 = new JTable();
	table1.setBackground(Color.white);
	
	table1.setForeground(new Color(255, 153, 51));
	model = (DefaultTableModel) table1.getModel();
	model.setColumnIdentifiers(columnsName);
	
	updateTable();
	JScrollPane scroll1 = new JScrollPane(table1);
	scroll1.setBackground(new Color(255, 153, 51));
	scroll1.setBounds(10,10 , 1165, 320);
	table1.addMouseListener(this);
	pp.add(scroll1, BorderLayout.CENTER);

	
	ref=new JButton("Calculate");
	ref.setBounds(20,730,150,30);
	tab5.add(ref);
	ref.addActionListener(new ActionListener() {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				String fromdate = ((JTextField) checkin.getDateEditor().getUiComponent()).getText();
				String todate = ((JTextField) checkout.getDateEditor().getUiComponent()).getText();

				LocalDate fday = LocalDate.parse(fromdate);
				LocalDate tday = LocalDate.parse(todate);
				
				Long day_gap = ChronoUnit.DAYS.between(fday, tday);
				noofdays.setText(String.valueOf(day_gap));
				
			}
			
			catch(Exception ex) {
				System.out.println("Error"+ex.getMessage());
			}
			
			
			
			int a=Integer.parseInt(noofdays.getText());
			int b=Integer.parseInt(roomrate.getText());
			int c=a*b;
			
			
			roomfinal.setText(Integer.toString(c));
			
			
			int d=Integer.parseInt(foodrate.getText());
			int f=Integer.parseInt(drinksrate.getText());
			int g=Integer.parseInt(serviceprice.getText());
			int fin=c+d+f+g;
			
			total.setText(Integer.toString(fin));
			
			double v= fin + (0.13*fin);
			vat.setText(Double.toString(v));
				
	}
		
	
	
	
	
	
	
	});
	

	
	
	
	
	
	
	
	
	
	frame.setVisible(true);

}

public void updateTable() {
	a1= new JDBC_bill().bill();
	model.setRowCount(0);
	for (bill1_library b : a1) {
		Object tmpRow[] = {

				b.getBookingid(),b.getCheckin(),b.getCheckout(),b.getUsername(),b.getDrinksrate(),b.getFoodrate(),b.getServiceprice(),b.getRoomno(),b.getRate(),
				b.getPosition()
		};

		model.addRow(tmpRow);
	}
	table1 = new JTable(model);

}

public static void main(String[]args) {
	
	
	new features();
}


@Override
public void itemStateChanged(ItemEvent e) {
	if (e.getSource() == cmbfood) {
		int i = cmbfood.getSelectedIndex();
		jfoodrate.setText(Integer.toString(Global_food.food_price[i]));
	}
	
	
	if (e.getSource() == barcmbDrinks)
		;
	{
		int j = barcmbDrinks.getSelectedIndex();
		barrate.setText(Integer.toString(Global_food.drink_price[j]));

	}
	
	
	
	
}


@Override
public void actionPerformed(ActionEvent e) {
	
	
	
	if (e.getSource() == btnfoodBook) {

		food_library f = new food_library();
		f.setBookingid(Integer.parseInt(txtbookingid.getText()));
		f.setFood(cmbfood.getSelectedItem().toString());
		f.setFoodquantity(Integer.parseInt(txtquantity.getSelectedItem().toString()));
		f.setFoodrate((Integer.parseInt(txttotalfood.getText())));
		f.setFoodstatus("pending");
		JDBC_food h = new JDBC_food();
		boolean result = h.fooding(f);
		if (result == true) {

			JOptionPane.showMessageDialog(null,
					"Successfully " + f.getFood() + " booked please wait your food is on the way");
		}
	}
	
	///bar
	
	
	
	
	
	
	if (e.getSource() == BarbtnBook) {

		bar_library b = new bar_library();
		b.setBookingid(Integer.parseInt(txtbookingid.getText()));
		b.setDrinks(barcmbDrinks.getSelectedItem().toString());
		b.setDrinksquantity(Integer.parseInt(txtcmbquantity.getSelectedItem().toString()));
		b.setDrinksrate((Integer.parseInt(txttotalbar.getText())));
		b.setDrinksstatus("pending");

		JDBC_bar j = new JDBC_bar();
		boolean Result = j.bar(b);
		if (Result == true) {
			JOptionPane.showMessageDialog(null,
			"Successfully " + b.getDrinks() + " booked please wait your drink is on the way");
		}

		
		
		updateTable();
	}
	
	if (e.getSource() == pay) {
	
	bill2_library k=new bill2_library();
	k.setBookingid(Integer.parseInt(bookingid.getText()));
    k.setRoomrate(Integer.parseInt(roomfinal.getText()));
    k.setDrinksrate(Integer.parseInt(drinksrate.getText()));
	k.setFoodrate(Integer.parseInt(foodrate.getText()));
	k.setServiceprice(Integer.parseInt(serviceprice.getText()));
	k.setTotalprice(Double.parseDouble(vat.getText()));
	k.setCardno(card.getText());
	k.setBillstatus("paid");
	
	JDBC_bill b=new JDBC_bill();
	boolean result=b.insertintobill(k);
	
	
	
	
	if(result=true) {

		JOptionPane.showMessageDialog(null,
				"paid sucessfully");
	}

	
	
	
	}
	

	
	if (e.getSource() == pay) {
	
	room_library o=new room_library();
	o.setRoomstatus("available");
	o.setRoomno(Integer.parseInt(txtroomno.getText()));
	
	JDBC_addroom m= new JDBC_addroom();
	boolean result=m.updateroom(o);
	
	
	

	}

	
	if (e.getSource() == pay) {
		
	booking_library p=new booking_library();
	p.setBookingstatus("inactive");
	p.setBookingid(Integer.parseInt(bookingid.getText()));
	
	JDBC_booking m= new JDBC_booking();
	boolean result=m.checkinupdate(p);
	

	}
		
		
	if (e.getSource() == logout) {
		
		new login();
		frame.dispose();

	}	
		
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

		String role = model.getValueAt(h, 9).toString();
		position.setText(role);

		String roomno = model.getValueAt(h, 7).toString();
		txtroomno.setText(roomno);
		
		
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



}