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
import iodware.pcbuild.Psu;
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

public class PsuController implements Initializable{

	@FXML
	private Button botaovoltar;
	@FXML
	private Button checar;
	@FXML
	public ChoiceBox<String> boxpsu;
	@FXML
	public Label nomepsu;
	@FXML
	public Label wattspsu;
	@FXML
	public Label eighty;
	@FXML
	public Label pfc;
	
	ObservableList<String> listpsu = FXCollections.observableArrayList();
	
	Creator c = new Creator();
	
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
	
	public void checar() throws IOException {
		
		String nome;
		
		nome = boxpsu.getValue();
		
		Psu psu = c.criarPsu(nome);
		
		Connection con3 = Conexao.getConnection();
		try {

		PreparedStatement ps = con3.prepareStatement("SELECT * FROM fonte WHERE nome = ?");

		ps.setString(1, nome);

		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			psu.setNome(rs.getString("nome"));
			psu.setWatts(rs.getInt("watts"));
			psu.setSeisPinos(rs.getInt("cabosSeisPinos"));
			psu.setEightyP(rs.getString("eightyplus"));
			psu.setPfc(rs.getBoolean("pfc"));
			}

		} catch (SQLException e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}finally {
			Conexao.closeConnection(con3);
		}
		
		nomepsu.setText("Fonte "+psu.getNome());
		wattspsu.setText(Integer.toString(psu.getWatts())+"Watts");
		eighty.setText("80+"+psu.getEightyP());
		if(psu.getPfc() == true) {
			pfc.setText("Pfc Ativo");
		}else {
			pfc.setText("Pfc Desativado");
		}
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
