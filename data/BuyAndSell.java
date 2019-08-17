package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class BuyAndSell {
	static Scanner in=new Scanner(System.in);
	static ObjectMapper objectmapper=new ObjectMapper();
	static File customerfile=new File("/home/user/json files/userDetail.json");
	static File companySharefile=new File ("/home/user/json files/company.json");
	public static LinkedList<Object>linkedlist=new LinkedList<Object>();
	public static StackList<Object>stackList=new StackList<Object>();
	public static QueueList<Object> queue=new QueueList<Object> (0);
	
	public static void list() {

		try {
			List<CompanyDetail> companySharesList = objectmapper.readValue(companySharefile,new TypeReference<List<CompanyDetail>>() {});
			@SuppressWarnings("unused")
			List<userDetail> customerList = objectmapper.readValue(customerfile, new TypeReference<List<userDetail>>() {});

			String str = "";
			
			for (int i = 0; i < companySharesList.size(); i++) 
			{
				str = companySharesList.get(i).toString();
				
				linkedlist.add(str);

			}

		} catch (IOException e) {
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}

	}
	public static void buy(int amount, String symbol) {
		try {
			List<CompanyDetail> companySharesList = objectmapper.readValue(companySharefile,new TypeReference<List<CompanyDetail>>() {});
			List<userDetail> customerList = objectmapper.readValue(customerfile, new TypeReference<List<userDetail>>() {});
			System.out.println("Enter The Person  id");
			int search =  in.nextInt();
			int custIndex = StockAccount.searchCustomerIndex(search, customerList);
			int stockIndex = StockAccount.searchSharesBySymbol(symbol, companySharesList);
			String stackSymbol = null;
			CompanyDetail companyShares = null;
			if (custIndex != -1)
			{
				companyShares = companySharesList.get(stockIndex);
				int noOfShares = companyShares.getShare();
				companyShares.setShare(noOfShares - amount);
				stackSymbol = companyShares.getSymbol();
				// ls.add(companyShares);

				// System.out.println(stockIndex);
				userDetail customer = customerList.get(custIndex);
				if (stockIndex == 0) {
					int value = customer.getCompany1();
					customer.setCompany1(value + amount);
				}else if (stockIndex == 1) {
					int value = customer.getCompany2();
					customer.setCompany2(value + amount);
				}else if (stockIndex == 2) {
					int value = customer.getCompany3();
					customer.setCompany3(value + amount);
				}else if (stockIndex == 3) {
					int value = customer.getCompany4();
					customer.setCompany4(value + amount);
				} else {
					System.err.println("Stock Not Found ");
				}
			}
			
			objectmapper.writerWithDefaultPrettyPrinter().writeValue(companySharefile, companySharesList);
			objectmapper.writerWithDefaultPrettyPrinter().writeValue(customerfile, customerList);

			System.out.println("\n----------Stock Details----------");
			System.out.printf("%-15s %-20s %-20s\n", "Company_Name", "NO._of Stocks", "Price");
			System.out.println(companySharesList.get(stockIndex).toString());
			System.out.printf("\n%-15s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Cust. Name", "Id  ", "number","company1","company2","company3","company4");
			System.out.println("-------------------------------------------------------------------");
			System.out.println(customerList.get(custIndex).toString());
			System.out.println("Q 6) Here We are Adding CompanyShares Into LinkList");
			System.out.println("==================In LIST==================");
			linkedlist.add(companyShares);
			System.out.println("Company Shares in LIST:");
		     BuyAndSell.list();
		     linkedlist.print();
		     System.out.println("---------------------------------------------");
		     System.out.println("Q 7) Here We are Adding StockSymbol Into Stack");
		     stackList.push(stackSymbol);
			System.out.println("Company Symbol in STACK LIST:");
			stackList.print();
			System.out.println("-----------------------------------------------------------------");
			 System.out.println("Q 8) Here We are Adding Date ");
			Date currentDate = new Date();
			System.out.println(currentDate);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		/**************************************************************************
		 * 
		 * 
		 * 
		 */
	public static void sell(int amount1,String symbol1) 
	{
		try {
				//companySharesList USE FOR READIING DATA FROM FILE AND STORING IN TO THE LIST
			List<CompanyDetail> companySharesList = objectmapper.readValue(companySharefile,new TypeReference<List<CompanyDetail>>() {});
			// customerList USE FOR READIING DATA FROM FILE AND STORING IN TO THE LIST
			List<userDetail> customerList = objectmapper.readValue(customerfile, new TypeReference<List<userDetail>>() {});
			int stockIndex = StockAccount.searchSharesBySymbol(symbol1, companySharesList);
			System.out.println("Enter The Person  id");
			int searchin =  in.nextInt();
			int custIndex = StockAccount.searchCustomerIndex(searchin, customerList);
			String stackSymbol = "";
			CompanyDetail companyShares = null;
			if (custIndex != -1) {
				companyShares = companySharesList.get(stockIndex);
				int noOfShares = companyShares.getShare();
				companyShares.setShare(noOfShares + amount1);

				System.out.println("");
				stackSymbol = companyShares.getSymbol();
				// ls.add(companyShares);

				// System.out.println(stockIndex);
				userDetail customer = customerList.get(custIndex);
				
				if (stockIndex == 0) {
					int value = customer.getCompany1();
					customer.setCompany1(value - amount1);
				}
				if (stockIndex == 1) {
					int value = customer.getCompany2();
					customer.setCompany2(value - amount1);
				}
				if (stockIndex == 2) {
					int value = customer.getCompany3();
					customer.setCompany3(value - amount1);
				}
				if (stockIndex == 3) {
					int value = customer.getCompany4();
					customer.setCompany4(value - amount1);
				}
			} else {
				System.err.println("stock not found!");
			}

			objectmapper.writerWithDefaultPrettyPrinter().writeValue(companySharefile, companySharesList);
			objectmapper.writerWithDefaultPrettyPrinter().writeValue(customerfile, customerList);
			
			System.out.println("\n----------Stock Details----------");
			System.out.printf("%-15s %-20s %-20s\n", "Company Name", "NO. of Stocks", "Price");
			System.out.println("---------------------------------------------------------------------");
			System.out.println(companySharesList.get(stockIndex).toString());

			System.out.println(customerList.get(custIndex).toString());
			System.out.println("Q 6) Here We are Adding CompanyShares Into LinkList");
			System.out.println("==================In LIST==================");
			linkedlist.add(companyShares);
		     BuyAndSell.list();
		     linkedlist.print();
		     System.out.println("---------------------------------------------");
		     System.out.println("Q 7) Here We are Adding StockSymbol Into Stack");
		     stackList.push(stackSymbol);
			System.out.println("Company Symbol in STACK LIST:");
			stackList.print();
			System.out.println("-----------------------------------------------------------------");
			 System.out.println("Q 8) Here We are Adding Date ");
			
			Date currentDate = new Date();
			System.out.println(currentDate);
					
		} catch (IOException e) {
			e.printStackTrace();
		}

	

}
}
	

