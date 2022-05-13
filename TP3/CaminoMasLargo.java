package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CaminoMasLargo {
	private Grafo<?> grafo;
	private HashMap<Integer,Boolean> visitado;
	
	
	public CaminoMasLargo(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitado = new HashMap<>();
	}
	//ejercicio 4
	public ArrayList<Integer> caminoMasLargo(int origen, int destino){
		ArrayList<Integer> arcos = new ArrayList<>();
					
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			visitado.put(verticeId, false);
		}
		int vertice = origen;
		
			arcos = caminoLargo(vertice, destino, origen);
		
		return arcos;
	}

	private ArrayList<Integer> caminoLargo(int vertice, int destino, int origen) {
		visitado.put(vertice, true);
		
		ArrayList<Integer> unicoCamino = new ArrayList<>();
		
		if(vertice == destino){
			unicoCamino.add(vertice);
		
		}else{
			
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
			
			while (it.hasNext()){
				int adyacente = it.next();
				
				if(visitado.get(adyacente) == false){
					ArrayList<Integer> caminoAdyacente = new ArrayList<>();									
					caminoAdyacente.addAll(caminoLargo(adyacente, destino, origen));
					
					if(unicoCamino.size()<=caminoAdyacente.size()) {
						unicoCamino.clear();
						unicoCamino.add(vertice);
						unicoCamino.addAll(caminoAdyacente);
					}
				}
			}
			visitado.put(vertice, false);
		}
        return unicoCamino;
	}
	

}
