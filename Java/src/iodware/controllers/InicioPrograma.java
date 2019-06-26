package iodware.controllers;

import iodware.actions.Creator;
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
	private static Scene result;
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
		launch(args);
		FXMLLoader loader  = new FXMLLoader();
		
	}
	
	public static void fechar() {
		stage.close();
	}
	

}
