package model;

import controller.AppointmentController;
import controller.PrescriptionController;
import controller.UserController;

public class UpdateModel {
	public static void Update(UserController user) {
		String request = "UPDATE btsProject_User SET firstName = '"+user.firstName+"', lastName = '"+user.lastName+"' , age = '"+user.age+"', mail = '"+user.mail+"', address = '"+user.address+"', role = '"+user.role+"' WHERE idUser = '"+user.idUser+"';";
		SQLRequestModel.executeSQL(request);
	}
	public static void Update(AppointmentController appointment) {
		String request = "UPDATE btsProject_Appointment SET dateAppointment = '"+appointment.dateAppointment+"', timeAppointment = '"+appointment.timeAppointment+"' , reason = '"+appointment.reason+"', idPatient = '"+appointment.patient.idUser+"', idDoctor = '"+appointment.doctor.idUser+"' WHERE idAppointment = '"+appointment.idAppointment+"';";
		SQLRequestModel.executeSQL(request);
	}
	public static void Update(PrescriptionController prescription) {
		String request = "UPDATE btsProject_Prescription SET datePrescription = '"+prescription.datePrescription+"', content = '"+prescription.content+"' , idPatient = '"+prescription.patient.idUser+"', idDoctor = '"+prescription.doctor.idUser+"' WHERE idAppointment = '"+prescription.idPrescription+"';";
		SQLRequestModel.executeSQL(request);
	}
}
