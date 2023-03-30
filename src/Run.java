import java.util.*;

public class Run {

	private final static int totalCar_Count = 10;
	
	final static String[] carTypes = {"Jeep", "Bmw", "Lexus", "Honda", "Toyota"}; //just for show purposes, can add more if needed

	public static void main(String[] args) {
		
		ArrayList<Car> carList = new ArrayList<Car>();
		
		for(int i =0; i < totalCar_Count; i++){
			carList.add(randomGenerator());
		}
		
		sortByTrustValue(carList);
		System.out.println("List of cars in the vehicular network...");
		System.out.println(carList + "\n");
		
		//Random car interactions that adjust their trust values
		for(int i=0; i< totalCar_Count; i++) {
			Car carA = carList.get(carPicker());
			Car carB = carList.get(carPicker());
			
			while(carA == carB) {
				carB = carList.get(carPicker());
			}
			
			if(carA.getTrustValue() < 4) {
				System.out.println("Suspicious Trust Value Found in " + carA);
				carA.adjustTrust(lowTrustPicker());
			}
			else {
				carA.adjustTrust(highTrustPicker());
			}
			
			if(carB.getTrustValue() < 4) {
				System.out.println("Suspicious Trust Value Found in " + carB);
				carB.adjustTrust(lowTrustPicker());
			} else {
				carB.adjustTrust(highTrustPicker());
			}
			
		}

		System.out.println("\nList of cars in the vehicular network after simulations...");
		sortByTrustValue(carList);
		System.out.println(carList);

	}
	
	public static double highTrustPicker() {
		Random randVal = new Random();
		Double randomValue = randVal.nextInt(6) + 5.0;
		return randomValue;
	}
	
	public static double lowTrustPicker() {
		Random randVal = new Random();
		Double randomValue = randVal.nextInt(5) + 1.0;
		return randomValue;
	}
	
	public static int carPicker() {
		Random randCar = new Random();
		int randomCar = randCar.nextInt(totalCar_Count);
		return randomCar;
	}
	
	public static Car randomGenerator() {
		Random rand = new Random();
		int trustScore = rand.nextInt(10); //Trust scores from 0-10 . Can be changed if anything
		int carVal = rand.nextInt(4); //5 car types, 0-4 indexes. ****Must change if more carTypes are added!
		int lPlate = rand.nextInt(10000); //create random license Plate #
		String carType = carTypes[carVal];
			
		return new Car(trustScore, carType, lPlate);
	}
	
	//descending order. Greatest -> Least (1st element in list has greatest trust val)
	public static void sortByTrustValue(ArrayList<Car> carList) {
		Collections.sort(carList, new Comparator<Car>() {
			@Override
			public int compare(Car car1, Car car2) {
				// Sort in descending order of trustValue
				if (car1.getTrustValue() < car2.getTrustValue()) 
					return 1;
				  else if (car1.getTrustValue() > car2.getTrustValue()) 
					return -1;
				  else 
					return 0;
			}
		});
	}
	
}