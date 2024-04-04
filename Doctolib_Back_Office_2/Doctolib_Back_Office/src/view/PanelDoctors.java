package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class PanelDoctors extends PanelModel{
	private JTable doctorList = new JTable();
	public PanelDoctors() {
		this.setBackground(new Color(0, 0, 55));
	}
}
