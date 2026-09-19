package Ejercicio1;

public class ExVerificarDNI extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	
	public ExVerificarDNI() {
		
	}

	@Override
	public String getMessage() {
		return "El DNI debe contener exactamente 8 caracteres numéricos.";
	}
}