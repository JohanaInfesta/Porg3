package EntregaArray;

import java.util.ArrayList;

public class Genero {

	ArrayList<Libro> libros;
	String nombre;
	
	public Genero(String n) {
		libros = new ArrayList<Libro>();
		nombre = n;
	}
	
	public void addLibro(Libro l) {
		libros.add(l);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean contieneLibro(Libro l) {
		return libros.contains(l);
	}

	@Override
	public String toString() {
		return "Genero [nombre=" + nombre + ", libros=" + libros + "]";
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}
	

	
}
