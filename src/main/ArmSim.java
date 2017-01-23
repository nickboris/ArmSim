package main;
import java.io.IOException;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class ArmSim extends Application {
	private Stage primaryStage;
	private Parent rootLayout;
	private Model model;
	
	public ArmSim(){
		this.model = new Model();
	}
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	this.primaryStage = primaryStage;
    	this.primaryStage.setTitle("Life Cycle of an ARM Instruction");
    	
    	initRootLayout();
    }
    
    public void initRootLayout(){
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(ArmSim.class.getResource("Main.fxml"));
	    	rootLayout = loader.load();
	    	
	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
	        primaryStage.show();
	        
	        Controller controller = loader.getController();
	        controller.setApp(this);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public Stage getPrimaryStage(){
    	return primaryStage;
    }
    
    public Model getModel(){
    	return model;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
 
}