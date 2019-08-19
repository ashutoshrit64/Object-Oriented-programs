package com.bridgelabz.oops.address;

	import java.io.File;
import java.io.IOException;
import java.util.Collection;
	import java.util.Iterator;
	import java.util.List;
	import java.util.ListIterator;
	import java.util.Scanner;
	import java.util.stream.Collectors;

	import org.codehaus.jackson.JsonParseException;
	import org.codehaus.jackson.map.JsonMappingException;
	import org.codehaus.jackson.map.ObjectMapper;
	import org.codehaus.jackson.type.TypeReference;

	public class AddressBookManager 
	{
		


		
			
			static Scanner scannerString = new Scanner(System.in);
			static ObjectMapper objectmapper=new ObjectMapper();
			
			/**
			 * @throws IOException *******************************************************************************************
			 * 
			 */
			public static void newAddressBook() throws IOException {
				AddressBookManager.listoffiles();
				String fileSeparator = System.getProperty("file.separator");
		        
		        //absolute file name with path  /home/user/address/jsonfiles
				String string;
				System.out.println("ENTER THE FILE NAME WITH EXTENTION");
				string = scannerString.next();
		        String absoluteFilePath = fileSeparator+"home"+fileSeparator+"user"+fileSeparator+"address"
		        							+fileSeparator+"jsonfiles"+fileSeparator+string;
		        File file = new File(absoluteFilePath);
		        Person person = new Person();
		        if(file.createNewFile())
			{
		            System.out.println(absoluteFilePath+" File Created");
		            
		        }else System.out.println("File "+absoluteFilePath+" already exists");
		        
		      //  List<Person> personList = objectmapper.readValue(person,new TypeReference<List<Person>>() {});
		        AddressBookManager.initialiseAdressBook(absoluteFilePath, person);
			}

			private static void listoffiles()
			{
				// TODO Auto-generated method stub
				String path="/home/user/address/jsonfiles";
				File file=new File(path);
				File[] files = file.listFiles(); 
				System.out.println("REFERENCE OF CREATED ADDRESS BOOK:");
				for(File f: files)
				{
					
					System.out.println(f.getName());
				
				}
				
				
			}

			public static void addPersonInAddressBook() throws JsonParseException, JsonMappingException, IOException {
				AddressBookManager.listoffiles();
				String fileSeparator = System.getProperty("file.separator");
		        
		        //absolute file name with path   /home/user/address/jsonfiles
				String string;
				System.out.println("ENTER THE FILE NAME WITH EXTENTION");
				string = scannerString.next();
		        String absoluteFilePath = fileSeparator+"home"+fileSeparator+"user"+fileSeparator+"address"
		        							+fileSeparator+"jsonfiles"+fileSeparator+string;
		        File file = new File(absoluteFilePath);
		   
		        if(file.createNewFile())
		        {
		            System.out.println(absoluteFilePath+"New  File Created");
		           
		        }
		        else {
		        	System.out.println("File "+absoluteFilePath+" already exists");
		        }
		       
		        	List<Person> personList = objectmapper.readValue(new File(absoluteFilePath),new TypeReference<List<Person>>() {});
				
					System.out.println("Enter the first name:");
					String firstName = scannerString.next().toUpperCase();
					int indexNumber=searchPersonIndex(firstName, personList);
					if (indexNumber== -1) {
					System.out.println("Enter the last name:");
					String lastName = scannerString.next().toUpperCase();
					System.out.println("enter the address:");
					String address = scannerString.next().toUpperCase();
					System.out.println("enter the city:");
					String city = scannerString.next().toUpperCase();
					System.out.println("Enter the state:");
					String state = scannerString.next().toUpperCase();
					System.out.println("Enter the zip");
					String zip = scannerString.next();
					System.out.println("Enter the Phone");
					String phone = scannerString.next();
			
					Person personnewEntry = new Person(firstName, lastName, address, city, state, zip, phone);
					personList.add(personnewEntry);
					System.out.println("\nNew Person added : " + firstName + "\n");
					/***
					 * HERE WE ARE SAVING DATA
					 */
					AddressBookManager.saveToAdressBook(absoluteFilePath, personList);
				}
					else System.out.println(firstName+" Is Alredy Present In AdressBook");
			}

			public static void saveToAdressBook(String fileName, List<Person> personList) {
				try {
					
					/***
					 * writerWithDefaultPrettyPrinter() 
					 */
					objectmapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), personList);
				} catch (IOException e) {
					// e.printStackTrace();
				}
			}
		
			public static void initialiseAdressBook(String fileName, Person person)
			{
				try {
					/***
					 * writerWithDefaultPrettyPrinter() 
					 */
					List<Person> personList =new List<Person>() {
						
						@Override
						public <T> T[] toArray(T[] arg0) {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public Object[] toArray() {
							// TODO Auto-generated method stub
							return null;
						}
						
					@Override
						public List<Person> subList(int arg0, int arg1) {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public int size() {
							// TODO Auto-generated method stub
							return 0;
						}
					
						@Override
						public Person set(int arg0, Person arg1) {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public boolean retainAll(Collection<?> arg0) {
							// TODO Auto-generated method stub
							return false;
						}
						
						@Override
						public boolean removeAll(Collection<?> arg0) {
							// TODO Auto-generated method stub
							return false;
						}
					
						@Override
						public Person remove(int arg0) {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public boolean remove(Object arg0) {
							// TODO Auto-generated method stub
							return false;
						}
						
						@Override
						public ListIterator<Person> listIterator(int arg0) {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public ListIterator<Person> listIterator() {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public int lastIndexOf(Object arg0) {
							// TODO Auto-generated method stub
							return 0;
						}
						
						@Override
						public Iterator<Person> iterator() {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public boolean isEmpty() {
							// TODO Auto-generated method stub
							return false;
						}
						
						@Override
						public int indexOf(Object arg0) {
							// TODO Auto-generated method stub
							return 0;
						}
						
						@Override
						public Person get(int arg0) {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public boolean containsAll(Collection<?> arg0) {
							// TODO Auto-generated method stub
							return false;
						}
						
						@Override
						public boolean contains(Object arg0) {
							// TODO Auto-generated method stub
							return false;
						}
					
						@Override
						public void clear() {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public boolean addAll(int arg0, Collection<? extends Person> arg1) {
							// TODO Auto-generated method stub
							return false;
						}
						
						@Override
						public boolean addAll(Collection<? extends Person> arg0) {
							// TODO Auto-generated method stub
							return false;
						}
						
						@Override
						public void add(int arg0, Person arg1) {
							// TODO Auto-generated method stub
							
						}
						
					@Override
						public boolean add(Person arg0) {
							// TODO Auto-generated method stub
							return false;
						}
					};
					personList.add(person);
					objectmapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), personList);
				} catch (IOException e) {
					// e.printStackTrace();
				}
		}
			
			public static int searchPersonIndex(String searchName, List<Person> personList)
			{
				int count = 0;
				int index = -1;
				for(int i = 0; i < personList.size(); i++)
				{
					count = 0;
					//HERE WE ARE FETCHING ALL INDEX OF LIST 
					String personName = personList.get(i).getFirstName();
					if(searchName.equals(personName))
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
			 
			@SuppressWarnings({ "unused", "rawtypes" })
			public static void sortAddressBook() throws JsonParseException, JsonMappingException, IOException {
				AddressBookManager.listoffiles();
				String fileSeparator = System.getProperty("file.separator");
		        
		        //absolute file name with path  ////////////home/user/address/jsonfiles
				String string;
				System.out.println("ENTER THE FILE NAME WITH EXTENTION");
				string = scannerString.next();
		        String absoluteFilePath = fileSeparator+"home"+fileSeparator+"user"+fileSeparator+"address"
		        							+fileSeparator+"jsonfiles"+fileSeparator+string;
		        File file = new File(absoluteFilePath);
		        if(file.createNewFile()){
		            System.out.println(absoluteFilePath+" File Created");
		            
		            //AddressBookManager.savePerson(absoluteFilePath, personList);
		            
		        }
		        else {
		        	System.out.println("File "+absoluteFilePath+" already exists");
		        }
		        	List<Person> personList = objectmapper.readValue(new File(absoluteFilePath),new TypeReference<List<Person>>() {});
		        List result = personList.stream().sorted((p1, p2)->p1.getFirstName().compareTo(p2.getFirstName())).collect(Collectors.toList());
		        	System.out.println("\nADRESS BOOK is sorded\n");
		        	System.out.println(result);
					AddressBookManager.saveToAdressBook(absoluteFilePath, result);  //HERE WE ARE SAVING DATA
			}

			public static void printAddressBook()
			{
				AddressBookManager.listoffiles();
				try {
					//home/user/address/jsonfiles
					String fileSeparator = System.getProperty("file.separator");
			        
			        //absolute file name with path  
					String string;
					System.out.println("ENTER THE FILE NAME WITH EXTENTION");
					string = scannerString.next();
			        String absoluteFilePath = fileSeparator+"home"+fileSeparator+"user"+fileSeparator+"address"
			        							+fileSeparator+"jsonfiles"+fileSeparator+string;
			        File file = new File(absoluteFilePath);
			        if(file.createNewFile()){
			            System.out.println(absoluteFilePath+" File Created");
			            
			            //AddressBookManager.savePerson(absoluteFilePath, personList);
			            
			        }
			        else {
			        	System.out.println("File "+absoluteFilePath+" already exists");
			        }

			        List<Person> personList = objectmapper.readValue(new File(absoluteFilePath),new TypeReference<List<Person>>() {});
					System.out.println("\n-----------------------------------------Person Details-----------------------------------------");
					System.out.printf("\n%-15s %-20s %-20s %-25s %-20s\n", "First Name", "\tLast Name", "Vilege","City","State","Zip");
					System.out.println("-----------------------------------------------------------------------------------------------------------");
					for(Object obj:personList) {
						System.out.println(obj);
					}
					System.out.println("===============================================================================================");
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public static List<Person> editexiting() throws JsonParseException, JsonMappingException, IOException {
				AddressBookManager.listoffiles();
				String fileSeparator = System.getProperty("file.separator");
		        
		        //absolute file name with path   /home/user/address/jsonfiles
				String string;
				System.out.println("ENTER THE FILE NAME WITH EXTENTION");
				string = scannerString.next();
		        String absoluteFilePath = fileSeparator+"home"+fileSeparator+"user"+fileSeparator+"address"
		        							+fileSeparator+"jsonfiles"+fileSeparator+string;
		        File file = new File(absoluteFilePath);
		   
		        if(file.createNewFile())
		        {
		            System.out.println(absoluteFilePath+"New  File Created");
		           
		        }
		        else {
		        	System.out.println("File "+absoluteFilePath+" already exists");
		        }
		       
		        	List<Person> list = objectmapper.readValue(new File(absoluteFilePath),new TypeReference<List<Person>>() {});
				Person p1=new Person();
				for(int i=0;i<list.size();i++)
				{
					System.out.println(list.get(i));
				}
				System.out.println("Enter the first name:");
				String firstName = scannerString.next().toUpperCase();
				for(int i=0;i<list.size();i++) {
					
					if(list.get(i).getFirstName().equals(firstName))
					{
						
						System.out.println(" ENTER NEW FIRST NAME ");
						String firsName=scannerString.next();
						list.get(i).setFirstName(firsName);
						p1.setFirstName(firsName);
						System.out.println(" ENTER NEW LAST NAME");
						String lastName=scannerString.next();
						p1.setLastName(lastName);
						list.get(i).setLastName(lastName);
						AddressBookManager.saveToAdressBook(absoluteFilePath, list);
					break;
					}
					
			}

				return list;
			}	
			public static List<Person> deletePersonInAddressBook() throws JsonParseException, JsonMappingException, IOException
			{
				AddressBookManager.listoffiles();
			String fileSeparator = System.getProperty("file.separator");
	        
	        //absolute file name with path   /home/user/address/jsonfiles
			String string;
			System.out.println("ENTER THE FILE NAME WITH EXTENTION");
			string = scannerString.next();
	        String path = fileSeparator+"home"+fileSeparator+"user"+fileSeparator+"address"
	        							+fileSeparator+"jsonfiles"+fileSeparator+string;
	        File file = new File(path);
				List<Person> list = objectmapper.readValue(new File(path),new TypeReference<List<Person>>() {});
				Person p1=new Person();
				System.out.println("WHICH PERSON'S DETAILS YOU WANT TO DELETE?");

				for (int i = 0; i < list.size(); i++) 
				{
					System.out.println(list.get(i));
				}
				System.out.println("ENTER FIRST NAME - ");
				String name = scannerString.next();
				for (int i = 0; i < list.size(); i++) 
				{
					System.out.println(list.get(i).getFirstName());
				}
				for (int i = 0; i < list.size(); i++) 
				{
					
					if(list.get(i).getFirstName().equals(name))
					{
						list.remove(i);
						AddressBookManager.saveToAdressBook(path, list);
					}
				}
				return list;
			}
			
}
