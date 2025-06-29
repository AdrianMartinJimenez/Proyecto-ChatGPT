package biblioteca;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private int edad;
	private ArrayList<Libro> librosPrestados;
	
	public Usuario(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		librosPrestados = new ArrayList<Libro>();
	}
	
	public void prestarLibro(Libro libro) throws LibroNoDisponibleException{
		if(this.librosPrestados.contains(libro)&&libro.isPrestado()) {
			throw new LibroNoDisponibleException("Este libro ya se encuentra en la lista de Prestados");
		}else {
			libro.prestar();
			this.librosPrestados.add(libro);
		}
	}
	
	public void devolverLibro(Libro libro) throws LibroNoDisponibleException {
		if(this.librosPrestados.contains(libro)) {
			this.librosPrestados.remove(libro);
			libro.devolver();
		}else {
			throw new LibroNoDisponibleException("Este libro no se encuentra en la lista de Prestados");
		}
	}
	
	public void mostrarLibrosPrestados() throws LibroNoDisponibleException {
		if(this.librosPrestados.size()>0) {
			System.out.println("Esta es la lista de libros del usuario "+nombre+": ");
			for(int i = 0; i < this.librosPrestados.size(); i++) {
				this.librosPrestados.get(i).mostrarInformacion();
			}
		}else {
			throw new LibroNoDisponibleException("No tiene libros prestados");
		}
	}
}
