import java.util.*;

public class Run {

	private final static int totalCar_Count = 10;
	public static int currentCarCount = 10;
	
	final static String[] carTypes = {"Jeep", "Bmw", "Lexus", "Honda", "Toyota"}; //just for show purposes, can add more if needed

	public static void main(String[] args) {
		
		ArrayList<Car> carList = new ArrayList<Car>();
		
		//Generates initial list of cars, two of which will have low trust scores while the rest have high
		
		for(int i =0; i < totalCar_Count; i++){
			if(i<totalCar_Count-2) {
				Car car = randomGenerator();
				System.out.println(car);
				carList.add(car);
			}
			else {
				Car car =  maliceGenerator();
				System.out.println(car);
				carList.add(car);
			}
			
		}
		
		
		
		sortByTrustValue(carList);
		System.out.println("List of cars in the vehicular network...");
		System.out.println(carList + "\n");
		
		ArrayList<Integer> overseers = overseePicker(2);
		for(int overseer: overseers) {
			carList.get(overseer).setTrustValue(10);
			carList.get(overseer).setOverseer();
			System.out.println(carList.get(overseer).toString() + " is overseer"+ "\n");
		}
		
		//Random car interactions that adjust their trust values
		for(int i=0; i < 25; i++) {
			if(carList.size() < 1 ) {
				break;
			}
			Car carA = carList.get(carPicker());
			Car carB = carList.get(carPicker());
			
			while(carA == carB) {
				carB = carList.get(carPicker());
			}
			
			if(carA.getTrustValue() <= 5) {
				System.out.println("Suspicious Trust Value Found in " + carA);
				carA.adjustTrust(lowTrustPicker());
				carA.increaseSus();
				if(carB.getOverseer() == true && carA.getSusCounter() > 1) {
					carList.remove(carA);
					currentCarCount--;
					System.out.println(carA.toString() + "has been isolated");
				}
			}
			else {
				carA.adjustTrust(highTrustPicker());
			}
			
			if(carB.getTrustValue() <= 5) {
				System.out.println("Suspicious Trust Value Found in " + carB);
				carB.adjustTrust(lowTrustPicker());
				carB.increaseSus();
				if(carA.getOverseer() == true && carB.getSusCounter() > 1) {
					carList.remove(carB);
					currentCarCount--;
					System.out.println(carB.toString() + "has been isolated");
				}
			} else {
				carB.adjustTrust(highTrustPicker());
			}
			
		}

		System.out.println("\nList of cars in the vehicular network after simulations...");
		sortByTrustValue(carList);
		System.out.println(carList);
	}
	
	public static ArrayList overseePicker(int overseerCount) {
		ArrayList<Integer> overseers = new ArrayList<Integer>();
		HashSet<Integer> overseersSet = new HashSet<>();
		Random randVal = new Random();
		
		for (int i=0; i<overseerCount; i++) {
			while (overseersSet.size() < overseerCount) {
				int randomValue = randVal.nextInt(totalCar_Count);
				if(!overseersSet.contains(randomValue)) {
					overseersSet.add(randomValue);
					overseers.add(randomValue);
				}
			}
		}
		
		return overseers;
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
	
	public static double randomTrustPicker() {
		Random randVal = new Random();
		Double randomValue = randVal.nextInt(10) + 1.0;
		return randomValue;
	}
	
	public static int carPicker() {
		Random randCar = new Random();
		int randomCar = randCar.nextInt(currentCarCount);
		return randomCar;
	}
	
	public static Car randomGenerator() {
		Random rand = new Random();
		int trustScore = rand.nextInt(5) + 6; //Trust scores from 0-10 . Can be changed if anything
		int carVal = rand.nextInt(4); //5 car types, 0-4 indexes. ****Must change if more carTypes are added!
		int lPlate = rand.nextInt(10000); //create random license Plate #
		String carType = carTypes[carVal];
			
		return new Car(trustScore, carType, lPlate, 0);
	}
	
	public static Car maliceGenerator() {
		Random rand = new Random();
		int trustScore = rand.nextInt(5) + 1;
		int carVal = rand.nextInt(4);
		int lPlate = rand.nextInt(10000);
		String carType = carTypes[carVal];
		
		return new Car(trustScore, carType, lPlate, 0);
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