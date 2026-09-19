package Ejercicio2;

public class EdificioOficinas implements Edificio {
    private double superficie;
    private int numeroOficinas;

    public EdificioOficinas(double superficie, int numeroOficinas) {
        this.superficie = superficie;
        this.numeroOficinas = numeroOficinas;
    }
    
    public EdificioOficinas() {}

    @Override
    public double getSuperficieEdificio() {
        return superficie;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

}
