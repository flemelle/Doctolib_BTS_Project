package model;

import controller.AppointmentController;
import controller.UserController;

public class InsertModel {
	public static void Insert(UserController user) {
		String request = "INSERT INTO btsProject_User VALUES (null, '"+user.firstName+"', '"+user.lastName+"' , '"+user.age+"', '"+user.mail+"', '"+user.address+"', '"+user.password+"', '"+user.role+"');";
		SQLRequestModel.executeSQL(request);
	}
	public static void Insert(AppointmentController appointment) {
		String request = "INSERT INTO btsProject_Appointment VALUES (null, '"+ appointment.dateAppointment+"', '"+appointment.timeAppointment+"' , '"+appointment.reason+"', '"+appointment.idPatient+"', '"+appointment.idDoctor+"');";
		SQLRequestModel.executeSQL(request);
	}
}
