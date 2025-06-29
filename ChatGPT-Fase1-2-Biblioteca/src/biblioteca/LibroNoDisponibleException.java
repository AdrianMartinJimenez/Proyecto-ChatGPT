package biblioteca;

public class LibroNoDisponibleException extends Exception {
	
	// Constructor por defecto
    public LibroNoDisponibleException() {
        super("El libro ya está prestado.");
    }

    // Constructor personalizado con mensaje
    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
