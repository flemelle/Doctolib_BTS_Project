package controller;

import javax.swing.table.AbstractTableModel;

public class tableController extends AbstractTableModel{

	private String header []; 
	private Object data[][]; 
	
	public tableController(String[] header, Object[][] data) {
		super();
		this.setHeader(header);
		this.setData(data);
	}

	public String[] getHeader() {
		return header;
	}

	public void setHeader(String header[]) {
		this.header = header;
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object data[][]) {
		this.data = data;
	}

	
	public int getRowCount() {
		 
		return this.data.length; 
	}

	
	public int getColumnCount() {
		 
		return this.header.length; 
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {
		 
		return this.data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return this.header[column];
	}

	// public int getSelectedRow() {
	// 	// TODO Auto-generated method stub
	// 	return 0;
	// }
	public void addRow(Object row[]) {
		Object matrice [][] = new Object [this.data.length+1][this.header.length];
		//on recopie les donnees dans la matrice 
		for (int i=0; i <this.data.length; i++) {
			matrice [i] = this.data[i]; 
		}
		//on ajoute la ligne dans la matrice 
		matrice [this.data.length] = row;
		//on ecrase les données par la nouvelle matrice
		this.data = matrice; 
		//on applique les changements 
		this.fireTableDataChanged();
	}
	public void removeRow(int row) {
		Object matrice [][] = new Object [this.data.length-1][this.header.length];
		//on recopie les donnees dans la matrice 
		int j = 0; 
		for (int i=0; i <this.data.length; i++) {
			if(i != row) {
					matrice [j] = this.data[i]; 
					j++;
			}
		}
		//on ecrase les données par la nouvelle matrice
		this.data = matrice; 
		//on applique les changements 
		this.fireTableDataChanged();
	}
	public void updateTable(int rowNumber, Object row []) {
		Object matrice [][] = new Object [this.data.length][this.header.length];
		//on recopie les donnees dans la matrice 
		int j = 0; 
		for (int i=0; i <this.data.length; i++) {
			if(i != rowNumber) {
					matrice [j] = this.data[i]; 
					j++;
			}else {
				matrice [j] = row; 
				j++;
			}
		}
		//on ecrase les données par la nouvelle matrice
		this.data = matrice; 
		//on applique les changements 
		this.fireTableDataChanged();
	}
	
}
