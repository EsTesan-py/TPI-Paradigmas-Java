public class Vehiculo {
    private final TipoVehiculo tipoVehiculo;
    private final String numeroMotor;
    private final String numeroChasis;
    private final String color;
    private final int kilometraje;
    private final Marca marca;

    public Vehiculo(TipoVehiculo tipoVehiculo, String numeroMotor, String numeroChasis, String color, int kilometraje, Marca marca) {
        this.tipoVehiculo = tipoVehiculo;
        this.numeroMotor = numeroMotor;
        this.numeroChasis = numeroChasis;
        this.color = color;
        this.kilometraje = kilometraje;
        this.marca = marca;
    }

    public void mostrar() {
        System.out.println("Vehículo:");
        System.out.println("  Tipo: " + (tipoVehiculo != null ? tipoVehiculo.getCategoria() : "No especificado"));
        System.out.println("  Número de Motor: " + numeroMotor);
        System.out.println("  Número de Chasis: " + numeroChasis);
        System.out.println("  Color: " + color);
        System.out.println("  Kilometraje: " + kilometraje);
        System.out.println("  Marca: " + (marca != null ? marca.getNombre() : "No especificado"));
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
}
