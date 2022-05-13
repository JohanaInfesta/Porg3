package Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class ExisteCiclo {

	private Grafo<?> grafo;
	private HashMap<Integer,String> colores;
	private int tiempo;
	private Boolean existe = false;
	private HashMap<Integer,Integer> descubrimiento;
	private HashMap<Integer,Integer> finalizacion;

	public ExisteCiclo(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.descubrimiento = new HashMap<>();
		this.finalizacion = new HashMap<>();
		this.tiempo = 0;
	}

	//ejercicio 3 Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo
	public boolean existeCiclo() {
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
		this.tiempo = 0;

		it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			if (colores.get(verticeId).equals("blanco"))
				existe = existe_ciclo(verticeId);
		}
		return existe;
	}

	public boolean existe_ciclo(int origen) {
		//u-> color == amarillo
		colores.put(origen, "amarillo");
		tiempo += 1;
		descubrimiento.put(origen, tiempo);

		Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
		System.out.println(colores);

		while(it.hasNext() && !existe) {
			int adyacente = it.next();
			if (colores.get(adyacente).equals("blanco")){
				existe = existe_ciclo(adyacente);
			}else if (colores.get(adyacente).equals("amarillo")) {
				return true;
			}

		}

		colores.put(origen, "negro");
		System.out.println(colores);
		tiempo += 1;
		finalizacion.put(origen, tiempo);
		return existe;
	}

}
