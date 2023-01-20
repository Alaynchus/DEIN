package model;

import java.sql.Date;


public class Historico_prestamo {

	private int id_prestamo, codigo_libro;
	private String dni_alumno;
	private Date fecha_prestamo, fecha_devolucion;
	
	public Historico_prestamo(int id_prestamo, String dni_alumno, int codigo_libro, Date fecha_prestamo, Date fecha_devolucion) {
		this.id_prestamo = id_prestamo;
		this.dni_alumno = dni_alumno;
		this.codigo_libro = codigo_libro;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
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

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	@Override
	public String toString() {
		return "Historico_prestamo [id_prestamo=" + id_prestamo + ", codigo_libro=" + codigo_libro + ", dni_alumno="
				+ dni_alumno + ", fecha_prestamo=" + fecha_prestamo + ", fecha_devolucion=" + fecha_devolucion + "]";
	}
	
	
	
}
