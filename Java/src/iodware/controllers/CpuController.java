package iodware.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import iodware.actions.Creator;
import iodware.pcbuild.Cpu;
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

public class CpuController implements Initializable{

	@FXML
	private Button botaovoltar;
	@FXML
	private Button checar;
	@FXML
	public ChoiceBox<String> boxcpu;
	@FXML
	public Label nomecpu;
	@FXML
	public Label tdpcpu;
	@FXML
	public Label clockcpu;
	@FXML
	public Label slotcpu;
	@FXML
	public Label corescpu;
	
	
	ObservableList<String> listcpu = FXCollections.observableArrayList();
	
	Creator c = new Creator();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		valores_cpu();
		boxcpu.setValue("Intel Core I5 8400");
		
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
	
	public void checar() throws IOException {
		
		String nome;
		
		nome = boxcpu.getValue();
		
		Cpu cpu = c.criarCpu(nome);
		
		nomecpu.setText(cpu.getNome());
		tdpcpu.setText(Integer.toString(cpu.getTdp()));
		clockcpu.setText(Integer.toString(cpu.getClock()));
		slotcpu.setText(cpu.getSocket());
		corescpu.setText(Integer.toString(cpu.getCores()));
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
