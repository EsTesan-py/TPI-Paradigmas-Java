public class Cliente extends  Persona {
    private Turno turno;
    private Vehiculo vehiculo;
    private Pago pago;


    public Cliente(String nombre, String apellido, String dni, String nroTelefono, String correoElectronico, String fechaNacimiento, String direccion, Turno turno, Vehiculo vehiculo, Pago pago) {
        super(nombre, apellido, dni, nroTelefono, correoElectronico, fechaNacimiento, direccion);
        this.turno = turno;
        this.vehiculo = vehiculo;
        this.pago = pago;
    }


    public Cliente(String nombre, String apellido, String dni, String nroTelefono, String correoElectronico, String fechaNacimiento, String direccion, Vehiculo vehiculo) {
        super(nombre, apellido, dni, nroTelefono, correoElectronico, fechaNacimiento, direccion);
        this.vehiculo = vehiculo;
    }


    public void mostrar() {
        System.out.println("Cliente:");
        System.out.println("  Turno: " + (turno != null ? turno.getFechaTurno() : "No asignado"));
        System.out.println("  Vehículo: " + (vehiculo != null ? vehiculo.getTipoVehiculo() : "No asignado"));
        System.out.println("  Pago: " + (pago != null ? "$" + pago.calcularMonto() : "No realizado"));
    }


    public Turno conocerTurno() {
        return turno;
    }


    public Vehiculo conocerVehiculo() {
        return vehiculo;
    }
}
