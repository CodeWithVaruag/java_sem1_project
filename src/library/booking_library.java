package library;

public class booking_library {

	

	int bookingid,
	userid,roomno;
	
	String bookingtype,checkin,checkout,bookingstatus,type;

	public booking_library() {
		

		this.bookingid = 0;
		this.bookingtype = "";
		this.checkin = "";
		this.checkout = "";
		this.userid = 0;
		this.roomno = 0;
		this.bookingstatus = "";
		
		
	}

	public booking_library(int bookingid,String bookingtype,String checkin,String checkout,int userid,int roomno,String bookingstatus ) {
	
		this.bookingid = bookingid;
		this.bookingtype = bookingtype;
		this.checkin = checkin;
		this.checkout = checkout;
		this.userid = userid;
		this.roomno = roomno;
		this.bookingstatus = bookingstatus;
		
		
		
		
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public String getBookingtype() {
		return bookingtype;
	}

	public void setBookingtype(String bookingtype) {
		this.bookingtype = bookingtype;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
