package deployment;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {
	// IO streams  
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	
	@Override // Override the start method in the Application class  
	public void start(Stage primaryStage) {
		// Panel p to hold the label and text field    
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5, 5, 5, 5));
		paneForTextField.setStyle("-fx-border-color: green");    
		paneForTextField.setLeft(new Label("Enter a number, to check whether or not it is prime: "));
		
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(tf);
		
		BorderPane mainPane = new BorderPane();
		// Text area to display contents    
		TextArea ta = new TextArea();    
		mainPane.setCenter(new ScrollPane(ta));    
		mainPane.setTop(paneForTextField);    
		
		// Create a scene and place it in the stage    
		Scene scene = new Scene(mainPane, 450, 200);    
		primaryStage.setTitle("Prime Number Calculator"); 
		// Set the stage title    
		primaryStage.setScene(scene); 
		// Place the scene in the stage    
		primaryStage.show();
		// Display the stage   
		
		tf.setOnAction(e -> {      
			try {        
				// Get the number from the text field        
				double number = Double.parseDouble(tf.getText().trim()); 
				
				// Send the number to the server        
				toServer.writeDouble(number);        
				toServer.flush();  
				
				// Get the answer from the server        
				boolean primeness = fromServer.readBoolean();
				String primeness2 = "";
				
				if(primeness == false) {
					primeness2 = "not ";
				}
				
				// Display to the text area        
				ta.appendText("Your chosen number, " + number + "\n");        
				ta.appendText("Is "+ primeness2 + "prime" + '\n');
				}      
			catch (IOException ex) {
				System.err.println(ex);
				}    
			});
		try {      
			// Create a socket to connect to the server      
			@SuppressWarnings("resource")
			Socket socket = new Socket("localhost", 8000);
			
			// Create an input stream to receive data from the server      
			fromServer = new DataInputStream(socket.getInputStream());      
			
			// Create an output stream to send data to the server      
			toServer = new DataOutputStream(socket.getOutputStream());    
			}    
		catch (IOException ex) {      
			ta.appendText(ex.toString() + '\n');
			}  
		}  
	/*
	 * The main method is only needed for the IDE with limited   
	 *  JavaFX support. Not needed for running from the command line.   
	*/  
	public static void main(String[] args) {
		launch(args);  
		}
	}