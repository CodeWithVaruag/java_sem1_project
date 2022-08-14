package library;

public class bill2_library {
    double totalprice;
	int billingid,bookingid,roomrate,drinksrate,foodrate,serviceprice;
	String cardno,billstatus;
	public bill2_library() {
		
		this.billingid = 0;
		this.bookingid = 0;
		this.roomrate = 0;
		this.drinksrate = 0;
		this.foodrate = 0;
		this.serviceprice = 0;
		this.totalprice = 0;
		this.cardno = "";
		this.billstatus="";
	}
	public bill2_library(int billingid, int bookingid, int roomrate, int drinksrate, int foodrate, int serviceprice,
			double totalprice, String cardno,String billstatus) {
		
		this.billingid = billingid;
		this.bookingid = bookingid;
		this.roomrate = roomrate;
		this.drinksrate = drinksrate;
		this.foodrate = foodrate;
		this.serviceprice = serviceprice;
		this.totalprice = totalprice;
		this.cardno = cardno;
		this.billstatus=billstatus;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public int getBillingid() {
		return billingid;
	}
	public void setBillingid(int billingid) {
		this.billingid = billingid;
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getRoomrate() {
		return roomrate;
	}
	public void setRoomrate(int roomrate) {
		this.roomrate = roomrate;
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
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getBillstatus() {
		return billstatus;
	}
	public void setBillstatus(String billstatus) {
		this.billstatus = billstatus;
	}
	@Override
	public String toString() {
		return "bill2_library [totalprice=" + totalprice + ", billingid=" + billingid + ", bookingid=" + bookingid
				+ ", roomrate=" + roomrate + ", drinksrate=" + drinksrate + ", foodrate=" + foodrate + ", serviceprice="
				+ serviceprice + ", cardno=" + cardno + ", billstatus=" + billstatus + "]";
	}
	
	
	
}
