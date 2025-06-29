package main;

public class Main {

	public static void main(String[] args) {
		Inventario inventario = new Inventario();
		//String nombre, String categoria, double precio, int cantidad
		Producto p = null;
		try {
			p = new Producto("Patata", "Hortaliza", 1, 12);
			inventario.agregarProducto(p);
			p = new Producto("Boniato", "Hortaliza", 0.5, 8);
			inventario.agregarProducto(p);
			p = new Producto("Tomate", "Fruta", 4.85, 3);
			inventario.agregarProducto(p);
			p = new Producto("Coliflor", "Hortaliza", 3.23, 56);
			inventario.agregarProducto(p);
			p = new Producto("Sandia", "Hortaliza", 8.50, 2);
			inventario.agregarProducto(p);
			System.out.println(inventario.toString());
			inventario.guardarEnArchivo("");
			inventario.getProductos().clear();
			System.out.println(inventario.toString());
			inventario.cargarDesdeArchivo("");
		} catch (ProductoDuplicadoException e) {
			e.printStackTrace();
		}
	}

}
