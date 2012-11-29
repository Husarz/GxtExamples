package app.gxt.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class User implements IsSerializable {

	String id;
	String firstName;
	String email;
	String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(String firstName, String email, String password) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
	
}
