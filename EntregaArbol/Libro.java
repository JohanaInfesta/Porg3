package Entrega;

import java.util.ArrayList;

public class Libro {

	private String titulo;
	private String autor;
	private String cantidadPaginas;
	ArrayList<String> generos;

	public Libro(String titulo, String autor, String cantidadPaginas, ArrayList<String> arrayGeneros) {
		this.titulo = titulo;
		this.autor = autor;
		this.cantidadPaginas = cantidadPaginas;
		this.generos = arrayGeneros;
	}

	public void addGeneros(String g) {
		generos.add(g);
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCantidadPaginas() {
		return cantidadPaginas;
	}
	public void setCantidadPaginas(String cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public ArrayList<String> getGeneros() {
		return new ArrayList<>(generos);
	}

	public void addGenero(String genero) {
		generos.add(genero);
	}
	//	
	//	public Boolean contiene(String genero) {
	//		return generos.contains(genero);
	//	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor
				+ ", cantidadPaginas=" + cantidadPaginas + "]";
	}


}
