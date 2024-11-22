public class Pago {
    private String fecha;
    private String hora;
    private String condicionIva;
    private String cuil;
    private Revision revision;
    private Tarifa tarifa;
    private double monto;

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

    public void mostrar() {
        System.out.println("Pago:");
        System.out.println("  Fecha: " + fecha);
        System.out.println("  Hora: " + hora);
        System.out.println("  CUIL: " + cuil);
        System.out.println("  Monto: $" + monto);
    }
}
