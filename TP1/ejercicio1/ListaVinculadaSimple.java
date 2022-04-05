package ejercicio1;

public class ListaVinculadaSimple {

	protected Nodo primero;
	protected int size;//tamaño

	public ListaVinculadaSimple() {
		primero = null;
		size = 0;
	}

	public void insertFront(int object) {
		Nodo nuevo = new Nodo(object,null);
		nuevo.setNext(this.primero);
		this.primero = nuevo;
		size++;
	}

	public Integer extractFront() {
		if(isEmpty()){
			return null;
		}else{
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
		//      int posicion = 1;
		//      Nodo buscado = new Nodo(null, null);
		//      if (!this.isEmpty()) {
		//          buscado = this.primero;
		//      }
		//      while (posicion < index) {
		//          if (buscado.getNext() != null) {
		//              buscado = buscado.getNext();
		//              posicion++;
		//          } else {
		//              return null;
		//          }
		//      }
		//      return buscado.getInfo();
		//  } else {
		//      return null;
		//  }
		int posicion = 1;
		Nodo buscado = this.primero;
		while(posicion < index){
			buscado = buscado.getNext();
			posicion++;
		}
		return buscado.getInfo();
	}

    public Nodo getFirst(){
        return this.primero;
    }

	
}
