public class Cliente {
    private final Turno turno;
    private final Vehiculo vehiculo;
    private final Pago pago;

    public Cliente(Turno turno, Vehiculo vehiculo, Pago pago) {
        this.turno = turno;
        this.vehiculo = vehiculo;
        this.pago = pago;
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
