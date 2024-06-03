packidPatient view;

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
	private JTextField idPatient = new JTextField();
	private JTextField idDoctor = new JTextField();
	private JButton cancelButton = new JButton("Annuler"); 
	private JButton saveButton= new JButton("Enregistrer");
	
	private JLabel appointmentNumber;
	//private JComboBox<String> cathegoryList = new JComboBox<String>();
	public PanelAppointments() {
		this.setBackground(new Color(0, 100, 100));
//		this.cathegoryList.addItem("Médecins");
//		this.cathegoryList.addItem("Patients");
//		this.cathegoryList.addItem("Rendez-vous");
		

//		this.mainContainer.setLayout(new GridLayout(10, 2));
//		this.mainContainer.setBounds(60, 40, 800, 400);
//		//this.mainContainer.add(this.cathegoryList);
//		this.mainContainer.setVisible(true);
//		this.add(mainContainer);
		//appointment Form
		this.formAppointmentPanel.setBounds(50, 50, 300, 250);

		this.formAppointmentPanel.setLayout(new GridLayout(7, 2));
		this.formAppointmentPanel.add(new JLabel("Nom : "));
		this.formAppointmentPanel.add(this.dateAppointment);
		this.formAppointmentPanel.add(new JLabel("Prénom : "));
		this.formAppointmentPanel.add(this.timeAppointment);
		this.formAppointmentPanel.add(new JLabel("Âge : "));
		this.formAppointmentPanel.add(this.reason );
		this.formAppointmentPanel.add(new JLabel("status : "));
		this.formAppointmentPanel.add(this.idPatient);
		this.formAppointmentPanel.add(new JLabel("Adresse : "));
		this.formAppointmentPanel.add(this.idDoctor);
		this.formAppointmentPanel.add(this.cancelButton);
		this.formAppointmentPanel.add(this.saveButton);
		this.add(this.formAppointmentPanel); 
		this.formAppointmentPanel.setVisible(true);
		
		//appointment Table list
		String header [] = {"idappointment", "dateAppointment", "timeAppointment", "idPatient", "status", "reason", "role"};
		this.tablePatient = new tableController(header, this.getData(""));
		this.patientList = new JTable(this.tablePatient); 
		this.tableScrollPanel = new JScrollPane(this.patientList); 
		this.tableScrollPanel.setBounds(400, 80, 400, 220);
		this.add(this.tableScrollPanel); 
		
		//Button listener
		this.saveButton.addActionListener(this);
		this.cancelButton.addActionListener(this);
		
//		reason .addKeyListener(new KeyAdapter() {
//	         public void keyPressed(KeyEvent ke) {
//	            
//	        	 //if ()
//	        	 String value = reason .getText();
//	            int l = value.length();
//	            if (value.charAt(0) == '0' && l ==10) {
//	            	reason .setEditable(true);
//	               label.setText("");
//	            } else {
//	            	reason .setEditable(false);
//	               label.setText("* Enter only numeric digits(0-9)");
//	            }
//	         }
//	      });
		
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
		});
		//Nombre de matériels dans la table :
		int nbappointments = this.tablePatient.getRowCount(); 
		appointmentNumber = new JLabel("Nombre de matériels disponnibles : " + nbappointments);
		appointmentNumber.setBounds(300, 360, 300, 20);
		this.add(appointmentNumber); 
	}
	public Object [][] getData (String filter){
		ArrayList<AppointmentController> appointmentList = AppointmentController.SelectAll(); 
		Object [][] matrice = new Object[appointmentList.size()][7];
		int i = 0; 
		for (AppointmentController appointment : appointmentList) {
			matrice [i][0] = appointment.getIdAppointment();
			matrice [i][1] = appointment.getDateAppointment();
			matrice [i][2] = appointment.getTimeAppointment();
			matrice [i][3] = appointment.getReason();
			matrice [i][4] = appointment.getdoctor();
			matrice [i][5] = appointment.getpatient(); 
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
			UserController doctor;
			UserController patient;
			String status = this.idPatient.getText(); 
			AppointmentController appointment = new AppointmentController (idappointment, dateAppointment, timeAppointment, status, reason, "", idPatient, idDoctor );
			if(this.saveButton.getText().equals("Modifier")) {
				int row = 0; 
				row = patientList.getSelectedRow(); 
				idappointment = Integer.parseInt(tablePatient.getValueAt(row, 0).toString());
				appointment.Update();
				Object updatedRow [] = {idappointment, dateAppointment, timeAppointment, idPatient, status, reason };
				this.tablePatient.updateTable(row, updatedRow);
				JOptionPane.showMessidPatientDialog(this, "Modification effectuée");
				this.clearFields();
				this.saveButton.setText("Enregistrer");
			} else if(this.saveButton.getText().equals("Enregistrer")) {
				boolean ok = true;
				if(idPatient < 0) {
					JOptionPane.showMessidPatientDialog(this, "Erreur, entrez un âge supérieur à 0");
					this.reason .setBackground(Color.red);
					ok = false;
				}else {
					this.reason .setBackground(Color.white);
				}
				if(ok) {
					appointment.Add();
					JOptionPane.showMessidPatientDialog(this, "Nouvel utilisateur bien créé");
					//récupération de l'ID donné par mysql 
					ArrayList<AppointmentController> appointmentList = AppointmentController.SelectAll();  
					AppointmentController newappointment = appointmentList.get(appointmentList.size() - 1);
//					JOptionPane.showMessidPatientDialog(this, "Matériel inséré avec succés dans la BDD");
//					//insertion dans l'affichidPatient graphique 
					Object row[]= {newappointment.idappointment, newappointment.dateAppointment, newappointment.timeAppointment, newappointment.idPatient, newappointment.status, newappointment.reason, newappointment.role};
					this.tablePatient.addRow(row);
					appointmentNumber.setText("Nombre de matériels disponibles :"+tablePatient.getRowCount());
					this.clearFields();
				}
			} 
		}
	}
}


























