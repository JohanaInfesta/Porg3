package EntregaArray;

import java.util.ArrayList;
import java.util.Iterator;


public class Biblioteca {

	ArrayList<Genero> generos;
	int cont;
	public Biblioteca() {
		generos = new ArrayList<>();
		cont = 0;
	}
	//Complejidad O(n^2) donde n es la cantidad de generos que posee el libro y la cantidad de generos que posee el arreglo de generos
	public void addLibro(Libro libro) {
		ArrayList<String>generosLibro = libro.getGeneros();
		Iterator<String>it = generosLibro.iterator();
		//itera sobre los string de los generos entrantes del libro
		while(it.hasNext()){
			String generoLibroEntrante = it.next();
			generoLibroEntrante =  generoLibroEntrante.toLowerCase(); //convierte en minuscula por las dudas que venga en mayuscula 
			AgregarGenero(libro, generoLibroEntrante);//pasa a un metodo para agregar los libros al genero correspondiente
		}
	}
	//Complejidad O(n) donde n en el peor de los casos es la cantidada de generos que existen en el arreglo
	private void AgregarGenero(Libro libro, String generoLibroEntrante) {
		boolean existeGenero = false;
		for (Genero genero : generos) {//itera en el for de generos
			if(genero.getNombre().equals(generoLibroEntrante) && !existeGenero){ // si el nombre del genero existe y el libro no
				genero.addLibro(libro);//lo agrega
				existeGenero = true;//y le pone un estado existente
			}
		}if(!existeGenero)//si no existe el genero pasa a un metodo que crea el genero y le agrega el libro a ese genero
			addLibroGenero(libro, generoLibroEntrante);	
	}

	public void addLibroGenero(Libro l, String g){
		Genero nuevo = new Genero(g);
		addGenero(nuevo);
		nuevo.addLibro(l);
	}



	public void addGenero(Genero g){
		generos.add(g);
	}

	public ArrayList<Genero> getGeneros() {
		return generos;
	}


	//O(n)
	public ArrayList<Libro> getLibros(String genero){
		String generoEntrante = genero.toLowerCase();
		ArrayList<Libro>retorno = new ArrayList<>();
		long start = System.currentTimeMillis();
		
		for (Genero genero2 : generos) {
			cont ++;
			if(genero2.getNombre().equals(generoEntrante)){
				retorno.addAll(genero2.getLibros());
				System.out.println(cont);
				long end = System.currentTimeMillis() - start;
				System.out.println("Duracion en tiempo " + end);
				return retorno;
			}
		}
		
		return retorno;
	}



}
