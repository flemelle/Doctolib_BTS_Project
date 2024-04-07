package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelAccount extends PanelModel implements ActionListener {
	private JTextArea accountDataInput = new JTextArea();
	private JButton saveButton = new JButton("Enregistrer");
	private JButton updateButton = new JButton("Modifier");
	private JButton cancelButton = new JButton("Annuler");
	private JPanel accountDataForm = new JPanel();
	JTextField inputId = new JTextField();
	JTextField inputFirstName = new JTextField();
	JTextField inputLastName = new JTextField();
	JTextField inputMail = new JTextField();
	JTextField inputAge = new JTextField();
	JTextField inputAdress = new JTextField();
	JTextField inputPassword = new JTextField();
	JTextField inputRole = new JTextField();
	
	PanelAccount() {
		//this.setBackground(new Color(0, 55, 0));
		this.accountDataForm.setLayout(new GridLayout(10, 2));
		this.accountDataForm.setBounds(60, 40, 800, 400);
		this.accountDataForm.add(new JLabel ("Id : "));
		this.accountDataForm.add(this.inputId);
		this.accountDataForm.add(new JLabel ("Nom : "));
		this.accountDataForm.add(this.inputLastName);
		this.accountDataForm.add(new JLabel ("Prénom : "));
		this.accountDataForm.add(this.inputFirstName);
		this.accountDataForm.add(new JLabel ("Mail : "));
		this.accountDataForm.add(this.inputMail);
		this.accountDataForm.add(new JLabel ("Âge : "));
		this.accountDataForm.add(this.inputAge);
		this.accountDataForm.add(new JLabel ("Adresse : "));
		this.accountDataForm.add(this.inputAdress);
		this.accountDataForm.add(new JLabel ("Mot de passe : "));
		this.accountDataForm.add(this.inputPassword);
		this.accountDataForm.add(new JLabel ("Rôle : "));
		this.accountDataForm.add(this.inputRole);
		this.accountDataForm.add(this.cancelButton);
		this.accountDataForm.add(this.saveButton);
		this.add(this.accountDataForm);
		this.accountDataForm.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
