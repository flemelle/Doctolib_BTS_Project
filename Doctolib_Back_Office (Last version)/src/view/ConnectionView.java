package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Doctolib_Back_Office;
import controller.UserController;
import model.SelectModel;

public class ConnectionView extends JFrame implements ActionListener, KeyListener{
	private JTextField loginField = new JTextField("admin@admin.admin");
	private JPasswordField passwordField = new JPasswordField("admin");
	private JButton connectionButton = new JButton("Connexion");
	private JButton cancelButton = new JButton("Annuler");
	private JPanel connectionPanel = new JPanel();
	private EmptyBorder connectionPanelBorder = new EmptyBorder(0, 50, 50, 50);
	
	public ConnectionView() {
		this.setTitle("Administration Doctolib");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500, 500, 700, 500);
		this.getContentPane().setBackground(new Color ( 255, 255, 255));
		this.setLayout(new GridLayout(2, 1));
		this.setResizable(false);
		
		//Logo Panel
		ImageIcon logo = new ImageIcon("src/pictures/Logo_Doctolib.svg.png");
		JLabel LabelLogo = new JLabel(logo);
		LabelLogo.setBounds(20, 40, 220, 220);
		this.add(LabelLogo); 
		
		//Connection Panel
		connectionPanel.setBounds(260, 40, 300, 200);
		connectionPanel.setBackground(new Color ( 255, 255, 255));
		connectionPanel.setLayout(new GridLayout(3, 2));
		connectionPanel.add(new JLabel("Email : ")); 
		connectionPanel.add(this.loginField); 
		connectionPanel.add(new JLabel("Mot de passe :")); 
		connectionPanel.add(this.passwordField); 
		connectionPanel.add(this.cancelButton); 
		connectionPanel.add(this.connectionButton); 
		connectionPanel.setBorder(connectionPanelBorder);
		connectionPanel.setVisible(true);
		this.add(connectionPanel); 
		
		//Button listener
		this.connectionButton.addActionListener(this);
		this.cancelButton.addActionListener(this);
		
		//Field Listener
		this.loginField.addKeyListener(this);
		this.passwordField.addKeyListener(this);
		
	}
	public void inputVerification() {
		//Input into values
		String mail = this.loginField.getText();
		String password = new String(this.passwordField.getPassword());
		
		UserController user = SelectModel.VerifyCredential(mail, password);
		if (user == null) {
			JOptionPane.showMessageDialog(this, "Identifiants incorrectes");
//			this.loginField.setText("");
//			this.passwordField.setText("");
		}else {
			//on lance la vue générale et on réduit la vue connexion 
			Doctolib_Back_Office.visibleGeneralView(true);
			Doctolib_Back_Office.visibleConnectionView(false);
		}	
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==this.cancelButton) {
			this.loginField.setText("");
			this.passwordField.setText("");
		}
		else if (e.getSource() == this.connectionButton) {
			this.inputVerification();
		}
		
	}
}
