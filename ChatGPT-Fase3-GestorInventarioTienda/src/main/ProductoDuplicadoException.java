package main;

public class ProductoDuplicadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3257612232323347732L;
	
	public ProductoDuplicadoException(String msg) {
		super(msg);
	}
	
	public ProductoDuplicadoException() {
		super("No se puede insertar dos productos iguales, aumente la cantidad");
	}
}
