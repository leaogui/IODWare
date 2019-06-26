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

public class TelaEscolha implements Initializable{

	@FXML
	private Button botaovoltar;
	@FXML
	private Button botaofinalizar;
	@FXML
	public ChoiceBox<String> boxgpu;
	@FXML
	public ChoiceBox<String> boxcpu;
	@FXML
	public ChoiceBox<String> boxpsu;
	@FXML
	public ChoiceBox<String> boxmobo;
	@FXML
	public ChoiceBox<String> boxram	;
	
	ObservableList<String> listgpu = FXCollections.observableArrayList();
	ObservableList<String> listcpu = FXCollections.observableArrayList();
	ObservableList<String> listpsu = FXCollections.observableArrayList();
	ObservableList<String> listmobo = FXCollections.observableArrayList();
	ObservableList<String> listram = FXCollections.observableArrayList();
	
	public void valores_gpu() {
		listgpu.removeAll();
		String a = "GTX 1050";
		String b = "GTX 1050 TI";
		String c = "GTX 1060";
		String d = "GTX 1070";
		String e = "GTX 1080";
		listgpu.addAll(a,b,c,d,e);
		boxgpu.getItems().addAll(listgpu);
	}
	
	public void valores_cpu() {
		listcpu.removeAll();
		String a = "Intel Core I5 8400";
		String b = "Intel Core I7 8700";
		String c = "Ryzen 5 2600";
		String d = "Ryzen 7 2700";
		listcpu.addAll(a,b,c,d);
		boxcpu.getItems().addAll(listcpu);
	}
	
	public void valores_psu() {
		listpsu.removeAll();
		String a = "400 Watts";
		String b = "500 Watts";
		String c = "600 Watts";
		listpsu.addAll(a,b,c);
		boxpsu.getItems().addAll(listpsu);
	}
	
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
		valores_gpu();
		boxgpu.setValue("GTX 1050");
		valores_cpu();
		boxcpu.setValue("Intel Core I5 8400");
		valores_psu();
		boxpsu.setValue("400 Watts");
		valores_mobo();
		boxmobo.setValue("h310");
		valores_ram();
		boxram.setValue("Pente 4gb");
	}

	public void voltar() throws IOException {
		Stage stage = (Stage) botaovoltar.getScene().getWindow();
		Parent voltar = FXMLLoader.load(getClass().getResource("../../telas/tela_inicio.fxml"));
		Scene scene = new Scene(voltar);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void finalizar() throws IOException {
		Stage stage = (Stage) botaofinalizar.getScene().getWindow();
		Parent finali = FXMLLoader.load(getClass().getResource("../../telas/tela_resultado.fxml"));
		Scene scene = new Scene(finali);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
}
