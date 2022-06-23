package Entrega;

import java.util.ArrayList;

public class Genero {

	Genero der, izq;
	private String nombre;
	private ArrayList<Libro> libros;
	
	public Genero(String nombre) {
		this.nombre = nombre;
		this.libros = new ArrayList<>();
		izq = der = null;
	}
	
	public void addLibro(Libro l) {
			libros.add(l);			
	}
	
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Libro> getLibros() {
		return new ArrayList<>(libros);
	}

	public Genero getDer() {
		return der;
	}

	public void setDer(Genero der) {
		this.der = der;
	}

	public Genero getIzq() {
		return izq;
	}

	public void setIzq(Genero izq) {
		this.izq = izq;
	}

	
	
	
}
