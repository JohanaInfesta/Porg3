package Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class DFS {

	private Grafo<?> grafo;
	private HashMap<Integer,String> colores;
	private int tiempo;
	private HashMap<Integer,Integer> descubrimiento;
	private HashMap<Integer,Integer> finalizacion;

	public DFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.descubrimiento = new HashMap<>();
		this.finalizacion = new HashMap<>();
		this.tiempo = 0;
	}

	public void dfs() {

		Iterator<Integer> it = this.grafo.obtenerVertices();
		//for each vertice u � G ->  V
		while (it.hasNext()) {
			int verticeId = it.next();
			//u->color= blanco
			colores.put(verticeId, "blanco");
		}
		this.tiempo = 0;

		it = this.grafo.obtenerVertices();
		//for each vertice u � G ->  V
		while (it.hasNext()) {
			int verticeId = it.next();
			//if(u->color == blanco ) 
			if (colores.get(verticeId).equals("blanco"))
				dfs_visit(verticeId);
		}

	}

	public void dfs_visit(int vertice) {
		//u-> color == amarillo
		colores.put(vertice, "amarillo");
		tiempo += 1;
		System.out.print(tiempo);
		//u-> d = tiempo
		descubrimiento.put(vertice, tiempo);

		Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
		System.out.println(colores);
		//for each v � u -> Adj []
		while(it.hasNext()) {
			int adyacente = it.next();
			//if(v-> color == blanco )
			if (colores.get(adyacente).equals("blanco"))
				dfs_visit(adyacente);

		}
		//u-> color == negro
		colores.put(vertice, "negro");
		System.out.println(colores);
		tiempo += 1;
		//u-> f == tiempo
		System.out.print(tiempo);
		finalizacion.put(vertice, tiempo);

	}

}
