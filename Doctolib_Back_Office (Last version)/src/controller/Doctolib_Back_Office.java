package controller;
import view.ConnectionView;
import view.GeneralView;

public class Doctolib_Back_Office {
	public static GeneralView GeneralView;
	public static ConnectionView ConnectionView;

	public static void main(String[] args) {
		ConnectionView = new ConnectionView();
		ConnectionView.setVisible(true);
		//PanelAccount.setVisible(true);
	}
	public static void visibleGeneralView(boolean action) {

		GeneralView = new GeneralView();
		GeneralView.setVisible(action);
	}
	public static void visibleConnectionView(boolean action) {
		ConnectionView.setVisible(action);
	}
}