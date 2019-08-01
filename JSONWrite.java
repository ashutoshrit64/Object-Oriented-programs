
/******************************************************************************
 *  Compilation:  javac -d bin PrimeChecker.java
 *  Execution:    java -cp bin com.bridgelabz.util.PrimeChecker n
 *  
 *  Purpose: Read data from JSONFile and display it.
 *
 *  @author  Ashutosh
 *  @version 1.0
 *  @since   031/07/2019
 *
 ******************************************************************************/

/*
 * JAVA STYLE GUIDE - PACKAGE NAMING STYLE
 */
package com.bridgelabz.oops;
/*
 * importing header files
 */
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JSONWrite {
	/*
	 * class declaration
	 */
	public static void main(String[] args) {
/*
 * initializing the variable
 */
		int ch;
		/*
		 * putting condition to be checked in the intervals
		 */
		do {
		System.out.println("Inventory\nEnter the number to check for specific inventory");
		System.out.println("1.Rice\n2.Pulses\n3.Wheat\n4.checkout");
		System.out.println("Enter the choice:");
		/*
		 * created scanner object
		 */
		Scanner sc = new Scanner(System.in);
		ch = sc.nextInt();
		/*
		 * putting the condition in the switch case to get desired output
		 */
		switch (ch) {
		case 1:
		calculate("Rice");//putting the given in the function according to the input
		break;
		case 2:
		calculate("Pulses");
		break;
		case 3:
		calculate("Wheat");
		break;
		case 4:
			break;
		}
		sc.close();
		} while (ch < 3);
/*
 * condition closed
 */
		}
/*
 * intializing the function
 */
		private static void calculate(String string) 
		{
		ObjectMapper mapper = new ObjectMapper();
		//creating object of object mapper
		File file = new File("/home/user/json files]\\/inventory.json");
		//getting path to the json file
		LinkedList<Rice> list = new LinkedList<>();
//creating linked list and giving path of class
		try {
			
		list = mapper.readValue(file, new TypeReference<LinkedList<Rice>>() {
		});
		/*
		 * object created byobject mapper will read each values from files and input string
		 */

		System.out.println("Name\tWeight\tprice\tTotal");
//declaring iot in condition
		for (int i = 0; i < list.size(); i++) {
		if (list.get(i).getName().equals(string)) {
		System.out.println(list.get(i).getName() + "    " + list.get(i).getWeight() + "    " + list.get(i).getPrice()
		+ "    " + list.get(i).getWeight() * list.get(i).getPrice() + "    ");
//calculation of it and displaying it
		}}}
		catch (IOException e) {
//exception
		}}}
