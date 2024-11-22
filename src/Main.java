public class Main {
    public static void main(String[] args) {
        // Aca creo los objetos para probar
        Estado estadoAprobado = new Estado("Aprobado");
        Estado estadoPendiente = new Estado("En espera");
        // Aca instancio los objetos del tipo de vehiculo
        TipoVehiculo tipoAuto = new TipoVehiculo(1200, 4, "Automóvil");
        TipoVehiculo tipoMoto = new TipoVehiculo(300, 2, "Motocicleta");
        // Aca instancio los objetos vehiculo con sus datos
        Vehiculo vehiculo1 = new Vehiculo(tipoAuto, "12345", "67890", "Rojo", 50000, new Marca("Toyota", new Modelo("Corolla")));
        Vehiculo vehiculo2 = new Vehiculo(tipoMoto, "54321", "09876", "Negro", 10000, new Marca("Honda", new Modelo("CBR500R")));
        // Instanciamos la Oblea
        Oblea oblea1 = new Oblea(1, "2025-01-01", vehiculo1, estadoAprobado, 10, "2024-01-01");
        //Instanciamos los defectos visuales que puede llegar a tener
        Defectos defectos1 = new Defectos("Faros delanteros dañados", "Los faros están rotos.");
        Defectos defectos2 = new Defectos("Frenos desgastados", "Los frenos tienen desgaste avanzado.");
        // Instanciamos las mediciones
        Medicion medicion1 = new Medicion("Emisiones de gases", 0.08);
        Medicion medicion2 = new Medicion("Frenado", 2.5);
        //Creamos la revision entera con sus datos
        Revision revision1 = new Revision(1, "2024-11-22", "2025-11-22", vehiculo1, oblea1, null, defectos1, medicion1, estadoAprobado);
        Revision revision2 = new Revision(2, "2024-11-22", "2025-11-22", vehiculo2, null, null, defectos2, medicion2, estadoPendiente);

        // Asignar oblea
        revision2.asignarOblea(oblea1);

        // Mostrar datos de una revisión, la numero uno
        System.out.println("=== Revisión 1 ===");
        revision1.mostrar();
        // Mostrar datos de la segunda revision
        System.out.println("\n=== Revisión 2 ===");
        revision2.mostrar();
    }
}
