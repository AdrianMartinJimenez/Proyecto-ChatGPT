package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Inventario {
	private ArrayList<Producto> productos;

	public Inventario() {
		super();
		this.productos = new ArrayList <Producto>();
	}
	
	public void agregarProducto(Producto producto) throws ProductoDuplicadoException{
		for(Producto p : this.productos) {
			if(p.getNombre().equals(producto.getNombre())) {
				throw new ProductoDuplicadoException();
			}
		}
		this.productos.add(producto);
	}
	
	public void buscarPorCategoria(String categoria) {
		ArrayList<Producto> productosFiltrados = (ArrayList<Producto>) this.productos.stream()
				.filter(p -> p.getCategoria().equals(categoria))
				.collect(Collectors.toList());
		
		productosFiltrados.forEach(p -> p.toString());
	}
	
	public void guardarEnArchivo(String ruta) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta+"Inventario.txt"))) {
		    productos.forEach(p -> {
				try {
					bw.write(p.toString());
					bw.newLine();
				} catch (IOException e) {
					System.out.print("Error al escribir en el archivo. - "+e.getMessage());
				}
			});
		} catch (IOException e) {
		    System.out.println("Error al guardar en el archivo. - "+e.getMessage());
		}

	}
	
	public void cargarDesdeArchivo(String ruta) {
		try (BufferedReader br = new BufferedReader(new FileReader(ruta+"Inventario.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Quitar "Producto [" al inicio y "];" al final
                if (linea.startsWith("Producto [") && linea.endsWith("];")) {
                    String contenido = linea.substring(9, linea.length() - 2); // extrae el texto dentro de corchetes

                    // Ahora contenido = "nombre=Manzana, categoria=Fruta, precio=1.5, cantidad=10"
                    // Lo separamos por coma para obtener cada campo
                    String[] campos = contenido.split(", ");

                    String nombre = "";
                    String categoria = "";
                    double precio = 0;
                    int cantidad = 0;

                    for (String campo : campos) {
                        String[] claveValor = campo.split("=");
                        if (claveValor.length == 2) {
                            String clave = claveValor[0].trim();
                            String valor = claveValor[1].trim();

                            switch (clave) {
                                case "nombre":
                                    nombre = valor;
                                    break;
                                case "categoria":
                                    categoria = valor;
                                    break;
                                case "precio":
                                    precio = Double.parseDouble(valor);
                                    break;
                                case "cantidad":
                                    cantidad = Integer.parseInt(valor);
                                    break;
                            }
                        }
                    }

                    Producto p = new Producto(nombre, categoria, precio, cantidad);
                    productos.add(p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar productos cargados
		productos.forEach(p -> System.out.println(p.toString()));

	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Inventario [productos=" + productos + "]";
	}
	
}
