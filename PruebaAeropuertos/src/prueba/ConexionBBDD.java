package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBBDD {

	public static void main(String[] args) {
		try{
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establecemos la conexión con la BD
			Connection conexión = DriverManager.getConnection ("jdbc:mysql://localhost/aeropuertos","admin", "password");
			
			
			// Preparamos la consulta
			PreparedStatement pst = conexión.prepareStatement("delete from aviones where id=?");
			System.out.println("id a borrar");
			pst.setString(1, Consola.leeString());
			pst.execute();
//			PreparedStatement pst = conexión.prepareStatement("insert into aviones values(?,?,?,?,?,?)");
//			System.out.println("id");
//			pst.setString(1, Consola.leeString());
//			System.out.println("modelo");
//			pst.setString(2, Consola.leeString());
//			System.out.println("numero de asientos");
//			pst.setString(3, Consola.leeString());
//			System.out.println("velocidad maxima");
//			pst.setString(4, Consola.leeString());
//			System.out.println("activo");
//			pst.setString(5, Consola.leeString());
//			System.out.println("id_aeropuerto");
//			pst.setString(6, Consola.leeString());
//			pst.execute();
//			PreparedStatement pst = conexión.prepareStatement("SELECT * FROM aviones WHERE numero_asientos>? and velocidad_maxima>?");
//			System.out.println("Introduce cantidad de asientos para filtrar");
//			pst.setString(1, Consola.leeString());
//			System.out.println("Introduce valocidad maxima para filtrar");
//			pst.setString(2, Consola.leeString());
//			ResultSet resul = pst.executeQuery ();
//			
			// Recorremos el resultado para visualizar cada fila
			// Se hace un bucle mientras haya registros, se van visualizando
			
			
			pst.close();// Cerrar ResultSet
		
			conexión.close();//Cerrar conexión
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
