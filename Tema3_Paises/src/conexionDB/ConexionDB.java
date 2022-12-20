package conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

	private Connection conexion;


	public ConexionDB() throws SQLException {

		String user = "admin";

	        String password = "password";

	        String url = "jdbc:mysql://localhost/paises?serverTimezone=Europe/Madrid";

		conexion = DriverManager.getConnection(url, user, password);

		conexion.setAutoCommit(true);
	}

	public Connection getConexion() {

		return conexion;

	}
}
