package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private Connection miConexion;
	
	public Connection conectar() {
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbeducar_java", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return miConexion;
	}
}
