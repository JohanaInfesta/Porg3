package Ejercicio7;

import java.util.ArrayList;

public class Arbol {

	private Nodo raiz;

	public Arbol(int [] arr){
		this.raiz = null;
		for (int i : arr) {
			add(i);
		}
	}
	public Arbol() {
		this.raiz = null;
	}

	// O(1)
	public Integer getRoot(){
		if(!this.isEmpty()){
			return raiz.getValor();
		}
		return null;
	}

	// O(h)donde h es la altura de albol
	public boolean hasElem(Integer elem){
		if(!this.isEmpty())
			return hasElem(elem, raiz);
		else 
			return false;
	}
	//O(h)donde h es la altura de albol
	private boolean hasElem(Integer elem, Nodo nodo){
		boolean resultado = false;
		if(elem < nodo.getValor()){
			if(nodo.getIzq() != null){
				return hasElem(elem, nodo.getIzq());
			}
		}else if(elem > nodo.getValor()){
			if(nodo.getDer() != null){
				return hasElem(elem, nodo.getDer());
			}
		}else{
			resultado = true;
		}
		return resultado;
	}

	//O(1)
	public boolean isEmpty(){
		return this.raiz == null;
	}

	//O(h)donde h es la altura de albol
	public void add(Integer valor){
		if(raiz == null){
			raiz = new Nodo(valor);
		}else{
			add(raiz, valor);
		}
	}
	//O(h)donde h es la altura de albol
	private void add(Nodo nodo,Integer valorInsertar){
		if(valorInsertar < nodo.getValor()){
			if(nodo.getIzq() == null){
				Nodo temp = new Nodo(valorInsertar);
				nodo.setIzq(temp);
			}else{
				add(nodo.getIzq(), valorInsertar);
			}
		}else{
			if(nodo.getDer() == null){
				Nodo temp = new Nodo(valorInsertar);
				nodo.setDer(temp);
			}else{
				add(nodo.getDer(), valorInsertar);
			}
		}
	}

	// O(h)donde h es la altura de albol
	public Boolean  delete(Integer valor){
		if(this.hasElem(valor))
			return delete(raiz, valor) != null;
		else
			return false;
	}
	// O(h) donde h es la altura de albol
	private Nodo delete(Nodo nodo, Integer val){
		//si no encuentra el nodo a eliminar retorna NULL
		if(nodo == null)
			return null;  
		//si no es null me fijo por que lado del arbol voy a tomar y hago la recursiva con su respectivo nodo
		else if(val < nodo.getValor()){
			Nodo izq = delete(nodo.getIzq(), val); 
			nodo.setIzq(izq);
		}else if(val > nodo.getValor()){
			Nodo der = delete(nodo.getDer(), val);
			nodo.setDer(der);
		}else{
			//si se mete en este else es porque encontro el nodo que quiere eliminar
			Nodo padre = nodo;
			//si tiene un solo hijo
			if(padre.getIzq()==null){
				nodo = padre.getDer();
			}else if(padre.getDer() == null){
				nodo = padre.getIzq();
			}else{
				//si tiene mas de 1 hijo
				padre = cambiar(padre);
			}
			//si no tengo hijos soy nodo terminal y se setea a null;
			padre = null;
		}
		return nodo;
	}
	//O(h)donde h es la altura de albol
	private Nodo cambiar(Nodo nodo){
		Nodo padre = nodo;
		Nodo hoja = nodo.getIzq();
		//desde la rama izquierda busca el mayor que esta en su rama derecha
		while(hoja.getDer() != null){
			padre = hoja;
			hoja = hoja.getDer();
		}
		nodo.setValor(hoja.getValor());
		if(padre == nodo)
			padre.setIzq(hoja.getIzq());
		else
			padre.setDer(hoja.getDer());
		return hoja;

	}

	// O(n) donde n es la cantidad de nodos del arbol
	public Integer getHeight() {
		System.out.println("Altura del arbol");
		if (!this.isEmpty())
			return this.getHeight(this.raiz);
		else
			return null;
	}
	//O(n) donde n es la cantidad de nodos del arbol
	private Integer getHeight(Nodo cursor) {
		if (cursor.getIzq() == null && cursor.getDer() == null) { // Si es una hoja
			return 0; // Soy chato, tengo altura 0
		} else {
			// Si tengo al menos un hijo
			int alturaIzq = 0;
			int alturaDer = 0;
			if (cursor.getIzq() != null)
				alturaIzq = 1 + this.getHeight(cursor.getIzq()); 
			if (cursor.getDer() != null)
				alturaDer = 1 + this.getHeight(cursor.getDer());
			int mayor = Math.max(alturaIzq, alturaDer);

			return mayor;	
		}
	}

	// O(n)donde n es la cantidad de nodos del arbol
	public void printPostorder(){
		this.printPostorder(raiz);
	}
	//	O(n)donde n es la cantidad de nodos del arbol
	private void printPostorder(Nodo node){
		if (node == null)
			return;
		printPostorder(node.getIzq());
		printPostorder(node.getDer());
		System.out.print(node.getValor() + " - ");
	}

	// O(n)donde n es la cantidad de nodos del arbol
	public void printPreOrder(){
		this.printPreOrder(raiz);
	}
	//O(n)donde n es la cantidad de nodos del arbol
	private void printPreOrder(Nodo nodo){
		if(nodo == null)
			return ;
		System.out.print(nodo.getValor() + " ");
		printPreOrder(nodo.getIzq());
		if(nodo.getIzq() == null)
			System.out.print("- ");
		printPreOrder(nodo.getDer());
		if(nodo.getDer() == null)
			System.out.print("- ");
	}

	// O(n)donde n es la cantidad de nodos del arbol
	public void printInorder(){
		this.printInorder(raiz);;
	}
	//O(n)donde n es la cantidad de nodos del arbol
	private void printInorder(Nodo node){
		if (node == null)
			return;
		printInorder(node.getIzq());
		System.out.print(node.getValor() + " - ");
		printInorder(node.getDer());
	} 

	//O(n)donde n es la cantidad de nodos del arbol
	public ArrayList<Integer>getLongestBranch(){
		if(!this.isEmpty())
			return getLongestBranch(raiz);
		else
			return null;
	}
	//O(n)donde n es la cantidad de nodos del arbol
	private ArrayList<Integer>getLongestBranch(Nodo nodo){
		ArrayList<Integer>retorno = new ArrayList<>();
		ArrayList<Integer>izq = new ArrayList<>();
		ArrayList<Integer>der = new ArrayList<>();
		if(nodo.getIzq() == null && nodo.getDer() == null){
			retorno.add(nodo.getValor());
			return retorno;
		}
		//agrego todos los nodos de su respectivo lado en los arreglos
		if(nodo.getIzq() != null)
			izq = getLongestBranch(nodo.getIzq());
		if(nodo.getDer() != null)
			der = getLongestBranch(nodo.getDer());
		//depende de cual sera mas larga la devuelvo
		if(izq.size() > der.size()){
			izq.add(0, nodo.getValor());
			return izq;
		}else{
			der.add(0, nodo.getValor());
			return der;
		}
	}
	//0(n)donde n es la cantidad de nodos del arbol
	public ArrayList<Integer>getFrontera(){
		if(!this.isEmpty())
			return getFrontera(raiz);
		else
			return null;
	}
	//O(n)donde n es la cantidad de nodos del arbol
	private ArrayList<Integer>getFrontera(Nodo nodo){
		ArrayList<Integer>izq = new ArrayList<>();
		ArrayList<Integer>der = new ArrayList<>();
		ArrayList<Integer>retorno = new ArrayList<>();

		if(nodo.getDer() == null && nodo.getIzq() == null){
			retorno.add(nodo.getValor());
			return retorno;
		}
		if(nodo.getIzq() != null)
			izq = getFrontera(nodo.getIzq());
		if(nodo.getDer() != null)
			der = getFrontera(nodo.getDer());

		if(!izq.isEmpty())
			retorno.addAll(izq);
		if(!der.isEmpty())
			retorno.addAll(der);
		return retorno;
	}
	//O(h)donde h es la altura de albol
	public Integer getMaxElem(){
		System.out.println("\n" + "Elemento mas grade del arbol");
		if(!this.isEmpty())
			return getMaxElem(raiz);
		else
			return null;
	}
	//O(h)donde h es la altura de albol
	private Integer getMaxElem(Nodo nodo){
		Integer retorno = 0;
		if(nodo.getDer() != null){
			retorno = getMaxElem(nodo.getDer());
		}else{
			retorno = nodo.getValor();
		}
		return retorno;
	}

	//O(n)donde n es la cantidad de nodos del arbol
	public ArrayList<Integer>getElementAtLevel(Integer nivel){
		int cont = 0;
		if(!this.isEmpty())
			return getElementAtLevel(raiz, nivel, cont);
		else
			return null;
	}
	//O(n)donde n es la cantidad de nodos del arbol
	private ArrayList<Integer>getElementAtLevel(Nodo nodo, Integer nivel, Integer cont){
		ArrayList<Integer>izq = new ArrayList<>();
		ArrayList<Integer>der = new ArrayList<>();
		ArrayList<Integer>retorno = new ArrayList<>();
		if( cont == nivel){
			retorno.add(nodo.getValor());
			return retorno;
		}else{
			if(nodo.getIzq() != null)
				izq = getElementAtLevel(nodo.getIzq(), nivel, cont + 1);
			if(nodo.getDer() != null)
				der = getElementAtLevel(nodo.getDer(), nivel, cont + 1);
		}
		if(!izq.isEmpty())
			retorno.addAll(izq);
		if(!der.isEmpty())
			retorno.addAll(der);
		return retorno;
	}

}

