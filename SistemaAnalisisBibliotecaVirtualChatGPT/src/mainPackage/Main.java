package mainPackage;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    
	public static void main(String[] args) {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		libros.add(new Libro("1984", "George Orwell", 1949, "Distopía", 9.4));
        libros.add(new Libro("Dune", "Frank Herbert", 1965, "Ciencia Ficción", 8.9));
        libros.add(new Libro("El Hobbit", "J.R.R. Tolkien", 1937, "Fantasía", 9.2));
        libros.add(new Libro("Fahrenheit 451", "Ray Bradbury", 1953, "Distopía", 8.5));
        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico", 9.1));
        libros.add(new Libro("Neuromante", "William Gibson", 1984, "Ciencia Ficción", 7.8));
        libros.add(new Libro("Los juegos del hambre", "Suzanne Collins", 2008, "Juvenil", 8.2));
        libros.add(new Libro("It", "Stephen King", 1986, "Terror", 7.9));
        libros.add(new Libro("Orgullo y prejuicio", "Jane Austen", 1813, "Romántico", 8.7));
        libros.add(new Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", 1981, "Misterio", 8.6));
	    ordenar(libros);
	    encontrarGenero(libros,"Distopía");
	    getMediaCalificacion(libros);
	    librosPorGenero(libros);
	    getAutores(libros);
	}
	
	private static void ordenar(ArrayList<Libro> libros) {
		ordenarAnio(libros);
		ordenarCalificacion(libros);
	}
	
	private static void ordenarAnio(ArrayList<Libro> libros) {
		libros.sort(Libro.porAnioPublicacionDesc);
		System.out.println("Por orden de Anio Desc");
	    for(Libro l : libros) {
	    	System.out.println(l.toString());
	    }
	}
	
	private static void ordenarCalificacion(ArrayList<Libro> libros) {
		libros.sort(Libro.porCalificacionAsc);
	    System.out.println("Por orden de calificación Asc");
	    for(Libro l : libros) {
	    	System.out.println(l.toString());
	    }
	}
	
	private static void encontrarGenero(ArrayList<Libro> libros, String genero) {
		System.out.println("Libros encontrados del genero: "+genero);
		for(Libro l : libros) {
			if(l.getGenero().equalsIgnoreCase(genero))
				System.out.println(l.toString());
	    }
	}
	
	private static void getMediaCalificacion(ArrayList<Libro> libros) {
		double media = 0;
		for(Libro l : libros) {
			media+=l.getCalificacion();
	    }
		media = media/libros.size();
		System.out.println("La media de calificación de la lista de libros es: "+media);
	}
	
	private static void librosPorGenero(ArrayList<Libro> libros) {
		Map<String,Integer> libGenero = new TreeMap();
		String genero = "";
		for(Libro l : libros) {
			genero = l.getGenero();
			libGenero.put(genero, libGenero.getOrDefault(genero, 0) + 1);
		}
		System.out.println("Este es el resultado de organizar por genero: ");
		for(Map.Entry<String, Integer> l : libGenero.entrySet()) {
			System.out.println(l.getKey() + " → " + l.getValue());
		}
	}
	
	private static void getAutores(ArrayList<Libro> libros) {
		Set<String> autores = new TreeSet<>();
		for(Libro l : libros) {
			autores.add(l.getAutor());
		}
		System.out.println("Esta es la lista de Autores");
		System.out.println(autores);
	}
}
