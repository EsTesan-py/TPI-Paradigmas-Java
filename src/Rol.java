public class Rol {
    private final String tipoRol;
    private final String funcion;

    public Rol(String tipoRol, String funcion) {
        this.tipoRol = tipoRol;
        this.funcion = funcion;
    }

    public void mostrar() {
        System.out.println("Rol:");
        System.out.println("  Tipo de Rol: " + tipoRol);
        System.out.println("  Función: " + funcion);
    }
}
