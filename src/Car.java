
public class Car {
	private double trustValue;
	private String carName;

	public Car(double trustValue, String carName) {
		super();
		this.trustValue = trustValue;
		this.carName = carName;
	}

	public double getTrustValue() {
		return trustValue;
	}

	public void setTrustValue(double trustValue) {
		this.trustValue = trustValue;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "Car: " + carName + " trustValue= " + trustValue;
	}

}
