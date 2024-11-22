public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String nroTelefono;
    private String correoElectronico;
    private String fechaNacimiento;
    private String direccion;

    public Persona(String nombre, String apellido, String dni, String nroTelefono, String correoElectronico, String fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nroTelefono = nroTelefono;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public void mostrar() {
        System.out.println("Persona:");
        System.out.println("  Nombre: " + nombre + " " + apellido);
        System.out.println("  DNI: " + dni);
        System.out.println("  Teléfono: " + nroTelefono);
        System.out.println("  Correo Electrónico: " + correoElectronico);
        System.out.println("  Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("  Dirección: " + direccion);
    }
}
