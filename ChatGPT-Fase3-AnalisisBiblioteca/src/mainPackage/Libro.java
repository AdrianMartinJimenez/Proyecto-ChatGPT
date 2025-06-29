package mainPackage;

import java.util.Collection;
import java.util.Comparator;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private double calificacion;
    
    public Libro(String titulo, String autor, int anioPublicacion, String genero, double calificacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.calificacion = calificacion;
    }
    
    public static Comparator<Libro> porAnioPublicacionDesc = Comparator.comparing(Libro::getAnioPublicacion).reversed();
    
    public static Comparator<Libro> porCalificacionAsc = Comparator.comparing(Libro::getCalificacion);
    
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", anioPublicacion=" + anioPublicacion + ", genero="
				+ genero + ", calificacion=" + calificacion + "]";
	}

}
