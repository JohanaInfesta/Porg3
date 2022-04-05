package ejercicio5;

import java.util.Iterator;

import ejercicio1.Nodo;

public class MyIterador implements Iterator<Integer>{

	private Nodo cursor;


	public MyIterador(Nodo cursor) {
		this.cursor = cursor;
	}

	@Override
	public boolean hasNext() {	//  O(1)
		if(this.cursor != null){ 
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Integer next() {  //  O(1)
		Integer valor = this.cursor.getInfo();
		
		this.cursor = this.cursor.getNext();
		
		return valor;
	}

	public Integer valor(){	//  O(1)
		return this.cursor.getInfo();
	}

	public void avanzar(){	//  O(1)
		this.cursor = this.cursor.getNext();
	}
	
	
	
	public Integer actual() {
        if(this.hasNext()){
            return this.cursor.getInfo();
        }else{
            return null;
        }
    }
	
    public void siguiente() {
        if (this.hasNext()){
            this.cursor = this.cursor.getNext();
        }else{
            this.cursor = null;
        }
    }
}
