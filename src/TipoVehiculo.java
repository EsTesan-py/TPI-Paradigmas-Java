public class TipoVehiculo {
    private final double peso;
    private final int eje;
    private final String categoria;

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
    @Override
    public String toString(){
        return "Peso: "+peso +
                " Ejes "+eje +
                " Categoria: "+categoria;
    }
}
