package application;
	
import java.lang.reflect.Array;
import java.util.Iterator;


import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


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
			ObservableList<String> valorescomb = FXCollections.<String>observableArrayList("Menores de 18", "Entre 18 y 30", "Entre 30 y 50", "Entre 51 y 70", "Mayores de 70");
			edadcombo.getItems().addAll(valorescomb);
			Label sexolbl= new Label("Sexo:");
			RadioButton hombrerdnbtn= new RadioButton("Hombre");
			RadioButton mujerdnbtn= new RadioButton("Mujer");
			RadioButton otrordnbtn= new RadioButton("Otro");
			ToggleGroup grupordn= new ToggleGroup();
			grupordn.getToggles().addAll(hombrerdnbtn, mujerdnbtn, otrordnbtn);
			
			CheckBox practicadeplbl= new CheckBox("¿Práctica algún deporte?");
			Label cuallbl= new Label("¿Cúal?");
			ObservableList<String> valoreslista = FXCollections.<String>observableArrayList("Tenis", "Futbol", "Baloncesto");
			ListView<String> listadep= new ListView<String>();
			listadep.getItems().addAll(valoreslista);
			
			GridPane root = new GridPane();
			root.add(titulolbl, 0, 0, 4, 1);
			
			root.add(proflbl, 0, 1, 1, 1);
			root.add(proftxt, 1, 1, 3, 1);
			
			root.add(hermalbl, 0, 2, 1, 1);
			root.add(hermatxt, 1, 2, 1, 1);
			root.add(edadlbl, 2, 2, 1, 1);
			root.add(edadcombo, 3, 2, 1, 1);
			
			HBox cajaradio= new HBox();
			cajaradio.getChildren().addAll(sexolbl, hombrerdnbtn, mujerdnbtn, otrordnbtn);
			root.add(cajaradio, 0, 3, 3, 1);
			
			root.add(practicadeplbl, 0, 4, 1, 1);
			root.add(cuallbl, 2, 4, 1, 1);
			root.add(listadep, 2, 5, 2, 3);
			
			
			
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
