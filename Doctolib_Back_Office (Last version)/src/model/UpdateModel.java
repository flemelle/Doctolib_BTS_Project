package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.AppointmentController;
import controller.UserController;

public class UpdateModel {
	private static DBConnection bdd = new DBConnection ("localhost:3306","btsProject","phpmyadmin","root");
	private SQLRequestModel SQLExecute = new SQLRequestModel();
	
	public static void Update(UserController user) {
		String request = "UPDATE btsProject_User SET (firstName = "+user.firstName+", lastName ="+user.lastName+" , age="+user.age+", mail= "+user.mail+", address="+user.address+", role="+user.role+") where idUser = '"+user.idUser+"';";
		SQLRequestModel.executeSQL(request);
	}
	public static void Update(AppointmentController appointment) {
		String request = "UPDATE btsProject_Appointment SET (dateAppointment = "+appointment.dateAppointment+", timeAppointment ="+appointment.timeAppointment+" , reason ="+appointment.reason+", idPatient = "+appointment.idPatient+", idDoctor ="+appointment.idDoctor+") where idAppointment = '"+appointment.idAppointment+"';";
		SQLRequestModel.executeSQL(request);
	}
}
