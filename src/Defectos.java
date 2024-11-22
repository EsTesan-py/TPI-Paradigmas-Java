public class Defectos {
    private final String defectosVisuales;
    private final String descripcion;

    public Defectos(String defectosVisuales, String descripcion) {
        this.defectosVisuales = defectosVisuales;
        this.descripcion = descripcion;
    }

    public void mostrar() {
        System.out.println("Defectos Visuales:");
        System.out.println("  Defectos: " + defectosVisuales);
        System.out.println("  Descripción: " + descripcion);
    }
}
