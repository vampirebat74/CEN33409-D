//Dawud Hunt 2/5/2019
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
/*
Palindrome Checker - A palindrome is a string that is the same forwards as backwards.  For example, the following strings are palindromes:

" ", "a", "aa", "bb", "aba", "bab", "bob"

These are not:

"ab", "ba", "bba", "abb"

Use the Queue concept to create a palindrome checker.
 */

public class palindromeChecker extends myQueue{
	
	public String[] backupList() {
		
		
		return this.backupList();
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Queue<String> theQueue = new LinkedList<String>();
		Queue<String> otherQueue = new LinkedList<String>();
		int isPalindrome = 0;

		System.out.println("Please type one word to be compared.");
		
		String wordString = scnr.next();
		
		wordString = wordString.toUpperCase();
		
		for (int i = 0; i < wordString.length();i++) {
			//populate the queue with inputString
			char wordChar = wordString.charAt(i);
			String inputString = Character.toString(wordChar);
			theQueue.add(inputString);
		}
		

		
		for (int i = wordString.length() - 1; i >= 0;i--) {
			//find the reverse order
			char reverseChar = wordString.charAt(i);
			String reverseString = Character.toString(reverseChar);
			otherQueue.add(reverseString);
		}
		
		for (int i = 0; i < wordString.length();i++) {
			//compare the two queues
			String firstWord = theQueue.poll();
			String secondWord = otherQueue.poll();
			System.out.println(firstWord + " compared to " + secondWord);
			
			if (!firstWord.equals(secondWord)) {
				System.out.println("This word isn't a palindrome!");
				i = wordString.length();
				isPalindrome = 1;
			}
			
		}
		
		if (isPalindrome == 0) {
			System.out.println("This word is a palindrome!");
	}
	}
}
