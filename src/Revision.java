public class Revision {
    private final int idRevision;
    private final String fechaAlta;
    private final String fechaVencimiento;
    private final Vehiculo vehiculo;
    private Oblea oblea;
    private final Empleado empleado;
    private final Defectos defectosVisuales;
    private final Medicion resultadoMedicion;
    private final Estado estado;

    public Revision(int idRevision, String fechaAlta, String fechaVencimiento, Vehiculo vehiculo,
                    Oblea oblea, Empleado empleado, Defectos defectosVisuales, Medicion resultadoMedicion, Estado estado) {
        this.idRevision = idRevision;
        this.fechaAlta = fechaAlta;
        this.fechaVencimiento = fechaVencimiento;
        this.vehiculo = vehiculo;
        this.oblea = oblea;
        this.empleado = empleado;
        this.defectosVisuales = defectosVisuales;
        this.resultadoMedicion = resultadoMedicion;
        this.estado = estado;
    }

    public void mostrar() {
        System.out.println("Revisión #" + idRevision);
        System.out.println("Fecha de Alta: " + fechaAlta);
        System.out.println("Fecha de Vencimiento: " + fechaVencimiento);
    }
    public void asignarOblea(Oblea nuevaOblea) {
        this.oblea = nuevaOblea;
        System.out.println("Oblea asignada correctamente.");
    }

}
