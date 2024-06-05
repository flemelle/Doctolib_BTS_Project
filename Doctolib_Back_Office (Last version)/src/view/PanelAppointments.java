package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.AppointmentController;
import controller.UserController;
import controller.tableController;

public class PanelAppointments extends PanelModel implements ActionListener{
	private JTable appointmentList;
	private JScrollPane tableScrollPanel;
	private tableController tableAppointment;
	

	private JPanel formAppointmentPanel = new JPanel(); 
	private JTextField dateAppointmentField = new JTextField();
	private JTextField timeAppointmentField = new JTextField();
	private JTextField reasonField  = new JTextField();
	private JTextField idPatientField = new JTextField();
	private JTextField idDoctorField = new JTextField();
	private JButton cancelButton = new JButton("Annuler"); 
	private JButton saveButton= new JButton("Enregistrer");
	
	private JLabel appointmentNumber;
	public PanelAppointments() {
		this.setBackground(new Color(0, 100, 100));
//		
		this.formAppointmentPanel.setBounds(50, 50, 300, 250);

		this.formAppointmentPanel.setLayout(new GridLayout(6, 2));
		this.formAppointmentPanel.add(new JLabel("Date : "));
		this.formAppointmentPanel.add(this.dateAppointmentField);
		this.formAppointmentPanel.add(new JLabel("Heure : "));
		this.formAppointmentPanel.add(this.timeAppointmentField);
		this.formAppointmentPanel.add(new JLabel("Topic : "));
		this.formAppointmentPanel.add(this.reasonField );
		// this.formAppointmentPanel.add(new JLabel("Id Médecin : "));
		// this.formAppointmentPanel.add(this.idDoctor);
		// this.formAppointmentPanel.add(new JLabel("Id Patient : "));
		// this.formAppointmentPanel.add(this.idPatient);
		this.formAppointmentPanel.add(new JLabel("Médecin : "));
		this.formAppointmentPanel.add(this.idDoctorField);
		this.formAppointmentPanel.add(new JLabel("Patient : "));
		this.formAppointmentPanel.add(this.idPatientField);
		this.formAppointmentPanel.add(this.cancelButton);
		this.formAppointmentPanel.add(this.saveButton);
		this.add(this.formAppointmentPanel); 
		this.formAppointmentPanel.setVisible(true);
		
		//appointment Table list
		String header [] = {"Id", "Date", "Durée", "Topic", "Id Médecin", "Médecin", "Id Patient", "Patient"};
		this.tableAppointment = new tableController(header, this.getData(""));
		this.appointmentList = new JTable(this.tableAppointment); 
		this.tableScrollPanel = new JScrollPane(this.appointmentList); 
		this.tableScrollPanel.setBounds(400, 80, 600, 220);
		this.add(this.tableScrollPanel); 
		
		//Button listener
		this.saveButton.addActionListener(this);
		this.cancelButton.addActionListener(this);
		
		//appointment Tablemouse listener
		this.appointmentList.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-gtableMaterielsenerated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				//TO DO
				int row = 0; 
				if (e.getClickCount()>=2) {
					row = appointmentList.getSelectedRow();
					UserController patient = UserController.Select(7);
					UserController doctor = UserController.Select(7);
					AppointmentController appointment = new AppointmentController(Integer.parseInt(tableAppointment.getValueAt(row, 0).toString()), tableAppointment.getValueAt(row, 1).toString(), tableAppointment.getValueAt(row, 2).toString(), tableAppointment.getValueAt(row, 3).toString(), patient,  doctor);
					int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet utilisateur ?", 
							"Suppression de l'utilisateur", JOptionPane.YES_NO_OPTION); 
					if (reponse == 0) {
						//suppression dans la BDD
						appointment.Delete();
						tableAppointment.removeRow(row);
						//suppression dans l'affichidPatient de la table 
						//tableAppointment.supprimerLigne(row);
						appointmentNumber.setText("Nombre de rendez-vous :" + tableAppointment.getRowCount());
					}
				}
				else {
					row = appointmentList.getSelectedRow();
					String dateAppointment = tableAppointment.getValueAt(row, 1).toString(); 
					String timeAppointment = tableAppointment.getValueAt(row, 2).toString(); 
					String reason = tableAppointment.getValueAt(row, 3).toString();
					String idDoctor = tableAppointment.getValueAt(row, 4).toString(); 
					String idPatient = tableAppointment.getValueAt(row, 6).toString(); 
					//remplissiage du formulaire 

					dateAppointmentField.setText(dateAppointment);
					timeAppointmentField.setText(timeAppointment);
					reasonField.setText(reason); 
					idPatientField.setText(idPatient);
					idDoctorField.setText(idDoctor);
					saveButton.setText("Modifier");
				}
				
			}
		});
		//Nombre de matériels dans la table :
		int nbappointments = this.tableAppointment.getRowCount(); 
		appointmentNumber = new JLabel("Nombre de rendez-vous : " + nbappointments);
		appointmentNumber.setBounds(300, 360, 300, 20);
		this.add(appointmentNumber); 
	}
	public Object [][] getData (String filter){
		ArrayList<AppointmentController> appointmentList = AppointmentController.SelectAll(); 
		Object [][] matrice = new Object[appointmentList.size()][8];
		int i = 0; 
		for (AppointmentController appointment : appointmentList) {
			matrice [i][0] = appointment.getIdAppointment();
			matrice [i][1] = appointment.getDateAppointment();
			matrice [i][2] = appointment.getTimeAppointment();
			matrice [i][3] = appointment.getReason();
			matrice [i][4] = appointment.getdoctor().idUser;
			matrice [i][5] = appointment.getdoctor().firstName + " " + appointment.getdoctor().lastName;
			matrice [i][6] = appointment.getpatient().idUser;
			matrice [i][7] = appointment.getpatient().firstName + " " + appointment.getpatient().lastName;
			i++;
		}
		return matrice;
	}
	public void clearFields() {
		dateAppointmentField.setText("");
		timeAppointmentField.setText("");
		reasonField.setText("");
		idPatientField.setText("");
		idDoctorField.setText("");
		saveButton.setText("Enregistrer");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.cancelButton) {
			clearFields();
		}
		else if (e.getSource() == this.saveButton) {
			int idappointment = 0;
			String dateAppointment = this.dateAppointmentField.getText(); 
			String timeAppointment = this.timeAppointmentField.getText(); 
			String reason = this.idDoctorField.getText();
			int idPatient =  Integer.parseInt(this.reasonField.getText()); 
			int idDoctor =  Integer.parseInt(this.reasonField.getText()); 
			UserController doctor = UserController.Select(idDoctor);
			UserController patient = UserController.Select(idPatient);
			//String status = this.idPatient.getText(); 
			AppointmentController appointment = new AppointmentController (idappointment, dateAppointment, timeAppointment, reason, doctor, patient);
			if(this.saveButton.getText().equals("Modifier")) {
				int row = 0; 
				row = appointmentList.getSelectedRow(); 
				idappointment = Integer.parseInt(tableAppointment.getValueAt(row, 0).toString());
				appointment.Update();
				Object updatedRow [] = {idappointment, dateAppointment, timeAppointment, reason, patient.idUser, doctor.idUser, patient.firstName + " " + patient.lastName, doctor.firstName + " " +doctor.lastName};
				this.tableAppointment.updateTable(row, updatedRow);
				JOptionPane.showMessageDialog(this, "Modification effectuée");
				this.clearFields();
				this.saveButton.setText("Enregistrer");
			} else if(this.saveButton.getText().equals("Enregistrer")) {
				boolean ok = true;
				if(idPatient < 0) {
					JOptionPane.showMessageDialog(this, "Erreur, entrez un âge supérieur à 0");
					this.reasonField.setBackground(Color.red);
					ok = false;
				}else {
					this.reasonField.setBackground(Color.white);
				}
				if(ok) {
					appointment.Add();
					JOptionPane.showMessageDialog(this, "Nouvel utilisateur bien créé");
					//récupération de l'ID donné par mysql 
					ArrayList<AppointmentController> appointmentList = AppointmentController.SelectAll();  
					AppointmentController newappointment = appointmentList.get(appointmentList.size() - 1);
//					JOptionPane.showMessidPatientDialog(this, "Matériel inséré avec succés dans la BDD");
//					//insertion dans l'affichidPatient graphique 
					Object row[]= {newappointment.idAppointment, newappointment.dateAppointment, newappointment.timeAppointment, newappointment.reason, newappointment.doctor, newappointment.patient};
					this.tableAppointment.addRow(row);
					appointmentNumber.setText("Nombre de rendez-vous :"+tableAppointment.getRowCount());
					this.clearFields();
				}
			} 
		}
	}
}


























