package com.entities;

public class Diamond extends Item{
	public Diamond(int itemID, double weight, double buyNowPrice, double currentBid, Profile seller) 
	{
		this.setItemID(itemID);
		this.setName("Diamond");
		this.setWeight(weight);
		this.setBuyNowPrice(buyNowPrice);
		this.setCurrentBid(currentBid);
		this.setSeller(seller);
	}
}
