/******************************************************************************
 *  Compilation:  javac -d bin PrimeChecker.java
 *  Execution:    java -cp bin com.bridgelabz.util.PrimeChecker n
 *  
 *  Purpose: Reading JSON file and printing stock report.
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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class stockData  {
/*
 * declaration of main class
 */
	
		public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("/home/user/json files/stock2.json");
		//file path
		@SuppressWarnings({ "unused", "resource" })
		Scanner scan = new Scanner(System.in);
		//scanner object
		ObjectMapper mapper = new ObjectMapper();            //initializing object to  object mapper
		LinkedList<portfolio> stocks = new LinkedList<>(); 
		LinkedList<portfolio> newStocks = new LinkedList<>(); //storing json object into list
				portfolio port=new portfolio();
				
		try {
			stocks = mapper.readValue(reader, new TypeReference<LinkedList<portfolio>>() {});
			//reading each line in the file
		  
			int total=0;
		System.out.println("S T O C K   R E P O R T   O F   A L L   C O M P A N I E S");
		System.out.println("Company\t\tShares\tprice\tprice/share");
		System.out.println("-----------------------------------------");
		//Display in the output
		
	
		int a=0;
		
		
		for(int i=0;i<stocks.size();i++) 
		{
			a=0;
			 a=stocks.get(i).getShares();
//			System.out.println(i);
//			System.out.println(a);
			 int price=stocks.get(i).getShareprice()/a;
				total=total+stocks.get(i).getShares();
				System.out.println(stocks.get(i).getName()+" \t"+stocks.get(i).getShares()+"  "
				+ " \t"+stocks.get(i).getShareprice() +"\t"+price+" \t  ");
			 stocks.get(i).setPricepershare(price);
			 stocks.get(i).setName(stocks.get(i).getName());
			 stocks.get(i).setShareprice(stocks.get(i).getShareprice());
			 stocks.get(i).setShares(stocks.get(i).getShares());
		}
		
				System.out.println("total shares of all the companies are:  "+total);
				FileWriter write= new FileWriter("/home/user/json files/a.json");
			//	write.write(stocks.toString());
				//write.flush();
				mapper.writeValue(write,stocks);
		}	
		catch (JsonGenerationException e) 
		{
		// TODO Auto-generated catch block
		e.printStackTrace();

		} 
		catch (JsonMappingException e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
		catch (IOException e) 
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		}

		}