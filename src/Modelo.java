public class Modelo {
    private final String nombre;

    public Modelo(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.println("  Modelo: " + nombre);
    }
}
