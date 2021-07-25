package deployment;
import java.util.Scanner;

/*
 * Dawud Hunt
 * 7/24/2021
 */

public class deployment {

	public static void main(String[] args) {
		
		
		System.out.println("Please type a numerical value, to be calculated whether it's a prime number.");
		Scanner scan = new Scanner(System.in);
		Double inputVal = scan.nextDouble();
		double safetyVal = inputVal;
		
		if (inputVal == 0) {
			System.out.println("This number is prime.");
		}
		
		//This loop calculates the modulus of the number with any number lower than it
		for (double i=1; i < (safetyVal - 1); ++i) {
			
			inputVal %= (i + 1);
			
			if (inputVal == 0){
				System.out.println("This number is not Prime");
				safetyVal = inputVal;
			}
			inputVal = safetyVal;
		}
		
		
		//Checks if the modulus operator can't divide with anything but itself
		if (safetyVal > 0) {
			System.out.println("This number is prime.");
		}
		
	}
}
