package biblioteca;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca("Quijote");
		Libro libro1,libro2,libro3;
		
		libro1 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", new Date(19540629));
		libro2 = new Libro("El Hobbit", "J.R.R. Tolkien", new Date(19370921));
		libro3 = new Libro("El Silmarillion", "J.R.R. Tolkien", new Date(19770915));
		
		biblioteca.agregarLibro(libro1);
		biblioteca.agregarLibro(libro2);
		biblioteca.agregarLibro(libro3);

		Usuario usuario = new Usuario("Lucas",19);
		
		try {
			usuario.prestarLibro(libro1);
			usuario.prestarLibro(libro2);
			usuario.prestarLibro(libro2);
			usuario.mostrarLibrosPrestados();
		} catch (LibroNoDisponibleException e) {
			e.printStackTrace();
		}
		
		try {
			usuario.mostrarLibrosPrestados();
		} catch (LibroNoDisponibleException e) {
			e.printStackTrace();
		}
		
		try {
			biblioteca.mostrarLibrosDisponibles();
			biblioteca.buscarLibro("El Señor");
		} catch (LibroNoDisponibleException e) {
			e.printStackTrace();
		}
	}
}
