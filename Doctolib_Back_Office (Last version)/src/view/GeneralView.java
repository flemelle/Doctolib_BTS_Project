package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Doctolib_Back_Office;

public class GeneralView extends JFrame implements ActionListener{
	private JButton doctorsPageButton = new JButton("Médecins");
	private JButton patientsPageButton = new JButton("Patients");
	private JButton usersPageButton = new JButton("Utilisateurs");
	private JButton appoitmentsPageButton = new JButton("Rendez-vous");
	private JButton prescriptionsPageButton = new JButton("Ordonnaces");
	private JButton exit = new JButton("Quitter");
	private JPanel navigationPanel = new JPanel();
	private static PanelDoctors panelDoctors = new PanelDoctors();
	private static PanelPatients panelPatients = new PanelPatients();
	private static PanelUsers panelUsers = new PanelUsers();
	private static PanelAppointments panelAppointements = new PanelAppointments();
	private static PanelPrescriptions panelPrescriptions = new PanelPrescriptions();
	
	public GeneralView() {
		//JFrame set up
		this.setTitle("Doctolib Back Office");
		this.setBackground(new Color(55, 55, 55));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1000, 600);
		this.setLayout(null);
		this.setResizable(true);
		
		//Menu panel
		navigationPanel.setBounds(100, 20, 800, 30);
		navigationPanel.setLayout(new GridLayout(1,4));
		navigationPanel.add(this.doctorsPageButton);
		navigationPanel.add(this.patientsPageButton);
		navigationPanel.add(this.usersPageButton);
		navigationPanel.add(this.appoitmentsPageButton);
		navigationPanel.add(this.prescriptionsPageButton);
		navigationPanel.add(this.exit);
		this.add(navigationPanel);
		
		//Clickable buttons
		this.usersPageButton.addActionListener(this);
		this.patientsPageButton.addActionListener(this);
		this.doctorsPageButton.addActionListener(this);
		this.appoitmentsPageButton.addActionListener(this);
		this.prescriptionsPageButton.addActionListener(this);
		this.exit.addActionListener(this);
		
		//Panel Addition
		this.add(panelDoctors);
		this.add(panelPatients);
		this.add(panelUsers);
		this.add(panelAppointements);
		this.add(panelPrescriptions);
	}
	public void display(int tab) {
		panelUsers.setVisible(false);
		panelDoctors.setVisible(false);
		panelPatients.setVisible(false);
		panelAppointements.setVisible(false);
		switch(tab) {
			case 2 :
				panelDoctors.setVisible(true);
				break;
			case 3 :
				panelPatients.setVisible(true);
				break;
			case 4 :
				panelAppointements.setVisible(true);
				break;
			case 5 :
				panelUsers.setVisible(true);
				break;
			case 6 :
				panelPrescriptions.setVisible(true);
				break;
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (this.doctorsPageButton == e.getSource()) {
			display(2);			
		} else if (this.patientsPageButton == e.getSource()) {
			display(3);			
		} else if (this.appoitmentsPageButton == e.getSource()) {
			display(4);		
		} else if (this.usersPageButton == e.getSource()) {
			display(5);
		} else if (this.prescriptionsPageButton == e.getSource()) {
			display(6);
		} else if (this.exit == e.getSource()) {
			Doctolib_Back_Office.GeneralView.setVisible(false);
			Doctolib_Back_Office.ConnectionView.setVisible(true);
		}
	}
}
