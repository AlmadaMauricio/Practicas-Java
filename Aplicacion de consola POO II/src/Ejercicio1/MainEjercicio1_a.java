package Ejercicio1;

import java.time.LocalDate;

public class MainEjercicio1_a {

	public static void main(String[] args) {
		try {
			Persona persona1 = new Persona("AA202020", "Carlos", "Gomez", LocalDate.of(1990, 5, 12), "Masculino", "Av. San Martin 123", "1144445555", "carlos@email.com");
			Persona.VerificarDNI(persona1.getDni());
			System.out.println("Persona agregada correctamente");
		} catch (ExVerificarDNI ex) {
			System.out.println("Persona no agregada por no verificar el DNI");
		}
		
		try {	
			Persona persona2 = new Persona("20202020", "John", "Doe", LocalDate.of(1998, 1, 1), "Masculino", "Pedro Calderon de la Barca 123", "1122000001", "john.doe@email.com");
			Persona.VerificarDNI(persona2.getDni());
			System.out.println("Persona agregada correctamente");
		} catch (ExVerificarDNI ex) {
			System.out.println("Persona no agregada por no verificar el DNI");
		}
	}

}