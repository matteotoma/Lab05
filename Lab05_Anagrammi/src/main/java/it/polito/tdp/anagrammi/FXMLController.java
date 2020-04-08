package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.RicercaAnagrammi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private RicercaAnagrammi ric;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;
    
    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	String parola = txtParola.getText();
    	if(parola.equals("") || parola.contains(" ")) {
    		txtCorretti.appendText("Devi inserire una parola\n");
    		txtErrati.appendText("Devi inserire una parola\n");
    		return;
    	}
    	else {
    		ric.anagrammi(parola);
    		List<String> anagrammiCorretti = ric.getCorretti();
    		List<String> anagrammiErrati = ric.getErrati();
    		for(String c: anagrammiCorretti)
    			txtCorretti.appendText(c+"\n");
    		for(String e: anagrammiErrati)
    			txtErrati.appendText(e+"\n");
    		return;
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
    	assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(RicercaAnagrammi ric) {
		this.ric = ric;
	}
}