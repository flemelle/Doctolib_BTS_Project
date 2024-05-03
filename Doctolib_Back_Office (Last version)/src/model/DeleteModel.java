package model;

import controller.AppointmentController;
import controller.PrescriptionController;
import controller.UserController;

public class DeleteModel {
	public static void Delete(UserController user) {
		String request = "DELETE FROM btsProject_User WHERE idUser = " + user.idUser + ";";
		SQLRequestModel.executeSQL(request);
	}
	public static void Delete(AppointmentController appointment) {
		String request = "DELETE FROM btsProject_Appointment WHERE idAppointment = " + appointment.idAppointment + ";";
		SQLRequestModel.executeSQL(request);
	}
	public static void Delete(PrescriptionController prescription) {
		String request = "DELETE FROM btsProject_Appointment WHERE idPrescription = " + prescription.idPrescription + ";";
		SQLRequestModel.executeSQL(request);
	}

}
