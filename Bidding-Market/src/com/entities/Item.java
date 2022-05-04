package com.entities;

public abstract class Item {
	private int itemID;
	private String name;
	private double weight;
	private double buyNowPrice;
	private double currentBid;
	private Profile seller;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBuyNowPrice() {
		return buyNowPrice;
	}
	public void setBuyNowPrice(double buyNowPrice) {
		this.buyNowPrice = buyNowPrice;
	}
	public double getCurrentBid() {
		return currentBid;
	}
	public void setCurrentBid(double currentBid) {
		this.currentBid = currentBid;
	}
	public Profile getSeller() {
		return seller;
	}
	public void setSeller(Profile seller) {
		this.seller = seller;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
}
