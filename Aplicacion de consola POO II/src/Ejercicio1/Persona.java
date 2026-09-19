package Ejercicio1;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {

	private String dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String genero;
	private String direccion;
	private String telefono;
	private String email;

	public Persona() {
		this.dni = "11111111";
		this.nombre = "sin nombre";
		this.apellido = "sin apellido";
		this.fechaNacimiento = LocalDate.of(2025, 1, 1);
		this.genero = "sin genero";
		this.direccion = "sin direccion";
		this.telefono = "1111111111";
		this.email = "persona@sinEmail.com";
	}

	public Persona(String dni, String nombre, String apellido, LocalDate fechaNacimiento,
				   String genero, String direccion, String telefono, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	public static boolean VerificarDNI(String dni) throws ExVerificarDNI {
		if (dni == null || dni.length() != 8) {
			throw new ExVerificarDNI();
		}

		for (int i = 0; i < dni.length(); i++) {
			if (!Character.isDigit(dni.charAt(i))) {
				throw new ExVerificarDNI();
			}
		}
		return true;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "dni= " + dni + "\n" +
			   "nombre= " + nombre + "\n" +
			   "apellido= " + apellido + "\n" +
			   "fechaNacimiento= " + fechaNacimiento + "\n" +
			   "genero= " + genero + "\n" +
			   "direccion= " + direccion + "\n" +
			   "telefono= " + telefono + "\n" +
			   "email= " + email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
}