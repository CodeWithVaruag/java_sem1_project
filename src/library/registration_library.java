package library;

public class registration_library {

	String username,address,email,password,repassword,gender,position,contact;
    int age, userid ;

    public registration_library() {
	
		this.username = "";
		this.address = "";
		this.email = "";
		this.password = "";
		this.repassword = "";
		this.gender = "";
		this.position = "";
		this.age = 0;
		this.contact = "";
		this.userid=0;
	}

	public registration_library(String username, String address, String email, String password, String repassword,
			String gender, String position, int age, String contact,int userid) {
		
		this.username = username;
		this.address = address;
		this.email = email;
		this.password = password;
		this.repassword = repassword;
		this.gender = gender;
		this.position = position;
		this.age = age;
		this.contact = contact;
		this.userid=userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
		
		
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "registration_library [username=" + username + ", address=" + address + ", email=" + email
				+ ", password=" + password + ", repassword=" + repassword + ", gender=" + gender + ", position="
				+ position + ", age=" + age + ", contact=" + contact + "]";
	}
    
    
    
    
    
}
	
 
