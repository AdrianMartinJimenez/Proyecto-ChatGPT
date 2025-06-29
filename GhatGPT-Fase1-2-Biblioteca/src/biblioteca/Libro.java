package biblioteca;

import java.util.Date;

public class Libro {
	private String titulo,autor;
	private Date anioPublicacion;
	private boolean prestado;
	
	public Libro(String titulo, String autor, Date anioPublicacion) {
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.prestado = false;
	}
	
	public void prestar() {
		this.prestado=true;
	}
	
	public void devolver() {
		this.prestado=false;
	}

	public void mostrarInformacion() {
		System.out.println("Libro [titulo=" + titulo + ", autor=" + autor + ", anioPublicacion=" + anioPublicacion + ", prestado=" + prestado + "]");
	}

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

	public Date getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(Date anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
}
