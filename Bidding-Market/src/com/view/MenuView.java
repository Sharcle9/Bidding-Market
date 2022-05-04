package com.view;

import java.util.Scanner;

import com.controller.LoginController;
import com.entities.Diamond;
import com.entities.Item;
import com.entities.Profile;
import com.entities.Ruby;

public class MenuView 
{
	//Profile userProfile = null;
	LoginController loginController = new LoginController();
	Scanner scanner = new Scanner(System.in);
	Profile currentProfile = null;
	Item[] items = {};
	Item currentItem = null;
	
	public void showMenu()
	{
		clearProfile();
		setItems();
		System.out.println("********* Menu Page ***********");
		System.out.println("Enter 1 to Login, 2 to Register, 3 to Exit");
		
		int option = scanner.nextInt();

		
		if(option == 1)
		{
			loginView();
		}
		else if(option == 2)
		{
			registerView();						
			showMenu();
		} 
		else if(option == 3)
		{
			System.out.println("See you later!");
			return;
		}
		else
		{
			System.out.println("Invalid option is choosen, Please try again...");
			showMenu();
		}
		
	
	}
	
	public void loginView()
	{
		System.out.println("--------- Login Page --------");
		System.out.println("Enter the Username : ");
		String username = scanner.next();
		
		System.out.println("Enter the Password : ");
		String password = scanner.next();
		this.currentProfile = loginController.login(username, password);
		
		if(this.currentProfile == null)
		{
			System.out.println("Login Failed..");
			showMenu();
		}
		else
		{
			System.out.println("Welcome " + this.currentProfile.getName() + "!");
			marketView();
		}
	}
	
	public void registerView()
	{
		System.out.println("------------ Register Page ----------");
		System.out.println("Enter the Name : ");
		
		String name = scanner.next();
		System.out.println("Enter the Email : ");
		String email = scanner.next();
		
		System.out.println("Enter the Username : ");
		String username = scanner.next();
		
		System.out.println("Enter the Password : ");
		String password = scanner.next();
		
		System.out.println("Confirm the Password : ");
		String cfPassword = scanner.next();
		
		Profile profile = loginController.register(name, email, username, password, cfPassword, 0);
		if(profile == null)
			System.out.println("Register failed..");
		else
			System.out.println("Registered successfully!");
	}
	
	public void marketView()
	{
		clearItem();
		System.out.println("********* Market Page ***********");
		System.out.println("Enter 1 to see items on the market, 2 to show details of an item, 3 to check balance, 4 to deposit, 5 to Exit");
		
		int option = scanner.nextInt();

		
		if(option == 1)
		{
			printItems();
			marketView();
		}
		else if(option == 2)
		{
			System.out.println("Please enter the ID of the item you want to view, or enter -1 to go back..");
			
			int id = scanner.nextInt();
			
			for(int i = 0; i < items.length; i++) 
			{
				if(items[i].getItemID() == id)
				{
					currentItem = items[i];
					break;
				}
			}
			
			if(currentItem == null)
			{
				System.out.println("Item with item ID " + id + " cannot be found in the market :(");
				marketView();
				return;
			}
			else
			{
				System.out.println("********* Item Page ***********");
				System.out.printf("%5s%15s%15s%15s%15s%15s", "ID", "Item", "Weight", "Highest Bid", "Buy Now Price", "Seller");
				
				System.out.println();
				System.out.printf("%5s%15s%15s%15s%15s%15s", currentItem.getItemID(), currentItem.getName(), currentItem.getWeight(), currentItem.getCurrentBid(), currentItem.getBuyNowPrice(), currentItem.getSeller().getName());
				
				System.out.println();
				itemView();
			}
		}
		else if(option == 3)
		{
			System.out.println("You currently have a balance of $" + currentProfile.getBalance() + "..");
			marketView();
		}
		else if(option == 4)
		{
			deposit();
			marketView();
		}
		else if(option == 5)
		{
			showMenu();
		}
		else
		{
			System.out.println("Invalid option is choosen, Please try again...");
			marketView();
		}
	}
	
	public void setItems() 
	{
		Profile emily = new Profile("Emily", "emily2@gmail.com", "emily2", "123", 2500);
		Profile john = new Profile("John", "john2@gmail.com", "john2", "123", 1800);
		Profile katie = new Profile("Katie", "katie2@gmail.com", "katie2", "123", 3100);
		Diamond d1 = new Diamond(1, 0.3, 200, 46, emily);
		Diamond d2 = new Diamond(2, 0.4, 230, 55, katie);
		Ruby r1 = new Ruby(4, 2.3, 99, 20, john);
		Diamond d3 = new Diamond(3, 0.28, 190, 35, katie);
		Ruby r2 = new Ruby(5, 3.1, 150, 43, emily);
		
		this.items = new Item[] {d1, d2, d3, r1, r2};
	}
	
	public void printItems()
	{
		System.out.printf("%5s%15s%15s%15s%15s%15s", "ID", "Item", "Weight", "Highest Bid", "Buy Now Price", "Seller");
		System.out.println();
		for(int i = 0; i < items.length; i++)
		{
			Item item = items[i];
			if(item != null)
			{
				System.out.printf("%5s%15s%15s%15s%15s%15s", item.getItemID(), item.getName(), item.getWeight(), item.getCurrentBid(), item.getBuyNowPrice(), item.getSeller().getName());
				System.out.println();
			}
		}
	}
	
	public void itemView()
	{
		System.out.println("Enter 1 to place bid, 2 to buy now, 3 to go back..");
		
		int option = scanner.nextInt();
		
		if(option == 1)
		{
			boolean result = bid();
			if(result) marketView();
			else itemView();
		}
		else if(option == 2)
		{
			boolean result = buy();
			if(result) marketView();
			else itemView();
		}
		else if(option == 3)
		{
			marketView();
		}
		else
		{
			System.out.println("Invalid option is choosen, Please try again...");
			itemView();
		}
	}
	
	public boolean bid() 
	{	
		System.out.println("Please enter the amount you want to place, the current highest bid is $" + currentItem.getCurrentBid() + "..");
		int bid = scanner.nextInt();
		
		if(currentItem.getCurrentBid() >= bid)
		{
			System.out.println("You must place an amount larger than " + currentItem.getCurrentBid() + "!");
			return false;
		}
		else if(currentProfile.getBalance() < bid)
		{
			System.out.println("You dont have enough balance! You currently have $" + currentProfile.getBalance() + " in your account..");
			return false;
		}
		else
		{
			currentProfile.changeBalance(-bid);
			System.out.println("You successfully placed a bid of $" + bid + " on " + currentItem.getName() + "! You now have a balance of $" + currentProfile.getBalance() + ".");
			return true;
		}
	}
	
	public boolean buy() 
	{	
		double price = currentItem.getBuyNowPrice();
		if(currentProfile.getBalance() < price)
		{
			System.out.println("You dont have enough balance! You currently have $" + currentProfile.getBalance() + " in your account..");
			return false;
		}
		else
		{
			currentProfile.changeBalance(-price);
			currentItem.getSeller().changeBalance(price);
			System.out.println("You successfully bought " + currentItem.getName() + "! You now have a balance of $" + currentProfile.getBalance() + ".");
			return true;
		}
	}
	
	public void deposit()
	{
		System.out.println("Please enter the amount of money you'd like to deposit:");
		double amount = scanner.nextDouble();
		if(amount <= 0)
		{
			System.out.println("Invalid amount! Please re-enter the amount:");
			deposit();
		}
		else
		{
			currentProfile.changeBalance(amount);
			System.out.println("Success! You now have a balance of $" + currentProfile.getBalance() + ".");
		}
	}
	
	public void clearItem()
	{
		this.currentItem = null;
	}
	
	public void clearProfile()
	{
		this.currentProfile = null;
	}
	
}