import java.util.*;

public class Run {

	private final static int totalCar_Count = 5;
	
	final static String[] carTypes = {"Jeep", "Bmw", "Lexus", "Honda", "Toyota"}; //just for show purposes, can add more if needed

	public static void main(String[] args) {
		
		//Random rand = new Random();
		
		ArrayList<Car> carList = new ArrayList<Car>();
		
		for(int i =0; i < totalCar_Count; i++){
			carList.add(randomGenerator());
		}
		
		
		/*
		carList.add(new Car(5, "jeep"));
		carList.add(new Car(3, "bmw"));
		carList.add(new Car(8, "audi"));
		
		*/
		System.out.println(carList);

	}
	
	
	public static Car randomGenerator() {
		Random rand = new Random();
		int trustScore = rand.nextInt(10); //Trust scores from 0-10 . Can be changed if anything
		int carVal = rand.nextInt(4); //5 car types, 0-4 indexes
		String carType = carTypes[carVal];
		
		
		return new Car(trustScore, carType);
		
		
	}

}
