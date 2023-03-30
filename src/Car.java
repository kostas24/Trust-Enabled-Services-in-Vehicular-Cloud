
public class Car {
	private double trustValue;
	private String carType;
	private int lPlate;

	public Car(double trustValue, String carType, int lPlate) {
		super();
		this.trustValue = trustValue;
		this.carType = carType;
		this.lPlate = lPlate;
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

	public void adjustTrust(Double newTrust) {
		this.trustValue = (this.trustValue + newTrust) / 2;
	}

	@Override
	public String toString() {
		return "LPlate: " +lPlate+ " Car: " + carType + " trustValue = " + trustValue;
	}

}
