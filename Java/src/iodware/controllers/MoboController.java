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

public class MoboController implements Initializable{

	@FXML
	private Button botaovoltar;
	@FXML
	public ChoiceBox<String> boxmobo;
	
	
	ObservableList<String> listmobo = FXCollections.observableArrayList();
	
	public void valores_mobo() {
		listmobo.removeAll();
		String a = "h310";
		String b = "b360";
		String c = "z370";
		String d = "a320";
		String e = "b350";
		String f = "x370";
		listmobo.addAll(a,b,c,d,e,f);
		boxmobo.getItems().addAll(listmobo);
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		valores_mobo();
		boxmobo.setValue("h310");
		
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
