package com.bridgelabz.oops.address;

import java.io.IOException;
import java.util.Scanner;


public class AddressBookApplication {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException 
	{
		boolean value = true;
		Scanner scanner = new Scanner(System.in);
		
			while(value)
			{
				
				System.out.println("1. Create New Address Book");
				System.out.println("2. Add Person");
				System.out.println("3. Sort AdressBook");
				System.out.println("4. Print entries");
				System.out.println("5.Quit Program");
				System.out.println("6.edit person");
				System.out.println("7.delete person");
				System.out.println("Enter the choice:");
				
				int n = scanner.nextInt();
				switch(n)
				{
					case 1:	AddressBookManager.newAddressBook();
							break;
					case 2: AddressBookManager.addPersonInAddressBook();
							break;
					case 3:	AddressBookManager.sortAddressBook();
							break;
					case 4: AddressBookManager.printAddressBook();
							break;
					case 5: System.out.println("\nApplication stopped!\n"); 
							value = false;
							break;
					case 6:System.out.println("edit person:");
							AddressBookManager.editexiting();
							break;
					case 7:AddressBookManager.deletePersonInAddressBook();
						break;
					default: System.out.println("invalid choice... try again");
							
				}	
			}
		
		
		}
}
