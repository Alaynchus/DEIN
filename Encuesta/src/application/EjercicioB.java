package application;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import model.Persona;

public class EjercicioB extends Application{
	
	private TextField nombretxt;
	private TextField apetxt;
	private TextField edadtxt;
	private Button agregarbtn;
	private TableView<Persona> tabla;
	private ObservableList<Persona> listadepersonas;
	
	public void start(Stage stage) {
		try {
			Label nombrelbl = new Label("Nombre");
			Label apelbl = new Label("Apellidos");
			Label edadlbl = new Label("Edad");
			nombretxt = new TextField();
			apetxt = new TextField();
			edadtxt = new TextField();
			agregarbtn = new Button("Agregar Pesona");
			agregarbtn.setOnAction(e -> agregarPersona());
			VBox leftbox = new VBox(nombrelbl, nombretxt, apelbl, apetxt, edadlbl, edadtxt, agregarbtn);
			leftbox.setSpacing(10);
			BorderPane.setAlignment(leftbox, Pos.CENTER_LEFT);
			leftbox.setStyle("-fx-padding: 10px;");
			
			
			listadepersonas=FXCollections.observableArrayList();
			
			tabla = new TableView<>(listadepersonas);
			
			TableColumn<Persona, String> nombrecol = new TableColumn<>("NOMBRE");
			nombrecol.setMinWidth(200);
			nombrecol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			
			TableColumn<Persona, String> apecol = new TableColumn<>("APELLIDOS");
			apecol.setMinWidth(200);
			apecol.setCellValueFactory(new PropertyValueFactory<>("apellidos"));;
			
			TableColumn<Persona, Integer> edadcol = new TableColumn<>("EDAD");
			edadcol.setCellValueFactory(new PropertyValueFactory<>("edad"));
			
			tabla.getColumns().addAll(nombrecol, apecol, edadcol);
			tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			
			listadepersonas = tabla.getItems();;
			
			GridPane root = new GridPane();
			root.add(leftbox, 0, 0);
			root.add(tabla, 1, 0);
			leftbox.setAlignment(Pos.CENTER_LEFT);
			root.setStyle("-fx-padding: 10px");
			Scene scene = new Scene(root);
			String imagePath = getClass().getResource("/imagenes/agenda.png").toString();
			stage.getIcons().add(new Image(imagePath));
			stage.setScene(scene);
			stage.setTitle("PERSONAS");
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void agregarPersona() {
		if(nombretxt.getText().trim()=="" || apetxt.getText().trim()=="" || !esNumerico(edadtxt.getText().trim()) || edadtxt.getText().trim()=="") {
			String textoerror="";
			if(nombretxt.getText().trim()=="") {
				textoerror = "Desbes introducir un nombre \n";
			}
			if(apetxt.getText().trim()=="") {
				textoerror = textoerror + "Desbes introducir un apellido \n";
			}
			if(edadtxt.getText().trim()=="") {
				textoerror = textoerror + "Desbes introducir una edad \n";
			}
			if(!esNumerico(edadtxt.getText().trim()) && edadtxt.getText().trim()!="") {
				textoerror = textoerror + "La edad debe ser un número";
			}
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(textoerror);
			alert.showAndWait();
	
		}
		else {
			Persona per = new Persona(nombretxt.getText(), apetxt.getText(), Integer.valueOf(edadtxt.getText()));
			
			if(!listadepersonas.contains(per)) {
				listadepersonas.add(per);
				nombretxt.setText("");
				apetxt.setText("");
				edadtxt.setText("");
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Información");
				alert.setContentText("Ha sido agregada con éxito");
				alert.showAndWait();
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Esta persona ya se encuentra en la lista");
				alert.showAndWait();
			}
			
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
