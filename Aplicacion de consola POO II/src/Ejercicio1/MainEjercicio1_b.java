package Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class MainEjercicio1_b {

	public static void main(String[] args) {
		
		// 1. Crear 5 Empleados
		Empleado emp1 = new Empleado("11111111", "Juan", "Perez", LocalDate.of(1990, 1, 15), "Masculino", "Calle Falsa 123", "1122334455", "juan@email.com", "Vendedor");
		Empleado emp2 = new Empleado("22222222", "Maria", "Gomez", LocalDate.of(1992, 5, 20), "Femenino", "Av. Libertador 456", "1155667788", "maria@email.com", "Gerente");
		Empleado emp3 = new Empleado("33333333", "Carlos", "Lopez", LocalDate.of(1985, 8, 10), "Masculino", "San Martin 789", "1199001122", "carlos@email.com", "Operario");
		Empleado emp4 = new Empleado("44444444", "Ana", "Martinez", LocalDate.of(1993, 3, 25), "Femenino", "Sarmiento 987", "1133224455", "ana@email.com", "Administrativo");
		Empleado emp5 = new Empleado("55555555", "Lucia", "Fernandez", LocalDate.of(1995, 12, 5), "Femenino", "Belgrano 321", "1144332211", "lucia@email.com", "Supervisora");

		// 2. Guardarlos dentro de un ArrayList
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		listaEmpleados.add(emp1);
		listaEmpleados.add(emp2);
		listaEmpleados.add(emp3);
		listaEmpleados.add(emp4);
		listaEmpleados.add(emp5);
		
		// 3. Mostrar la información utilizando un Iterator
		System.out.println("--- LISTA DE EMPLEADOS (ArrayList) ---");
		Iterator<Empleado> it = listaEmpleados.iterator();
		
		while(it.hasNext()) {
			Empleado emp = it.next();
			System.out.println(emp.toString());
			System.out.println("----------------------------------------");
		}
	}
}