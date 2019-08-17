package com.bridgelabz.oops;

public class CompanyDetail {
String name;
int share;
int shareprice;
String Symbol;
/**
 * @return the symbol
 */
public String getSymbol() {
	return Symbol;
}
/**
 * @param symbol the symbol to set
 */
public void setSymbol(String symbol) {
	Symbol = symbol;
}
public CompanyDetail(String companyName, String companySymbol, int numberOfShare, int sharePrice2) {
	// TODO Auto-generated constructor stub
	super();
	this.name = companyName;
	this.Symbol = companySymbol;
	this.share = numberOfShare;
	this.shareprice = sharePrice2;
	
}
public CompanyDetail() {
	// TODO Auto-generated constructor stub
}
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
 * @return the share
 */
public int getShare() {
	return share;
}
/**
 * @param share the share to set
 */
public void setShare(int share) {
	this.share = share;
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
@Override
public String toString() {
	return "CompanyDetail [name=" + name + ", share=" + share + ", shareprice=" + shareprice + ", Symbol=" + Symbol
			+ "]";
}




}
