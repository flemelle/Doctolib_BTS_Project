package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.UserController;

public class PanelAccount extends PanelModel implements ActionListener {
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
	
	PanelAccount() {
		//this.setBackground(new Color(0, 55, 0));
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
	}
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.cancelButton) {
			//clearFields();
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
				row = patientList.getSelectedRow(); 
				idUser = Integer.parseInt(tablePatient.getValueAt(row, 0).toString());
				user.Update();
				Object updatedRow [] = {idUser, firstName, lastName, age, mail, address, role };
				this.tablePatient.updateTable(row, updatedRow);
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
					this.tablePatient.addRow(row);
					userNumber.setText("Nombre de matériels disponibles :"+tablePatient.getRowCount());
					this.clearFields();
				}
			} 
		}
	}

	public Object [] getData (String filter){
		//TO DO
		UserController user = UserController.Select(15); 
		return user;
	}
	
}
