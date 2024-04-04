package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.UserController;
import controller.tableController;
import model.DeleteModel;
import model.SelectModel;

public class PanelPatients extends PanelModel implements ActionListener{
	private JPanel mainContainer = new JPanel();
	private JTable patientList;
	private JScrollPane tableScrollPanel;
	private tableController tablePatient;
	

	private JPanel formUserPanel = new JPanel(); 
	private JTextField idUserField = new JTextField(); 
	private JTextField firstNameField = new JTextField();
	private JTextField lastNameField = new JTextField();
	private JTextField ageField = new JTextField();
	private JTextField mailField = new JTextField();
	private JTextField addressField = new JTextField();
	private JTextField passwordField = new JTextField();
	private JTextField roleField = new JTextField();
	private JButton cancelButton = new JButton("Annuler"); 
	private JButton saveButton= new JButton("Enregistrer");
	private JLabel label;
	
	private JLabel userNumber;
	//private JComboBox<String> cathegoryList = new JComboBox<String>();
	public PanelPatients() {
		this.setBackground(new Color(0, 100, 100));
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
		String header [] = {"idUser", "firstName", "lastName", "age", "mail", "address", "password", "role"};
		this.tablePatient = new tableController(header, this.getData(""));
		this.patientList = new JTable(this.tablePatient); 
		this.tableScrollPanel = new JScrollPane(this.patientList); 
		this.tableScrollPanel.setBounds(400, 80,400, 220);
		this.add(this.tableScrollPanel); 
		
		//Button listener
		this.saveButton.addActionListener(this);
		this.cancelButton.addActionListener(this);
		
		ageField.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            
	        	 if ()
	        	 String value = ageField.getText();
	            int l = value.length();
	            if (value.charAt(0) == '0' && l ==10) {
	            	ageField.setEditable(true);
	               label.setText("");
	            } else {
	            	ageField.setEditable(false);
	               label.setText("* Enter only numeric digits(0-9)");
	            }
	         }
	      });
		
		//User Tablemouse listener
		this.patientList.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				int row = 0; 
				int idUser; 
				if (e.getClickCount()>=2) {
					row = tablePatient.getSelectedRow(); 
					idUser= Integer.parseInt(tablePatient.getValueAt(row, 0).toString());
					int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce materiel", 
							"Suppression Matérielle", JOptionPane.YES_NO_OPTION); 
					if (reponse == 0) {
						//suppression dans la BDD
						//DeleteModel.DeleteUser(User);
						//suppression dans l'affichage de la table 
						//tablePatient.supprimerLigne(row);
						userNumber.setText("Nombre de matériels disponibles :"+tablePatient.getRowCount());
					}
				}
				else {
					row = tablePatient.getSelectedRow();
					idUser = Integer.parseInt(tablePatient.getValueAt(row, 0).toString());
					String firstName =tablePatient.getValueAt(row, 1).toString(); 
					String lastName =tablePatient.getValueAt(row, 2).toString(); 
					String address =tablePatient.getValueAt(row, 5).toString();
					
					int age = Integer.parseInt(tablePatient.getValueAt(row, 3).toString()); 
					String mail = tablePatient.getValueAt(row, 4).toString(); 
					String password = tablePatient.getValueAt(row, 6).toString(); 
					String role = tablePatient.getValueAt(row, 7).toString(); 
					//remplissage du formulaire 

					//idUserField.setText(user.getIdUser()); 
					firstNameField.setText(firstName);
					lastNameField.setText(lastName);
					//ageField.setText(age);
					mailField.setText(mail);
					addressField.setText(address);
					passwordField.setText(password);
					roleField.setText(role);
					saveButton.setText("Modifier");
				}
				
			}
		});
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
