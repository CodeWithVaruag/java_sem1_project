package library;

public class food_library {

	int orderid,bookingid;
	String food;
	int foodquantity,foodrate;
    String foodstatus;
	
	public food_library() {
		
		this.orderid = 0;
		this.bookingid = 0;
		this.food ="";
		this.foodquantity = 0;
		this.foodrate = 0;
		this.foodstatus="";
		
	}


	public food_library(int orderid, int bookingid, String food, int foodquantity, int foodrate,String foodstatus) {
	
		this.orderid = orderid;
		this.bookingid = bookingid;
		this.food = food;
		this.foodquantity = foodquantity;
		this.foodrate = foodrate;
		this.foodstatus=foodstatus;
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
		return "food_library [orderid=" + orderid + ", bookingid=" + bookingid + ", food=" + food + ", foodquantity="
				+ foodquantity + ", foodrate=" + foodrate + ", foodstatus=" + foodstatus + "]";
	}




	
	
}
