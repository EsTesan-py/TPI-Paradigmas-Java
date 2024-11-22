public class Defectos {
    private String defectosVisuales;
    private String descripcion;

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
