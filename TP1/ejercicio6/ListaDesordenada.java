package ejercicio6;

import ejercicio1.ListaVinculadaSimple;
import ejercicio5.MyIterador;

public class ListaDesordenada {

	public static void main(String[] args) {
		ListaVinculadaSimple list1 = new ListaVinculadaSimple();
		ListaVinculadaSimple list2 = new ListaVinculadaSimple();
		ListaVinculadaSimple commonElements = new ListaVinculadaSimple();

		list1.insertFront(4);
        list1.insertFront(3);
        list1.insertFront(1);
        list1.insertFront(2);

        list2.insertFront(3);
        list2.insertFront(1);
        list2.insertFront(7);
        list2.insertFront(2);
        
        MyIterador iterador1 = new MyIterador(list1.getFirst());
        MyIterador iterador2 = new MyIterador(list2.getFirst());
        
        int menor = 999;
        int ultmenor= -1;
        int i=1;

        while(i<=list2.size()){
        	iterador1 = new MyIterador(list1.getFirst());
            for(int j=1; j<= list1.size(); j++){
                 if(menor>iterador1.actual() && iterador1.actual()>ultmenor){
                    menor = iterador1.actual();
                }
                 iterador1.siguiente();
            }

            ultmenor = menor;
            int k=1;
           while (k<=list2.size()){
                if(menor == iterador2.actual()){
                    commonElements.insertFront(iterador2.actual());
                    k= list2.size()+1;
                }else{
                    k++;
                    iterador2.siguiente();
                }
            }
           iterador2 = new MyIterador(list2.getFirst());
           i++;
           menor=999;
        }

        MyIterador iterador3 = new MyIterador(commonElements.getFirst());

        System.out.println("Elementos en Comun " + commonElements.size());
        for (int l = 1; l <= commonElements.size(); l++) {
            System.out.println(iterador3.actual());
            iterador3.siguiente();
        }
	}

}
