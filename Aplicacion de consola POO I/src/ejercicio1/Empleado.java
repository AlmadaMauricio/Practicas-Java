package ejercicio1;

import java.time.LocalDate;

public class Empleado extends Persona {
	//Atributos
	private static int SECUENCIA_LEGAJO = 1000;
	private final int legajo;
	private String puesto;
	
	public Empleado() {
		super();
		this.legajo = SECUENCIA_LEGAJO;
		SECUENCIA_LEGAJO++;
	}
	
	public Empleado(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String genero, String direccion, String telefono, String email, String puesto) {
	    super(dni, nombre, apellido, fechaNacimiento, genero, direccion, telefono, email);
	    this.legajo = SECUENCIA_LEGAJO;
	    SECUENCIA_LEGAJO++;
	    this.puesto = puesto;
	}
		
	//Getters y Setters
	public int getLegajo() {
		return legajo;
	}

	public String getPuesto() {
		return puesto;
	}
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public static int devuelveProximoLegajo() {
	    return SECUENCIA_LEGAJO;
	}
	
	//Creacion toString
	@Override
	public String toString() {
		return "Empleado [Legajo=" + legajo + ", Puesto=" + puesto + "] - Datos Personales: " + super.toString();
	}
}




