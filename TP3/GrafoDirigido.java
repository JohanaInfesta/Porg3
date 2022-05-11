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
		if(!vertices.containsKey(verticeId))
			vertices.put(verticeId, vertice);
		else
			System.out.println("Ya existe este vertice");
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(vertices.containsKey(verticeId)) {
			vertices.get(verticeId).clear();
			vertices.remove(verticeId);
		}

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> arcoAux = new Arco<T>(verticeId1, verticeId2, etiqueta);
		//		if(!vertices.containsKey(verticeId1)){
		//			agregarVertice(verticeId1);
		//		}
		if(!existeArco(verticeId1,verticeId2)){
			vertices.get(verticeId1).add(arcoAux);
		}else{
			System.out.println("Arco ya existente");
		}

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1)){
			ArrayList <Arco<T>> arcos = vertices.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if(arco.getVerticeDestino() == verticeId2){
					arcos.remove(arco);
				}
			}
		}

	}

	@Override
	public boolean contieneVertice(int verticeId) {
		if(vertices.containsKey(verticeId))
			return true;
		return false;
	}

	@Override
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
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Arco<T>> adyacentes = vertices.get(verticeId);
		ArrayList<Integer> aux = new ArrayList<>();
		for(Arco<T> a:adyacentes) {
			aux.add(a.getVerticeDestino());
		}
		return aux.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
