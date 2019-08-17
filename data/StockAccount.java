/******************************************************************************
 * 
 *  
 *  Purpose: Commercial data processing
 *
 *  @author  Bridgelabz.ashu
 *  @version 1.0
 *  @since   02-08-2019
 *
 ******************************************************************************/

/*
 * JAVA STYLE GUIDE - PACKAGE NAMING STYLE
 */
package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;



public class StockAccount  {
	static Scanner scan=new Scanner(System.in);
	static ObjectMapper mapper = new ObjectMapper();
	static File customerDetail=new File("/home/user/json files/userDetail.json");
	static File customerShare=new File ("/home/user/json files/company.json");
	
	
	public static int add() {
		try {
			System.out.printf("\n", "Name ", " id  ", "number");
			/******
			 * HERE WE ARE READING OUR FILE IF IT IS HAVING ANY DATA INSIDE THEN WE ARE GOING TO PUT IT ON LIST COLLECTION ARRAY
			 */
			List<userDetail> customerList = mapper.readValue(customerDetail,new TypeReference<List<userDetail>>() {});
			/**
			 * HERE WE ARE TESTING(PRINTING) IS DATA ARE STORE OR NOT INSIDE THE LIST ARRAY
			 */
			
			for(Object obj:customerList) {
				System.out.println(obj);
			}
			System.out.println("======================================================================");
			
			System.out.println("Enter Customer id");
			int customerId = scan.nextInt();
			/**
			 * HERE WE ARE CREATING STOCK ACCOUNT CLASS OBJ FOR ACCESSING INSIDE METHOD OF CLASS STOCK A\C
			 */
			
			/*****
			 * IF SEARCH CUSTOMER INDEX CONDITION IS TRUE THEN WE ARE ADDING NEW CUSTOMER IN FILE 
			 */
			int indexNumber=searchCustomerIndex(customerId, customerList);
			if (indexNumber== -1) {
				/**
				 * HERE WE ARE PASSING THE CUSTOMER NAME & ALL Share Detail
				 * LIKE newCustomer.setCustomerName("");
				 */
				System.out.println("Enter name:");
				String name=scan.nextLine();
				System.out.println("Enter The id");
				int id=scan.nextInt();
				System.out.println("Enter contact number");
				int no=scan.nextInt();
				System.out.println("Enter The company1 Share");
				int company1=scan.nextInt();
				System.out.println("Enter The company2 Share");
				int company2=scan.nextInt();
				System.out.println("Enter The company3 Share");
				int company3=scan.nextInt();
				System.out.println("Enter The company4 Share");
				int company4=scan.nextInt();
				/****************************************************************************************************************
				 * HERE WE ARE ADDING DATA 
				 * we are created one constructor for assign the value for every ,method becoz list having customer class parameter
				 */
				userDetail newCustomer = new userDetail(name,id,no,company1,company2,company3,company4);
				
				
				customerList.add(newCustomer);
				
				
				System.out.println("\nNew Customer added : " + customerId + "\n");
				/***
				 * HERE WE ARE SAVING DATA
				 */
				StockAccount.save("/home/mobicomp/oop/JSON/userDetail.json", customerList);
				System.out.printf("\n%-15s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Cust. Name", "id", "no" ,"company1","company2","company3","company4");
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println(customerList.get(searchCustomerIndex(customerId, customerList)).toString());
			} 
			else {
				System.out.println("\nCustomer Already Exist!");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}    
		return 0;
	}

	static int searchCustomerIndex(double customerId, List<userDetail> customerList) {

		{
			int count = 0;
			int index = -1;
			for(int i = 0; i < customerList.size(); i++)
			{
				count = 0;
				//HERE WE ARE FETCHING ALL INDEX OF LIST 
				double custName =  customerList.get(i).getId(); 
				if(customerId==custName)
				{
					index = i;
					break;
				}
				else
				{
					count++;
				}
			}
			if(count != 0)
			{
				//System.err.println("Customer not found!");
			}
			//RETURNING THE POSITION  OF INDEX 
			return index;
		}
	}

	static int searchCustomerIndex(String searchName, List<userDetail> customerList)
	{
		
		
		{
			int count = 0;
			int index = -1;
			for(int i = 0; i < customerList.size(); i++)
			{
				count = 0;
				//HERE WE ARE FETCHING ALL INDEX OF LIST 
				String custName = customerList.get(i).getUsername();
				if(searchName.equals(custName))
				{
					index = i;
					break;
				}
				else
				{
					count++;
				}
			}
			if(count != 0)
			{
				//System.err.println("Customer not found!");
			}
			//RETURNING THE POSITION  OF INDEX 
			return index;
		}
	}
	public static double valueOf() {
		try {

			//customerList USE FOR READIING DATA FROM FILE AND STORING IN TO THE LIST
			List<userDetail> customerList = mapper.readValue(customerDetail, new TypeReference<List<userDetail>>() {});
			//companySharesList USE FOR READIING DATA FROM FILE AND STORING IN TO THE LIST
			List<CompanyDetail> companySharesList = mapper.readValue(customerShare,new TypeReference<List<CompanyDetail>>() {});
		
			boolean flag=true;
			while(flag) {
						System.out.println("Select The Menu Option.....!!!");
						System.out.println("1)Company\n2)Customer\n3)Exit");
	
						System.out.println("Enter Choice....!!!");
							int select=scan.nextInt();
							switch (select) {
							/**************************************************************************************************
							 * THIS IS FOR STOCK MARKET
							 */
							case 1:System.out.println("Welcome to the Stock Market...!!!");		
							System.out.println("Enter Company Symbol :");
							String searchSymbol = scan.next().toUpperCase();
							int index = StockAccount.searchSharesBySymbol(searchSymbol, companySharesList);
							if (index != -1) {
								CompanyDetail companyShare = new CompanyDetail();
								//here we are providing value to the customer setter and getter method to get share count
								companyShare= companySharesList.get(index);
								int totalShare=0;
								int noOfShare=companyShare.getShare();
								totalShare = +noOfShare;
								
								System.out.print("Company\t \t Number Of Shares \t Price  \t\t\t\t\t Date \n"+companyShare.toString());
								System.out.println("Totalshare : "+totalShare);
								System.out.print("\nTotal Value of Stock: ");
								return (double) totalShare*56;
							} else {
								System.out.println("you have entered wrong company symbol,please check the symbol again.....");
								System.out.println();
								System.out.println("One more chance to see the stocks");
								break;
							}
							/**************************************************************************************************
							 * THIS FOR CUSTOMER SHARE INFORMATION
							 */
							case 2:System.out.println("Welcome To the Customer Panel ");
							
							System.out.println("Enter Customer/Person Id :");
							int searchName = scan.nextInt();
							int index1 = StockAccount.searchCustomerIndex(searchName, customerList);
							if (index1 != -1) {
								
								userDetail customer = new userDetail();
								//here we are providing value to the customer setter and getter method to get share count
								customer = customerList.get(index1);
								/****
								 * @param we are taking all share into the variable for count
								 */
								int company1 = customer.getCompany1();
								int company2 = customer.getCompany2();
								int company3 =  customer.getCompany3();
								int company4 =  customer.getCompany4();
								int totalShare = company1+ company2 + company3+company4;
							
								//System.out.print("Customer\t Share 1 \t  Share 2 \t\t Share 3\n"+customer.toString());
								System.out.println("Totalshare : "+totalShare);
								System.out.print("\nTotal Value of Stock: ");

						
								
								System.out.print(customer.toString());
							
								return (double) totalShare;

							
							} else {
								System.out.print("\nPERSON NOT FOUND ");
								break;
							}
							
							case 3:System.out.println("................EXit.................");
							flag = false;		
							default:
								break;
							}
		
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public static int addCompany() {
		try {
			System.out.printf("\n%-15s %-20s %-20s %-25s %-20s\n", "Company Name", "\tStock Symbol", "Number of Shares","Price","DateTime");
			/******
			 * HERE WE ARE READING OUR FILE IF IT IS HAVING ANY DATA INSIDE THEN WE ARE GOING TO PUT IT ON LIST COLLECTION ARRAY
			 */
			List<CompanyDetail> companyList = mapper.readValue(new File("/home/user/json files/company.json"),new TypeReference<List<CompanyDetail>>() {});
			/**
			 * HERE WE ARE TESTING(PRINTING) IS DATA ARE STORE OR NOT INSIDE THE LIST ARRAY
			 */
			
			for(Object obj:companyList) {
				System.out.println(obj);
			}
			System.out.println("===============================================================================================");
			
			System.out.println("Enter Stock Symbol ");
			String companySymbol = scan.nextLine().toUpperCase();
			/**
			 * HERE WE ARE CREATING STOCK ACCOUNT CLASS OBJ FOR ACCESSING INSIDE METHOD OF CLASS STOCK A\C
			 */
		
			/*****
			 * IF SEARCH COMPANY INDEX CONDITION IS TRUE THEN WE ARE ADDING NEW COMPANY IN FILE 
			 */
			int indexNumber=searchSharesBySymbol(companySymbol, companyList);
			if (indexNumber== -1) {
				/**
				 * HERE WE ARE PASSING THE COMPANY NAME & ALL Share Detail
				 */
				System.out.println("Enter The Company Name");
				String companyName=scan.nextLine();
				System.out.println("Enter Number Of Share");
				int numberOfShare=scan.nextInt();
				System.out.println("Enter Share Price");
				int sharePrice=scan.nextInt();
				
				/***
				 * HERE WE ARE ADDING DATA 
				 * we are created one constructor for assign the value for every ,method becoz list having CompanyShares class parameter
				 */
				CompanyDetail companyShare=new CompanyDetail(companyName,companySymbol,numberOfShare,sharePrice);
				companyList.add(companyShare);
				System.out.println("\nNew Company added : " + companyName + "\n");
				/***
				 * HERE WE ARE SAVING DATA
				 */
				
				StockAccount.saveCompany("/home/user/json files/company.json", companyList);
				
				System.out.printf("\n%-15s %-20s %-20s %-25s %-20s\n", "Company Name", "\tStock Symbol", "Number of Shares","Price","Auto Date");
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println(companyList.get(searchSharesBySymbol(companySymbol, companyList)).toString());
			} 
			else {
				System.out.println("\nCompany Already Exist!");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return 0;
	}


	private static void saveCompany(String string, List<CompanyDetail> companyList) {
		// TODO Auto-generated method stub
		try {
			/***
			 * writerWithDefaultPrettyPrinter() 
			 */
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(string), companyList);
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}
	public static void save(String string, List<userDetail> customerList) 
	{
		try {
			/***
			 * writerWithDefaultPrettyPrinter() 
			 * USING THIS MATHOD WE CAN ABLE TO WRITE FILE LIKE FOLLOWING FORMAT
			 * [ {
  					"name" : "SHIVA",
  					"shivaShares" : 57,
  					"jokerShares" : 68,
  					"ravanaShares" : 30
				}, {
  					"name" : "RAVANA",
  					"shivaShares" : 70,
  					"jokerShares" : 41,
  					"ravanaShares" : 28
			}]
			 */
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(string), customerList);
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}
	
	
	

	static int searchSharesBySymbol(String searchSymbol, List<CompanyDetail> companySharesList) {
		// TODO Auto-generated method stub
		int count = 0;
		int index = -1;
		for(int i = 0; i < companySharesList.size(); i++)
		{
			count = 0;
			String companySymbol = companySharesList.get(i).getSymbol();
			if(searchSymbol.compareTo(companySymbol) == 0)
			{
				index = i;
				break;
			}
			else
			{
				count++;
			}
		}
		if(count != 0)
		{
			//System.out.println("Customer not found!");
		}
		
		return index;
	}
	     
		
		
	public static void printReport() {
		try {

			List<userDetail> customerList = mapper.readValue(customerDetail, new TypeReference<List<userDetail>>() {});
			List<CompanyDetail> companyList = mapper.readValue(customerShare, new TypeReference<List<CompanyDetail>>() {});
			System.out.println("\n-----------------------------------------Stock Details-----------------------------------------");
			System.out.printf("\n%-15s %-20s %-20s %-25s %-20s\n", "Company Name", "\tStock Symbol", "Number of Shares","Price","DateTime");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			for(Object obj:companyList) {
				System.out.println(obj);
			}
			System.out.println("===============================================================================================");
			


			System.out.println("\n---------------------------------------Customer Details--------------------------------------");
			System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", " id ", "number","company1","company2","company3","company4");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			
			for(Object obj:customerList) {
				System.out.println(obj);
			}
			System.out.println("================================================================================================");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

		}

		