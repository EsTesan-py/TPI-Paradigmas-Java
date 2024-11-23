public class Cliente extends  Persona {
    private final Turno turno;
    private Vehiculo vehiculo;
    private final Pago pago;


    public Cliente(String nombre, String apellido, String dni, String nroTelefono, String correoElectronico, String fechaNacimiento, String direccion, Turno turno, Vehiculo vehiculo, Pago pago) {
        super(nombre, apellido, dni, nroTelefono, correoElectronico, fechaNacimiento, direccion);
        this.turno = turno;
        this.vehiculo = vehiculo;
        this.pago = pago;
    }


    public void mostrar() {
        System.out.println("Cliente:");
        System.out.println("  Turno: " + (turno != null ? turno.getFechaTurno() : "No asignado"));
        System.out.println("  Vehículo: " + (vehiculo != null ? vehiculo.getTipoVehiculo() : "No asignado"));
        System.out.println("  Pago: " + (pago != null ? "$" + pago.calcularMonto() : "No realizado"));
        mostrarInformacionBasica();
    }


    public Turno conocerTurno() {
        return turno;
    }


    public Vehiculo conocerVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
