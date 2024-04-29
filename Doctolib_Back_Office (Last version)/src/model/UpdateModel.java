package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.UserController;

public class UpdateModel {
	private static DBConnection bdd = new DBConnection ("localhost:3306","btsProject","phpmyadmin","root");
	private SQLRequestModel SQLExecute = new SQLRequestModel();
	
	public static void updateUser(UserController user) {
		String request = "UPDATE btsProject_User SET (firstName = "+user.getFirstName()+", lastName ="+user.getLastName()+" , age="+user.getAge()+", mail= "+user.getMail()+", address="+user.getAddress()+", role="+user.getRole()+") where idUser = '"+user.idUser+"';";
		SQLRequestModel.executeSQL(request);
	}

}
