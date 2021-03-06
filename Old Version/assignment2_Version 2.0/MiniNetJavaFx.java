package assignment;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MiniNetJavaFx extends Application implements Data{

	private static HashMap<Integer, Profile> list = new HashMap<Integer, Profile>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list.putAll(inbuilt);
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Pane : Main Menu
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);

		// Place nodes in the pane
		Button btadd = new Button("Add Profile");
		Button btdisplay = new Button("Display Profile");
		Button btaccess = new Button("Access Profile");
		Button btexit = new Button("Exit");
		pane.add(new Label("Welcome to MiniNet"),0,0);
		pane.add(btadd, 0, 1);
		pane.add(btdisplay, 0, 2);
		pane.add(btaccess, 0, 3);
		pane.add(btexit, 0, 4);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

		// Action for Add Profile
		btadd.setOnAction((ActionEvent add) -> {
			primaryStage.hide();
			Stage stageAddProfile = new Stage(); // Create a new stage
			stageAddProfile.setTitle("ADD PROFILE"); // Set the stage title
			
			// Pane : Add Profile Menu
			GridPane paneAP = new GridPane();
			paneAP.setAlignment(Pos.CENTER);
			paneAP.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			paneAP.setHgap(5.5);
			paneAP.setVgap(5.5);
			Button saveAP = new Button("Save");
			Button backAP = new Button("Back");
			TextField name = new TextField();
			TextField age = new TextField();
			TextField status = new TextField();

			// Place nodes in the pane
			paneAP.add(new Label("ADD PROFILE"),0,0);
			paneAP.add(new Label("Name"), 0, 1);
			paneAP.add(name, 1, 1);
			paneAP.add(new Label("Age"), 0, 2);
			paneAP.add(age, 1, 2);
			paneAP.add(new Label("Status"), 0, 3);
			paneAP.add(status, 1, 3);
			paneAP.add(saveAP, 0, 4);
			paneAP.add(backAP, 1, 4);

			saveAP.setOnAction((ActionEvent save) -> {
				String nname = name.getText();
				String nstatus = name.getText();
				try {
				int nnage = Integer.parseInt(age.getText());
				}
				catch (NumberFormatException exc1) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Age Exception");
					alert.setHeaderText("Age");
					alert.setContentText("Invalid Number");
					Label label = new Label(exc1.getMessage().toString());
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Exception into the dialog pane.
					alert.getDialogPane().setExpandableContent(expContent);
					alert.showAndWait();
				}
			});
			
			backAP.setOnAction((ActionEvent back) -> {
				stageAddProfile.close();
				primaryStage.show();
			});


			Scene sceneAddProfile = new Scene(paneAP);
			stageAddProfile.setScene(sceneAddProfile);
			stageAddProfile.show();
		});

		//Action for Display Profile
		btdisplay.setOnAction((ActionEvent display) -> {
			primaryStage.hide();
			// Code to update Profile, will contain another menu to select the update
			Stage stageDisplay = new Stage(); // Create a new stage
			stageDisplay.setTitle("DISPLAY PROFILE"); // Set the stage title
			
			// Pane : Display Profile
			GridPane paneDP = new GridPane();
			paneDP.setAlignment(Pos.CENTER);
			paneDP.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			paneDP.setHgap(5.5);
			paneDP.setVgap(5.5);
			Button okDP = new Button("Ok");
			Button backDP = new Button("Back");
			TextField name = new TextField();

			// Place nodes in the pane
			paneDP.add(new Label("-----DISPLAY PROFILE-------"),0,0);
			paneDP.add(new Label("Name"), 0, 1);
			paneDP.add(name, 1, 1);
			paneDP.add(okDP, 0, 2);
			paneDP.add(backDP, 1, 2);
			
			// Still required to be worked on to display print statements and handle exceptions
			okDP.setOnAction((ActionEvent confirm) -> {
				String search = name.getText();
				// Use Profile does not exist exception handling here
				// Still Requires work to change display profile method
				// Each component will be displayed in tables
				if (search!="") {
				Profile person = Driver.profileCheck(list, search);
				Label displayProfile = new Label(Driver.displayProfile(person));
				paneDP.add(displayProfile,0,3);
				}
				else {
					System.err.println();
				}
			});
			
			backDP.setOnAction((ActionEvent back) -> {
				stageDisplay.close();
				primaryStage.show();
			});
			
			Scene sceneDisplay = new Scene(paneDP);
			stageDisplay.setScene(sceneDisplay);
			stageDisplay.show();
			

		});


		//Action for Access Profile
		btaccess.setOnAction((ActionEvent access) -> {
			
			primaryStage.hide();
			Stage stageAccess = new Stage(); // Create a new stage
			stageAccess.setTitle("------PROFILE MENU------"); // Set the stage title

			// Pane : Access Profile Menu
			GridPane paneACP = new GridPane();
			paneACP.setAlignment(Pos.CENTER);
			paneACP.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			paneACP.setHgap(5.5);
			paneACP.setVgap(5.5);
			Button update = new Button("Update Profile");
			Button delete = new Button("Delete Profile");
			Button details = new Button("Profile Details");
			Button relation = new Button("Add Relation");
			Button backACP = new Button("Back");
			backACP.setMinWidth(200);

			// Buttons for Profile Menu added to the Pane
			paneACP.add(update, 0, 1);
			paneACP.add(delete, 0, 2);
			paneACP.add(details, 0, 3);
			paneACP.add(relation, 0, 4);			
			paneACP.add(backACP, 0, 5);
			
			// Event Handling of each button
			update.setOnAction((ActionEvent uProfile) -> {
				stageAccess.close();
				// Code to update Profile, will contain another menu to select the update
				Stage stageUpdate = new Stage(); // Create a new stage
				stageUpdate.setTitle("UPDATE PROFILE"); // Set the stage title
				
				// Pane : Update Profile Menu
				GridPane paneUP = new GridPane();
				paneUP.setAlignment(Pos.CENTER);
				paneUP.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				paneUP.setHgap(5.5);
				paneUP.setVgap(5.5);
				Button saveUP = new Button("Save");
				Button backUP = new Button("Back");
				TextField name = new TextField();
				TextField age = new TextField();
				TextField status = new TextField();

				// Place nodes in the pane
				paneUP.add(new Label("-----UPDATE PROFILE-------"),0,0);
				paneUP.add(new Label("Name"), 0, 1);
				paneUP.add(name, 1, 1);
				paneUP.add(new Label("Age"), 0, 2);
				paneUP.add(age, 1, 2);
				paneUP.add(new Label("Status"), 0, 3);
				paneUP.add(status, 1, 3);
				paneUP.add(saveUP, 0, 4);
				paneUP.add(backUP, 1, 4);

				saveUP.setOnAction((ActionEvent save) -> {
					
					
				});
				
				backUP.setOnAction((ActionEvent back) -> {
					stageUpdate.close();
					stageAccess.show();
				});
				
				Scene sceneUpdate = new Scene(paneUP);
				stageUpdate.setScene(sceneUpdate);
				stageUpdate.show();
				
			});
			
			delete.setOnAction((ActionEvent deProfile) -> {
				stageAccess.close();
				// Code to Delete Profile
			});
			
			details.setOnAction((ActionEvent dProfile) -> {
				stageAccess.close();
				// Code to access Profile Details, will be displayed as table
			});
			
			relation.setOnAction((ActionEvent addRelation) -> {
				stageAccess.close();
				//Code to add a relation, will contain another menu to trigger which relation
			});
			
			backACP.setOnAction((ActionEvent back) -> {
				stageAccess.close();
				primaryStage.show();
			});

			Scene sceneAccess = new Scene(paneACP);
			stageAccess.setScene(sceneAccess);
			stageAccess.show();

		});

		//Action to Exit
		btexit.setOnAction((ActionEvent exit) -> {
			System.exit(0);
		});

	}

}
