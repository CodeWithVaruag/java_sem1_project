  package library;
import ui.login;

public class login_library {
  
   String username;
   String password;
    
   
   public login_library() {
	
	this.username = "";
	this.password = "";
   }


    public login_library(String username, String password) {
	
	this.username = username;
	this.password = password;
}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "login_liabrary [username=" + username + ", password=" + password + "]";
	}

}
