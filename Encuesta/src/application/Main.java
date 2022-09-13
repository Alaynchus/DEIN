package application;
	
import java.lang.reflect.Array;
import java.util.Iterator;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Label titulolbl = new Label("ENCUESTA");
			Label proflbl = new Label("Profesión:");
			TextField proftxt = new TextField();
			Label hermalbl = new Label("Nº Hermanos:");
			TextField hermatxt = new TextField();
			Label edadlbl = new Label("Edad");
			ComboBox<String> edadcombo = new ComboBox<>();
			//ObservableList<String> valorescomb = {"Menores de 18", "Entre 18 y 30", "Entre 30 y 50", "Entre 51 y 70", "Mayores de 70"};
			System.out.println("hola");
			GridPane root = new GridPane();
			root.add(titulolbl, 0, 0, 4, 1);
			root.add(proflbl, 0, 1, 1, 1);
			root.add(proftxt, 1, 1, 3, 1);
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("ENCUESTA");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
