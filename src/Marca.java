public class Marca {
    private final String nombre;
    private final Modelo modelo;

    public Marca(String nombre, Modelo modelo) {
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrar() {
        System.out.println("Marca: " + nombre);
        if (modelo != null) {
            modelo.mostrar();
        }
    }
    @Override
    public String toString() {
        return "Marca{" +
                "nombre=" + nombre +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
