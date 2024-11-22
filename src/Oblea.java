public class Oblea {
    private int nroDeOblea;
    private String fechaDeVencimiento;
    private Vehiculo vehiculo;
    private Estado estado;
    private int stock;
    private String fechaDeAlta;

    public Oblea(int nroDeOblea, String fechaDeVencimiento, Vehiculo vehiculo, Estado estado, int stock, String fechaDeAlta) {
        this.nroDeOblea = nroDeOblea;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.vehiculo = vehiculo;
        this.estado = estado;
        this.stock = stock;
        this.fechaDeAlta = fechaDeAlta;
    }

    public void mostrar() {
        System.out.println("Oblea:");
        System.out.println("  Número de Oblea: " + nroDeOblea);
        System.out.println("  Fecha de Vencimiento: " + fechaDeVencimiento);
        System.out.println("  Vehículo Asociado: " + (vehiculo != null ? vehiculo.getTipoVehiculo() : "No asignado"));
        System.out.println("  Estado: " + (estado != null ? estado.getTipo() : "No asignado"));
        System.out.println("  Stock: " + stock);
        System.out.println("  Fecha de Alta: " + fechaDeAlta);
    }
}