package ejercicio7;

import ejercicio1.ListaVinculadaSimple;
import ejercicio5.MyIterador;

public class Main {

	public static void main(String[] args) {
		ListaVinculadaSimple list1 = new ListaVinculadaSimple();
		ListaVinculadaSimple list2 = new ListaVinculadaSimple();
		ListaVinculadaSimple list3 = new ListaVinculadaSimple();


        list1.insertFront(4);
        list1.insertFront(3);
        list1.insertFront(1);
        list1.insertFront(2);

        list2.insertFront(6);
        list2.insertFront(5);
        list2.insertFront(8);
        list2.insertFront(9);

        MyIterador iteratorl1 = new MyIterador(list1.getFirst());
        MyIterador iteratorl2 = new MyIterador(list2.getFirst());
        MyIterador iteratorl3 = new MyIterador(list3.getFirst());

        for (int i = 1; i <= list1.size(); i++) {

            boolean exist = false;
            while (iteratorl2.actual() != null && !exist) {
                if (iteratorl1.actual().equals(iteratorl2.actual())) {
                    exist = true;
                    iteratorl2 = new MyIterador(list2.getFirst());
                    iteratorl1.siguiente();
                } else {
                    iteratorl2.siguiente();
                }
            }
            if (!exist) {
                while (iteratorl3.actual() != null && !exist) {
                    if (iteratorl1.actual().equals(iteratorl3.actual())) {
                        exist = true;
                        iteratorl3 = new MyIterador(list3.getFirst());
                        iteratorl2 = new MyIterador(list2.getFirst());
                        iteratorl1.siguiente();
                    } else {
                        iteratorl3.siguiente();
                    }
                }
                if (!exist) {
                    list3.insertFront(iteratorl1.actual());
                    iteratorl3 = new MyIterador(list3.getFirst());
                    iteratorl2 = new MyIterador(list2.getFirst());
                    iteratorl1.siguiente();
                }
            }

        }

        System.out.println("Elementos en la 1er lista que no estan en la 2da");
        iteratorl3 = new MyIterador(list3.getFirst());
        for (int l = 1; l <= list3.size(); l++) {
            System.out.println(iteratorl3.actual());
            iteratorl3.siguiente();
        }

	}

}
