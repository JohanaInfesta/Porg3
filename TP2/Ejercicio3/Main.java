package Ejercicio3;

public class Main {

	public static void main(String[] args) {
		int decimal = 41 ; 
		
		Binario(decimal);
	}

	public static void Binario (int decimal){
		if(decimal != 0){
			Binario(decimal / 2 );
			System.out.print(decimal % 2);
		}else;
	}
}
