package model;

import controller.AppointmentController;
import controller.PrescriptionController;
import controller.UserController;

public class InsertModel {
	public static void Insert(UserController user) {
		String request = "INSERT INTO btsProject_User VALUES (null, '"+user.firstName+"', '"+user.lastName+"' , '"+user.age+"', '"+user.mail+"', '"+user.address+"', '"+user.password+"', '"+user.role+"');";
		SQLRequestModel.executeSQL(request);
	}
	public static void Insert(AppointmentController appointment) {
		String request = "INSERT INTO btsProject_Appointment VALUES (null, '"+ appointment.dateAppointment+"', '"+appointment.timeAppointment+"' , '"+appointment.reason+"', '"+appointment.patient.idUser+"', '"+appointment.doctor.idUser+"');";
		SQLRequestModel.executeSQL(request);
	}
	public static void Insert(PrescriptionController prescritpion) {
		String request = "INSERT INTO btsProject_Prescription VALUES (null, '"+ prescritpion.datePrescription+"', '"+prescritpion.content+"' , '"+prescritpion.patient.idUser+"', '"+prescritpion.doctor.idUser+"');";
		SQLRequestModel.executeSQL(request);
	}
}
