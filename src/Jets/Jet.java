package Jets;

import java.text.DecimalFormat;

public class Jet {
    private String model;
    private float speedMph;
    private float speedMach;
    private float range;
    private Pilot[] pilots = new Pilot[0];
    
    //constructors
    public Jet(){
    	
    }
    
    public Jet(String mod, float sp, float rg, Pilot p) {
        setModel(mod);
        setSpeedMph(sp);
        convertSpeedToMach(sp);
        setRange(rg);
        addPilot(p);
    }

    
    //Getters and Setters
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getSpeedMph() {
		return speedMph;
	}

	public void setSpeedMph(float speedMph) {
		this.speedMph = speedMph;
	}

	public float getSpeedMach() {
		return speedMach;
	}

	public void setSpeedMach(float speedMach) {
		this.speedMach = speedMach;
	}

	public float getRange() {
		return range;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public Pilot[] getPilots() {
		return pilots;
	}

	public void setPilots(Pilot[] pilot) {
		this.pilots = pilot;
	}

	public void convertSpeedToMach(float s){
		DecimalFormat dec = new DecimalFormat("#.##");
		
		speedMach = Float.valueOf(dec.format(speedMph / (0.447f * 340.29f)));

	}
	
	//add Pilot
	public void addPilot(Pilot newPilot){
		//if array length is 0, create new array of length ONE and add new jet
		if(pilots.length==0){
			pilots = new Pilot[1];
			pilots[0] = newPilot;
		}
		//otherwise create new array list that is one element bigger
		else{		
			Pilot[] newPilotList = new Pilot[pilots.length+1];
			//store the oldlist of jets in the new list
			for(int i = 0; i<pilots.length; i++){
				newPilotList[i] = pilots[i];
			}
			//store the new jet in the last spot of the array
			newPilotList[pilots.length] = newPilot;
			
			//set the new list to jetsArray
			pilots = newPilotList;
		}
	}
	
	//toString
	@Override
	public String toString() {
		return "Jet [model=" + model + ", speedMph=" + speedMph + ", speedMach=" + speedMach + ", range=" + range
				+ "]";
	}

}