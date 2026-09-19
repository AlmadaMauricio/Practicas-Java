package Ejercicio1;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class MainEjercicio1_c {

	public static void main(String[] args) {

		// 1. Creando 5 Empleados y Agregandolos a un TreeSet
		// Funcionalidad Extra: Implementación de Comparator para ordenar alfabéticamente
		TreeSet<Empleado> listEmpleados = new TreeSet<Empleado>(new Comparator<Empleado>() {
			@Override
			public int compare(Empleado emp1, Empleado emp2) {
				int comparacionApellido = emp1.getApellido().compareToIgnoreCase(emp2.getApellido());
				if (comparacionApellido == 0) {
					return emp1.getNombre().compareToIgnoreCase(emp2.getNombre());
				}
				return comparacionApellido;
			}
		});
		
		listEmpleados.add(new Empleado("11111111", "Raul", "Lopes", LocalDate.of(1990, 5, 25), "Masculino", "Calle Falsa 123", "11122233", "lopez@email.com", "Tecninco"));
		listEmpleados.add(new Empleado("22222222", "Ana", "Gomez", LocalDate.of(2000, 6, 5), "Femenino", "AV Peron 33", "13234233", "gomez@email.com", "Administradora"));   
		listEmpleados.add(new Empleado("33333333", "Sofia", "Gonzalez", LocalDate.of(1999, 7, 30), "Femenino", "Calle Directorio 999", "34689033", "carrito@email.com", "Recepcionista"));   
		listEmpleados.add(new Empleado("44444444", "Ernesto", "Vera", LocalDate.of(2003, 6, 29), "Masculino", "Calle Independencia 2023", "45783335", "ern32z@email.com", "Jefe de Planta"));   
		listEmpleados.add(new Empleado("55555555", "Alan", "Garcia", LocalDate.of(1995, 3, 20), "Masculino", "Calle Martes 123", "21347651", "alan32@email.com", "Ingeniero"));
		
		// 2. Mostrando informacion con un iterator
		System.out.println("--- EMPLEADOS ORDENADOS ALFABÉTICAMENTE ---");
		Iterator<Empleado> it = listEmpleados.iterator();
		while (it.hasNext()) {
			Empleado empleado = (Empleado) it.next();
			System.out.println(empleado.toString());
			System.out.println("----------------------------------------");
		}
	}
}