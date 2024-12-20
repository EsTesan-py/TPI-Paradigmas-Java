public class Revision {
    private final int idRevision;
    private final String fechaAlta;
    private final String fechaVencimiento;
    private final Vehiculo vehiculo;
    private Oblea oblea;
    private final Empleado empleado;
    private Defectos defectosVisuales;
    private Medicion resultadoMedicion;
    private final Estado estado;




    public Revision(int idRevision, String fechaAlta, String fechaVencimiento, Vehiculo vehiculo, Empleado empleado, Defectos defectosVisuales, Medicion resultadoMedicion, Estado estado) {
        this.idRevision = idRevision;
        this.fechaAlta = fechaAlta;
        this.fechaVencimiento = fechaVencimiento;
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.defectosVisuales = defectosVisuales;
        this.resultadoMedicion = resultadoMedicion;
        this.estado = estado;
        this.oblea = null;
        this.defectosVisuales = null;
        this.resultadoMedicion = null;
    }


   /* public Revision(int idRevision, String fechaAlta, String fechaVencimiento, Vehiculo vehiculo, Empleado empleado, Estado estado) {
        this.idRevision = idRevision;
        this.fechaAlta = fechaAlta;
        this.fechaVencimiento = fechaVencimiento;
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.estado = estado;
    }*/




    public void mostrar() {
        System.out.println("Revisión #" + idRevision);
        System.out.println("Fecha de Alta: " + fechaAlta);
        System.out.println("Fecha de Vencimiento: " + fechaVencimiento);
        System.out.println("Estado: " + estado);
        System.out.println("Vehículo: " + vehiculo);
        System.out.println("Oblea: " + (oblea != null ? oblea : "Sin oblea asignada"));
    }
    public void asignarOblea(Oblea nuevaOblea) {
        if (this.oblea != null) {
            System.out.println("Advertencia: Esta revisión ya tiene una oblea asignada.");
        }
        this.oblea = nuevaOblea;
        System.out.println("Oblea asignada correctamente.");
    }

    public Vehiculo conocerVehiculo() {
        return vehiculo;
    }


    public Oblea conocerOblea() {
        return oblea;
    }




    public Empleado conocerEmpleado() {
        return empleado;
    }




    public Estado conocerEstado() {
        return estado;
    }




    public Medicion conocerResultadoMedicion() {
        return resultadoMedicion;
    }


    @Override
    public String toString() {
        return "Revision{" +
                "idRevision=" + idRevision +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", vehiculo=" + vehiculo +
                ", oblea=" + oblea +
                ", empleado=" + empleado +
                ", defectosVisuales=" + defectosVisuales +
                ", resultadoMedicion=" + resultadoMedicion +
                ", estado=" + estado +
                '}';
    }

    public int getIdRevision() {
        return idRevision;
    }

}
