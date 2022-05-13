package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	public HashMap<Integer, ArrayList<Arco<T>>>vertices;


	public GrafoDirigido() {
		this.vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
	}

	@Override
	//Complejidad: O(1)
	public void agregarVertice(int verticeId) {
		ArrayList<Arco<T>> vertice = new ArrayList<Arco<T>>();
		if(!contieneVertice(verticeId))
			vertices.put(verticeId, vertice);
		else
			System.out.println("Ya existe este vertice");
	}

	@Override
	//Complejidad: O(1)
	public void borrarVertice(int verticeId) {
		if(contieneVertice(verticeId)) {
			vertices.get(verticeId).clear();
			vertices.remove(verticeId);
		}

	}

	@Override
	//Complejidad: O(a) donde a es el tamanio de adyacentes del verticeId1
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(contieneVertice(verticeId1) && contieneVertice(verticeId2)){
			if(!existeArco(verticeId1,verticeId2)){
				Arco<T> arcoAux = new Arco<T>(verticeId1, verticeId2, etiqueta);
				vertices.get(verticeId1).add(arcoAux);
			}else{
				System.out.println("Arco ya existente");
			}
		}
	}

	@Override
	//Complejidad: O(a) donde a es el tamanio de adyacentes del verticeId1
	public void borrarArco(int verticeId1, int verticeId2) {
//		if(contieneVertice(verticeId1)){
			ArrayList <Arco<T>> arcos = vertices.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if(arco.getVerticeDestino() == verticeId2){
					arcos.remove(arco);
				}
			}
//		}

	}

	@Override
	//Complejidad: O(1)
	public boolean contieneVertice(int verticeId) {
		if(vertices.containsKey(verticeId))
			return true;
		return false;
	}

	@Override
	//Complejidad: O(a) donde a es la lista de adyacentes del verticeId1
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1)){
			ArrayList <Arco<T>> arcos = vertices.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if(arco.getVerticeDestino() == verticeId2){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	//Complejidad: O(a) donde a es la lista de adyacentes del verticeId1
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1)){
			ArrayList <Arco<T>> arcos = vertices.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if(arco.getVerticeDestino() == verticeId2){
					return arco;
				}
			}
		}
		return null;
	}

	@Override
	//Complejidad: O(1)
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int aux = 0;
		for (int i:vertices.keySet()) {
			aux += vertices.get(i).size();
		}
		return aux;
	}

	@Override
	//Complejidad: O(1) devolver el keyset de un hashmap es una compejidad constante, pasar esa lista resultado a iterador tambien es constante
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();
	}

	@Override
	//Complejidad: O(1) mediante encapsular mi iterador dentro de una clase que exclusivamente recorre a travez de it.next().getVerticeDestino() reduzco la complejidad
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		Iterator<Arco<T>> itInterno = vertices.get(verticeId).iterator();
		return new IteradorAdyacentes<T>(itInterno);
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for(int i:vertices.keySet()) {
			arcos.addAll(vertices.get(i));
		}
		return arcos.iterator();
	}

	@Override
	//Complejidad: O(1)
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return vertices.get(verticeId).iterator();
	}

}
