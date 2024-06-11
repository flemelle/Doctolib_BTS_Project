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
import javax.swing.SwingConstants;

import controller.UserController;
import controller.tableController;

public class PanelDoctors extends PanelModel implements ActionListener{
		private JTable doctorList;
		private JScrollPane tableScrollPanel;
		private tableController tableDoctor;
		

		private JPanel formUserPanel = new JPanel(); 
		private JTextField idUserField = new JTextField(); 
		private JTextField firstNameField = new JTextField();
		private JTextField lastNameField = new JTextField();
		private JTextField ageField = new JTextField();
		private JTextField mailField = new JTextField();
		private JTextField addressField = new JTextField();
		private JTextField roleField = new JTextField();
		private JButton cancelButton = new JButton("Annuler"); 
		private JButton saveButton= new JButton("Enregistrer");
	private JLabel title = new JLabel("Médecins", SwingConstants.CENTER);
		
		private JLabel userNumber;
		//private JComboBox<String> cathegoryList = new JComboBox<String>();
		public PanelDoctors() {
			//this.setBackground(new Color(0, 100, 100));
	//		this.cathegoryList.addItem("Médecins");
	//		this.cathegoryList.addItem("Patients");
	//		this.cathegoryList.addItem("Rendez-vous");
			

	//		this.mainContainer.setLayout(new GridLayout(10, 2));
	//		this.mainContainer.setBounds(60, 40, 800, 400);
	//		//this.mainContainer.add(this.cathegoryList);
	//		this.mainContainer.setVisible(true);
	//		this.add(mainContainer);
			//User Form
			this.formUserPanel.setBounds(50, 50, 300, 250);
			this.title.setBounds(400, 30, 600, 40);
			this.add(this.title);

			this.formUserPanel.setLayout(new GridLayout(7, 2));
			this.formUserPanel.add(new JLabel("Nom : "));
			this.formUserPanel.add(this.firstNameField);
			this.formUserPanel.add(new JLabel("Prénom : "));
			this.formUserPanel.add(this.lastNameField);
			this.formUserPanel.add(new JLabel("Âge : "));
			this.formUserPanel.add(this.ageField);
			this.formUserPanel.add(new JLabel("Mail : "));
			this.formUserPanel.add(this.mailField);
			this.formUserPanel.add(new JLabel("Adresse : "));
			this.formUserPanel.add(this.addressField);
			this.formUserPanel.add(new JLabel("Role : "));
			this.formUserPanel.add(this.roleField);
			this.formUserPanel.add(this.cancelButton);
			this.formUserPanel.add(this.saveButton);
			this.add(this.formUserPanel); 
			this.formUserPanel.setVisible(true);
			
			//User Table list
			String header [] = {"idUser", "firstName", "lastName", "age", "mail", "address", "role"};
			this.tableDoctor = new tableController(header, this.getData(""));
			this.doctorList = new JTable(this.tableDoctor); 
			this.tableScrollPanel = new JScrollPane(this.doctorList); 
			this.tableScrollPanel.setBounds(400, 80, 650, 550);
			this.add(this.tableScrollPanel); 
			
			//Button listener
			this.saveButton.addActionListener(this);
			this.cancelButton.addActionListener(this);
			
	//		ageField.addKeyListener(new KeyAdapter() {
	//	         public void keyPressed(KeyEvent ke) {
	//	            
	//	        	 //if ()
	//	        	 String value = ageField.getText();
	//	            int l = value.length();
	//	            if (value.charAt(0) == '0' && l ==10) {
	//	            	ageField.setEditable(true);
	//	               label.setText("");
	//	            } else {
	//	            	ageField.setEditable(false);
	//	               label.setText("* Enter only numeric digits(0-9)");
	//	            }
	//	         }
	//	      });
			
			//User Tablemouse listener
			this.doctorList.addMouseListener(new MouseListener() {
				
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
					int row = 0; 
					if (e.getClickCount()>=2) {
						row = doctorList.getSelectedRow();
						UserController user = new UserController(Integer.parseInt(tableDoctor.getValueAt(row, 0).toString()), tableDoctor.getValueAt(row, 1).toString(), tableDoctor.getValueAt(row, 2).toString(), tableDoctor.getValueAt(row, 6).toString(), tableDoctor.getValueAt(row, 4).toString(), tableDoctor.getValueAt(row, 5).toString(),"",  Integer.parseInt(tableDoctor.getValueAt(row, 3).toString()));
						int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet utilisateur ?", 
								"Suppression de l'utilisateur", JOptionPane.YES_NO_OPTION); 
						if (reponse == 0) {
							//suppression dans la BDD
							user.Delete();
							tableDoctor.removeRow(row);
							//suppression dans l'affichage de la table 
							//tableDoctor.supprimerLigne(row);
							userNumber.setText("Nombre de médecin disponibles :" + tableDoctor.getRowCount());
						}
					}
					else {
						row = doctorList.getSelectedRow();
						String idUser = tableDoctor.getValueAt(row, 0).toString();
						String firstName = tableDoctor.getValueAt(row, 1).toString(); 
						String lastName = tableDoctor.getValueAt(row, 2).toString(); 
						String address = tableDoctor.getValueAt(row, 5).toString();
						String age = tableDoctor.getValueAt(row, 3).toString(); 
						String mail = tableDoctor.getValueAt(row, 4).toString(); 
						String role = tableDoctor.getValueAt(row, 6).toString(); 
						//remplissage du formulaire 

						idUserField.setText(idUser); 
						firstNameField.setText(firstName);
						lastNameField.setText(lastName);
						ageField.setText(age);
						mailField.setText(mail);
						addressField.setText(address);
						roleField.setText(role);
						saveButton.setText("Modifier");
					}
					
				}
			});
			//Nombre de matériels dans la table :
			int nbUsers = this.tableDoctor.getRowCount(); 
			userNumber = new JLabel("Nombre de médecins : " + nbUsers, SwingConstants.CENTER);
			userNumber.setBounds(50, 400, 950, 550);
			this.add(userNumber); 
		}
		public Object [][] getData (String filter){
			ArrayList<UserController> userList = UserController.SelectAllDoctors(); 
			Object [][] matrice = new Object[userList.size()][7];
			int i = 0; 
			for (UserController user : userList) {
				matrice [i][0] = user.getIdUser();
				matrice [i][1] = user.getFirstName();
				matrice [i][2] = user.getLastName();
				matrice [i][3] = user.getAge();
				matrice [i][4] = user.getMail();
				matrice [i][5] = user.getAddress(); 
				matrice [i][6] = user.getRole();
				i++;
			}
			return matrice;
		}
		public void clearFields() {
			firstNameField.setText("");
			lastNameField.setText("");
			ageField.setText("");
			mailField.setText("");
			addressField.setText("");
			roleField.setText("");
			saveButton.setText("Enregistrer");
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.cancelButton) {
				clearFields();
			}
			else if (e.getSource() == this.saveButton) {
				int idUser = 0;
				String firstName = this.firstNameField.getText(); 
				String lastName = this.lastNameField.getText(); 
				String address = this.addressField.getText();
				int age =  Integer.parseInt(this.ageField.getText()); 
				String mail = this.mailField.getText(); 
				String role = this.roleField.getText(); 
				UserController user = new UserController (idUser, firstName, lastName, mail, address, "", role, age );
				if(this.saveButton.getText().equals("Modifier")) {
					int row = 0; 
					row = doctorList.getSelectedRow(); 
					user.idUser = Integer.parseInt(tableDoctor.getValueAt(row, 0).toString());
					user.Update();
					Object updatedRow [] = {idUser, firstName, lastName, age, mail, address, role };
					this.tableDoctor.updateTable(row, updatedRow);
					JOptionPane.showMessageDialog(this, "Modification effectuée");
					this.clearFields();
					this.saveButton.setText("Enregistrer");
				} else if(this.saveButton.getText().equals("Enregistrer")) {
					boolean ok = true;
					if(age < 0) {
						JOptionPane.showMessageDialog(this, "Erreur, entrez un âge supérieur à 0");
						this.ageField.setBackground(Color.red);
						ok = false;
					}else {
						this.ageField.setBackground(Color.white);
					}
					if(ok) {
						user.Add();
						JOptionPane.showMessageDialog(this, "Nouvel utilisateur bien créé");
						//récupération de l'ID donné par mysql 
						ArrayList<UserController> userList = UserController.SelectAll();  
						UserController newUser = userList.get(userList.size() - 1);
	//					JOptionPane.showMessageDialog(this, "Matériel inséré avec succés dans la BDD");
	//					//insertion dans l'affichage graphique 
						Object row[]= {newUser.idUser, newUser.firstName, newUser.lastName, newUser.age, newUser.mail, newUser.address, newUser.role};
						this.tableDoctor.addRow(row);
						userNumber.setText("Nombre de médecin :"+tableDoctor.getRowCount());
						this.clearFields();
					}
				} 
			}
		}
	}


























