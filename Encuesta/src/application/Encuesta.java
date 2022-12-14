package application;
	
import java.lang.reflect.Array;
import java.util.Iterator;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class Encuesta extends Application {
	
	private  CheckBox practicadeplbl;
	private ListView<String> listadep;
	private TextField proftxt;
	private TextField hermatxt;
	private ComboBox<String> edadcombo;
	private ToggleGroup grupordn;
	private Slider comsl;
	private Slider telesl;
	private Slider cinesl;
	
	public void start(Stage stage) {
		try {
			Label titulolbl = new Label("ENCUESTA");
			titulolbl.setId("titulo");
			Label proflbl = new Label("Profesión:");
			proftxt = new TextField();
			Label hermalbl = new Label("Nº Hermanos:");
			hermatxt = new TextField();
			Label edadlbl = new Label("Edad");
			
			edadcombo = new ComboBox<>();
			ObservableList<String> valorescomb = FXCollections.<String>observableArrayList("Menores de 18", "Entre 18 y 30", "Entre 30 y 50", "Entre 51 y 70", "Mayores de 70");
			edadcombo.getItems().addAll(valorescomb);
			edadcombo.getSelectionModel().select(0);
			Label sexolbl= new Label("Sexo:");
			RadioButton hombrerdnbtn= new RadioButton("Hombre");
			RadioButton mujerdnbtn= new RadioButton("Mujer");
			RadioButton otrordnbtn= new RadioButton("Otro");
			mujerdnbtn.setSelected(true);
			grupordn= new ToggleGroup();
			grupordn.getToggles().addAll(hombrerdnbtn, mujerdnbtn, otrordnbtn);
			
			practicadeplbl= new CheckBox("¿Práctica algún deporte?");
			practicadeplbl.selectedProperty().addListener(this::changed);
			Label cuallbl= new Label("¿Cúal?");
			ObservableList<String> valoreslista = FXCollections.<String>observableArrayList("Tenis", "Futbol", "Baloncesto", "Natacion", "Ciclismo", "Otro");
			listadep= new ListView<String>();
			listadep.getItems().addAll(valoreslista);
			listadep.setPrefHeight(65);
			listadep.setDisable(true);
			
			Label marcalbl = new Label("Marque del 1 al 10 su grado de aficción");
			Label comlbl = new Label("Compras:");
			comsl= new Slider(0, 10, 5);
			comsl.setShowTickLabels(true);
			comsl.setShowTickMarks(true);
			comsl.setMajorTickUnit(1);
			Tooltip ttcom = new Tooltip("Indíca del 1 al 10 cúanto te gustría ir de compras"); 
			comsl.setTooltip(ttcom);
			
			Label telelbl = new Label("Ver televisión:");
			telesl = new Slider(0, 10, 5);
			telesl.setShowTickLabels(true);
			telesl.setShowTickMarks(true);
			telesl.setMajorTickUnit(1);
			Tooltip ttele = new Tooltip("Indíca del 1 al 10 cúanto te gustría ver la tele"); 
			telesl.setTooltip(ttele);
			
			Label cinelbl = new Label("Ir al cine:");
			cinesl = new Slider(0, 10, 5);
			cinesl.setShowTickLabels(true);
			cinesl.setShowTickMarks(true);
			cinesl.setMajorTickUnit(1);
			Tooltip ttcine = new Tooltip("Indíca del 1 al 10 cúanto te gustría ir de compras"); 
			cinesl.setTooltip(ttcine);
			Button acepbtn = new Button("Aceptar");
			acepbtn.setOnAction(e -> mostrarDatos());
			Button cancbtn = new Button("Cancelar");   
			cancbtn.setOnAction(e -> Platform.exit());
			
			ColumnConstraints cc1 = new ColumnConstraints();
			ColumnConstraints cc2 = new ColumnConstraints();
			ColumnConstraints cc3 = new ColumnConstraints();
			ColumnConstraints cc4 = new ColumnConstraints();
			
			cc4.setHgrow(Priority.ALWAYS);
			
			
			GridPane root = new GridPane();
			root.add(titulolbl, 0, 0, GridPane.REMAINING, 1);
			root.setHalignment(titulolbl, HPos.CENTER);
			root.add(proflbl, 0, 1, 1, 1);
			GridPane.setHalignment(proflbl, HPos.RIGHT);
			root.add(proftxt, 1, 1, 3, 1);
			
			root.add(hermalbl, 0, 2, 1, 1);
			GridPane.setHalignment(hermalbl, HPos.RIGHT);
			root.add(hermatxt, 1, 2, 1, 1);
			root.add(edadlbl, 2, 2, 1, 1);
			GridPane.setHalignment(edadlbl, HPos.RIGHT);
			root.add(edadcombo, 3, 2, 1, 1);
			
			HBox cajaradio= new HBox();
			cajaradio.getChildren().addAll(sexolbl, hombrerdnbtn, mujerdnbtn, otrordnbtn);
			root.add(cajaradio, 0, 3, 3, 1);
			
			root.add(practicadeplbl, 0, 4, 1, 1);
			GridPane.setHalignment(practicadeplbl, HPos.RIGHT);
			root.add(cuallbl, 2, 4, 1, 1);
			root.add(listadep, 2, 5, 2, 3);
			
			root.add(marcalbl , 0, 8, 4, 1);
			root.setHalignment(marcalbl, HPos.CENTER);
			
			root.add(comlbl, 0, 9, 1, 1); 
			root.setHalignment(comlbl, HPos.RIGHT);
			root.add(comsl, 1, 9, 3, 1); 
			
			root.add(telelbl, 0, 10, 1, 1); 
			root.add(telesl, 1, 10, 3, 1);
			
			root.add(cinelbl, 0, 11, 1, 1); 
			root.add(cinesl, 1, 11, 3, 1);
			
			root.add(acepbtn, 0, 12, 2, 1);
			root.add(cancbtn, 2, 12, 2, 1);
			
			root.getColumnConstraints().add(cc1);
			root.getColumnConstraints().add(cc2);
			root.getColumnConstraints().add(cc3);
			root.getColumnConstraints().add(cc4);
			
			Scene scene = new Scene(root);
			String url = getClass().getResource("/css/encuesta.css").toString();
			scene.getStylesheets().add(url);
			stage.setScene(scene);
			stage.setTitle("ENCUESTA");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(practicadeplbl.isSelected()) {
			listadep.setDisable(false);
		}
		else {
			listadep.setDisable(true);
		}
        
    }
	
	public void mostrarDatos() {
		
		boolean error=false;
		String textomostrar="";
		
		if(proftxt.getText().trim().isEmpty() || hermatxt.getText().trim().isEmpty() || !esNumerico(hermatxt.getText().trim()) || listadep.getSelectionModel().getSelectedItems().isEmpty()) {
			error=true;
			if(proftxt.getText().trim().isEmpty()) {
				textomostrar="Hay que rellenar el campo de profesion \n";
			}

			if(hermatxt.getText().trim().isEmpty()) {
				textomostrar = textomostrar + "Hay que rellenar el campo de número de hermanos \n" ;
			}
			else {
				if(!esNumerico(hermatxt.getText().trim())) {
					textomostrar = textomostrar + "Hay que rellenar el campo de número de hermanos con numeros \n";
				}
			}
			
			if(listadep.getSelectionModel().getSelectedItems().isEmpty()){
				textomostrar = textomostrar + "Tienes que indicar el deporte que practicas";
			}
		}
		
		if(error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(textomostrar);
			alert.showAndWait();
		}
		else{
			RadioButton sel = (RadioButton) grupordn.getSelectedToggle();
			textomostrar="Profesion: "+ proftxt.getText().trim()+"\n Nº de hermanos:" + hermatxt.getText().trim() + "\n Edad: "+ edadcombo.getValue()+
			"\n Sexo: "+ sel.getText()+ "\n Deportes que practicas: \n";
			
			
			ObservableList<String> depselec = listadep.getSelectionModel().getSelectedItems();
			for (Iterator iterator = depselec.iterator(); iterator.hasNext();) {
				String deporte = (String) iterator.next();
				textomostrar = textomostrar + deporte +"\n";
			}
			
			textomostrar = textomostrar + "Grado de afición a las compras: " + comsl.getValue() + "\n Grado de afición a ver la televisión: " + telesl.getValue() + "\n Grado de afición a ir al cine: " + cinesl.getValue();
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText(textomostrar);
			alert.showAndWait();
		}
		
	}
	public boolean esNumerico(String valor) {
		try{
	        if(valor!= null){
	            Integer.parseInt(valor);
	        }
	    }catch(NumberFormatException nfe){
	         return false; 
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
