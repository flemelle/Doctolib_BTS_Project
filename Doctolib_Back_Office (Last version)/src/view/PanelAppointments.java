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
	private JTable patientList;
	private JScrollPane tableScrollPanel;
	private tableController tablePatient;
	

	private JPanel formAppointmentPanel = new JPanel(); 
	private JTextField idAppointment = new JTextField(); 
	private JTextField dateAppointment = new JTextField();
	private JTextField timeAppointment = new JTextField();
	private JTextField reason  = new JTextField();
	private JTextField Patient = new JTextField();
	private JTextField Doctor = new JTextField();
	private JTextField idPatient = new JTextField();
	private JTextField idDoctor = new JTextField();
	private JButton cancelButton = new JButton("Annuler"); 
	private JButton saveButton= new JButton("Enregistrer");
	
	private JLabel appointmentNumber;
	public PanelAppointments() {
		this.setBackground(new Color(0, 100, 100));
//		
		this.formAppointmentPanel.setBounds(50, 50, 300, 250);

		this.formAppointmentPanel.setLayout(new GridLayout(8, 2));
		this.formAppointmentPanel.add(new JLabel("Date : "));
		this.formAppointmentPanel.add(this.dateAppointment);
		this.formAppointmentPanel.add(new JLabel("Durée : "));
		this.formAppointmentPanel.add(this.timeAppointment);
		this.formAppointmentPanel.add(new JLabel("Topic : "));
		this.formAppointmentPanel.add(this.reason );
		// this.formAppointmentPanel.add(new JLabel("Id Médecin : "));
		// this.formAppointmentPanel.add(this.idDoctor);
		// this.formAppointmentPanel.add(new JLabel("Id Patient : "));
		// this.formAppointmentPanel.add(this.idPatient);
		this.formAppointmentPanel.add(new JLabel("Médecin : "));
		this.formAppointmentPanel.add(this.Doctor);
		this.formAppointmentPanel.add(new JLabel("Patient : "));
		this.formAppointmentPanel.add(this.Patient);
		this.formAppointmentPanel.add(this.cancelButton);
		this.formAppointmentPanel.add(this.saveButton);
		this.add(this.formAppointmentPanel); 
		this.formAppointmentPanel.setVisible(true);
		
		//appointment Table list
		String header [] = {"Id", "Date", "Durée", "Topic", "Id Médecin", "Id Patient", "Médecin", "Patient"};
		this.tablePatient = new tableController(header, this.getData(""));
		this.patientList = new JTable(this.tablePatient); 
		this.tableScrollPanel = new JScrollPane(this.patientList); 
		this.tableScrollPanel.setBounds(400, 80, 600, 220);
		this.add(this.tableScrollPanel); 
		
		//Button listener
		this.saveButton.addActionListener(this);
		this.cancelButton.addActionListener(this);
		
		//appointment Tablemouse listener
		this.patientList.addMouseListener(new MouseListener() {
			
			public void moappointmenteleased(MouseEvent e) {
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
					row = patientList.getSelectedRow();
					AppointmentController appointment = new AppointmentController(Integer.parseInt(tablePatient.getValueAt(row, 0).toString()), tablePatient.getValueAt(row, 1).toString(), tablePatient.getValueAt(row, 2).toString(), tablePatient.getValueAt(row, 6).toString(), tablePatient.getValueAt(row, 4).toString(), tablePatient.getValueAt(row, 5).toString(),"",  Integer.parseInt(tablePatient.getValueAt(row, 3).toString()));
					int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet utilisateur ?", 
							"Suppression de l'utilisateur", JOptionPane.YES_NO_OPTION); 
					if (reponse == 0) {
						//suppression dans la BDD
						appointment.Delete();
						tablePatient.removeRow(row);
						//suppression dans l'affichidPatient de la table 
						//tablePatient.supprimerLigne(row);
						appointmentNumber.setText("Nombre de matériels disponibles :" + tablePatient.getRowCount());
					}
				}
				else {
					row = patientList.getSelectedRow();
					String idappointment = tablePatient.getValueAt(row, 0).toString();
					String dateAppointment = tablePatient.getValueAt(row, 1).toString(); 
					String timeAppointment = tablePatient.getValueAt(row, 2).toString(); 
					String reason = tablePatient.getValueAt(row, 5).toString();
					String idPatient = tablePatient.getValueAt(row, 3).toString(); 
					String status = tablePatient.getValueAt(row, 4).toString(); 
					String role = tablePatient.getValueAt(row, 6).toString(); 
					//remplissidPatient du formulaire 

					idAppointment.setText(idappointment); 
					dateAppointment.setText(dateAppointment);
					timeAppointment.setText(timeAppointment);
					reason .setText(idPatient);
					idPatient.setText(status);
					idDoctor.setText(reason);
					saveButton.setText("Modifier");
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
			}
		});
		//Nombre de matériels dans la table :
		int nbappointments = this.tablePatient.getRowCount(); 
		appointmentNumber = new JLabel("Nombre de matériels disponnibles : " + nbappointments);
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
		dateAppointment.setText("");
		timeAppointment.setText("");
		reason .setText("");
		idPatient.setText("");
		idDoctor.setText("");
		saveButton.setText("Enregistrer");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.cancelButton) {
			clearFields();
		}
		else if (e.getSource() == this.saveButton) {
			int idappointment = 0;
			String dateAppointment = this.dateAppointment.getText(); 
			String timeAppointment = this.timeAppointment.getText(); 
			String reason = this.idDoctor.getText();
			int idPatient =  Integer.parseInt(this.reason .getText()); 
			int idDoctor =  Integer.parseInt(this.reason .getText()); 
			UserController doctor = UserController.Select(idDoctor);
			UserController patient = UserController.Select(idPatient);
			//String status = this.idPatient.getText(); 
			AppointmentController appointment = new AppointmentController (idappointment, dateAppointment, timeAppointment, reason, doctor, patient);
			if(this.saveButton.getText().equals("Modifier")) {
				int row = 0; 
				row = patientList.getSelectedRow(); 
				idappointment = Integer.parseInt(tablePatient.getValueAt(row, 0).toString());
				appointment.Update();
				Object updatedRow [] = {idappointment, dateAppointment, timeAppointment, reason, patient.idUser, doctor.idUser, patient.firstName + " " + patient.lastName, doctor.firstName + " " +doctor.lastName};
				this.tablePatient.updateTable(row, updatedRow);
				JOptionPane.showMessageDialog(this, "Modification effectuée");
				this.clearFields();
				this.saveButton.setText("Enregistrer");
			} else if(this.saveButton.getText().equals("Enregistrer")) {
				boolean ok = true;
				if(idPatient < 0) {
					JOptionPane.showMessageDialog(this, "Erreur, entrez un âge supérieur à 0");
					this.reason .setBackground(Color.red);
					ok = false;
				}else {
					this.reason .setBackground(Color.white);
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
					this.tablePatient.addRow(row);
					appointmentNumber.setText("Nombre de matériels disponibles :"+tablePatient.getRowCount());
					this.clearFields();
				}
			} 
		}
	}
}


























