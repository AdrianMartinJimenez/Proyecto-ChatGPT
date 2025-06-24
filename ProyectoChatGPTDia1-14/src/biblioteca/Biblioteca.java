package biblioteca;

import java.util.ArrayList;

public class Biblioteca {
	private String nombre;
	private ArrayList<Libro> catalogo;
	
	public Biblioteca (String nombre) {
		this.nombre = nombre;
		this.catalogo = new ArrayList<Libro>();
	}
	
	public void agregarLibro(Libro libro) {
		this.catalogo.add(libro);
	}
	
	public void mostrarLibrosDisponibles() throws LibroNoDisponibleException {
		if(this.catalogo.size()>0) {
			ArrayList<Libro> catalogoDisponible = new ArrayList<Libro>();
			for(int i = 0; i < this.catalogo.size(); i++) {
				if(!this.catalogo.get(i).isPrestado()) {
					catalogoDisponible.add(this.catalogo.get(i));
				}
			}
			if(catalogoDisponible.size()>0) {
				System.out.println("Esta es la lista de libros de la biblioteca "+nombre+": ");
				for(int i = 0; i < catalogoDisponible.size(); i++) {
						catalogoDisponible.get(i).mostrarInformacion();
				}
			}else {
				throw new LibroNoDisponibleException("No tiene libros disponibles en el catálogo");
			}
		}else {
			throw new LibroNoDisponibleException("No tiene libros el catálogo");
		}
	}
	
	public void buscarLibro(String titulo) throws LibroNoDisponibleException {
		if(this.catalogo.size()>0) {
			boolean encontrado = false;
			for(int i = 0; i < this.catalogo.size(); i++) {
				if(this.catalogo.get(i).getTitulo().equals(titulo)) {
					encontrado = true;
					System.out.println("Esta es el líbro que busca:");
					this.catalogo.get(i).mostrarInformacion();
				}
			}
			if(!encontrado){
				System.out.println("Ese libro no se encuentra en el catálogo. Lo lamentamos. Le podemos ofrecer los siguientes títulos parecidos: ");
				for(int i = 0; i < this.catalogo.size(); i++) {
					if(this.catalogo.get(i).getTitulo().contains(titulo)) {
						catalogo.get(i).mostrarInformacion();
					}
				}
			}
		}else {
			throw new LibroNoDisponibleException("No tiene libros el catálogo");
		}
	}
}
