package deployment;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class serber extends Application {  
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
				
				while (true) {          
					
					System.out.println("Please type a numerical value, to be calculated whether it's a prime number.");
					//recieve input from client, create "backup" variable for formula
					Double inputVal = inputFromClient.readDouble();
					double safetyVal = inputVal;
					boolean isPrime = true;
					
					if (inputVal == 0) {
						isPrime = true;
					}
					
					//This loop calculates the modulus of the number with any number lower than it
					for (double i=1; i < (safetyVal - 1); ++i) {
						
						inputVal %= (i + 1);
						
						if (inputVal == 0){
							isPrime = false;
							ta.appendText("This number is not Prime" + '\n'); 
							safetyVal = inputVal;
						}
						inputVal = safetyVal;
					}
					
					
					//Checks if the modulus operator can't divide with anything but itself
					if (safetyVal > 0) {
						isPrime = true;
						ta.appendText("This number is prime." + '\n');
					}
					
					outputToClient.writeBoolean(isPrime);
					
					
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