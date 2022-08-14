
package library;

public class room_library {

	String roomtype,roomstatus;
    int roomno,rate;
	
    
    
    public room_library() {
		
		
		
		
		this.roomtype ="";
		this.roomno = 0;
		this.rate = 0;
		this.roomstatus="";
		
		
	}

    
	public room_library( int roomno,String roomtype,  int rate, String roomstatus) {
		
		this.roomtype = roomtype;
        this.roomno = roomno;
		this.rate = rate;
		this.roomstatus=roomstatus;
	}

	

	public String getRoomstatus() {
		return roomstatus;
	}






	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}




	public String getRoomtype() {
		return roomtype;
	}






	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
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


	@Override
	public String toString() {
		return "room_library [roomtype=" + roomtype + ", roomstatus=" + roomstatus + ", roomno=" + roomno + ", rate="
				+ rate + "]";
	}



	
	
	
}
