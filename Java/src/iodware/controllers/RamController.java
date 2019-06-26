package iodware.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class RamController implements Initializable{

	@FXML
	private Button botaovoltar;
	@FXML
	public ChoiceBox<String> boxram	;
	
	ObservableList<String> listram = FXCollections.observableArrayList();
	
	public void valores_ram() {
		listram.removeAll();
		String a = "Pente 4gb";
		String b = "Pente 8gb";
		String c = "Pente 16gb";
		listram.addAll(a,b,c);
		boxram.getItems().addAll(listram);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		valores_ram();
		boxram.setValue("Pente 4gb");
		
	}
	
	public void checar() throws IOException {
		
		String nome;
		
		nome = boxram.getValue();
		
		
	}
	
	public void voltar() throws IOException {
		Stage stage = (Stage) botaovoltar.getScene().getWindow();
		Parent voltar = FXMLLoader.load(getClass().getResource("../../telas/tela_componentes.fxml"));
		Scene scene = new Scene(voltar);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
