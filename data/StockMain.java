package com.bridgelabz.oops;

import java.util.Scanner;

public class StockMain {
public static void main(String[] args)
{
		boolean value=true;
		while(value)
		{
		System.out.println("--------------------------!!!WELCOME TO STOCK MARKET!!!-------------------------------------");
		System.out.println("Choice the Operation What You want to do....!!!\n 1) Add Customer Detail \n 2) Add Company Info & Share \n"
					+ " 3) Sell Share \n 4) Buy Share \n 5) Check Value Of Share \n 6) Print Customer And Share Detail \n 7) Exit  ");
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Your Choice....!!!");
		int n=in.nextInt();
			
		switch(n) {
		case 1: System.out.println("Welcome to the Customer Detail Add System...!!!");
		System.out.println("-------------------------------ADD NEW CUSTOMER INTO THE ACCOUNT----------------------------");
				StockAccount.add();
				break;
		case 2: System.out.println("Welcome to the Company Shares Panel....!!! ");
				StockAccount.addCompany();
				break;
		case 3: System.out.println("Welcome to the Seller Panel....!!! ");
			
				System.out.println("Enter the shares");
				int shares1 = in.nextInt();
				System.out.println("Enter the Symbol");
				String symbol1 = in.next();
				BuyAndSell.sell(shares1, symbol1);
				break;
		case 4: System.out.println("Welcome to the Buyer Panel....!!! ");
				System.out.println("Enter the shares");
				int shares = in.nextInt();
				System.out.println("Enter the Symbol");
				String symbol = in.next().toUpperCase();
				BuyAndSell.buy(shares, symbol);
		        break;		
		case 5: System.out.println("Welcome to the Check Value Of Share....!!! ");
				double totalValue = StockAccount.valueOf();
				if(totalValue >= 0)
				{
					System.out.println(totalValue);
				}
				break;	
		case 6: System.out.println("Welcome to the Display The All Customer And Share Penale....!!!");
				StockAccount.printReport();
				break;
		case 7: System.out.println("................EXit.................");
		value = false;
		break;
		default:System.out.println("Please Select Right Option....! ");
		}

		}
}
}

