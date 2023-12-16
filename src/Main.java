import frames.DashboardFrame;

public class Main {
	
	// Lanzar la aplicación

	public static void main(String[] args) {
	    try {
	        DashboardFrame frame = new DashboardFrame();
	        frame.setVisible(true);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
