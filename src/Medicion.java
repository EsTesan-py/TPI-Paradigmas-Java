public class Medicion {
    private String tipoMedicion;
    private double valorMedicion;

    public Medicion(String tipoMedicion, double valorMedicion) {
        this.tipoMedicion = tipoMedicion;
        this.valorMedicion = valorMedicion;
    }

    public void mostrar() {
        System.out.println("Medición:");
        System.out.println("  Tipo de Medición: " + tipoMedicion);
        System.out.println("  Valor: " + valorMedicion);
    }
}
