package model;

import java.io.InputStream;
import java.sql.Date;

import org.joda.time.DateTime;

public class Prestamo {

	private int id_prestamo, codigo_libro;
	private String dni_alumno;
	private Date fecha_prestamo;
	
	public Prestamo(int id_pres, String dni_alum, int codigo_lib, Date fecha_pres) {
		this.id_prestamo = id_pres;
		this.dni_alumno = dni_alum;
		this.codigo_libro = codigo_lib;
		this.fecha_prestamo = fecha_pres;
	}
	
	public int getId_prestamo() {
		return id_prestamo;
	}
	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}
	public int getCodigo_libro() {
		return codigo_libro;
	}
	public void setCodigo_libro(int codigo_libro) {
		this.codigo_libro = codigo_libro;
	}
	public String getDni_alumno() {
		return dni_alumno;
	}
	public void setDni_alumno(String dni_alumno) {
		this.dni_alumno = dni_alumno;
	}
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	@Override
	public String toString() {
		return "Prestamo [id_prestamo=" + id_prestamo + ", codigo_libro=" + codigo_libro + ", dni_alumno=" + dni_alumno
				+ ", fecha_prestamo=" + fecha_prestamo + "]";
	}
	
	
	
	
	
	
}
