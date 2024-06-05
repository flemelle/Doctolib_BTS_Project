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

import controller.PrescriptionController;
import controller.UserController;
import controller.tableController;

public class PanelPrescriptions extends PanelModel implements ActionListener{
	private JTable PrescriptionList;
	private JScrollPane tableScrollPanel;
	private tableController tablePrescription;
	

	private JPanel formPrescriptionPanel = new JPanel(); 
	private JTextField datePrescriptionField = new JTextField();
	private JTextField timePrescriptionField = new JTextField();
	private JTextField contentField  = new JTextField();
	private JTextField idPatientField = new JTextField();
	private JTextField idDoctorField = new JTextField();
	private JButton cancelButton = new JButton("Annuler"); 
	private JButton saveButton= new JButton("Enregistrer");
	
	private JLabel PrescriptionNumber;
	public PanelPrescriptions() {
		this.setBackground(new Color(0, 100, 100));
//		
		this.formPrescriptionPanel.setBounds(50, 50, 300, 250);

		this.formPrescriptionPanel.setLayout(new GridLayout(5, 2));
		this.formPrescriptionPanel.add(new JLabel("Date : "));
		this.formPrescriptionPanel.add(this.datePrescriptionField);
		this.formPrescriptionPanel.add(new JLabel("Contenue : "));
		this.formPrescriptionPanel.add(this.contentField );
		// this.formPrescriptionPanel.add(new JLabel("Id Médecin : "));
		// this.formPrescriptionPanel.add(this.idDoctor);
		// this.formPrescriptionPanel.add(new JLabel("Id Patient : "));
		// this.formPrescriptionPanel.add(this.idPatient);
		this.formPrescriptionPanel.add(new JLabel("Médecin : "));
		this.formPrescriptionPanel.add(this.idDoctorField);
		this.formPrescriptionPanel.add(new JLabel("Patient : "));
		this.formPrescriptionPanel.add(this.idPatientField);
		this.formPrescriptionPanel.add(this.cancelButton);
		this.formPrescriptionPanel.add(this.saveButton);
		this.add(this.formPrescriptionPanel); 
		this.formPrescriptionPanel.setVisible(true);
		
		//Prescription Table list
		String header [] = {"Id", "Date", "Contenue", "Id Médecin", "Médecin", "Id Patient", "Patient"};
		this.tablePrescription = new tableController(header, this.getData(""));
		this.PrescriptionList = new JTable(this.tablePrescription); 
		this.tableScrollPanel = new JScrollPane(this.PrescriptionList); 
		this.tableScrollPanel.setBounds(400, 80, 600, 220);
		this.add(this.tableScrollPanel); 
		
		//Button listener
		this.saveButton.addActionListener(this);
		this.cancelButton.addActionListener(this);
		
		//Prescription Tablemouse listener
		this.PrescriptionList.addMouseListener(new MouseListener() {
			
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
					row = PrescriptionList.getSelectedRow();
					UserController patient = UserController.Select(7);
					UserController doctor = UserController.Select(5);
					PrescriptionController Prescription = new PrescriptionController(Integer.parseInt(tablePrescription.getValueAt(row, 0).toString()), tablePrescription.getValueAt(row, 1).toString(), tablePrescription.getValueAt(row, 2).toString(), patient,  doctor);
					int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette ordonnace ?", 
							"Suppression de l'ordonnance ", JOptionPane.YES_NO_OPTION); 
					if (reponse == 0) {
						//suppression dans la BDD
						Prescription.Delete();
						tablePrescription.removeRow(row);
						//suppression dans l'affichidPatient de la table 
						//tablePrescription.supprimerLigne(row);
						PrescriptionNumber.setText("Nombre de rendez-vous :" + tablePrescription.getRowCount());
					}
				}
				else {
					row = PrescriptionList.getSelectedRow();
					String datePrescription = tablePrescription.getValueAt(row, 1).toString(); 
					String content = tablePrescription.getValueAt(row, 2).toString();
					String idDoctor = tablePrescription.getValueAt(row, 3).toString(); 
					String idPatient = tablePrescription.getValueAt(row, 5).toString(); 
					//remplissiage du formulaire 

					datePrescriptionField.setText(datePrescription);
					contentField.setText(content); 
					idPatientField.setText(idPatient);
					idDoctorField.setText(idDoctor);
					saveButton.setText("Modifier");
				}
				
			}
		});
		//Nombre de matériels dans la table :
		int nbPrescriptions = this.tablePrescription.getRowCount(); 
		PrescriptionNumber = new JLabel("Nombre de rendez-vous : " + nbPrescriptions);
		PrescriptionNumber.setBounds(300, 360, 300, 20);
		this.add(PrescriptionNumber); 
	}
	public Object [][] getData (String filter){
		ArrayList<PrescriptionController> PrescriptionList = PrescriptionController.SelectAll(); 
		Object [][] matrice = new Object[PrescriptionList.size()][8];
		int i = 0; 
		for (PrescriptionController Prescription : PrescriptionList) {
			matrice [i][0] = Prescription.getIdPrescription();
			matrice [i][1] = Prescription.getDatePrescription();
			matrice [i][2] = Prescription.getContent();
			matrice [i][3] = Prescription.getDoctor().idUser;
			matrice [i][4] = Prescription.getDoctor().firstName + " " + Prescription.getDoctor().lastName;
			matrice [i][5] = Prescription.getPatient().idUser;
			matrice [i][6] = Prescription.getPatient().firstName + " " + Prescription.getPatient().lastName;
			i++;
		}
		return matrice;
	}
	public void clearFields() {
		datePrescriptionField.setText("");
		timePrescriptionField.setText("");
		contentField.setText("");
		idPatientField.setText("");
		idDoctorField.setText("");
		saveButton.setText("Enregistrer");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.cancelButton) {
			clearFields();
		}
		else if (e.getSource() == this.saveButton) {
			int idPrescription = 0;
			String datePrescription = this.datePrescriptionField.getText(); 
			String timePrescription = this.timePrescriptionField.getText(); 
			String content = this.idDoctorField.getText();
			int idPatient =  Integer.parseInt(this.contentField.getText()); 
			int idDoctor =  Integer.parseInt(this.contentField.getText()); 
			UserController doctor = UserController.Select(idDoctor);
			UserController patient = UserController.Select(idPatient);
			//String status = this.idPatient.getText(); 
			PrescriptionController Prescription = new PrescriptionController (idPrescription, datePrescription, content, doctor, patient);
			if(this.saveButton.getText().equals("Modifier")) {
				int row = 0; 
				row = PrescriptionList.getSelectedRow(); 
				idPrescription = Integer.parseInt(tablePrescription.getValueAt(row, 0).toString());
				Prescription.Update();
				Object updatedRow [] = {idPrescription, datePrescription, timePrescription, content, patient.idUser, doctor.idUser, patient.firstName + " " + patient.lastName, doctor.firstName + " " +doctor.lastName};
				this.tablePrescription.updateTable(row, updatedRow);
				JOptionPane.showMessageDialog(this, "Modification effectuée");
				this.clearFields();
				this.saveButton.setText("Enregistrer");
			} else if(this.saveButton.getText().equals("Enregistrer")) {
				boolean ok = true;
				if(idPatient < 0) {
					JOptionPane.showMessageDialog(this, "Erreur, entrez un âge supérieur à 0");
					this.contentField.setBackground(Color.red);
					ok = false;
				}else {
					this.contentField.setBackground(Color.white);
				}
				if(ok) {
					Prescription.Add();
					JOptionPane.showMessageDialog(this, "Nouvelle ordonnance bien créée");
					//récupération de l'ID donné par mysql 
					ArrayList<PrescriptionController> PrescriptionList = PrescriptionController.SelectAll();  
					PrescriptionController newPrescription = PrescriptionList.get(PrescriptionList.size() - 1);
//					JOptionPane.showMessidPatientDialog(this, "Matériel inséré avec succés dans la BDD");
//					//insertion dans l'affichidPatient graphique 
					Object row[]= {newPrescription.idPrescription, newPrescription.datePrescription, newPrescription.content, newPrescription.doctor, newPrescription.patient};
					this.tablePrescription.addRow(row);
					PrescriptionNumber.setText("Nombre de rendez-vous :"+tablePrescription.getRowCount());
					this.clearFields();
				}
			} 
		}
	}
}


























