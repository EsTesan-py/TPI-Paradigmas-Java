public class TipoVehiculo {
    private double peso;
    private int eje;
    private String categoria;

    public TipoVehiculo(double peso, int eje, String categoria) {
        this.peso = peso;
        this.eje = eje;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void mostrar() {
        System.out.println("Tipo de Vehículo:");
        System.out.println("  Peso: " + peso + " kg");
        System.out.println("  Ejes: " + eje);
        System.out.println("  Categoría: " + categoria);
    }
}
