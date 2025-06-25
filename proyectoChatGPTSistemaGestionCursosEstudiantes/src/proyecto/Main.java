package proyecto;

public class Main {

	public static void main(String[] args) {
		Curso curso1 = new Curso("Margaritas", "1", 2);
		Estudiante estudiante1 = new Estudiante("Paquito","53452607Z");
		try {
			estudiante1.inscribirse(curso1);
			estudiante1.mostrarCursos();
			curso1.mostrarInformacion();
		} catch (CursoLlenoException e) {
			e.printStackTrace();
		}
	}

}
