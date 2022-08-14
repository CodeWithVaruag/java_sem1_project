package library;

public class bill1_library {

	int bookingid;
	String checkin,checkout,username;
	int drinksrate,foodrate,serviceprice,roomno,rate;
	String position;
	
	public bill1_library() {
	
		this.bookingid = 0;
		this.checkin = "";
		this.checkout = "";
		this.username = "";
		this.drinksrate = 0;
		this.foodrate = 0;
		this.serviceprice = 0;
		this.roomno = 0;
		this.rate = 0;
		this.position="";
	}


	public bill1_library(int bookingid, String checkin, String checkout, String username, int drinksrate, int foodrate,
			int serviceprice, int roomno, int rate,String position) {
	
		this.bookingid = bookingid;
		this.checkin = checkin;
		this.checkout = checkout;
		this.username = username;
		this.drinksrate = drinksrate;
		this.foodrate = foodrate;
		this.serviceprice = serviceprice;
		this.roomno = roomno;
		this.rate = rate;
		this.position=position;
	}


	public int getBookingid() {
		return bookingid;
	}


	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getDrinksrate() {
		return drinksrate;
	}


	public void setDrinksrate(int drinksrate) {
		this.drinksrate = drinksrate;
	}


	public int getFoodrate() {
		return foodrate;
	}


	public void setFoodrate(int foodrate) {
		this.foodrate = foodrate;
	}


	public int getServiceprice() {
		return serviceprice;
	}


	public void setServiceprice(int serviceprice) {
		this.serviceprice = serviceprice;
	}


	public int getRoomno() {
		return roomno;
	}


	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}


	public int getRate() {
		return rate;
	}


	public void setRate(int rate) {
		this.rate = rate;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return "bill1_library [bookingid=" + bookingid + ", checkin=" + checkin + ", checkout=" + checkout
				+ ", username=" + username + ", drinksrate=" + drinksrate + ", foodrate=" + foodrate + ", serviceprice="
				+ serviceprice + ", roomno=" + roomno + ", rate=" + rate + ", position=" + position + "]";
	}



	
	
	
	
	
	
}
