package Jets;

public class Pilot {
	
	private String firstName;
	private String lastName;
	private Jet jet;
	private String rank;
	
	//Constructors
	public Pilot(){
		this.firstName = "First Name";
		this.lastName = "Last Name";
		this.jet = new Jet();
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

	public Jet getJet() {
		return jet;
	}

	public void setJet(Jet jet) {
		this.jet = jet;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	//toString
	@Override
	public String toString() {
		return "Pilot [firstName=" + firstName + ", lastName=" + lastName + ", jet=" + jet + ", rank=" + rank + "]";
	}
	
	
	

}
