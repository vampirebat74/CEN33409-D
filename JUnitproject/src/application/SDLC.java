package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;



/*Dawud Hunt, 6/20/2021
Prof. Kafaf
33409
*/

public class SDLC{

public static void main (String args[]) {
	
	 File testFile = new File("");
	    String currentPath = testFile.getAbsolutePath();
	    System.out.println("current path is: " + currentPath);
	
	    BufferedReader reader;
		//Bufferedreader would feed the arraylist if it worked
	
		/*
		 * THE FOLLOWING DON'T WORK
		 * reader = new BufferedReader(new FileReader ("SDLC Assignment\\src\\The Project Gutenberg eBook of The Raven, by Edgar Allan Poe.html"));
		 * reader = new BufferedReader(new FileReader ("The Project Gutenberg eBook of The Raven, by Edgar Allan Poe.html"));
		 * reader = new BufferedReader(new FileReader ("text.html"));
		 * reader = new BufferedReader(new FileReader ("src\\text.html"));
		 * reader = new BufferedReader(new FileReader ("C:\\Users\\Dawud\\eclipse-workspace\\SDLC Assignment\\src\\text.html"));
		 * reader = new BufferedReader(new FileReader ("C:\\Users\\Dawud\\eclipse-workspace\\SDLC Assignment\\The Project Gutenberg eBook of The Raven, by Edgar Allan Poe.html"));
		*/
		//File theRaven = getCanonicalPath("");
	    
	    //Bufferedreader breaks the lines up here, tries to find start points (<p class="center"> and ends at <div>
	    //Bufferedreader ignores any words between <> symbols
	    
	    
		ArrayList<String> poePoem = new ArrayList();
		
		
		System.out.println("");
		
		poePoem.add("The");
		poePoem.add("Raven");
		poePoem.add("by");
		poePoem.add("Edgar");
		poePoem.add("Allan");
		poePoem.add("Poe");
		poePoem.add("Once");
		poePoem.add("upon");
		poePoem.add("a");
		poePoem.add("midnight");
		poePoem.add("dreary");
		poePoem.add("while");
		poePoem.add("I");
		poePoem.add("pondered,");
		poePoem.add("weak");
		poePoem.add("and");
		poePoem.add("weary,");
		poePoem.add("Over");
		poePoem.add("Many");
		poePoem.add("a");

		
		//find a way to sort the words retrieved from the buffer
		
		System.out.println(poePoem);
		

	
	List<String> words = new ArrayList<>();
	
	//list.add(n); <-- inside loop
	//List<String> lastNames = new LinkedList<String>();
	//words.asList(new String[] {"a", "b", "c"});
	
	
	}
}