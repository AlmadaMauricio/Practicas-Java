package ejercicio1;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
			//Empleados creados atraves de constructor con parametros
			Empleado emp1 = new Empleado("11222333", "Carlos", "Gomez", LocalDate.of(1990, 5, 12), "Masculino", "Av. San Martin 123", "1144445555", "carlos@email.com", "Desarrollador");
			Empleado emp2 = new Empleado("22333444", "Ana", "Martinez", LocalDate.of(1988, 8, 20), "Femenino", "Calle 45 No 678", "1166667777", "ana@email.com", "Analista");
			Empleado emp3 = new Empleado("33444555", "Lucas", "Rodríguez", LocalDate.of(1995, 3, 15), "Masculino", "Belgrano 432", "1188889999", "lucas@email.com", "Tester");

			//Empleados creados atraves de constructor vacio
			Empleado emp4 = new Empleado();
			emp4.setDni("44555666");
			emp4.setNombre("Maria");
			emp4.setApellido("Lopez");
			emp4.setFechaNacimiento(LocalDate.of(1992, 11, 30));
			emp4.setGenero("Femenino");
			emp4.setDireccion("Pedro Calderon de la Barca 1000");
			emp4.setTelefono("1122020211");
			emp4.setEmail("maria.lopez@email.com");
			emp4.setPuesto("QA Analyst");
			  
	
			Empleado emp5 = new Empleado();
			  
			//Impresion de empleados
			System.out.println("Informacion correspondiente a los empleados creados:");			
			System.out.println(emp1.toString());			
			System.out.println(emp2.toString());
			System.out.println(emp3.toString());
			System.out.println(emp4.toString());
			System.out.println(emp5.toString());
		
			//Mostrar proximo legajo
			System.out.println("El próximo legajo será el " + Empleado.devuelveProximoLegajo());
		}

	


	  // Completar datos de emp5
	
}
