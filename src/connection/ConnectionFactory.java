package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";	
	private static final String URL = "jdbc:mysql://localhost:3306/gerenciador_anuncio";
	private static final String USER ="root";
	private static final String PASS ="root";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro na conexao: ",ex);
			
		}
	}
	
	
	public static void closeConnection(Connection con) {	
			try {
				if(con != null) {
					con.close();					
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);		
			try {
				if(stmt != null) {
					stmt.close();
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con,stmt);	
	
			try {
				if(rs != null) {
					rs.close();					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
		

}
