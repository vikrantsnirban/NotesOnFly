package net.versatile.notesonflyservice.bo;

public class User {
	String userName;
	String firstName;
	String lastName;
	String emailAddress;
	String address;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	 @Override
	public String toString() {
		 return "UserName: " + userName + "\t"
			+ "FirstName: " + firstName + "\t"
			+ "LastName: " + lastName + "\t"
			+ "Email Address: " + emailAddress + "\t"
			+ "Address: " + address ;
	}
}
