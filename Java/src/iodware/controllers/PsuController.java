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

public class PsuController implements Initializable{

	@FXML
	private Button botaovoltar;
	@FXML
	public ChoiceBox<String> boxpsu;
	
	ObservableList<String> listpsu = FXCollections.observableArrayList();
	
	public void valores_psu() {
		listpsu.removeAll();
		String a = "400 Watts";
		String b = "500 Watts";
		String c = "600 Watts";
		listpsu.addAll(a,b,c);
		boxpsu.getItems().addAll(listpsu);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		valores_psu();
		boxpsu.setValue("400 Watts");
		
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
