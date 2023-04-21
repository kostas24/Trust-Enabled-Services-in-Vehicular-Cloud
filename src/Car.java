
public class Car {
	private double trustValue;
	private String carType;
	private int lPlate;
	private int susCounter;
	Boolean overseer = false;

	public Car(double trustValue, String carType, int lPlate, int susCounter) {
		super();
		this.trustValue = trustValue;
		this.carType = carType;
		this.lPlate = lPlate;
		this.susCounter = susCounter;
	}
	
	public void setOverseer() {
		this.overseer = true;
	}
	
	public Boolean getOverseer() {
		return overseer;
	}

	public double getTrustValue() {
		return trustValue;
	}

	public void setTrustValue(double trustValue) {
		this.trustValue = trustValue;
	}

	public String getcarType() {
		return carType;
	}

	public void setcarType(String carType) {
		this.carType = carType;
	}

	public int getLPlate(){
		return lPlate;
	}
	
	public int getSusCounter() {
		return susCounter;
	}
	
	public void increaseSus() {
		this.susCounter++;
	}

	public void adjustTrust(Double newTrust) {
		this.trustValue = (this.trustValue + newTrust) / 2;
	}

	@Override
	public String toString() {
		return "LPlate: " +lPlate+ " Car: " + carType + " trustValue = " + trustValue + "Sus count = " + susCounter;
	}

}
