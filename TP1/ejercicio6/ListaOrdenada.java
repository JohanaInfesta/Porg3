package ejercicio6;

import ejercicio1.ListaVinculadaSimple;
import ejercicio5.MyIterador;

public class ListaOrdenada {

	public static void main(String[] args) {
		ListaVinculadaSimple list1 = new ListaVinculadaSimple();
		ListaVinculadaSimple list2 = new ListaVinculadaSimple();
		ListaVinculadaSimple commonElements = new ListaVinculadaSimple();
		
		list1.insertFront(8);
        list1.insertFront(7);
        list1.insertFront(4);
        list1.insertFront(3);

        list2.insertFront(7);
        list2.insertFront(4);
        list2.insertFront(2);
        list2.insertFront(1);
        
        MyIterador iterador1 = new MyIterador(list1.getFirst());
        MyIterador iterador2 = new MyIterador(list2.getFirst());
        
        while (iterador1.actual() != null && iterador2.actual() != null) {
            if ( iterador1.actual() < iterador2.actual()) {
                iterador1.siguiente();
            } else {
                if (iterador1.actual().equals(iterador2.actual())) {
                    commonElements.insertFront(iterador1.actual());
                    iterador1.siguiente();
                    iterador2.siguiente();
                } else {
                	iterador2.siguiente();
                }
            }
        }
        System.out.println("Elementos en Comun " + commonElements.size());
        MyIterador iterador3 = new MyIterador(commonElements.getFirst());

        for (int l = 1; l <= commonElements.size(); l++) {
            System.out.println(iterador3.actual());
            iterador3.siguiente();
        }
	}
}
