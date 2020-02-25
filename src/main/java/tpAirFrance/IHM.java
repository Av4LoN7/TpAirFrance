package tpAirFrance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import dao.VolDAO;

public class IHM {

	static Scanner sc = new Scanner(System.in);
	static VolDAO vdao = new VolDAO();

	/**
	 * display run menu
	 * @return
	 */
	public static String showMenu() {
		boolean endLoop = false;
		while (!endLoop) {
			System.out.println("1 - Gestion des vols \n");
			System.out.println("2 - Gestion des réservations \n");
			System.out.println("3 - Quitter \n");
			System.out.println("Entrez votre choix : \n");

			try {
				String str = sc.nextLine();
				switch (Integer.parseInt(str)) {
				case 1:
					// go to gestion vol
					endLoop = true;
					return str;
				case 2:
					// go to gestion res
					endLoop = true;
					return str;
				case 3:
					return null;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Nous n'avons pas compris votre choix veuillez recommencer : \n");
			}
		}
		return null;
	}

	/**
	 * display menu for first choice
	 * @param str
	 * @return
	 */
	public static String showMenuVol(String str) {
		boolean endLoop = false;
		while (!endLoop) {
			System.out.println("Menu des vols :\n");
			System.out.println("1 - Création d'un vol \n");
			System.out.println("2 - Liste des vols \n");
			System.out.println("3 - Rechercher un vol \n");
			System.out.println("4 - Quitter \n");

			try {
				str = sc.nextLine();
				switch (Integer.parseInt(str)) {
				case 1:
					endLoop = true;
					return str;
				case 2:
					// go to liste des vols
					endLoop = true;
					return str;

				case 3:
					endLoop = true;
					return str;
				case 4:
					endLoop = true;
					return null;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Nous n'avons pas compris votre choix veuillez recommencer : \n");
			}
		}
		return null;
	}

	/**
	 * create a vol by user input
	 */
	public static void createVol() {

		String numVolTemp = null;
		String typeAv = null;
		String villeDep = null;
		String villeArr = null;
		LocalDate dateV = null;
		int nbPlace = 0;
		
		try {
			System.out.println("Création d'un vol :\n");
			numVolTemp = numVol();
			if (numVolTemp != null) {
				System.out.println("Entrer le type d'avion (A330, A340, A380, B747) :\n");
				typeAv = selectType();
				if(typeAv != null) {
					System.out.println("Ajouter la ville de départ");
					String str3 = sc.nextLine();
					if(str3.trim() != "") {
						villeDep = str3;
						if(villeDep != null) {
							System.out.println("Ajouter la ville d'arrivé");
							String str4 = sc.nextLine();
							if (str4.length() > 2 && str4 != null) {
								villeArr = str4;
							}
							if(villeArr != null) {
								System.out.println("Ajouter le nombre de place :\n");
								int place = sc.nextInt();
								if (place != 0) {
									nbPlace = place;
								}
							}
							
						}
					}
				}
			}	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(nbPlace > 0) {
			System.out.println("ajouter la date de depart ( ex: 12-01-2012) :\n");
			try {
				String str5 =  sc.next();
				if (str5 != null) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					dateV = LocalDate.parse(str5, formatter);
				}
			}catch(Exception e ) {
				System.out.println(e.getMessage());
			}
			
		}
		// send for persistence
		vdao.createAVol(numVolTemp, typeAv, nbPlace, villeDep, villeArr, dateV);
	}
	
	public static String selectType() {
		boolean endLoop = false;
		while (!endLoop) {
			// ajout du type d'avion
			String str2 = sc.nextLine();
			if (assignType(str2)) {
				endLoop = true;
				return str2;
			} else {
				System.out.println("le type de votre avion ne correspond pas à ceux existant");
			}
		}
		return null;
	}

	public static boolean testNumVol(String str) {
		if (str.length() == 4 && str.trim() != "") {
			if (vdao.findVol(str)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean assignType(String str) {
		switch (str.trim()) {
		case "A330":
			return true;
		case "A340":
			return true;
		case "A380":
			return true;
		case "B747":
			return true;
		default:
			return false;
		}
	}

	public static String numVol() {
		boolean endLoop = false;
		String numTemp = null;
		while (!endLoop) {
			// ajout du numero de vol
			System.out.println("Numéro de vol (ex: 0001) :\n");
			String str = sc.nextLine();
			if (!testNumVol(str)) {
				numTemp = str;
				endLoop = true;
			} else {
				System.out.println("le numero de vol saisi est déjà utiliser. veuillez en choisir un autre :\n");
			}
		}
		return numTemp;
	}
	
	public static void showVolList() {
		System.out.println("Numéro | Type | Place | Départ | Arrivé | Date \n");
		for( Vol vol : vdao.getAllVol()) {
			System.out.print(vol.getNumVol() + " |" + vol.getTypeAvion() + " |" + vol.getNumPlace() + " |" + vol.getVilleDep() + " |" + vol.getVilleArr() + " |" + vol.getDate() + "\n");
		}
	}
	
	public static void findByInterface() {
		System.out.println("Comment voulez vous rechercher votre avion ?");
		System.out.println("1 - par numéro de vol \n");
		System.out.println("2 - par ville de départ et arrivé \n");
		int check = sc.nextInt();
	}
	
	public static void fByNumber() {
		System.out.println("Entrez le numéro du vol recherché : \n");	
		try {
			String str = sc.nextLine();
			if(str.trim() != "") {
				List<Vol> volTemp = vdao.findVolByNumber(str);
				if(volTemp != null) {
					for(Vol vol: volTemp) {
						System.out.print(vol.getNumVol() + " |" + vol.getTypeAvion() + " |" + vol.getNumPlace() + " |" + vol.getVilleDep() + " |" + vol.getVilleArr() + " |" + vol.getDate() + "\n");
					}
				} else {
					System.out.println("Vol non trouvé, veuillez recommencer : \n");
					findByInterface();
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
