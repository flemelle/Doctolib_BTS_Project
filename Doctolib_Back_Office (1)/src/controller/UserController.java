package controller;

public class UserController {
	public int idUser;
	private int age;
	private String firstName, lastName, mail, address, password, role; 
	
	public UserController(int idUser, int age, String firstName, String lastName, String mail, String address, String password, String role) {
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
}
