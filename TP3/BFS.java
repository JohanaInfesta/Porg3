package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BFS {
	
	private Grafo<?> grafo;
	private HashMap<Integer,String> colores;
	private ArrayList<Integer>verticesVisitados;
	
	public BFS(Grafo<?> grafo){
		this.grafo = grafo;
		this.colores = new HashMap<>();
		verticesVisitados = new ArrayList<>();
	}
	
	public void bfs(Grafo<?> grafito){
		// vaciar la fila F
		verticesVisitados.clear();
		Iterator<Integer> it = grafito.obtenerVertices();
		//para cada vertices c de G
		while (it.hasNext()) {
			int verticeId = it.next();
			// Marcar v como NO_VISITADO
			colores.put(verticeId, "blanco");
		}
		it = grafito.obtenerVertices();
		//para cada vertices v de G
		while (it.hasNext()) {
			int verticeId = it.next();
			// si v es NO_VISITADO
			if (colores.get(verticeId).equals("blanco"))
				bfs_visit(grafito, verticeId);
		
		}
	}
	
	public void bfs_visit(Grafo<?> grafito, int vertice){
		//Marcar el vértice s como VISITADO.
		colores.put(vertice, "amarillo");
		//Agregar s a la fila F.
		verticesVisitados.add(vertice);
		System.out.println(colores);
		//Mientras la fila F no esté vacía
		for (int i = 0; i < verticesVisitados.size(); i++) {
			//Tomamos vértice x de la fila, 
			int verticeX = verticesVisitados.get(i);
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeX);
			//Para cada vértice y adyacente a x:
			while (it.hasNext()) {
				int adyacente = it.next();
				//Si y es NO_VISITADO :
				if(colores.get(adyacente).equals("blanco")){
					//Marcar el vértice y como VISITADO
					colores.put(adyacente, "amarrillo");
					//Agregar y a la fila F.
					verticesVisitados.add(adyacente);
					System.out.println(colores);
				}
			}
		}
	}

}
