package iodware.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import iodware.actions.Conexao;
import iodware.actions.Creator;
import iodware.pcbuild.Ram;
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

public class RamController implements Initializable{

	@FXML
	private Button botaovoltar;
	@FXML
	private Button checar;
	@FXML
	public ChoiceBox<String> boxram	;
	@FXML
	public Label nomeram;
	@FXML
	public Label clockram;
	@FXML
	public Label tamram;
	
	ObservableList<String> listram = FXCollections.observableArrayList();
	
	Creator c = new Creator();
	
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
		
		Ram ram = c.criarRam(nome);
		
		Connection con2 = Conexao.getConnection();
		try {

		PreparedStatement ps = con2.prepareStatement("SELECT * FROM ram WHERE nome = ?");

		ps.setString(1, nome);

		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			ram.setNome(rs.getString("nome"));
			ram.setGen(rs.getString("geracao"));
			ram.setClock(rs.getInt("clock"));
			ram.setSize(rs.getInt("tamanho"));
			}

		} catch (SQLException e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}finally {
			Conexao.closeConnection(con2);
		}
		
		nomeram.setText(ram.getNome());
		clockram.setText(Integer.toString(ram.getClock())+"MHZ");
		tamram.setText(Integer.toString(ram.getSize())+"GB");
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
