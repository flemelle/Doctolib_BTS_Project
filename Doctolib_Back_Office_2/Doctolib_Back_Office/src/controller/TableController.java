package controller;

import javax.swing.table.AbstractTableModel;

public class TableController  extends AbstractTableModel{

	private String header []; 
	private Object data[][]; 
	
	public TableController(String[] header, Object[][] data) {
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
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
