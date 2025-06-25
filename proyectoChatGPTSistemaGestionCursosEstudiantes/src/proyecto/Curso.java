package proyecto;

import java.util.ArrayList;

public class Curso {
	private String nombre, codigo;
	private int capacidad;
	private ArrayList<Estudiante> inscritos;
	
	public Curso(String nombre, String codigo, int capacidad) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.capacidad = capacidad;
		this.inscritos = new ArrayList<Estudiante>();
	}
	
	public void inscribirEstudiante(Estudiante e) throws CursoLlenoException{
		if(this.inscritos.size()>this.capacidad) {
			throw new CursoLlenoException();
		}else {
			this.inscritos.add(e);
		}
	}
	
	public void removerEstudiante(Estudiante e) throws CursoLlenoException {
		if(this.inscritos.isEmpty()) {
			throw new CursoLlenoException("No hay estudiantes, por lo que no se puede borrar");
		}else {
			this.inscritos.remove(e);
			e.cancelarInscripcion(this);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public ArrayList<Estudiante> getInscritos() {
		return inscritos;
	}

	public void setInscritos(ArrayList<Estudiante> inscritos) {
		this.inscritos = inscritos;
	}

	public void mostrarInformacion() {
		System.out.println("Curso [nombre=" + nombre + ", codigo=" + codigo + ", capacidad=" + capacidad + "]");
	}
	
	
}
