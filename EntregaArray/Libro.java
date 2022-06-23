package EntregaArray;

import java.util.ArrayList;

public class Libro {
	
	
	private String titulo;
	private String autor;
	private String paginas;
	private ArrayList<String>generos; // preguntar cual es la mejor opcion para el conjunto de generos
	
	
	public Libro( String titulo, String autor, String paginas, 	ArrayList<String> generos) {
		
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.generos = generos;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getPaginas() {
		return paginas;
	}

	public ArrayList<String> getGeneros() {
		return generos;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	public void setGeneros(ArrayList<String> generos) {
		this.generos = generos;
	}

	@Override
	public String toString() {
		return "Libro titulo=" + titulo + ", autor=" + autor + ", paginas="
				+ paginas + ", generos=" + generos;
	}
	
	

}
