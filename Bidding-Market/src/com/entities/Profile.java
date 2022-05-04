package com.entities;

public class Profile 
{
	private String name;
	private String email;
	private String username;
	private String password;
	private double balance;
	
	public Profile() {}
	
	public Profile(String name, String email, String username, String password, double balance)
	{
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	//Getter and Setter
	public void setName(String name)
	{
		this.name = name;
	}
	
	//Accessmodifier   returntype functionname
	public String getName()
	{
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void changeBalance(double amount) {
		this.balance += amount;
	}
	
}
