package com.model;

import com.entities.Profile;

public class TempStorage 
{

	private static Profile userProfiles[] = new Profile[5];
	
	
	public static void setProfiles(Profile profile)
	{
		//this.userProfiles[0] = profile;
		for(int i=0; i < userProfiles.length; i++)
		{
			if(userProfiles[i] == null)
			{
				userProfiles[i] = profile;
				break;
			}
		}
	}
	
	public Profile[] getProfiles()
	{
		return userProfiles;
	}
}
