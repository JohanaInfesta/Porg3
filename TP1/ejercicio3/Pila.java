package ejercicio3;

import ejercicio1.ListaVinculadaSimple;

public class Pila {

	private ListaVinculadaSimple lista;

	public Pila() {
		this.lista = new ListaVinculadaSimple();
	}

	public Integer pop(){
		return lista.extractFront();
	}

	public void push(int o){
		this.lista.insertFront(o);
	}

	public Integer top(){
		if(!this.lista.isEmpty()){
			return  this.lista.get(0);
		}else{
			return null;
		}
	}

	public void reverse(){
		ListaVinculadaSimple aux = new ListaVinculadaSimple();
		while(!this.lista.isEmpty()){
			aux.insertFront(lista.extractFront());
		}
		this.lista = aux;
	}
	
}
