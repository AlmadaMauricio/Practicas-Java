package Ejercicio1;

import java.time.LocalDate;

public class Empleado extends Persona implements Comparable<Empleado>{
	
	private final int legajo;
	private String puesto;
	private static int proximoLegajo = 1000;
	
	
	public Empleado() {
		super();
		this.legajo = proximoLegajo;
		this.puesto = "puesto no definido";
		
		proximoLegajo++;
	}
	
	public Empleado(String dni, String nombre, String apellido, LocalDate fechaNacimiento,
			   String genero, String direccion, String telefono, String email, String puesto) {
		
		super(dni, nombre, apellido, fechaNacimiento, genero, direccion, telefono, email);
		this.legajo = proximoLegajo;
		this.puesto = puesto;
		
		proximoLegajo++;
		
	}
	
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
		return proximoLegajo;
		
	}

	@Override
	public String toString() {
	    return super.toString() + "\n" +
	           "legajo= " + legajo + "\n" +
	           "puesto= " + puesto + "\n";
	}

	@Override
	public int compareTo(Empleado otroEmp) {
		// Ordenamiento por legajo de menor a mayor...
        return Integer.compare(this.legajo, otroEmp.legajo);
	}
}