package library;

public class service_library {

	String username;
	int serviceid, bookingid, serviceprice;
    String services,servicestatus;
	
	public service_library() {
		super();
		this.username = "";
		this.serviceid = 0;
		this.bookingid = 0;
		this.serviceprice = 0;
		this.services="";
		this.servicestatus="";
	}

	public service_library(String username, int serviceid, int bookingid, int serviceprice, String services, String servicestatus) {

		this.username = username;
		this.serviceid = serviceid;
		this.bookingid = bookingid;
		this.serviceprice = serviceprice;
		this.services=services;
		this.servicestatus=servicestatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getServiceprice() {
		return serviceprice;
	}

	public void setServiceprice(int serviceprice) {
		this.serviceprice = serviceprice;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getServicestatus() {
		return servicestatus;
	}

	public void setServicestatus(String servicestatus) {
		this.servicestatus = servicestatus;
	}

	@Override
	public String toString() {
		return "service_library [username=" + username + ", serviceid=" + serviceid + ", bookingid=" + bookingid
				+ ", serviceprice=" + serviceprice + ", services=" + services + ", servicestatus=" + servicestatus
				+ "]";
	}


	

	
	
}
