package tpAirFrance;

public class App {
	
	public static void main(String[] arg) {	
		//VolDAO vDAO = new VolDAO();
		//ReservationDAO rDAO = new ReservationDAO();
		//vDAO.createVolDB();
		//rDAO.createResaDB();
		String choice = IHM.showMenu();
		String select = null;
		if(choice.equals("1")) {
			select = IHM.showMenuVol(choice);
			if(select != null && select.equals("1")) {
				IHM.createVol();
			} else if(select.equals("2")) {
				IHM.showVolList();
			} else if (select.equals("3")) {
				IHM.findByInterface();
			}
		}
		else if (choice == "2") {
			// do stuff
		}
		
	}
}
