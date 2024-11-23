public class Empleado extends Persona{
    private final Rol rol;

    public Empleado(String nombre, String apellido, String dni, String nroTelefono, String correoElectronico, String fechaNacimiento, String direccion, Rol rol) {
        super(nombre, apellido, dni, nroTelefono, correoElectronico, fechaNacimiento, direccion);
        this.rol = rol;
    }

    public void mostrar() {
        System.out.println("Empleado:");
        if (rol != null) {
            rol.mostrar();
        }
        mostrarInformacionBasica();
    }

    public Rol conocerRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "rol=" + rol +
                '}';
    }
}
