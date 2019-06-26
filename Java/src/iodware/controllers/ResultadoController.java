package iodware.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import iodware.actions.StringsFinal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultadoController implements Initializable{

	@FXML
	private Button botaoinicio;
	@FXML
	private Button botaovoltar;
	@FXML
	public Label tdp;
	@FXML
	public Label gpucpu;
	@FXML
	public Label mobo;
	@FXML
	public Label ram;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tdp.setText(StringsFinal.tdp);
		gpucpu.setText(StringsFinal.cpugpu);
		mobo.setText(StringsFinal.remobo);
		ram.setText(StringsFinal.reram);		
	}

	public void inicio() throws IOException {
		Stage stage = (Stage) botaoinicio.getScene().getWindow();
		Parent inicio = FXMLLoader.load(getClass().getResource("../../telas/tela_inicio.fxml"));
		Scene scene = new Scene(inicio);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void voltar() throws IOException {
		Stage stage = (Stage) botaovoltar.getScene().getWindow();
		Parent voltar = FXMLLoader.load(getClass().getResource("../../telas/tela_escolha.fxml"));
		Scene scene = new Scene(voltar);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
}
