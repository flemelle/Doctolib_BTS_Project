package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelAppointments extends PanelModel{
	private JButton pageBtn = new JButton("appointment");
	public PanelAppointments() {
		this.setBackground(new Color(100, 0, 55));
		this.setBounds(40, 40, 900, 400);
		this.setLayout(null);
		this.setVisible(false);
		this.add(pageBtn);
	}
}
