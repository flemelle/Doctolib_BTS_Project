package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GeneralView extends JFrame implements ActionListener{
	private JButton accountPageButton = new JButton("Compte");
	private JButton doctorsPageButton = new JButton("Médecins");
	private JButton patientsPageButton = new JButton("Patients");
	private JButton appoitmentsPageButton = new JButton("Rendez-vous");
	private JButton exit = new JButton("Quitter");
	private JPanel navigationPanel = new JPanel();
	private static PanelAccount panelAccount = new PanelAccount();
	private static PanelDoctors panelDoctors = new PanelDoctors();
	private static PanelPatients panelPatients = new PanelPatients();
	private static PanelAppointments panelAppointements = new PanelAppointments();
	
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
		navigationPanel.add(this.appoitmentsPageButton);
		navigationPanel.add(this.accountPageButton);
		this.add(navigationPanel);
		
		//Clickable buttons
		this.patientsPageButton.addActionListener(this);
		this.doctorsPageButton.addActionListener(this);
		this.appoitmentsPageButton.addActionListener(this);
		this.accountPageButton.addActionListener(this);
		this.add(panelAccount);
		this.add(panelDoctors);
		this.add(panelPatients);
		this.add(panelAppointements);
	}
	public void display(int tab) {
		panelAccount.setVisible(false);
		panelDoctors.setVisible(false);
		panelPatients.setVisible(false);
		panelAppointements.setVisible(false);
		switch(tab) {
			case 1 :
				panelAccount.setVisible(true);
				break;
			case 2 :
				panelDoctors.setVisible(true);
				break;
			case 3 :
				panelPatients.setVisible(true);
				break;
			case 4 :
				panelAppointements.setVisible(true);
				break;
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (this.accountPageButton == e.getSource()) {
			display(1);	
		} else if (this.doctorsPageButton == e.getSource()) {
			display(2);			
		} else if (this.patientsPageButton == e.getSource()) {
			display(3);			
		} else if (this.appoitmentsPageButton == e.getSource()) {
			display(4);
		} else if (this.exit == e.getSource()) {
			//Close navigation
			//Back to connection page
		}
	}
}
