package Jets;

public class Jet {
    private String model;
    private float speedMph;
    private float speedMach;
    private float range;
    private Pilot pilot;
    
    public Jet(){
    	
    }
    
    public Jet(String mod, float sp, float rg, Pilot p) {
        setModel(mod);
        setSpeedMph(sp);
        convertSpeedToMach(sp);
        setRange(rg);
        pilot = p;
        pilot.setJet(this);
    }

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

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public void convertSpeedToMach(float s){
		speedMach = s;
	}
	
	@Override
	public String toString() {
		return "Jet [model=" + model + ", speedMph=" + speedMph + ", speedMach=" + speedMach + ", range=" + range
				+ "]";
	}

}