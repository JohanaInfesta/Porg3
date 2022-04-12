package ejercicio3;

public class Main3 {

	public static void main(String[] args) {
		int N = 5;
		int [] arr = new int [N];

		//Arreglo ordenado
		arr[0] = 10; 
		arr[1] = 50; 
		arr[2] = 30; 
		arr[3] = 20; 
		arr[4] = 40; 

		imprimir(arr);

		System.out.println("El arreglo ordenado por seleccion ");
		seleccion(arr);
		imprimir(arr);
		System.out.println("El arreglo ordenado por burbujeo ");
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
	public static void seleccion(int A[]) {
		int i, j, menor, pos, tmp;
		for (i = 0; i < A.length - 1; i++) {     
			menor = A[i];                                         
			pos = i;                            
			for (j = i + 1; j < A.length; j++){ 
				if (A[j] < menor) {           
					menor = A[j];             
					pos = j;
				}
			}
			if (pos != i){                                           
				tmp = A[i];
				A[i] = A[pos];
				A[pos] = tmp;
			}
		}
	}

	//O(n^2)
	public static void burbujeo(int[] arr) {
		boolean intercambio = true;
		int j = 0;
		int tmp;
		while (intercambio) {
			intercambio = false;
			j++;
			for (int i=0; i<arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					intercambio = true;
				}
			}
		}
	}

}
