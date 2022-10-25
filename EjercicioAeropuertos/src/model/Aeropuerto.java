package model;

public class Aeropuerto {
	
	private String nombre, ciudad, pais, calle, numero;
	private int anioInaguracion, capacidad, numSocios, numTrabajdores, numCalle;
	private double financiacion;
	
	public Aeropuerto(String nombre, String pais, String ciudad, String calle, int numCalle, int anioIna, int capacidad, int numSocios) {
		
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
		this.calle = calle;
		this.numCalle = numCalle;
		this.anioInaguracion = anioIna;
		this.capacidad = capacidad;
		this.numSocios = numSocios;
	}
	
	public Aeropuerto(String nombre, String pais, String ciudad, String calle, int numCalle, int anioIna, int capacidad, double financiacion,  int numTrabaja) {
		
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
		this.calle = calle;
		this.numCalle = numCalle;
		this.anioInaguracion = anioIna;
		this.capacidad = capacidad;
		this.financiacion = financiacion;
		this.numTrabajdores = numTrabaja;
	}
}
