package main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Actividades {

	public static void empleadosSalarioMas2000(List<Empleado> empleados) {
		empleados.stream()
			.filter(e->e.getSalario()>2000)
			.forEach(System.out::println);
	}
	
	public static void ordenarPorSalarioDesc(List<Empleado> empleados) {
		empleados.stream()
			.sorted(Comparator.comparing(Empleado::getSalario).reversed())
			.forEach(System.out::println);
	}
	
	public static void getSalarioMasAltoYMasBajo(List<Empleado> empleados) {
		Optional<Empleado> mejorPagado = empleados.stream().max(Comparator.comparingDouble(Empleado::getSalario));
		Optional<Empleado> peorPagado = empleados.stream().min(Comparator.comparingDouble(Empleado::getSalario));
		
		mejorPagado.ifPresent(e -> System.out.println("Mejor pagado: "+e));
		peorPagado.ifPresent(e -> System.out.println("Peor pagado: "+e));
	}
	
	public static void agruparDepartamento(List<Empleado> empleados) {
		Map<String, List<Empleado>> agrupados = empleados.stream().collect(Collectors.groupingBy(Empleado::getDepartamento));
		agrupados.forEach((departamento,lista)->{
			System.out.println(departamento+" : ");
			lista.forEach(e->System.out.println(" - "+e));
		});
	}
}
