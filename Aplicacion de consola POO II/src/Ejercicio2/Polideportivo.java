package Ejercicio2;

public class Polideportivo implements Edificio, InstalacionDeportiva{
	private String nombre;
	private double superficie;
	private int tipoDeInstalacion;
	
    public Polideportivo(String nombre, double superficie, int tipoDeInstalacion) {
        this.nombre = nombre;
        this.superficie = superficie;
        this.tipoDeInstalacion = tipoDeInstalacion;
    }
    
    public Polideportivo() {}

	@Override
	public int getTipoDeInstalacion() {
		return tipoDeInstalacion;
	}

	@Override
	public double getSuperficieEdificio() {
		return superficie;
	}
	
	public String getNombre() {
		return nombre;
	}
}