package com.controller;

import com.entities.Profile;
import com.model.TempStorage;

public class LoginController 
{

	
	public Profile login(String userName, String password)
	{
		TempStorage db = new TempStorage();
		Profile userProfiles[] = db.getProfiles();
		Profile profile = null;
		
		for(int i=0; i < userProfiles.length; i++)
		{
			if(userProfiles[i] != null && userProfiles[i].getUsername().equals(userName) && userProfiles[i].getPassword().equals(password))
			{
				profile = userProfiles[i];
				break;
			}
		}
		
		return profile;

	}
	
	public Profile register(String name, String  email, String username, String password, String cfPassword, double balance)
	{
		if(password.equals(cfPassword))
		{
			TempStorage db = new TempStorage();
			//db.setProfiles(new Profile(name, age, mobile, address, email, username, password));
			
			Profile profile = new Profile(name, email, username, password, balance);
			TempStorage.setProfiles(profile);
						
			Profile userProfiles[] = db.getProfiles();
			for(int i=0; i < 5; i++) 
			{
				
				if(userProfiles[i] == null)
				{
					System.out.println("----------");
				} else 
				{
					System.out.println(userProfiles[i].getName());
				}
				
				
			}
			return profile;
		}
		else
			return null;
		
	}
}