package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.AppointmentController;
import controller.UserController;

public class DeleteModel {
	private static DBConnection bdd = new DBConnection ("localhost","btsProject","phpmyadmin","root");
	
	public static void Delete(UserController user) {
		String request = "DELETE FROM btsProject_User WHERE idUser = "+user.idUser+";";
		SQLRequestModel.executeSQL(request);
	}
	public static void Delete(AppointmentController appointment) {
		String request = "DELETE FROM btsProject_Appointment WHERE idAppointment = "+appointment.idAppointment+";";
		SQLRequestModel.executeSQL(request);
	}
	

}
