import java.util.*;

public class Run {

	private final static int totalCar_Count = 5;
	
	final static String[] carTypes = {"Jeep", "Bmw", "Lexus", "Honda", "Toyota"}; //just for show purposes, can add more if needed

	public static void main(String[] args) {
		
		ArrayList<Car> carList = new ArrayList<Car>();
		
		for(int i =0; i < totalCar_Count; i++){
			carList.add(randomGenerator());
		}

		sortByTrustValue(carList);
		System.out.println(carList);

	}
	
	
	public static Car randomGenerator() {
		Random rand = new Random();
		int trustScore = rand.nextInt(10); //Trust scores from 0-10 . Can be changed if anything
		int carVal = rand.nextInt(4); //5 car types, 0-4 indexes
		String carType = carTypes[carVal];
			
		return new Car(trustScore, carType);
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
