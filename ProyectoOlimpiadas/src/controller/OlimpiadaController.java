package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Olimpiada;


public class OlimpiadaController {
	@FXML
	private TableView tablaOlim;
	@FXML
	private TableColumn colNombre;
	@FXML
	private TableColumn colAnio;
	@FXML
	private TableColumn colTemporada;
	@FXML
	private TableColumn colCiudad;
	@FXML
	private Button btnCrear;
	@FXML
	private Button btnModificar;
	@FXML
	private Button btnEliminar;
	@FXML
	private TextField txtFiltro;
	@FXML
	private RadioButton radioSummer;
	@FXML
	private RadioButton radioWinter;
	private ObservableList<Olimpiada> listaOlimpiada;
	
	@FXML
	public void abrirCrearOlimpiada(ActionEvent event) {
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/crearOlimpiada.fxml"));
	         Parent root = loader.load();
	         Scene newScene = new Scene(root);
	         Stage newStage = new Stage();
	         NuevaOlimpiadaController control= loader.getController();
	         //control.cargarLista(listaOlimpiada);
	         newStage.initModality(Modality.APPLICATION_MODAL);
	         newStage.initOwner(this.btnCrear.getScene().getWindow());
	         newStage.setScene(newScene);
	         newStage.showAndWait();
	         
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	 @FXML
	 void abrirModificarOlim(ActionEvent event) {
		 try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/crearOlimpiada.fxml"));
	         Parent root = loader.load();
	         Scene newScene = new Scene(root);
	         Stage newStage = new Stage();
	         NuevaOlimpiadaController control= loader.getController();
	         //control.cargarLista(listaOlimpiada);
	         control.setOlimpiadalbl("Modificar Olimpiada");
	         newStage.initModality(Modality.APPLICATION_MODAL);
	         newStage.initOwner(this.btnCrear.getScene().getWindow());
	         newStage.setScene(newScene);
	         newStage.showAndWait();
	        
		 }
		 catch (Exception e) {
			System.out.println(e);
		}
	 }
	
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		listaOlimpiada = FXCollections.observableArrayList();
		tablaOlim.setItems(listaOlimpiada);
		colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colNombre.prefWidthProperty().bind(tablaOlim.widthProperty().multiply(0.3));
		colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
		colAnio.prefWidthProperty().bind(tablaOlim.widthProperty().multiply(0.1));
		colTemporada.setCellValueFactory(new PropertyValueFactory<>("temporada"));
		colTemporada.prefWidthProperty().bind(tablaOlim.widthProperty().multiply(0.2));
		colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
		colCiudad.prefWidthProperty().bind(tablaOlim.widthProperty().multiply(0.4));
		
		
		
	}
	
}
