package EntregaArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

	public static void main(String[] args) {
		String csvFile = "./src/Entrega2/dataset1.csv";
		String line = "";
		String cvsSplitBy = ",";
		
		Biblioteca b = new Biblioteca();
		
		ArrayList<Libro> libro = new ArrayList<Libro>();
//		Busqueda bu = new Busqueda(libro);
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			line = br.readLine();
			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				//separo la lista es String personalizados. para tener las posiciones especificas
				String titulo = items[0];
				String autor = items[1];
				String paginas = items[2];
				String genero = items[3];
				String[]generos = genero.split(" ");
				
//				System.out.println(Arrays.toString(generos));
				
				ArrayList<String> arrayGeneros = new ArrayList<String>();
				for (int i = 0; i < generos.length; i++) {
					arrayGeneros.add(generos[i]);
				}
				
//				libro.add(new Libro(titulo, autor, paginas, arrayGeneros));
				Libro librito = new Libro(titulo, autor, paginas, arrayGeneros);
				b.addLibro(librito);
				
//				System.out.println(Arrays.toString(items));
				
				
				// ---------------------------------------------
				// Poner el codigo para cargar los datos
				// ---------------------------------------------
				
			}
			
			libro.addAll(b.getLibros("cine"));
	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
