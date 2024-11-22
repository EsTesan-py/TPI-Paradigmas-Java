public class Empleado {
    private final Rol rol;
    private final String rolEmpleado;

    public Empleado(Rol rol, String rolEmpleado) {
        this.rol = rol;
        this.rolEmpleado = rolEmpleado;
    }

    public void mostrar() {
        System.out.println("Empleado:");
        System.out.println("  Rol del Empleado: " + rolEmpleado);
        if (rol != null) {
            rol.mostrar();
        }
    }

    public Rol conocerRol() {
        return rol;
    }
}
