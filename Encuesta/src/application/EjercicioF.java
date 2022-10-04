package application;




import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

import model.Persona;

public class EjercicioF extends Application{
	
	private TextField nombretxt;
	private TextField apetxt;
	private TextField edadtxt;
	private TextField filtnomtxt;
	private Button agregarbtn;
	private Button modificarbtn;
	private Button eliminarbtn;
	private Button importarbtn;
	private Button exportarbtn;
	private TableView<Persona> tabla;
	private ObservableList<Persona> listadepersonas;
	
	public void start(Stage stage) {
		try {
			nombretxt = new TextField();
			apetxt = new TextField();
			edadtxt = new TextField();
			
			
			Label filtrarNombrelbl = new Label("Filtrar por nombre:");
			filtnomtxt = new TextField();
			filtnomtxt.setOnKeyTyped(e-> filtrar());
			
			importarbtn= new Button("Importar");
			importarbtn.setOnAction(e-> importar());
			exportarbtn = new Button("Exportar");
			exportarbtn.setOnAction(e-> exportar());
			
			HBox upperBox = new HBox(filtrarNombrelbl, filtnomtxt, importarbtn, exportarbtn);
			upperBox.setSpacing(15);
			upperBox.setStyle("-fx-padding: 10px;");
			
			ColumnConstraints cc1 = new ColumnConstraints();
			ColumnConstraints cc2 = new ColumnConstraints();
			
			cc2.setHgrow(Priority.ALWAYS);
			
			agregarbtn = new Button("Agregar Pesona");
			agregarbtn.setOnAction(e -> abrirModal(agregarbtn));
			
			modificarbtn = new Button("Modificar Persona");
			modificarbtn.setOnAction(e-> abrirModal(modificarbtn));
			
			eliminarbtn = new Button("Eliminar Persona");
			eliminarbtn.setOnAction(e-> eliminar());
			
			HBox downbox = new HBox(agregarbtn, modificarbtn, eliminarbtn);
			downbox.setSpacing(75);
			downbox.setStyle("-fx-padding: 10px;");
			
			//VBox leftbox = new VBox(nombrelbl, nombretxt, apelbl, apetxt, edadlbl, edadtxt, agregarbtn);
			//leftbox.setSpacing(10);
			//BorderPane.setAlignment(leftbox, Pos.CENTER_LEFT);
			//leftbox.setStyle("-fx-padding: 10px;");
			
			
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
			edadcol.setStyle("-fx-alignment: CENTER;");
			
			tabla.getColumns().addAll(nombrecol, apecol, edadcol);
			tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			tabla.setOnMouseClicked(e-> cargarDatos());
			
			
			
			GridPane root = new GridPane();
			root.add(upperBox, 0, 0);
			root.add(tabla, 0, 1);
			root.add(downbox, 0, 2, 1, 1);
			root.getColumnConstraints().add(cc1);
			root.getColumnConstraints().add(cc2);
			
			//leftbox.setAlignment(Pos.CENTER_LEFT);
			downbox.setAlignment(Pos.CENTER);
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
	
	private void agregarPersona(Stage st) {
		if(!validarDatos()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(dameError());
			alert.showAndWait();
		}
		else {
			Persona per = new Persona(nombretxt.getText(), apetxt.getText(), Integer.valueOf(edadtxt.getText()));
			
			if(!listadepersonas.contains(per)) {
				listadepersonas.add(per);
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Información");
				alert.setContentText("Ha sido agregada con éxito");
				alert.showAndWait();
				apetxt.setText("");
				nombretxt.setText("");
				edadtxt.setText("");
				
			    st.close();
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
	

	
	public void modificarDatos(Stage st){
		
		if(!validarDatos()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(dameError());
			alert.showAndWait();
		}
		else {
			Persona perselec = tabla.getSelectionModel().getSelectedItem();
			Persona pernueva = new Persona(nombretxt.getText(), apetxt.getText(), Integer.valueOf(edadtxt.getText()));
			
			if (!listadepersonas.contains(pernueva)) {
				perselec.setNombre(nombretxt.getText());
				perselec.setApellidos(apetxt.getText());
				perselec.setEdad(Integer.valueOf(edadtxt.getText()));
				st.close();
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Esta persona ya se encuentra en la lista");
				alert.showAndWait();
			}
			tabla.refresh();
		}
	}
	
	public void eliminar() {
		Persona perselec = tabla.getSelectionModel().getSelectedItem();
		listadepersonas.remove(perselec);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Información");
		alert.setContentText("Ha sido borrada con éxito");
		alert.showAndWait();
		apetxt.setText("");
		nombretxt.setText("");
		edadtxt.setText("");
	}
	
	public void abrirModal(Button btnPulsado) {
		Label nombrelbl = new Label("Nombre");
		nombrelbl.setAlignment(Pos.BASELINE_LEFT);
		Label apelbl = new Label("Apellidos");
		apelbl.setAlignment(Pos.BASELINE_LEFT);
		Label edadlbl = new Label("Edad");
		edadlbl.setAlignment(Pos.BASELINE_LEFT);
		nombretxt = new TextField();
		apetxt = new TextField();
		edadtxt = new TextField();
		edadtxt.setMaxWidth(65);
		
		Button guardarbtn = new Button("Guardar");
		
		Button cancelarbtn = new Button("Cancelar");
		
		HBox downbox = new HBox(guardarbtn, cancelarbtn);
		downbox.setSpacing(25);
		downbox.setStyle("-fx-padding: 10px;");
		downbox.setAlignment(Pos.CENTER);
		

		ColumnConstraints cc1 = new ColumnConstraints();
		ColumnConstraints cc2 = new ColumnConstraints();
		
		cc2.setHgrow(Priority.ALWAYS);
		
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(5);
        root.addRow(0, nombrelbl, nombretxt);
        root.addRow(1, apelbl, apetxt);
        root.addRow(2, edadlbl, edadtxt);
        root.add(downbox, 0, 3, 2, 1);
        root.getColumnConstraints().add(cc1);
		root.getColumnConstraints().add(cc2);
        
        root.setStyle("-fx-padding: 20;");
        Scene newScene = new Scene(root);
        Stage newStage = new Stage();
        if (btnPulsado==agregarbtn) {
            guardarbtn.setOnAction(e-> agregarPersona(newStage));
		}
        else {
        	Persona perselec = tabla.getSelectionModel().getSelectedItem();
    		nombretxt.setText(perselec.getNombre());
    		apetxt.setText(perselec.getApellidos());
    		edadtxt.setText(String.valueOf(perselec.getEdad()));
    		guardarbtn.setOnAction(e-> modificarDatos(newStage));
        }
        
        cancelarbtn.setOnAction(e -> newStage.close());
        
        newStage.setScene(newScene);
        newStage.setTitle("Nueva Persona");
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setResizable(false);
        newStage.show();

	}
	
	public void filtrar() {
		ObservableList<Persona> listafiltrada = FXCollections.observableArrayList();
		if(filtnomtxt.getText().trim()=="" && tabla.getItems()!=listadepersonas) {
			tabla.setItems(listadepersonas);
		}
		else {
			for (int i = 0; i < listadepersonas.size(); i++) {
				if(listadepersonas.get(i).getNombre().contains(filtnomtxt.getText())) {
					listafiltrada.add(listadepersonas.get(i));
				}
			}
			tabla.setItems(listafiltrada);
		}
		tabla.refresh();
	}
	
	public void importar() {
		
	}
	
	public void exportar() {
		
	}
	
	public void cargarDatos() {
		Persona perselec = tabla.getSelectionModel().getSelectedItem();
		nombretxt.setText(perselec.getNombre());
		apetxt.setText(perselec.getApellidos());
		edadtxt.setText(String.valueOf(perselec.getEdad()));
	}
	
	public boolean validarDatos() {
		if(nombretxt.getText().trim()=="" || apetxt.getText().trim()=="" || !esNumerico(edadtxt.getText().trim()) || edadtxt.getText().trim()=="") {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String dameError() {
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
		return textoerror;
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
