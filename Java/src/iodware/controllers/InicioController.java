package iodware.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioController implements Initializable{

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	protected void mudarSobre(ActionEvent event) throws IOException{	
		Parent sobre = FXMLLoader.load(getClass().getResource("../../telas/tela_sobre.fxml"));
		InicioPrograma.ChangeScreen("sobre",sobre);
	}
	
	@FXML
	protected void mudarInicio(ActionEvent event) throws IOException{	
		Parent escolha = FXMLLoader.load(getClass().getResource("../../telas/tela_escolha.fxml"));
		InicioPrograma.ChangeScreen("escolha",escolha);
	}	
	
	@FXML
	protected void mudarComponente(ActionEvent event) throws IOException{	
		Parent compo = FXMLLoader.load(getClass().getResource("../../telas/tela_componentes.fxml"));
		InicioPrograma.ChangeScreen("componentes",compo);
	}
	
	@FXML
	private void sairPrograma(ActionEvent event) {
		InicioPrograma.fechar();
	}
	
}
