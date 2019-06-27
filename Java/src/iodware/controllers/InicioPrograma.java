package iodware.controllers;


import java.io.IOException;
import java.sql.SQLException;

import iodware.actions.Creator;
import iodware.infra.ConnectionJDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioPrograma extends Application {
	
	private static Stage stage;
	
	private static Scene comeco;
	private static Scene choice;
	private static Scene about;
	private static Scene compo;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		
		primaryStage.setTitle("IODware");
		
		Parent inicio = FXMLLoader.load(getClass().getResource("../../telas/tela_inicio.fxml"));		
		comeco = new Scene(inicio);
		
		Parent escolha = FXMLLoader.load(getClass().getResource("../../telas/tela_escolha.fxml"));		
		choice = new Scene(escolha);
		
		Parent sobre = FXMLLoader.load(getClass().getResource("../../telas/tela_sobre.fxml"));
		about = new Scene(sobre);
		
		Parent componentes = FXMLLoader.load(getClass().getResource("../../telas/tela_componentes.fxml"));
		compo = new Scene(componentes);
		
		primaryStage.setScene(comeco);
		primaryStage.show();
		
	}
	
	public static void ChangeScreen(String scr,Parent scene) {
		switch (scr) {
			case "inicio":
				stage.setScene(comeco);
				break;
			case "sobre":
				stage.setScene(about);
				break;
			case "escolha":
				stage.setScene(choice);
				break;
			case "componentes":
				stage.setScene(compo);
				break;
		}
	}
	
	public static void main(String[] args) {

		try {
			System.out.println("01");
			ConnectionJDBC.retornaCpu();
			System.out.println("0fim");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		launch(args);
		FXMLLoader loader  = new FXMLLoader();

		launch(args);		

	}
	
	public static void fechar() {
		stage.close();
	}
	

}
