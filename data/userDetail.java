package com.bridgelabz.oops;

public class userDetail {
String username;
long id;
int number;
int company1;
int company2;
int company3;
int company4;

/**
 * @return the company1
 */
public int getCompany1() {
	return company1;
}
/**
 * @param company1 the company1 to set
 */
public void setCompany1(int company1) {
	this.company1 = company1;
}
/**
 * @return the company2
 */
public int getCompany2() {
	return company2;
}
/**
 * @param company2 the company2 to set
 */
public void setCompany2(int company2) {
	this.company2 = company2;
}
/**
 * @return the company3
 */
public int getCompany3() {
	return company3;
}
/**
 * @param company3 the company3 to set
 */
public void setCompany3(int company3) {
	this.company3 = company3;
}
/**
 * @return the company4
 */
public int getCompany4() {
	return company4;
}
/**
 * @param company4 the company4 to set
 */
public void setCompany4(int company4) {
	this.company4 = company4;
}



/**
 * @return the username
 */
public String getUsername() {
	return username;
}
/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}





//public userDetail(int id2, int no) 
//{
//	// TODO Auto-generated constructor stub
//	super();
//	this.id = id2;
//	this.number = no;
//	
//	
//}


public userDetail(String name, int id2, int no, int company12, int company22, int company32, int company42) {
	// TODO Auto-generated constructor stub

	this.username = name;
	this.id = id2;
	this.number = no;
	this.company1 = company12;
	this.company2 = company22;
	this.company3 = company32;
	this.company4 = company42;
}

public userDetail() {
	// TODO Auto-generated constructor stub
}
/**
 * @return the id
 */
public long getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(long id) {
	this.id = id;
}
/**
 * @return the number
 */
public int getNumber() {
	return number;
}
/**
 * @param number the number to set
 */
public void setNumber(int number) {
	this.number = number;
}
@Override
public String toString() {
	return "userDetail [username=" + username + ", id=" + id + ", number=" + number + "]";
}

}
