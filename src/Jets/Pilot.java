package Jets;

public class Pilot {
	
	private String firstName;
	private String lastName;
	private Jet[] jets = new Jet[0];
	private String rank;
	
	//Constructors
	public Pilot(){
		this.firstName = "First Name";
		this.lastName = "Last Name";
		this.rank = "O1";
	}
	
	public Pilot(String firstName, String lastname, String rank) {
		this.firstName = firstName;
		this.lastName = lastname;
		this.rank = rank;
	}

	//Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Jet[] getJets() {
		return jets;
	}

	public void setJets(Jet[] jet) {
		this.jets = jet;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	//add Jet
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
	
	//toString
	@Override
	public String toString() {
		return "Pilot [firstName=" + firstName + ", lastName=" + lastName + ", rank=" + rank + "]";
	}
	
	
	

}
