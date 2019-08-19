package com.bridgelabz.oops.cliniquemanagement;
import java.io.File;
import java.io.IOException;
import java.util.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
public class CliniqueUtlity implements IClinique {
	@SuppressWarnings("unused")
	private static final String mobNum = null;
	public static ObjectMapper objectMapper = new ObjectMapper();
	static Scanner scannnerString = new Scanner(System.in);
	static Scanner scannerInteger = new Scanner(System.in);

	public static void addDocter(List<Doctor> docterList) {
		System.out.println("Enter Docter Name");
		String docterName = scannnerString.nextLine();
		System.out.println("Enter Id of Docter ");
		int id = scannerInteger.nextInt();
		System.out.println("Enter the Specialization");
		String speclization = scannnerString.nextLine().toUpperCase();
		System.err.println("Enter Availability");
		String availability = scannnerString.nextLine().toUpperCase();
		Doctor newDoctor = new Doctor(docterName, id, speclization, availability);
		docterList.add(newDoctor);

		try {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(doctorFile), docterList);

			System.out.println("\nNew Doctor Added!\n");
			System.out.printf("%-15s %-10s  %-15s %15s\n", "Doctor_Name", "Doctor_Id", "Specialization",
					"Availability");
			System.out.println("-------------------------------***********************----------------------");
			System.out.println(newDoctor.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addPatient(List<Patient> patientList) {
		System.out.println("Enter the patientName");
		String patientName = scannnerString.nextLine();
		System.out.println("Enter id of patient");
		int id = scannerInteger.nextInt();
		System.out.println("Enter The PhoneNumber");
		String phoneNumber = scannnerString.nextLine();
		System.out.println("Enter age");
		int age = scannerInteger.nextInt();
		Patient newPatient = new Patient(patientName, id, phoneNumber, age);
		patientList.add(newPatient);
		try {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(PatientFiles), patientList);
			System.out.printf("%-15s %-10s  %-15s %15s\n", "Patient_Name", "Patient_Id", "PhoneNumber", "Age");
			System.out.println("-------------------------------***********************----------------------");
			System.out.println(newPatient.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void searchDoctor(List<Doctor> doctorList) {

		Search searchStart = new Search();

		System.out.println("Enter the choice");
		System.out.println("\t1. By Name");
		System.out.println("\t2. By ID");
		System.out.println("\t3. By Specialization");
		System.out.println("\t4. By Availability");
		int n = scannerInteger.nextInt();

		switch (n) {
		case 1:
			System.out.println("Enter the Doctor's Name:");
			String doctorname = scannnerString.nextLine().toUpperCase();
			searchStart.searchDocByName(doctorname, doctorList);
			break;
		case 2:
			System.out.println("Enter the Docter's Id:");
			int doctorID = scannerInteger.nextInt();
			searchStart.searchDocById(doctorID, doctorList);
			break;
		case 3:
			System.out.println("Enter the Docter's Specilization");
			String doctorspecilazation = scannnerString.nextLine().toUpperCase();
			searchStart.searchDocBySPL(doctorspecilazation, doctorList);
			break;
		case 4:
			System.out.println("Enter the Docter's Availability");
			String docterAvailability = scannnerString.nextLine().toUpperCase();
			searchStart.searchDocByAvl(docterAvailability, doctorList);
			break;
		default:
			System.out.println("Invalid Option");
			break;

		}
	}

	public static void searchPatient(List<Patient> patientList) {
		Search searchStart = new Search();
		System.out.println("Enter the Choice");
		System.out.println("\t1. By Name");
		System.out.println("\t2. By ID");
		System.out.println("\t3. By Mobile Number");
		System.out.println("\t4. By Age");
		int key = scannerInteger.nextInt();
		switch (key) {
		case 1:
			System.out.println("Enter Patient's Name");
			String patientName = scannnerString.next().toUpperCase();
			searchStart.searchPatientByName(patientName, patientList);
			break;
		case 2:
			System.out.println("Enter Patient's Id");
			int id = scannerInteger.nextInt();
			searchStart.searchPatientById(id, patientList);
			break;
		case 3:
			System.out.println("Enter Patient's PhoneNumber");
			String phoneNumber = scannnerString.next();
			searchStart.searchPatientByPhoenNumber(phoneNumber, patientList);
			break;
		case 4:
			System.out.println("Enter Patient's Age");
			int age = scannerInteger.nextInt();
			searchStart.searchPatientByAge(age, patientList);
			break;
		default:
			System.out.println("Invalid choicice");
			break;
		}

	}

	public static void fixAppointment(List<Doctor> doctorList, List<Patient> patientList) // List<Appointment>
																							// appointmentList
	{
		String appointmentFile = "/home/mobicomp/oop/JSON/Apointment.json";
		try {
			List<Appointment> appointmentList = objectMapper.readValue(new File(appointmentFile),
					new TypeReference<List<Appointment>>() {});

			Search searchStart = new Search();
			System.out.println("Enter the Doctor's name:");
			String doctorName = scannnerString.nextLine().toUpperCase();
			if (searchStart.searchDocByName(doctorName, doctorList) == true) {
				System.out.println("Enter the patient's name:");
				String patientName = scannnerString.nextLine().toUpperCase();
				if (searchStart.searchPatientByName(patientName, patientList) == true) {
					System.out.println("Enter the date(DD/MM/YYYY): ");
					String date = scannnerString.nextLine();
					int index = searchStart.getAppointedDocIndex(doctorName, appointmentList);
					int docCount;

					// System.out.println(index);
					if (index == -1) {
						docCount = 1;
					} else {
						docCount = appointmentList.get(index).getDocAppointmentCount();
						docCount = docCount + 1;
					}
					if (docCount <= 5) {
						Appointment newAppointment = new Appointment(doctorName, patientName, date, docCount);
						appointmentList.add(newAppointment);
						objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(appointmentFile),
								appointmentList);

						System.out.println("\nAppointment Added!\n");
						System.out.printf("%-20s %-20s %-10s\n", "Doctor Name", "Patient Name", "Date of Appointment");
						System.out.println("--------------------------------------------------------------------");
						System.out.println(newAppointment.toString());
					} else {
						System.out.println("Sorry.. Doctor's not available right now!");
					}

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void printAppointments(List<Appointment> appointmentList) {
		System.out.println("****************List of Appointments*******************");
		System.out.printf("%-20s %-20s %-10s\n", "Doctor Name", "Patient Name", "Date of Appointment");
		System.out.println("==================================================================================");
		for (int i = 0; i < appointmentList.size(); i++) {
			System.out.println(appointmentList.get(i));
		}
	}
}
