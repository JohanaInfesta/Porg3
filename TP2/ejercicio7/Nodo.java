package ejercicio6;

public class Nodo {

	private Nodo izq;
	private Nodo der;
	private Integer valor;

	public Nodo(Integer valor) {
		this.valor = valor;
		this.izq = null;
		this.der = null;
	}

	public Integer getValor() {
		return valor;
	}

	public Nodo getIzq() {
		return izq;
	}

	public Nodo getDer() {
		return der;
	}

	public void setIzq(Nodo izq) {
		this.izq = izq;
	}

	public void setDer(Nodo der) {
		this.der = der;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}
