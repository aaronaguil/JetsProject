package Jets;

import java.util.Scanner;

public class JetTest {

	static Jet[] jets;
	static Hangar[] hangars;
	static Pilot[] pilots;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// initialize arrays
		jets = new Jet[5];
		hangars = new Hangar[5];
		pilots = new Pilot[5];

		// create pilots and store them in the array
		pilots[0] = new Pilot("Aaron", "Aguil", "O-3");
		pilots[1] = new Pilot("Andrew", "Conlin", "O-3");
		pilots[2] = new Pilot("Kris", "Kane", "O-3");
		pilots[3] = new Pilot("Rob", "Roselius", "O-3");
		pilots[4] = new Pilot("Jaime", "Romero", "O-3");

		// create jets and store them in the array
		jets[0] = new Jet("F-16", 500F, 20000.0F, pilots[0]);
		jets[1] = new Jet("F-17", 400.0F, 40000.0F, pilots[1]);
		jets[2] = new Jet("A-10", 800.0F, 80000.0F, pilots[2]);
		jets[3] = new Jet("F-18", 450.0F, 70000.0F, pilots[3]);
		jets[4] = new Jet("F-22", 600.0F, 95000.0F, pilots[4]);

		//add jets to pilot
		pilots[0].addJet(jets[0]);
		pilots[1].addJet(jets[1]);
		pilots[2].addJet(jets[2]);
		pilots[3].addJet(jets[3]);
		pilots[4].addJet(jets[4]);
		
		// create hangars and store jets in hangars
		for (int i = 0; i < hangars.length; i++) {
			hangars[i] = new Hangar();
			for (Jet j : jets) {
				hangars[i].addJet(j);
			}
		}

		printMenu(scanner);

	}

	// print selection menu
	public static void printMenu(Scanner scanner) {
		System.out.println("___________________________________");
		System.out.println("|___Choose One Of The Following___|");
		System.out.println("|                                 |");
		System.out.println("|Options:                         |");
		System.out.println("|[1]....................List Fleet|");
		System.out.println("|[2]..............View Fastest Jet|");
		System.out.println("|[3]...View Jet with Longest Range|");
		System.out.println("|[4]...........Create a Custom Jet|");
		System.out.println("|[5]..............Create New Pilot|");
		System.out.println("|[6].............List Jet By Pilot|");
		System.out.println("|[7]..........Add Pilot to New Jet|");
		System.out.println("|[8]..................Exit Program|");
		System.out.println("___________________________________");
		String selection = scanner.next();

		// switch based on user selection
		switch (selection) {
		case "1":
			listFleet(scanner);
			break;
		case "2":
			fastestJet(scanner);
			break;
		case "3":
			longestRange(scanner);
			break;
		case "4":
			addJet(scanner);
			break;
		case "5": createNewPilot(scanner);
			break;
		case "6": listJetByPilot(scanner);
		break;
		case "7": addPilotToJet(scanner);
			break;
		case "8":
			break;
		default:
			System.err.println("You have not entered a valid selection!");
			printMenu(scanner);
		}

	}

	// list all jets
	public static void listFleet(Scanner scanner) {
		for (Jet j : jets) {
			System.out.println("***************************");
			System.out.println("Model: " + j.getModel());
			System.out.println("Speed (MPH): " + j.getSpeedMph());
			System.out.println("Speed (Mach): " + j.getSpeedMach());
			System.out.println("Range: " + j.getRange());
			for (Pilot p : j.getPilots()) {
				System.out.println("Pilot\tName: " + p.getFirstName() + " " + p.getLastName());
				System.out.println("\tRame: " + p.getRank());	
			}
		}
		System.out.println("***************************");
		System.out.println();
		printMenu(scanner);
	}

	// list fastest jet
	public static void fastestJet(Scanner scanner) {
		// create jet object to store fastest jet
		Jet fastest = jets[0];
		for (Jet j : jets) {
			// if speed of current jet is less than the next, store the next
			// element as the fastest jet
			if (fastest.getSpeedMach() < j.getSpeedMach()) {
				fastest = j;
			}
		}
		System.out.println("***************************");
		System.out.println("********Fastest Jet********");
		System.out.println("Model: " + fastest.getModel());
		System.out.println("Speed (MPH): " + fastest.getSpeedMph());
		System.out.println("Speed (Mach): " + fastest.getSpeedMach());
		System.out.println("Range: " + fastest.getRange());
		for (Pilot p : fastest.getPilots()) {
			System.out.println("Pilot\tName: " + p.getFirstName() + " " + p.getLastName());
			System.out.println("\tRame: " + p.getRank());	
		}
		System.out.println("***************************");
		printMenu(scanner);
	}

	// find the jet with the longest range
	public static void longestRange(Scanner scanner) {
		// create new jet object to store the jet with longest range
		Jet longestRange = jets[0];
		for (Jet j : jets) {
			// if range of current jet is less than the next, store the next
			// element as the fastest jet
			if (longestRange.getRange() < j.getRange()) {
				longestRange = j;
			}
		}
		System.out.println("***************************");
		System.out.println("*******Longest Range*******");
		System.out.println("Model: " + longestRange.getModel());
		System.out.println("Speed (MPH): " + longestRange.getSpeedMph());
		System.out.println("Speed (Mach): " + longestRange.getSpeedMach());
		System.out.println("Range: " + longestRange.getRange());
		for (Pilot p : longestRange.getPilots()) {
			System.out.println("Pilot\tName: " + p.getFirstName() + " " + p.getLastName());
			System.out.println("\tRame: " + p.getRank());	
		}
		System.out.println("***************************");
		printMenu(scanner);
	}

	// add new jet to the fleet
	public static void addJet(Scanner scanner) {
		// create new array that is one element bigger than the previous array
		// of jets
		Jet[] newJetList = new Jet[jets.length + 1];
		// store the old list of jets into the new list
		// the last element of the new list will be empty
		for (int i = 0; i < jets.length; i++) {
			newJetList[i] = jets[i];
		}

		System.out.println("Please enter the model of the Jet");
		String model = scanner.nextLine();
		model = scanner.nextLine();
		System.out.println("Please enter the speed of the Jet");
		float speed = scanner.nextFloat();
		System.out.println("Please enter the range of the Jet");
		float range = scanner.nextFloat();

		System.out.println("Which pilot would you like to assign to this Jet");
		for (int i = 0; i < pilots.length; i++) {
			System.out.println("[" + (i + 1) + "] " + pilots[i].getFirstName() + " " + pilots[i].getLastName() + "("
					+ pilots[i].getRank() + ")");
		}
		int pilotSelection = scanner.nextInt();

		// create a new jet based on the user input
		Jet j = new Jet(model, speed, range, pilots[pilotSelection - 1]);
		pilots[pilotSelection-1].addJet(j);
		// add the new jet to the last element of the array
		newJetList[jets.length] = j;

		// set the newList to the oldList
		jets = newJetList;

		printMenu(scanner);
	}
	
	//list jets by pilot
	public static void listJetByPilot(Scanner scanner){
		System.out.println("Please select the Pilot");
		for (int i = 0; i<pilots.length; i++) {
			System.out.println("[" + (i+1) + "] " + pilots[i].getFirstName() + " " + pilots[i].getLastName());
		}
		int selection = scanner.nextInt();
		
		//print jets that pilot are assigned to
		for(Jet j : pilots[selection-1].getJets()){
			System.out.println("***************************");
			System.out.println("*************Jet***********");
			System.out.println("Model: " + j.getModel());
			System.out.println("Speed (MPH): " + j.getSpeedMph());
			System.out.println("Speed (Mach): " + j.getSpeedMach());
			System.out.println("Range: " + j.getRange());
			System.out.println("***************************");		}
		printMenu(scanner);
	}
	
	//create new Pilot
	public static void createNewPilot(Scanner scanner) {
		//create array list that is one element bigger 
		Pilot[] newPilotList = new Pilot[pilots.length+1];
		
		//store old list of pilots into new list of pilots
		for(int i = 0; i<pilots.length; i++){
			newPilotList[i] = pilots[i];
		}
		
		//ask for new pilot info
		System.out.println("Please enter the first name of the Pilot");
		String firstName = scanner.next();
		System.out.println("Please enter the last name of the Pilot");
		String lastName = scanner.next();
		System.out.println("Please enter the rank of the Pilot");
		String rank = scanner.next();
		
		System.out.println("Would you like to assign this pilot to a jet");
		String yesNo = scanner.next();
		
		Jet assignedJet = new Jet();
		
		//if yes, assign jet to pilot
		if(yesNo.equals("y")){
			System.out.println("Please select the Jet that you would like to assign " + firstName + " " + lastName + " to.");
			for (int i = 0; i<jets.length; i++) {
				System.out.println("[" + (i+1) + "] " + jets[i].getModel());
			}
			int selection = scanner.nextInt();
			Pilot p = new Pilot(firstName, lastName, rank);
			p.addJet(jets[selection-1]);
			
			//assign pilot to jet
			jets[selection-1].addPilot(p);
		
			newPilotList[pilots.length] = p;
		}
		else{
			Pilot p = new Pilot(firstName, lastName, rank);
			newPilotList[pilots.length] = p;
		}
		//set new list to pilots array
		pilots = newPilotList;
		printMenu(scanner);
	}
	
	//assign pilot to new jet
	public static void addPilotToJet(Scanner scanner){
		System.out.println("Please select the Pilot");
		for (int i = 0; i<pilots.length; i++) {
			System.out.println("[" + (i+1) + "] " + pilots[i].getFirstName() + " " + pilots[i].getLastName());
		}
		int pilotSelection = scanner.nextInt();
		System.out.println("Please select the Jet");
		for (int i = 0; i<jets.length; i++) {
			System.out.println("[" + (i+1) + "] " + jets[i].getModel());
		}
		int jetSelection = scanner.nextInt();
		
		boolean contains = false;
		for (Jet j : pilots[pilotSelection-1].getJets()) {
			if(j.equals(jets[jetSelection-1])){
				contains = true;
			}
		}
		if(!contains){			
			jets[jetSelection-1].addPilot(pilots[pilotSelection-1]);
			pilots[pilotSelection-1].addJet(jets[jetSelection-1]);
		}
		else{
			System.out.println(pilots[pilotSelection-1].getFirstName() + " " + pilots[pilotSelection-1].getLastName() + " is already signed to " + jets[jetSelection-1].getModel());
			System.out.println();
			addPilotToJet(scanner);
		}
		
		printMenu(scanner);
	}
}
