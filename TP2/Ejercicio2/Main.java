package Ejercicio2;

public class Main {

	public static void main(String[] args) {
		int N = 5;
		int [] arr = new int [N];
		
		//Arreglo ordenado
		arr[0] = 10; 
		arr[1] = 20; 
		arr[2] = 30; 
		arr[3] = 40; 
		arr[4] = 50; 
		
		imprimir(arr);
		
		System.out.println("El arreglo esta ordenado ? ");
		System.out.println(estaOrdenado(arr, 0));
		System.out.println(buscarIndice(arr, 0, 30));

	}

	//Complejidad O(n) en el peor de los casos voy hasta el final 
			public static Boolean estaOrdenado(int[] arr, int index){
				boolean aux = false;
				
				if(index + 1 < arr.length){
					if(arr[index] <= arr[index + 1]){
						//llamo recursividad
						return estaOrdenado(arr, index + 1);
					}
				}else{
					aux = true;
				}
				return aux;
			}

			public static int buscarIndice(int[] arr, int index, int val){
				int pos = index;
				if(estaOrdenado(arr, pos)){
					if(val != arr[pos]){
						return buscarIndice(arr, pos + 1, val);
					}
				}
				return pos;
			}
			
			public static void imprimir(int[] arr){
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println("");
			}
}
