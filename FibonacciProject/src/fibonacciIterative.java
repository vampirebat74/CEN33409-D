import java.util.Scanner;

/*
 * Dawud Hunt
 * 6/12/2021
 * This program iterates through the Fibonnaci sequence and records the runtime efficiency.
 * */
public class fibonacciIterative {
	
	//define the "startTime" and "endTime" variables for calculating efficiency.
	static long startTime;
	static long endTime;
	
	public static void main( String[] args){
		
		//declare the variables
		Scanner scnr = new Scanner(System.in);
		
		long num1 = 0;
		long num2 = 1;
		long num3 = 0;
		int i;
		int iterations = scnr.nextInt();
		
		//input query for the end user
		System.out.println("Please type the amount of iterations through the Fibonnaci sequence you'd like to see.");
		System.out.println("The number will overflow after 93 iterations.");
		
		//first timestamp created before the loop
		startTime = System.nanoTime();
		
		//this is the iterative loop for Fibonacci's sequence. Further down you'll see that N starts as the user's input, while the other numbers are 0, 1, and 0.
		//num1 is the resulting number from the equation, num1 and num2 are added together, while num3 "saves" the previous num1 for the next iteration of num2
		for (i = 0; i < iterations; i++) {
			System.out.println(num1);
			num3 = num1;
			num1 += num2;
			num2 = num3;

		}
		//endtime created after the loop, along with the total time it took.
		endTime = System.nanoTime();
		
		//outputs all the operating times.
		System.out.println("Start time: " + startTime);
		System.out.println("End time: " + endTime);
		System.out.println("Total time: " + (endTime - startTime) + " miliseconds.");
		scnr.close();
	}
}
