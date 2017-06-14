/**
 * Sample Skeleton for 'Rivers.fxml' Controller Class
 */

package it.polito.tdp.rivers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import it.polito.tdp.model.Risultato;
import it.polito.tdp.model.River;
import it.polito.tdp.model.Statistiche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RiversController {
	
	Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<River> boxRiver; // Value injected by FXMLLoader

	@FXML
	private TextField txtStartDate; // Value injected by FXMLLoader

	@FXML
	private TextField txtEndDate; // Value injected by FXMLLoader

	@FXML
	private TextField txtNumMeasurements; // Value injected by FXMLLoader

	@FXML
	private TextField txtFMed; // Value injected by FXMLLoader

	@FXML
	private TextField txtK; // Value injected by FXMLLoader

	@FXML
	private Button btnSimula; // Value injected by FXMLLoader

	@FXML
	private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doRiempi(ActionEvent event) {
    	txtStartDate.clear();
    	txtEndDate.clear();
    	txtNumMeasurements.clear();
    	txtFMed.clear();
		
    	try {
		
			River river = boxRiver.getValue() ;
			
			Statistiche statistiche = model.getStatistiche(river);
			
			txtStartDate.setText(String.valueOf(statistiche.getPrimaData()));
			txtEndDate.setText(String.valueOf(statistiche.getUltimaData()));
			txtNumMeasurements.setText(String.valueOf(statistiche.getNMisure()));
			txtFMed.setText(String.valueOf(statistiche.getFmed()));
			
		} catch (RuntimeException re) {
			txtResult.setText(re.getMessage());
		}

    }

    @FXML
    void doSimula(ActionEvent event) {
    	txtResult.clear();
    	
    	try {
			double k = Double.parseDouble(txtK.getText());
			
			Risultato r = model.run(boxRiver.getValue(), k);
			
			txtResult.setText("Numero di giorni in cui non si è potuta garantire l’erogazione minima: "+r.getNGiorni()+"\n");
			txtResult.appendText("Occupazione media: "+r.getOccupazioneMedia()+"\n");
	
    	} catch (NumberFormatException e) {
			txtResult.setText("Inserire un fattore di scala k nel formato corretto.");
		} catch (RuntimeException re) {
			txtResult.setText(re.getMessage());
		}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";
    }

	public void setModel(Model model) {
		this.model = model;
		boxRiver.getItems().addAll(model.getAllRivers());
	}
}
