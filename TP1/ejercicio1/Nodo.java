package ejercicio1;

public class Nodo {
	private Integer info;
	private Nodo next;
	
	public Nodo() {
		info = null;
		next = null;
	}
	
	public Nodo(Integer i, Nodo n) {
		setInfo(i);
		setNext(n);
		}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	} 

}
