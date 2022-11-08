package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NuevaOlimpiadaController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGuardar;
    
    @FXML
    private Label olimpiadalbl;
    
    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTemporada;

    @FXML
    private TextField txtanio;

    
    
    
    
	public Label getOlimpiadalbl() {
		return olimpiadalbl;
	}

	public void setOlimpiadalbl(String olimpiadalbl) {
		this.olimpiadalbl.setText(olimpiadalbl);
	}

	public Button getBtnCancelar() {
		return btnCancelar;
	}

	public Button getBtnGuardar() {
		return btnGuardar;
	}

	public TextField getTxtCiudad() {
		return txtCiudad;
	}

	public TextField getTxtNombre() {
		return txtNombre;
	}

	public TextField getTxtTemporada() {
		return txtTemporada;
	}

	public TextField getTxtanio() {
		return txtanio;
	}
    
    
    
}
