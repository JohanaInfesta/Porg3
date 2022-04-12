package Ejercicio4;

public class Main {

	public static void main(String[] args) {
		int N = 5;
		int [] arr = new int [N];

		//arr desordenado
		arr[0] = 10; 
		arr[1] = 50; 
		arr[2] = 30; 
		arr[3] = 20; 
		arr[4] = 40; 

		imprimir(arr);
		System.out.println("El arr ordenado por seleccion ");
		seleccion(arr);
		imprimir(arr);
		System.out.println("El arr ordenado por burbujeo ");
		burbujeo(arr);
		imprimir(arr);

	}

	public static void imprimir(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	//O(n^2)
	public static void seleccion(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temporal = arr[i];
					arr[i] = arr[j];
					arr[j] = temporal;
				}
			}
		}
	}

	//O(n^2)
	public static void burbujeo(int[] arr) {
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr.length - 1; y++) {
				int elemActual = arr[y], elemSig = arr[y + 1];
				if (elemActual > elemSig) {
					arr[y] = elemSig;
					arr[y + 1] = elemActual;
				}
			}
		}
	}
}
