package iodware.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import iodware.actions.Creator;
import iodware.pcbuild.Gpu;
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

public class GpuController implements Initializable{

	@FXML
	private Button botaovoltar;
	@FXML
	private Button checar;
	@FXML
	public ChoiceBox<String> boxgpu;
	@FXML
	public Label nomegpu;
	@FXML
	public Label tdpgpu;
	@FXML
	public Label clockgpu;
	@FXML
	public Label memogpu;
		
	ObservableList<String> listgpu = FXCollections.observableArrayList();

	Creator c = new Creator();
	
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		valores_gpu();
		boxgpu.setValue("GTX 1050");
		
	}
	
	public void checar() throws IOException {
		
		String nome;
		
		nome = boxgpu.getValue();
		
		Gpu gpu = c.criarGpu(nome);
		
		nomegpu.setText(gpu.getNome());
		tdpgpu.setText(Integer.toString(gpu.getTdp()));
		clockgpu.setText(Integer.toString(gpu.getClock()));
		memogpu.setText(gpu.getMemory());
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
