package Jets;

import java.util.Arrays;

public class Hangar {

	Jet[] jets = new Jet[0];
	
	//Constructors
	public Hangar(){

	}
	
	public Hangar(Jet[] jets) {
		super();
		this.jets = jets;
	}

	//Getters and Setters
	public Jet[] getJets() {
		return jets;
	}
	
	//add Jet to Hangar
	public void addJet(Jet newJet){
		//if array length is 0, create new array of length ONE and add new jet
		if(jets.length==0){
			jets = new Jet[1];
			jets[0] = newJet;
		}
		//otherwise create new array list that is one element bigger
		else{		
			Jet[] newJetList = new Jet[jets.length+1];
			//store the oldlist of jets in the new list
			for(int i = 0; i<jets.length; i++){
				newJetList[i] = jets[i];
			}
			//store the new jet in the last spot of the array
			newJetList[jets.length] = newJet;
			
			//set the new list to jetsArray
			jets = newJetList;
		}
	}
	
	//delete Jet from Hangar
	public void deleteJet(int index){
		
		//create new array that is one element smaller
		Jet[] newJetList = new Jet[jets.length-1];
		
		//iterate through array UP TO THE INDEX and store the elements of the old array into the new array
		for(int i = 0; i<index; i++){
			newJetList[i] = jets[i];
		}
		
		//skipping the INDEX add the rest of the elements of the old array in the new array
		for(int i = index+1; i<jets.length; i++){
			newJetList[i-1] = jets[i];
		}
		
		//set the new list to jetsArray
		jets = newJetList;
		
		
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}

	//toString
	@Override
	public String toString() {
		return "Hangar [jets=" + Arrays.toString(jets) + "]";
	}
	
	
	
	
}
