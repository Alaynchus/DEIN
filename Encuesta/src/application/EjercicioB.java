package application;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
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
			
			listadepersonas = FXCollections.<Persona>observableList(listadepersonas);
			
			tabla = new TableView<>(listadepersonas);
			
			TableColumn<Persona, Integer> nombrecol = new TableColumn<>("NOMBRE");
			nombrecol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			
			TableColumn<Persona, Integer> apecol = new TableColumn<>("APELLIDOS");
					nombrecol.setCellValueFactory(new PropertyValueFactory<>("apellidos"));;
			
			TableColumn<Persona, Integer> edadcol = new TableColumn<>("EDAD");
			nombrecol.setCellValueFactory(new PropertyValueFactory<>("edad"));
			
			tabla.getColumns().addAll(nombrecol, apecol, edadcol);
			tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			
			
			
			BorderPane root = new BorderPane();
			root.setLeft(leftbox);
			root.setCenter(tabla);
			root.setStyle("-fx-padding: 10px");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("PERSONAS");
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void agregarPersona() {
		Persona per = new Persona(nombretxt.getText(), apetxt.getText(), Integer.valueOf(edadtxt.getText()));
		listadepersonas.add(per);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
