package library;

public class bar_library {

	int barorderid,bookingid;
	String drinks;
	int drinksquantity,drinksrate;
	String drinksstatus;
	
	public bar_library() {
		
		this.barorderid = 0;
		this.bookingid = 0;
		this.drinks = "";
		this.drinksquantity = 0;
		this.drinksrate =0;
		this.drinksstatus="";
	}
	
	
	public bar_library(int barorderid, int bookingid, String drinks, int drinksquantity, int drinksrate,
			String drinksstatus) {
	
		this.barorderid = barorderid;
		this.bookingid = bookingid;
		this.drinks = drinks;
		this.drinksquantity = drinksquantity;
		this.drinksrate = drinksrate;
		this.drinksstatus = drinksstatus;
	}


	public int getBarorderid() {
		return barorderid;
	}


	public void setBarorderid(int barorderid) {
		this.barorderid = barorderid;
	}


	public int getBookingid() {
		return bookingid;
	}


	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}


	public String getDrinks() {
		return drinks;
	}


	public void setDrinks(String drinks) {
		this.drinks = drinks;
	}


	public int getDrinksquantity() {
		return drinksquantity;
	}


	public void setDrinksquantity(int drinksquantity) {
		this.drinksquantity = drinksquantity;
	}


	public int getDrinksrate() {
		return drinksrate;
	}


	public void setDrinksrate(int drinksrate) {
		this.drinksrate = drinksrate;
	}


	public String getDrinksstatus() {
		return drinksstatus;
	}


	public void setDrinksstatus(String drinksstatus) {
		this.drinksstatus = drinksstatus;
	}


	@Override
	public String toString() {
		return "bar_library [barorderid=" + barorderid + ", bookingid=" + bookingid + ", drinks=" + drinks
				+ ", drinksquantity=" + drinksquantity + ", drinksrate=" + drinksrate + ", drinksstatus=" + drinksstatus
				+ "]";
	}


	
	
}
