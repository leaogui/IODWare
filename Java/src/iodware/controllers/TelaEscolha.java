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
import iodware.actions.StringsFinal;
import iodware.pcbuild.Cpu;
import iodware.pcbuild.Gpu;
import iodware.pcbuild.Mobo;
import iodware.pcbuild.Psu;
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
	public ChoiceBox<String> boxram;
	@FXML
	public Label labeltopo;
	
	public String nomeGpu;
	public String nomeCpu;
	public String nomePsu;
	public String nomeRam;
	public String nomeMobo;

	static StringsFinal sf = new StringsFinal();
	Creator criador = new Creator();
	
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
		
		nomeGpu = boxgpu.getValue();
		nomeCpu = boxcpu.getValue();
		nomePsu = boxpsu.getValue();
		nomeRam = boxram.getValue();
		nomeMobo = boxmobo.getValue();
		
		Gpu gpu = criador.criarGpu(nomeGpu);
		Cpu cpu = criador.criarCpu(nomeCpu);
		Psu psu = criador.criarPsu(nomePsu);
		Ram ram = criador.criarRam(nomeRam);
		Mobo mobo = criador.criarMobo(nomeMobo); 
			
		
		// Conexão Processador
		
		
		Connection con = Conexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM cpu WHERE nome = ?");

			ps.setString(1, nomeCpu);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				cpu.setNome(rs.getString("nome"));
				cpu.setClock(rs.getInt("clock"));
				cpu.setCores(rs.getInt("cores"));
				cpu.setModelo(rs.getString("modelo"));
				cpu.setSocket(rs.getString("socket"));
				cpu.setGen(rs.getString("geracao"));
				cpu.setMthread(rs.getBoolean("MultiThread"));
				cpu.setTdp(rs.getInt("pdu"));
			}

		} catch (SQLException e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}finally {
			Conexao.closeConnection(con);
		}
		
			
		// Conexão Placa Mãe
		
		
		Connection con1 = Conexao.getConnection();
		try {

		PreparedStatement ps = con1.prepareStatement("SELECT * FROM placaMae WHERE nome = ?");

		ps.setString(1, nomeMobo);

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
		
		
		// Conexão Ram
		
		
		Connection con2 = Conexao.getConnection();
		try {

		PreparedStatement ps = con2.prepareStatement("SELECT * FROM ram WHERE nome = ?");

		ps.setString(1, nomeRam);

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
			
		
		// Conexão Fonte
		
		Connection con3 = Conexao.getConnection();
		try {

		PreparedStatement ps = con3.prepareStatement("SELECT * FROM fonte WHERE nome = ?");

		ps.setString(1, nomePsu);

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
		
		
		// Conexão Placa de Vídeo
		
		Connection con4 = Conexao.getConnection();
		try {

		PreparedStatement ps = con4.prepareStatement("SELECT * FROM placaVideo WHERE nome = ?");

		ps.setString(1, nomeGpu);

		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			gpu.setClock(rs.getInt("clock"));
			gpu.setNome(rs.getString("nome"));
			gpu.setMemory(rs.getString("memoria"));
			gpu.setModelo(rs.getString("modelo"));
			gpu.setSlot(rs.getString("slot"));
			gpu.setVentoinhas(rs.getInt("ventoinhas"));
			gpu.setSaidas(rs.getString("saidas"));
			gpu.setTdp(rs.getInt("pdu"));
			}

		} catch (SQLException e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}finally {
			Conexao.closeConnection(con4);
		}
			
		
		if(mobo.getSocket().equals(cpu.getSocket())) {
			validacao(gpu,cpu,psu,ram,mobo);
			Stage stage = (Stage) botaofinalizar.getScene().getWindow();
			Parent finali = FXMLLoader.load(getClass().getResource("../../telas/tela_resultado.fxml"));
			Scene scene = new Scene(finali);
			stage.setScene(scene);
			stage.setResizable(false);	
			stage.show();			
		} 
		else {
			labeltopo.setText("O Socket da placa mãe não pode ser diferente do socket do processador!");
		}
	}
	
	public void validacao(Gpu gpu, Cpu cpu, Psu psu, Ram ram, Mobo mobo) {
		
		if(mobo.getNome().equals("a320") || mobo.getNome().equals("h310")){
			StringsFinal.remobo = "Sua placa mãe não irá suportar upgrades para seu bom hardware no futuro.";
		}else {
			StringsFinal.remobo = "Sua placa mãe suportará upgrades.";
		}
		
		if(psu.getWatts() - (cpu.getTdp() + gpu.getTdp()) > 200) {
			StringsFinal.tdp = "Sua fonte não será confiável para sua build.";
		}else {
			StringsFinal.tdp = "Sua fonte suportará bem sua build";
		}
		
		if(mobo.getSlotmemo() > ram.getSize()) {
			StringsFinal.reram = "Você está usando pouca ram para sua build.";
		}else {
			StringsFinal.reram = "Você está usando ram suficiente para sua build";
		}
		
		if(cpu.getNome().equals("Ryzen 7 2700") && gpu.getNome().equals("GTX 1050") || gpu.getNome().equals("GTX 1050 TI")){
			StringsFinal.cpugpu = "Sua placa de vídeo é fraca para seu processador";
		}else 
			if(cpu.getNome().equals("Intel Core I7 8700") && gpu.getNome().equals("GTX 1050") || gpu.getNome().equals("GTX 1050 TI")){
			StringsFinal.cpugpu = "Sua placa de vídeo é fraca para seu processador";
		}
		else{
			StringsFinal.cpugpu = "Sua placa de vídeo é boa para seu processador";
			}
		
		
		
	}
}
