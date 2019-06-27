package iodware.infra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionJDBC {
	 public static Connection createConnection() throws SQLException, IOException {
	        String url = "jdbc:mysql:Banco de Dados/BancoDeDadosIODWare.sql"; //Nome da base de dados
	        Connection conexao = null;  
	  
	        conexao = DriverManager.getConnection(url);
	        if (conexao == null) {
	        	throw new IOException("Erro em conectar no banco de dados");
	        }else {
	        	return conexao; 
	        }
	 }
	 
	 public static void retornaCpu() throws SQLException, IOException{
		 Connection conn = null;
		 conn = createConnection();
		 PreparedStatement ps = null;
		
		
		try {
			String sql = "SELECT * FROM cpu";
			ps = conn.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
		 
			while(rs.next()){
				    int id = rs.getInt("codigo");
				    System.out.printf("Id %d \n",id);
				}
		}catch(SQLException e){
			throw new IOException("Erro em conectar no banco de dados");
		
		}
	 
	 } 
	 
}
