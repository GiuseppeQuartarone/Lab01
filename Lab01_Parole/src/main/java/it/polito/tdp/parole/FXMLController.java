package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parola;
import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	Parola elenco2;
	
	long start, end;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;
   
    @FXML
    private Button btnCancella;
    
    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtTempo;

    @FXML
    void doCancel (ActionEvent event) {
    	start = System.nanoTime();
    	String s = txtParola.getText();
    	if(elenco.getElenco().contains(s))
    		elenco.cancella(s);
    	String ss = "";
    	for(int i=0;i<elenco.getElenco().size();i++) {
    	ss +=elenco.getElenco().get(i)+"\n";
    	}
    	txtResult.setText(ss);
    	txtParola.clear();
    	end = System.nanoTime();
    	txtTempo.setText((end-start)+" nanosecondi"); 
    	return;
    }
    
    @FXML 
    void doInsert(ActionEvent event) {
    	start = System.nanoTime();
    	String s = txtParola.getText();
    	elenco.addParola(s);
    	String ss = "";
    	for(int i=0;i<elenco.getElenco().size();i++) {
    	ss +=elenco.getElenco().get(i)+"\n";
    	}
    	txtResult.setText(ss);
    	txtParola.clear();
    	end = System.nanoTime();
    	txtTempo.setText((end-start)+" nanosecondi"); 
    	return;
    }

    @FXML
    void doReset(ActionEvent event) {
    	start = System.nanoTime();
    	elenco.reset();
    	this.txtParola.clear();
    	this.txtResult.clear();
    	end = System.nanoTime();
    	txtTempo.setText((end-start)+" nanosecondi");
    	return;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
        elenco2 = new Parola() ;
    }
}
