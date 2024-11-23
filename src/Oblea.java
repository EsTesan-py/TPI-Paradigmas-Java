import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Oblea {
    private final int nroDeOblea;
    private final String fechaDeVencimiento; // Formato esperado: "YYYY-MM-DD"
    private final Vehiculo vehiculo;
    private final int stock;
    private final Estado estado;
    private final String fechaDeAlta; // Formato esperado: "YYYY-MM-DD"

    public Oblea(int nroDeOblea, String fechaDeVencimiento, Vehiculo vehiculo, Estado estado, int stock, String fechaDeAlta) {
        if (nroDeOblea <= 0) {
            throw new IllegalArgumentException("El número de oblea debe ser positivo.");
        }

        if (!esFechaValida(fechaDeVencimiento, fechaDeAlta)) {
            throw new IllegalArgumentException("La fecha de vencimiento debe ser posterior a la fecha de alta.");
        }

        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }

        this.nroDeOblea = nroDeOblea;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.vehiculo = vehiculo;
        this.estado = estado;
        this.stock = stock;
        this.fechaDeAlta = fechaDeAlta;
    }

    private boolean esFechaValida(String fechaDeVencimiento, String fechaDeAlta) {
        try {
            LocalDate vencimiento = LocalDate.parse(fechaDeVencimiento);
            LocalDate alta = LocalDate.parse(fechaDeAlta);
            return vencimiento.isAfter(alta);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Las fechas deben estar en el formato 'YYYY-MM-DD'.", e);
        }
    }

    public void mostrar() {
        System.out.println("Oblea:");
        System.out.println("  Número de Oblea: " + nroDeOblea);
        System.out.println("  Fecha de Alta: " + fechaDeAlta);
        System.out.println("  Fecha de Vencimiento: " + fechaDeVencimiento);
        System.out.println("  Vehículo Asociado: " + (vehiculo != null ? vehiculo.getTipoVehiculo() : "No asignado"));
        System.out.println("  Estado: " + (estado != null ? estado.getTipo() : "No asignado"));
        System.out.println("  Stock: " + stock);
    }

    public int getNroDeOblea() {
        return nroDeOblea;
    }

    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getFechaDeAlta() {
        return fechaDeAlta;
    }
}
