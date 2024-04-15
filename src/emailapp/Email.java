package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;  //encapsulation, we will access them through class API
	private String lastName;
	private String faculty;
	private String password;
	private String email;
	private int mailboxCapacity = 1000;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String university = "upb.ro";
	
	
	//constructor to get first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		//call a method that is asking for the faculty - return the faculty
		this.faculty = setFaculty();
		
		
		//call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);

		//combine all elements
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + faculty + "." + university;
	}
	
	
	//ask for faculty
	private String setFaculty() {
		System.out.print("New student: " + firstName + "\nFaculty codes:\n1 for ETTI\n2 for ACS\n3 for FIIR\n0 for None\nEnter faculty code: ");
		Scanner in = new Scanner(System.in);
		int facultyChoise =  in.nextInt(); //here will put 0/1/2/3
		if(facultyChoise == 1){
			return "etti";
		}
		else if(facultyChoise == 2) {
			return "acs";
		}
		else if(facultyChoise == 3) {
			return "fiir";
		}
		else return "";  //else return nothing
	}
	
	//generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		} 
		return new String(password);
	}
	
	//set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateEmail(){
		return alternateEmail;
		}
	

	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "Display name: " + firstName +  " " + lastName + "\n Email: " + email + "\n Mailbox capacity: " + mailboxCapacity + "GB";
	}
}
