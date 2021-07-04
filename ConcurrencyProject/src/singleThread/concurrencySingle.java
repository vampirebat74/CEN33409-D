package singleThread;

import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Math;

	/*
	 * Dawud Hunt
	 * 7/3/2021
	*/





public class concurrencySingle {
	
	//define the "startTime" and "endTime" variables for calculating efficiency.
	static long startTime;
	static long endTime;
	
	
	public static void main(String args[]) {
		long startTime = System.nanoTime();
		System.out.println("Start time: " + startTime);
		
		Integer arrayVal[] = {};
		ArrayList<Integer> arrayL =new ArrayList<Integer>(Arrays.asList(arrayVal));
		
		//thread 1 activity goes here
		for (int i = 0; i<2000;i++) {
			
			//appends the array i amount of times
			double arrayInputD = (Math.random()* 10);
			int arrayInputI = (int) arrayInputD + 1;
			arrayL.add(arrayInputI);
			
			arrayVal = arrayL.toArray(arrayVal);
			
			System.out.println(Arrays.toString(arrayVal));
		}

		
		endTime = System.nanoTime();
		
		System.out.println("Start time: " + startTime);
		System.out.println("End time: " + endTime);
		System.out.println("Total time: " + (endTime - startTime) + " nanoseconds.");
		
	}

}