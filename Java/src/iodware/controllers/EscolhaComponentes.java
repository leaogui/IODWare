package iodware.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EscolhaComponentes implements Initializable {

	@FXML
	private Button botaovoltar;
	@FXML
	private Button botaogpu;
	@FXML
	private Button botaocpu;
	@FXML
	private Button botaoram;
	@FXML
	private Button botaopsu;
	@FXML
	private Button botaomobo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void voltar() throws IOException {
		Stage stage = (Stage) botaovoltar.getScene().getWindow();
		Parent voltar = FXMLLoader.load(getClass().getResource("../../telas/tela_inicio.fxml"));
		Scene scene = new Scene(voltar);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void telaGpu() throws IOException {
		Stage stage = (Stage) botaogpu.getScene().getWindow();
		Parent tela = FXMLLoader.load(getClass().getResource("../../telas/tela_gpu.fxml"));
		Scene scene = new Scene(tela);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void telaCpu() throws IOException {
		Stage stage = (Stage) botaocpu.getScene().getWindow();
		Parent tela = FXMLLoader.load(getClass().getResource("../../telas/tela_cpu.fxml"));
		Scene scene = new Scene(tela);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void telaRam() throws IOException {
		Stage stage = (Stage) botaoram.getScene().getWindow();
		Parent tela = FXMLLoader.load(getClass().getResource("../../telas/tela_ram.fxml"));
		Scene scene = new Scene(tela);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void telaPsu() throws IOException {
		Stage stage = (Stage) botaopsu.getScene().getWindow();
		Parent tela = FXMLLoader.load(getClass().getResource("../../telas/tela_psu.fxml"));
		Scene scene = new Scene(tela);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void telaMobo() throws IOException {
		Stage stage = (Stage) botaomobo.getScene().getWindow();
		Parent voltar = FXMLLoader.load(getClass().getResource("../../telas/tela_placamae.fxml"));
		Scene scene = new Scene(voltar);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	

}
