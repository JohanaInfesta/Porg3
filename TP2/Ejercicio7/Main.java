package Ejercicio7;


public class Main {

	public static void main(String[] args) {
		//		Arbol miArbol = new Arbol();

		int[] valoresIniciales = new int[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
		Arbol miArbol = new Arbol(valoresIniciales);

		miArbol.printPreOrder();
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElementAtLevel(2) );
		System.out.println( miArbol.getFrontera() );

//		System.out.println(miArbol.delete(10));
//		miArbol.add(23);
//		miArbol.add(3);
//		miArbol.delete(6);
//		miArbol.delete(30);
//
//		miArbol.printPreOrder();
//		System.out.println( miArbol.getMaxElem() );
//		System.out.println( miArbol.getHeight() );
//		System.out.println( miArbol.getLongestBranch() );
//		System.out.println( miArbol.getElementAtLevel(2) );
//		System.out.println( miArbol.getFrontera() );
//
//		miArbol.add(65);
//		miArbol.delete(5);
//		miArbol.delete(15);
//		miArbol.add(55);
//
//		miArbol.printPreOrder();
//		System.out.println( miArbol.getMaxElem() );
//		System.out.println( miArbol.getHeight() );
//		System.out.println( miArbol.getLongestBranch() );
//		System.out.println( miArbol.getElementAtLevel(2) );
//		System.out.println( miArbol.getFrontera() );
	}

}
