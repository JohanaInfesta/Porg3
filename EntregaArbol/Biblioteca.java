package Entrega;

import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {

	Genero raiz;
	int cont;

	public Biblioteca(){
		raiz = null;
		cont = 0;
	}

	ArrayList<Genero>casilleros = new ArrayList<>();

	public void addLibro(Libro libro) {
		ArrayList<String>generosLibro = libro.getGeneros();
		Iterator<String>it = generosLibro.iterator();
		//itera sobre los string de los generos entrantes del libro
		while(it.hasNext()){
			String generoLibroEntrante = it.next();
			generoLibroEntrante =  generoLibroEntrante.toLowerCase(); //convierte en minuscula por las dudas que venga en mayuscula 
			agregarGenero(libro, generoLibroEntrante);//pasa a un metodo para agregar los libros al genero correspondiente
		}
	}

	//generamos una biblioteca en forma de arbol
	//primero si no existe una raiz la agregamos
	public void agregarGenero(Libro libro, String generoLibro){
		if(raiz == null){
			raiz = new Genero(generoLibro);
			raiz.addLibro(libro);
		}else{
			AgregarGenero(raiz, libro, generoLibro);
		}
	}
	//luego agregamos los nodos de la raiz
	private void AgregarGenero(Genero raiz, Libro libro, String generoLibro) {
		if(generoLibro.compareTo(raiz.getNombre()) < 0){
			if(raiz.getIzq() == null){
				Genero ge = new Genero(generoLibro);
				raiz.setIzq(ge);
				ge.addLibro(libro);
			}else if(raiz.getIzq().getNombre().equals(generoLibro)){
				raiz.getIzq().addLibro(libro);
			}
			else{
				AgregarGenero(raiz.getIzq(), libro, generoLibro);
			}
		}else{
			if(raiz.getDer() == null){
				Genero ge = new Genero(generoLibro);
				raiz.setDer(ge);
				ge.addLibro(libro);
			}else if(raiz.getDer().getNombre().equals(generoLibro)){
				raiz.getDer().addLibro(libro);
			}else{
				AgregarGenero(raiz.getDer(), libro, generoLibro);
			}
		}
		
	}

	

	
	public ArrayList<Libro> getLibros(String genero){
//		long start = System.currentTimeMillis();
		String generoEntrante = genero.toLowerCase();
		ArrayList<Libro>resultado = new ArrayList<>();
		if(raiz != null){
			resultado = getResultado(raiz, generoEntrante);
			System.out.println("Cantidada de Iteraciones = " + cont);
		}
		cont = 0;
//		long end = System.currentTimeMillis() - start;
//		System.out.println("Duracion en tiempo " + end);
		return resultado;
	}


	//
	private ArrayList<Libro> getResultado(Genero raiz, String generoEntrante) {
		ArrayList<Libro> resultado = new ArrayList<>();
		cont ++;
		if(raiz.getNombre().equals(generoEntrante)){
			resultado.addAll(raiz.getLibros());
		}else if(generoEntrante.compareTo(raiz.getNombre()) < 0){
			resultado = getResultado(raiz.getIzq(), generoEntrante);
		}else{
			resultado = getResultado(raiz.getDer(), generoEntrante);
		}
		return resultado;
	}
	
	

}
