public class Tarifa {
    private double precioxPeso;

    public Tarifa(double precioxPeso) {
        this.precioxPeso = precioxPeso;
    }

    public double getPrecio() {
        return precioxPeso;
    }

    public void mostrar() {
        System.out.println("Tarifa:");
        System.out.println("  Precio por Peso: $" + precioxPeso);
    }
}
