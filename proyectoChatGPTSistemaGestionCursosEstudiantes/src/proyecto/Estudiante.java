package proyecto;

import java.util.ArrayList;

public class Estudiante {
	private String nombre, dni;
	private ArrayList<Curso> cursosInscritos;
	
	public Estudiante (String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.cursosInscritos = new ArrayList<Curso>();
	}
	
	public void inscribirse(Curso c) throws CursoLlenoException {
		c.inscribirEstudiante(this);
		this.cursosInscritos.add(c);
	}
	
	public void cancelarInscripcion(Curso c) throws CursoLlenoException {
		if(!this.cursosInscritos.contains(c)) {
			throw new CursoLlenoException("El estudiante no se encuentra inscrito en este curso");
		}else {
			this.cursosInscritos.remove(c);
		}
	}
	
	public void mostrarCursos() throws CursoLlenoException {
		if(this.cursosInscritos.isEmpty()) {
			throw new CursoLlenoException("El estudiante no esta inscrito en ningún curso");
		}else {
			System.out.println("El estudiante "+ this.nombre+" con dni "+this.dni+" esta inscrito en: [");
			for(int i = 0 ; i < this.cursosInscritos.size(); i++) {
				if(i == 0) {
					this.cursosInscritos.get(i).mostrarInformacion();
				}else {
					System.out.print(",");
					this.cursosInscritos.get(i).mostrarInformacion();
				}
			}
			System.out.println("]");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public ArrayList<Curso> getCursosInscritos() {
		return cursosInscritos;
	}

	public void setCursosInscritos(ArrayList<Curso> cursosInscritos) {
		this.cursosInscritos = cursosInscritos;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", dni=" + dni + ", cursosInscritos=" + cursosInscritos + "]";
	}
	
	
}
