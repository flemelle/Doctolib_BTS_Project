package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.TableController;
import controller.UserController;
import model.SelectModel;

public class PanelPatients extends PanelModel{
	private JPanel mainContainer = new JPanel();
	private JTable patientList;
	private JScrollPane tablePanel;
	private TableController tablePatient;
	private JButton test = new JButton("test");
	//private JComboBox<String> cathegoryList = new JComboBox<String>();
	public PanelPatients() {
		this.setBackground(new Color(0, 100, 100));
//		this.cathegoryList.addItem("Médecins");
//		this.cathegoryList.addItem("Patients");
//		this.cathegoryList.addItem("Rendez-vous");
		

		this.mainContainer.setLayout(new GridLayout(10, 2));
		this.mainContainer.setBounds(60, 40, 800, 400);
		//this.mainContainer.add(this.cathegoryList);
		this.mainContainer.setVisible(true);
		this.add(mainContainer);
		
		//construction de la Jtable des materiels 
		String header [] = {"idUser", "firstName", "lastName", "age", "mail", "address", "password", "role"};
		this.tablePatient = new TableController(header, this.getData(""));
		this.patientList = new JTable(this.tablePatient); 
		this.tablePanel = new JScrollPane(this.patientList); 
		this.tablePanel.setBounds(400, 80,400, 220);
		this.tablePanel.add(this.test);
		this.add(this.tablePanel); 
	}
	public Object [][] getData (String filtre){
		ArrayList<UserController> userList = SelectModel.selectUserList(); 
		Object [][] matrice = new Object[userList.size()][8];
		int i = 0; 
		for (UserController user : userList) {
			matrice [i][0] = user.getIdUser();
			matrice [i][1] = user.getFirstName();
			matrice [i][2] = user.getLastName();
			matrice [i][3] = user.getAge();
			matrice [i][4] = user.getMail();
			matrice [i][5] = user.getAddress(); 
			matrice [i][6] = user.getPassword();
			matrice [i][7] = user.getRole();
			i++;
		}
		return matrice;
	}
}
