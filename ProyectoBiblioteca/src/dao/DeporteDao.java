package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexionBD.ConexionBD;
import dao.Olimpiada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Deporte;
import model.Evento;

public class DeporteDao {

	private ConexionBD conexion;

	public ObservableList<Deporte> cargarDeportes() throws Exception {
		ObservableList<Deporte> deportes = FXCollections.observableArrayList();
		String sql;

		conexion = new ConexionBD();
		Connection con = conexion.getConexion();

		sql = "SELECT * FROM Deporte;";

		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Deporte d = new Deporte(rs.getString("id_deporte"), rs.getString("nombre"));
			deportes.add(d);

		}
		rs.close();
		ps.close();

		con.close();

		return deportes;
	}

	public Deporte getDeporte(String id) throws Exception {
		Deporte d = null;
		String sql;

		conexion = new ConexionBD();
		Connection con = conexion.getConexion();
		
		sql = "SELECT * FROM Deporte WHERE id_deporte = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			d = new Deporte(rs.getString("id_deporte"), rs.getString("nombre"));
		}
		rs.close();
		ps.close();

		con.close();
		return d;
	}

	public String crearDeporte(Deporte d) {
		String sql, msg = "";
		try {
			conexion = new ConexionBD();
			PreparedStatement ps;
	
			sql = "INSERT INTO Deporte VALUES (?,?)";
			ps = conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, null);
			ps.setString(2, d.getNombre());
			ps.executeUpdate();
	
			ps.close();
			conexion.cerrarConexion();
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "Fallo al crear el Deporte";
		}
		return msg;
	}

	public String editarDeporte(Deporte d) {
		String sql, msg = "";
		
		try {
			conexion = new ConexionBD();
			Connection con = conexion.getConexion();
			PreparedStatement ps;
			System.out.println("1");
			sql = "UPDATE Deporte SET nombre = ? WHERE id_deporte = ? ;";
			ps = con.prepareStatement(sql);
			ps.setString(1, d.getNombre());
			ps.setString(2, d.getId_deporte());
			System.out.println(sql);
			ps.executeUpdate();
			System.out.println("3");
			ps.close();

			con.close();

			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Fallo al modificar el Deporte";
		}
		return msg;
	}

	public void borrarDeporte(Deporte d) throws Exception {
		ObservableList<Evento> eventos = FXCollections.observableArrayList();
		String sql;
		OlimpiadaDao oliDao = new OlimpiadaDao();
		DeporteDao depDao = new DeporteDao();
		Olimpiada olimpiada;
		Deporte deporte;

		conexion = new ConexionBD();
		Connection con = conexion.getConexion();
		PreparedStatement ps;

		sql = "SELECT * FROM Evento WHERE id_deporte = ? ;";
		ps = con.prepareStatement(sql);
		ps.setString(1, d.getId_deporte());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			olimpiada = oliDao.getOlimpiada(rs.getString("id_olimpiada"));
			deporte = depDao.getDeporte(rs.getString("id_deporte"));
			Evento e = new Evento(rs.getString("id_evento"), rs.getString("nombre"), olimpiada, deporte);
			eventos.add(e);
		}
		rs.close();

		for (Evento e : eventos) {
			sql = "SELECT * FROM Participacion WHERE id_evento = ? ;";
			ps = con.prepareStatement(sql);
			ps.setString(1, e.getId_evento());
			rs = ps.executeQuery();
			while (rs.next()) {
				sql = "DELETE FROM Participacion WHERE id_evento = ?  AND id_deportista = ?;";
				ps = con.prepareStatement(sql);
				ps.setString(1, e.getId_evento());
				ps.setString(2, rs.getString("id_deportista"));
				ps.executeUpdate();
			}
			rs.close();


			sql = "DELETE FROM Evento WHERE id_evento = ?;";
			ps = con.prepareStatement(sql);
			ps.setString(1, e.getId_evento());
			ps.executeUpdate();
		}
		sql = "DELETE FROM Deporte WHERE id_deporte =?;";
		ps = con.prepareStatement(sql);
		ps.setString(1, d.getId_deporte());
		ps.executeUpdate();

		ps.close();
		conexion.cerrarConexion();
	}
	
	public int verRepetidos(String nom) throws Exception {
		String sql;
		int respuesta = -1;
		try {
			conexion = new ConexionBD();
			Connection con = conexion.getConexion();
	
			sql = "SELECT count(*) as respuesta FROM Deporte WHERE nombre = ? ;";
	
			PreparedStatement ps = conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				respuesta = rs.getInt("respuesta");
			}
			rs.close();
			ps.close();
	
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = -1;
		}
		return respuesta;
			
	}
}
