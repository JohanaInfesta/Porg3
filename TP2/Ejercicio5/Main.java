package Ejercicio5;

public class Main {

	public static void main(String[] args) {
		int [] arr = {3, 1, 2, 7, 9, 5};
		
		imprimir(arr);
		System.out.println("El arr ordenado por Mergesort  ");
		merSort(arr, 0, arr.length-1);
		imprimir(arr);
		System.out.println("El arr ordenado por Quicksort  ");
		quicksort(arr, 0, arr.length-1);
		imprimir(arr);

	}
	public static void imprimir(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static void merSort(int[] arr,int left,int right) {
		if(left<right) {
			int middle =(left+right)/2;
			merSort(arr, left, middle);
			merSort(arr, middle+1, right);
			merge(arr,left,middle,right);
		}
	}
	public static void merge(int[] arr,int left,int middle,int right) {
		int[] temp =new int[right-left+1];
		int i = left;
		int j = middle + 1;
		int k = 0;
		while(i <= middle && j <= right) {
			if(arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
			}
		}
		// Rellena los elementos restantes a la izquierda en temp
		while(i <= middle) {
			temp[k++] = arr[i++];
		}
		 // Rellena los elementos restantes de la secuencia correcta en temp
		while(j <= right) {
			temp[k++] = arr[j++];
		}
		 // Copia todos los elementos en temp a la matriz original
		for(int m = 0; m < temp.length; m++) {
			arr[m + left] = temp[m];
		}
	}
	
    public static void quicksort(int arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }
    
    private static int particion(int arreglo[], int izquierda, int derecha) {
        int pivote = arreglo[izquierda];
        while (true) {
            while (arreglo[izquierda] < pivote) {
                izquierda++;
            }
            while (arreglo[derecha] > pivote) {
                derecha--;
            }
            if (izquierda >= derecha) {
                return derecha;
            } else {
            	int temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
                izquierda++;
                derecha--;
            }
        }
    }
}
