package com.bridgelabz.oops;

public class portfolio {

	String name;
	int shares;
	int shareprice;
	int pricepershare;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the shares
	 */
	public int getShares() {
		return shares;
	}
	/**
	 * @param shares the shares to set
	 */
	public void setShares(int shares) {
		this.shares = shares;
	}
	/**
	 * @return the shareprice
	 */
	public int getShareprice() {
		return shareprice;
	}
	/**
	 * @param shareprice the shareprice to set
	 */
	public void setShareprice(int shareprice) {
		this.shareprice = shareprice;
	}
	/**
	 * @return the pricepershare
	 */
	public int getPricepershare() {
		return pricepershare;
	}
	/**
	 * @param pricepershare the pricepershare to set
	 */
	public void setPricepershare(int pricepershare) {
		this.pricepershare = pricepershare;
	}
	@Override
	public String toString() {
		return "portfolio [name=" + name + ", shares=" + shares + ", shareprice=" + shareprice + ", pricepershare="
				+ pricepershare + "]";
	}

	
}
