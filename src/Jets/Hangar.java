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
		if(jets.length==0){
			jets = new Jet[1];
			jets[0] = newJet;
		}
		else{		
			Jet[] newJetList = new Jet[jets.length+1];
			for(int i = 0; i<jets.length; i++){
				newJetList[i] = jets[i];
			}
			newJetList[jets.length] = newJet;
			jets = newJetList;
		}
	}
	
	//delete Jet from Hangar
	public void deleteJet(int index){
		Jet[] newJetList = new Jet[jets.length-1];
		for(int i = 0; i<index; i++){
			newJetList[i] = jets[i];
		}
		for(int i = index+1; i<jets.length; i++){
			newJetList[i-1] = jets[i];
		}
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
