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
		
		Connection con1 = Conexao.getConnection();
		try {

		PreparedStatement ps = con1.prepareStatement("SELECT * FROM placaMae WHERE nome = ?");

		ps.setString(1, nome);

		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			mobo.setNome(rs.getString("nome"));
			mobo.setModelo(rs.getString("modelo"));
			mobo.setSocket(rs.getString("socket"));
			mobo.setSlotmemo(rs.getInt("slot_memo"));
			mobo.setSlotpci(rs.getInt("slot_pci"));
			mobo.setSaidas(rs.getString("saidas"));
	
			}

		} catch (SQLException e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}finally {
			Conexao.closeConnection(con1);
		}	
		
		nomemobo.setText(mobo.getNome());
		modmobo.setText(mobo.getModelo());
		socketmobo.setText("Socket "+mobo.getSocket());
		slotrammobo.setText(Integer.toString(mobo.getSlotmemo())+" Slots de RAM");
		slotpcimobo.setText(Integer.toString(mobo.getSlotpci())+" Slots PCI");
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
