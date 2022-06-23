package Entrega;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

	public static void main(String[] args) {
		String csvFile = "./src/Entrega/dataset1.csv";
		String line = "";
		String cvsSplitBy = ",";
		Biblioteca b = new Biblioteca();

		ArrayList<Libro> libro = new ArrayList<Libro>();

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

				ArrayList<String> arrayGeneros = new ArrayList<String>();
				for (int i = 0; i < generos.length; i++) {
					arrayGeneros.add(generos[i]);
				}

				Libro librito = new Libro(titulo, autor, paginas, arrayGeneros);
				b.addLibro(librito);


			}
			
			libro.addAll(b.getLibros("cine"));
			
			exportarCSV(libro);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void exportarCSV(ArrayList<Libro>libros){
		BufferedWriter bw = null;
		try {
			File file = new File("./src/Entrega/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			String contenidoLinea1 = "Titulo, Autor, CantPaginas, Genero";
			String cont = ", ";
			bw.write(contenidoLinea1);
			for (Libro libro : libros) {
				bw.newLine();
				bw.write(libro.getTitulo()+ cont);
				bw.write(libro.getAutor()+cont);
				bw.write(libro.getCantidadPaginas()+ cont);
				ArrayList<String>generoArray = libro.getGeneros();
				String generos = "";
				for (String string : generoArray) {
					generos += string +",";
				}
				bw.write(generos);
//				System.out.println(libro);
			}
			
			bw.close();
			
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 

	}

}
