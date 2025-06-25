package proyecto;

import java.util.ArrayList;

public class Academia {
	private String nombre;
	private ArrayList cursos, estudiantes;
	
	public Academia(String nombre) {
		this.nombre = nombre;
		this.cursos = new ArrayList<Curso>();
		this.estudiantes = new ArrayList<Estudiante>();
	}
	
	public void agregarCurso(Curso c) {
		this.cursos.add(c);
	}
	
	public void agregarEstudiante(Estudiante e) {
		this.estudiantes.add(e);
	}
	
	public void buscarCursoPorcodigo(String codigo) throws CursoLlenoException{
		if(this.cursos.isEmpty()) {
			throw new CursoLlenoException("La academia no tiene cursos aún");
		}else {
			boolean encontrado = false;
			for(int i = 0 ; i < this.cursos.size() ; i++) {
				if(((Curso) this.cursos.get(i)).getCodigo().equals(codigo)) {
					System.out.println("El curso que busca es el siguiente: ");
					((Curso) this.cursos.get(i)).mostrarInformacion();
					encontrado = true;
				}else if(((Curso) this.cursos.get(i)).getCodigo().contains(codigo)) {
					System.out.println("El curso que busca no se ha encontrado pero un código similar sería el siguiente: ");
					((Curso) this.cursos.get(i)).mostrarInformacion();
					encontrado = true;
				}
			}
			if(!encontrado) {
				throw new CursoLlenoException("La academia no tiene ese curso registrado");
			}
		}
	}
	
	public void buscarEstudiantePorDNI(String dni) throws CursoLlenoException{
		if(this.estudiantes.isEmpty()) {
			throw new CursoLlenoException("La academia no tiene estudiantes aún");
		}else {
			boolean encontrado = false;
			for(int i = 0 ; i < this.estudiantes.size() ; i++) {
				if(((Estudiante) this.estudiantes.get(i)).getDni().equals(dni)) {
					System.out.println("El estudiante que busca es el siguiente: ");
					((Estudiante) this.estudiantes.get(i)).toString();
					encontrado = true;
				}
			}
			if(!encontrado) {
				throw new CursoLlenoException("La academia no tiene ese estudiante registrado");
			}
		}
	}
}
