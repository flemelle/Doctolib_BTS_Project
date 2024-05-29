package controller;

import java.util.ArrayList;

import model.DeleteModel;
import model.InsertModel;
import model.SelectModel;
import model.UpdateModel;

public class UserController {
	public int idUser, age;
	public String firstName, lastName, mail, address, password, role; 
	
	public UserController(int idUser, String firstName, String lastName, String mail, String address, String password, String role, int age) {
		this.setIdUser(idUser);
		this.setAge(age);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setMail(mail);
		this.setAddress(address);
		this.setPassword(password);
		this.setRole(role);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public static ArrayList<UserController> SelectAll() {
		return SelectModel.SelectAllUser(null);
	}
	
	public static ArrayList<UserController> SelectAllPatients() {
		return SelectModel.SelectAllUser("patient");
	}
	
	public static ArrayList<UserController> SelectAllDoctors() {
		return SelectModel.SelectAllUser("doctor");
	}

	public static ArrayList<UserController> SelectAllAdmin() {
		return SelectModel.SelectAllUser("admin");
	}

	public static UserController Select(int idUser) {
		return SelectModel.SelectUser(idUser);
	}
	
	public void Delete() {
		DeleteModel.Delete(this);
	}
	public void Update() {
		UpdateModel.Update(this);
	}
	public void Add() {
		InsertModel.Insert(this);
	}
}
