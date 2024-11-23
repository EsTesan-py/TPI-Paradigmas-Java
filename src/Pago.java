public class Pago {
    private final String fecha;
    private final String hora;
    private final String condicionIva;
    private final String cuil;
    private final Revision revision;
    private final Tarifa tarifa;
    private final double monto;

    public Pago(String fecha, String hora, String condicionIva, String cuil, Revision revision, Tarifa tarifa) {
        this.fecha = fecha;
        this.hora = hora;
        this.condicionIva = condicionIva;
        this.cuil = cuil;
        this.revision = revision;
        this.tarifa = tarifa;
        this.monto = calcularMonto();
    }

    public double calcularMonto() {
        return tarifa != null ? tarifa.getPrecio() : 0;
    }

    public Tarifa conocerTarifa() {
        return tarifa;
    }

    public void mostrar() {
        System.out.println("Pago:");
        System.out.println("  Fecha: " + fecha);
        System.out.println("  Hora: " + hora);
        System.out.println("  CUIL: " + cuil);
        System.out.println("  Monto: $" + monto);
    }
}
