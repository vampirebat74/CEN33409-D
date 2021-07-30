package deployment;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SDLCServer extends Application {  
	
	/**
	 * @author Dawud
	 * This server collects a cluster of data from the stream and sends it to the client, at the requested amount
	 * @return
	 */
	
	//data stream
    public static List<String> readFile() {
        try {
            return Files.readAllLines(Paths.get("C:\\Users\\dawud\\Desktop\\text1.txt"))
                .stream()
                .map(l -> l.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
	
	
	
	
	
	
	
	/**
	 * Creates the GUI for the end user
	 */
	@Override // Override the start method in the Application class  
	public void start(Stage primaryStage) {
		// Text area for displaying contents    
		TextArea ta = new TextArea();  
		
		// Create a scene and place it in the stage    
		Scene scene = new Scene(new ScrollPane(ta), 450, 200);    
		primaryStage.setTitle("Server"); // Set the stage title    
		primaryStage.setScene(scene); // Place the scene in the stage    
		primaryStage.show(); 
		// Display the stage  
		
		
		/**
		 * Creates the server functionality, input and output streams serve as a means of communicating with the client
		 */
		new Thread( () -> {
			try {        
				// Create a server socket        
				ServerSocket serverSocket = new ServerSocket(8000);        
				Platform.runLater(() ->          
				ta.appendText("Server started at " + new Date() + '\n'));    
				
				// Listen for a connection request        
				Socket socket = serverSocket.accept();     
				
				// Create data input and output streams        
				DataInputStream inputFromClient = new DataInputStream(
						socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(
						socket.getOutputStream());
				
				//List<String> poeList = readFile();
				
				/**
				 * Data stream didn't work so I just made it all up
				 */
				
				List<String> poeList2 = new ArrayList<String>();
				
				poeList2.add("The");poeList2.add("Raven");poeList2.add("by"); poeList2.add("Edgar"); poeList2.add("Allan"); poeList2.add("Poe"); 
				poeList2.add("Once"); poeList2.add("upon"); poeList2.add("a"); poeList2.add("midnight"); poeList2.add("dreary,");
				poeList2.add("while"); poeList2.add("I"); poeList2.add("pondered,"); poeList2.add("weak"); poeList2.add("and"); poeList2.add("weary,"); poeList2.add("Over");
				poeList2.add("many"); poeList2.add("a"); poeList2.add("quaint"); poeList2.add("and"); poeList2.add("curious");
				poeList2.add("volume"); poeList2.add("of"); poeList2.add("forgotten"); poeList2.add("lore-");
				
				while (true) {    
					
					System.out.println("Test.");
					//recieve input from client, create "backup" variable for formula
					
					Double inputVal = inputFromClient.readDouble();
					
					/**
					 * loop writes the values from the input stream to the client, 
					 */
					for (int i=0; i< inputVal; i++) {
						
						System.out.println(poeList2.get(i));
						
						
						outputToClient.writeUTF(poeList2.get(i));
						
						outputToClient.flush();
						
					}
					

					
					//none of this crap works
					/*
					for (int i=0; i< poeList.size(); i++) {
						if((poeList.get(i) == "The")||(poeList.get(i) == "by")||poeList.get(i) == "Edgar"||(poeList.get(i) == "Poe")){
							//poeList.remove(i);
							poeBuffer.add(poeList.get((i + 1)));
							poeBuffer.add(poeList.get(i));
							System.out.println(poeBuffer);
						}
						else {
							poeList.remove(i);
						}
						

						
					}
					*/

					//System.out.println(readFile());
					
					
					//for (int i=0; i< inputVal; i++) {
					//	poeList.remove(i);
					//}
					
					//System.out.println(poeList);
					
				//	for (String p:poeList) {
					//	System.out.println(p);
						
				//	}
					
					
					
					}      
				}      
			catch(IOException ex) {        ex.printStackTrace();
		      }    
			}).start();  
		}  
	/**
	 * The main method is only needed for the IDE with limited   
	 * JavaFX support. 
	 * Not needed for running from the command line.   
	 * */  
	public static void main(String[] args) {    
		launch(args);  
		}}