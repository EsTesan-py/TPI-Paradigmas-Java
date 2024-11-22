public class Vehiculo {
    private TipoVehiculo tipoVehiculo;
    private String numeroMotor;
    private String numeroChasis;
    private String color;
    private int kilometraje;
    private Marca marca;

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
