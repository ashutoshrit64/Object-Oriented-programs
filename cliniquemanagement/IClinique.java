package com.bridgelabz.oops.cliniquemanagement;

public interface IClinique {
	 String name="";
	 int id=0;
	 String specialization="";
	 String avl="";
	 String mobNumber="";
	 int age=0;
	String doctorFile = "/home/user/address/jsonfiles/CliniqueManagement/doctor.json";
	String PatientFiles = "/home/user/address/jsonfiles/CliniqueManagement/patient.json";
	String appointmentFile = "/home/user/address/jsonfiles/CliniqueManagement/appointment.json";
	public static void addDocter(List<Doctor> docterList);

}
