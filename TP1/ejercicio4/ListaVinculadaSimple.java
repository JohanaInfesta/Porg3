package ejercicio4;

import java.util.Iterator;

import ejercicio1.Nodo;
import ejercicio5.MyIterador;

public class ListaVinculadaSimple implements Iterable<Integer>{

	protected Nodo primero;
	protected int size;//tamaño

	public ListaVinculadaSimple() {
		primero = null;
		size = 0;
	}

	public void insertFront(int o) {
		Nodo nuevo = new Nodo(o,null);
		nuevo.setNext(this.primero);
		this.primero = nuevo;
		size++;
	}

	public Integer extractFront() {
		if(isEmpty()){
			return null;
		}else{
			//guardo la info del nodo
			Integer obj = this.primero.getInfo();
			
			this.primero = this.primero.getNext();
			
			size--;
			return obj;
		}	
	}

	public boolean isEmpty() {
		return this.primero == null;
	}

	public int size() {
		return this.size;
	}

	public Integer get(int index) {
//		if (index > 0) {
//            int posicion = 1;
//            Nodo buscado = new Nodo(null, null);
//            if (!this.isEmpty()) {
//                buscado = this.primero;
//            }
//            while (posicion < index) {
//                if (buscado.getNext() != null) {
//                    buscado = buscado.getNext();
//                    posicion++;
//                } else {
//                    return null;
//                }
//            }
//            return buscado.getInfo();
//        } else {
//            return null;
//        }
		int posicion = 1;
		Nodo buscado = this.primero;
		while(posicion < index){
			buscado = buscado.getNext();
			posicion++;
		}
		return buscado.getInfo();
	}
	
	public Integer indexOf(int o){
		Nodo pos;
		if(!this.isEmpty()){
			int index = 1;
			pos = this.primero;
			while(pos.getInfo() != o && index <= this.size()){
				if(pos.getNext() != null){
					pos = pos.getNext();
				}
				index++;
			}
			if(index > this.size()){
				return -1;
			}else{
				return index;
			}
		}else{
			return -1;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new MyIterador(this.primero);
	}
}
