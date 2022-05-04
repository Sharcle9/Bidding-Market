package com.entities;

public class Ruby extends Item{
	public Ruby(int itemID, double weight, double buyNowPrice, double currentBid, Profile seller) 
	{
		this.setItemID(itemID);
		this.setName("Ruby");
		this.setWeight(weight);
		this.setBuyNowPrice(buyNowPrice);
		this.setCurrentBid(currentBid);
		this.setSeller(seller);
	}
}
