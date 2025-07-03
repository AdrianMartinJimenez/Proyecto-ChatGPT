package main;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<Empleado> empleados = List.of(
				new Empleado("Ana", "Ventas", 2500),
	            new Empleado("Luis", "IT", 3000),
	            new Empleado("Marta", "Ventas", 1800),
	            new Empleado("Carlos", "IT", 2200),
	            new Empleado("Lucía", "Marketing", 1900)
			);
		System.out.println("🔎 Empleados con salario > 2000:");
		Actividades.empleadosSalarioMas2000(empleados);
		System.out.println("\n📊 Empleados ordenados por salario descendente:");
		Actividades.ordenarPorSalarioDesc(empleados);
		Actividades.getSalarioMasAltoYMasBajo(empleados);
		System.out.println("\n📁 Empleados agrupados por departamento:");
		Actividades.agruparDepartamento(empleados);
	}
	
}
