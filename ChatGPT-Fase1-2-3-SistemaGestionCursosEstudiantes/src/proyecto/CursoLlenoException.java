package proyecto;

public class CursoLlenoException extends Exception {
	public CursoLlenoException (){
		super("El curso está lleno");
	}
	
	public CursoLlenoException (String e){
		super(e);
	}
}
