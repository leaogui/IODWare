package iodware.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import iodware.actions.Creator;
import iodware.pcbuild.Mobo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MoboController implements Initializable{

	@FXML
	private Button botaovoltar;
	@FXML
	private Button checar;
	@FXML
	public ChoiceBox<String> boxmobo;
	@FXML
	public Label nomemobo;
	@FXML
	public Label modmobo;
	@FXML
	public Label socketmobo;
	@FXML
	public Label slotrammobo;
	@FXML
	public Label slotpcimobo;
	
	
	ObservableList<String> listmobo = FXCollections.observableArrayList();
	
	Creator c = new Creator();
	
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
	
	public void checar() throws IOException {
		
		String nome;
		
		nome = boxmobo.getValue();
		
		Mobo mobo = c.criarMobo(nome);
		
		nomemobo.setText(mobo.getNome());
		modmobo.setText(mobo.getModelo());
		socketmobo.setText(mobo.getSocket());
		slotrammobo.setText(Integer.toString(mobo.getSlotmemo()));
		slotpcimobo.setText(Integer.toString(mobo.getSlotpci()));
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
