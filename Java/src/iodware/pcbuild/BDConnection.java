package iodware.pcbuild;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {

	public static java.sql.Connection getConexaoMySQL() {
		Connection connection = null;          //atributo do tipo Connection
 
		try {
 
			// Carregando o JDBC Driver padr�o
 
			String driverName = "com.mysql.jdbc.Driver";                        
 
			Class.forName(driverName);
 
  
 
			// Configurando a nossa conex�o com um banco de dados//
 
			String serverName = new String("localhost");    			  //caminho do servidor do BD
 
			String mydatabase =  new String("mysql");        //nome do seu banco de dados
 
			String url = new String("jdbc:mysql://" + serverName + "/" + mydatabase);
 
			String username = new String("root");        //nome de um usu�rio de seu BD      
 
			String password = new String("123456");      //sua senha de acesso
 
			connection = DriverManager.getConnection(url, username, password);
 
 
 
			//Testa sua conex�o//  
 
			if (connection != null) {
 
				status = ("STATUS--->Conectado com sucesso!");
 
			} else {
 
				status = ("STATUS--->N�o foi possivel realizar conex�o");
 
			}
 
 
 
			return connection;
 
  
 
        } catch (ClassNotFoundException e) {  //Driver n�o encontrado
 
  
 
            System.out.println("O driver expecificado nao foi encontrado.");
 
            return null;
 
        } catch (SQLException e) {
 
        	//N�o conseguindo se conectar ao banco
 
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
 
            return null;
 
        }
 
  
 
    }
 
  
 
    //M�todo que retorna o status da sua conex�o//
 
    public static String statusConection() {
 
        return status;
 
    }
 
   
 
   //M�todo que fecha sua conex�o//
 
    public static boolean FecharConexao() {
 
        try {
 
            ConexaoMySQL.getConexaoMySQL().close();
 
            return true;
 
        } catch (SQLException e) {
 
            return false;
 
        }
 
  
 
    }
 
   
 
   //M�todo que reinicia sua conex�o//
 
    public static java.sql.Connection ReiniciarConexao() {
 
        FecharConexao();
 
  
 
        return ConexaoMySQL.getConexaoMySQL();
 
    }
 
}
	
	
}
