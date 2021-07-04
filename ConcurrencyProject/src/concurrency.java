import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Math;

	/*
	 * Dawud Hunt
	 * 7/3/2021
	*/

class Threadd extends Thread{
	
	static long startTime;
	static long endTime;
	
	@Override
	public void run() {
		
		Integer arrayVal[] = {};
		ArrayList<Integer> arrayL =new ArrayList<Integer>(Arrays.asList(arrayVal));
		startTime = System.nanoTime();
		
		//thread 1 activity goes here
		for (int i = 0; i<500;i++) {
			
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

public class concurrency {
	
	//define the "startTime" and "endTime" variables for calculating efficiency.
	static long startTime;
	static long endTime;
	
	
	public static void main(String args[]) {
		
		Threadd thread1 = new Threadd();
		thread1.start();
		
		Threadd thread2 = new Threadd();
		thread2.start();
		
		Threadd thread3 = new Threadd();
		thread3.start();
		
		Threadd thread4 = new Threadd();
		thread4.start();
		
		
		
		
		System.out.println("Start time: " + startTime);
		System.out.println("End time: " + endTime);
		System.out.println("Total time: " + (endTime - startTime) + " nanoseconds.");
		
	}

}
