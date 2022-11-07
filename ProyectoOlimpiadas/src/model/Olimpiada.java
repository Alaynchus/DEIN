package model;

public class Olimpiada {
	private String nombre, temporada, ciudad;
	private int anio;
	
	public Olimpiada(String nom, int anio, String temporada, String ciudad) {
		this.nombre=nom;
		this.anio=anio;
		this.temporada=temporada;
		this.ciudad=ciudad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
}
