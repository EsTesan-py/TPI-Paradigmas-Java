public class Modelo {
    private String nombre;

    public Modelo(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.println("  Modelo: " + nombre);
    }
}
