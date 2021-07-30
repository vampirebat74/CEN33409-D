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

public class SDLCClient extends Application {
	
	
	/**
	 *  IO streams to communicate with server 
	 */
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	
	@Override // Override the start method in the Application class  
	
	/**
	 * Create the gui
	 */
	public void start(Stage primaryStage) {
		// Panel p to hold the label and text field    
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5, 5, 5, 5));
		paneForTextField.setStyle("-fx-border-color: green");    
		paneForTextField.setLeft(new Label("The following words are from Edgar Allan Poe's The Raven."));
		
		//delet this
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(tf);
				
		BorderPane mainPane = new BorderPane();
		// Text area to display contents    
		TextArea ta = new TextArea();
		mainPane.setCenter(new ScrollPane(ta));    
		mainPane.setTop(paneForTextField);    
		
		/**
		 * Main text box for the gui
		 */
		// Create a scene and place it in the stage    
		Scene scene = new Scene(mainPane, 450, 200);    
		primaryStage.setTitle("SDLC Client"); 
		// Set the stage title    
		primaryStage.setScene(scene); 
		// Place the scene in the stage    
		primaryStage.show();
		// Display the stage   
		
		
		//CRASH IS SOMEWHERE HERE
		//input field functionality, delete it
		
		System.out.println("test1");
		
		/**
		 * this snippet of code activates every time "enter" is pressed after content is added into the field.
		 */
		tf.setOnAction(e -> {      
			try {        
				// Get the number from the text field        
				double number = Double.parseDouble(tf.getText().trim()); 
				
				// Send the number to the server        
				toServer.writeDouble(number);        
				toServer.flush();  
				

				
				// Display to the text area
				while (fromServer.available() > 0) {
					   // By using readUTF() method is to read
					   // encoded string from the obj_in_stm 
					   String poeWords = fromServer.readUTF();
					   ta.appendText(poeWords + "\n");
					  }
				

				
				
				}
			
			catch (IOException ex) {
				System.err.println(ex);
				}    
			});
		
		/**
		 * Establish a connection to the server, after the program is initiated.
		 */
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
	}}