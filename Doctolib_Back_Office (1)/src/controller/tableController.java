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

	@Override
	public int getRowCount() {
		 
		return this.data.length; 
	}

	@Override
	public int getColumnCount() {
		 
		return this.header.length; 
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		 
		return this.data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return this.header[column];
	}

	public int getSelectedRow() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
