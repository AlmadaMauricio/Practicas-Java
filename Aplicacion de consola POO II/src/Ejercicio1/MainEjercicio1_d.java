package Ejercicio1;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;

public class MainEjercicio1_d {

	public static void main(String[] args) {

		// 1. Crear 5 objetos Persona
		Persona p1 = new Persona("11111111", "Juan", "Perez", LocalDate.of(1990, 1, 15), "Masculino", "Calle 1", "11111111", "juan@email.com");
		Persona p2 = new Persona("22222222", "Maria", "Gomez", LocalDate.of(1992, 5, 20), "Femenino", "Calle 2", "22222222", "maria@email.com");
		Persona p3 = new Persona("33333333", "Carlos", "Lopez", LocalDate.of(1985, 8, 10), "Masculino", "Calle 3", "33333333", "carlos@email.com");
		Persona p4 = new Persona("44444444", "Ana", "Martinez", LocalDate.of(1993, 3, 25), "Femenino", "Calle 4", "44444444", "ana@email.com");
		Persona p5 = new Persona("55555555", "Lucia", "Fernandez", LocalDate.of(1995, 12, 5), "Femenino", "Calle 5", "55555555", "lucia@email.com");

		// Persona con DNI repetido, para probar que el HashSet detecta el duplicado
		Persona p6Duplicada = new Persona("11111111", "Juan", "Perez", LocalDate.of(1990, 1, 15), "Masculino", "Calle 1", "11111111", "juan@email.com");

		// 2. Guardarlas dentro de un HashSet
		HashSet<Persona> listaPersonas = new HashSet<Persona>();
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		listaPersonas.add(p4);
		listaPersonas.add(p5);
		listaPersonas.add(p6Duplicada);

		System.out.println("Cantidad de personas en el HashSet: " + listaPersonas.size());
		System.out.println("(Se agregaron 6 objetos, pero el HashSet detecta el DNI repetido gracias a equals()/hashCode() y no lo duplica)");
		System.out.println("----------------------------------------");

		// 3. Mostrar la información utilizando un Iterator
		Iterator<Persona> it = listaPersonas.iterator();
		while (it.hasNext()) {
			Persona persona = it.next();
			System.out.println(persona.toString());
			System.out.println("----------------------------------------");
		}
	}
}