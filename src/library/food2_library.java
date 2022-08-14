package library;

public class food2_library {
     
	String username;
	int orderid,bookingid;
	String food;
	int foodquantity,foodrate;
	String foodstatus;
	
	public food2_library() {
	
		this.username ="";
		this.orderid =0;
		this.bookingid = 0;
		this.food = "";
		this.foodquantity =0;
		this.foodrate =0;
		this.foodstatus="";
	}


	public food2_library(String username, int orderid, int bookingid, String food, int foodquantity, int foodrate, String foodstatus) {
	
		this.username = username;
		this.orderid = orderid;
		this.bookingid = bookingid;
		this.food = food;
		this.foodquantity = foodquantity;
		this.foodrate = foodrate;
		this.foodstatus=foodstatus;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getOrderid() {
		return orderid;
	}


	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}


	public int getBookingid() {
		return bookingid;
	}


	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}


	public String getFood() {
		return food;
	}


	public void setFood(String food) {
		this.food = food;
	}


	public int getFoodquantity() {
		return foodquantity;
	}


	public void setFoodquantity(int foodquantity) {
		this.foodquantity = foodquantity;
	}


	public int getFoodrate() {
		return foodrate;
	}


	public void setFoodrate(int foodrate) {
		this.foodrate = foodrate;
	}


	public String getFoodstatus() {
		return foodstatus;
	}


	public void setFoodstatus(String foodstatus) {
		this.foodstatus = foodstatus;
	}


	@Override
	public String toString() {
		return "food2_library [username=" + username + ", orderid=" + orderid + ", bookingid=" + bookingid + ", food="
				+ food + ", foodquantity=" + foodquantity + ", foodrate=" + foodrate + ", foodstatus=" + foodstatus
				+ "]";
	}



	
	
	
	
	
}
