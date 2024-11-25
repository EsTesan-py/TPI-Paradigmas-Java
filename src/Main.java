import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Listas para almacenar clientes y revisiones
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Revision> revisiones = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);// Objeto Scanner para entrada de datos
        int opcion;// Variable para controlar el menú

        // Datos de ejemplo para iniciar con información predefinida
        Vehiculo vehiculoEjemplo = new Vehiculo(
                new TipoVehiculo(222, 2, "Auto"),
                "456",
                "123",
                "Azul",
                120,
                new Marca("Nissan", new Modelo("Tiida")),
                "ABC123"
        );
        Cliente clienteEjemplo = new Cliente(
                "Juan",
                "Perez",
                "12345678",
                "1155667788",
                "juan.perez@email.com",
                "1990-05-20",
                "Calle Falsa 123",
                new Turno(null,null),
                vehiculoEjemplo,
                new Pago(null,null,null,null,null,null) // Informacion de pago sin llenar
        );
        Empleado empleadoEjemplo = new Empleado(
                "Juanfer",
                "Quintero",
                "12345679",
                "1155667789",
                "juanfer.quintero@email.com",
                "1990-05-20",
                "Calle Falsa 1234",
                new Rol("Encargado de Cobro", "Registrar datos para inspección")
        );
        // Revisión de ejemplo
        Revision revision1 = new Revision(1, "25-11-2023", "27-12-2024", vehiculoEjemplo, empleadoEjemplo,new Defectos("Aboyadura","Hundimiento en parte frontal"),new Medicion("Porcentaje desperfecto",78), new Estado("Aprobado"));

        // Agregar datos iniciales a listas
        clientes.add(clienteEjemplo);
        revisiones.add(revision1);

        // Menú interactivo
        do {
            System.out.println("\n--- MENÚ INTERACTIVO ---");
            System.out.println("1. Registrar datos para inspección");
            System.out.println("2. Registrar cliente nuevo");
            System.out.println("3. Registrar vehículo nuevo");
            System.out.println("4. Consultar revisión mediante ID");
            System.out.println("5. Consultar clientes y vehículos");
            System.out.println("6. Asignar Oblea a una revisión");
            System.out.println("7. Cancelar y salir del menú");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); // Leer la opción seleccionada
            scanner.nextLine(); // Consumir el salto de línea
            // Lógica para ejecutar la acción correspondiente
            switch (opcion) {
                case 1 -> registrarDatosInspeccion(clientes, revisiones, empleadoEjemplo, scanner);
                case 2 -> registrarClienteNuevo(clientes, scanner);
                case 3 -> registrarVehiculoNuevo(clientes, scanner);
                case 4 -> consultarRevisionPorId(revisiones, scanner);
                case 5 -> consultarClientesYVehiculos(clientes);
                case 6 -> asignarOblea(revisiones, scanner);
                case 7 -> System.out.println("Saliendo del menú...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7); // Continuar el menú hasta que se elija la opción 7

        scanner.close(); // Cerrar el objeto Scanner
    }
    // Metodo para registrar datos de inspección
    private static void registrarDatosInspeccion(ArrayList<Cliente> clientes, ArrayList<Revision> revisiones, Empleado empleado, Scanner scanner) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();

        Cliente usuario = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre) && cliente.getApellido().equalsIgnoreCase(apellido)) {
                usuario = cliente;
                break;
            }
        }

        if (usuario == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Ingrese la matrícula del vehículo:");
        String matricula = scanner.nextLine();

        if (!usuario.conocerVehiculo().getMatricula().equalsIgnoreCase(matricula)) {
            System.out.println("Matrícula no coincide con el cliente.");
            return;
        }

        // Uso de biblioteca para obtener la fecha del dia de hoy
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaActualFormateada = fechaActual.format(formatter);
        String fechaVencimiento = fechaActual.plusDays(10).format(formatter);

        Revision revision = new Revision(
                revisiones.size() + 1, // ID de la revisión
                fechaActualFormateada,
                fechaVencimiento,
                usuario.conocerVehiculo(),
                empleado,
                new Defectos("Aboyadura","Hundimiento en parte frontal"),
                new Medicion("Porcentaje desperfecto",78),
                new Estado("Pendiente")
        );

        revisiones.add(revision);
        System.out.println("Revisión registrada exitosamente: " + revision);
    }
    // Metodo para regsitrar cliente nuevo
    private static void registrarClienteNuevo(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el DNI:");
        String dni = scanner.nextLine();
        System.out.println("Ingrese el número de teléfono:");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese el correo electrónico:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
        String fechaNacimiento = scanner.nextLine();
        System.out.println("Ingrese la dirección:");
        String direccion = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(nombre, apellido, dni, telefono, correo, fechaNacimiento, direccion, null,null,null);
        clientes.add(nuevoCliente);

        System.out.println("Cliente registrado exitosamente: " + nuevoCliente + "\n Nombre: "+nombre+"\n Apellido: "+apellido+"\n DNI: "+dni);
    }
    // Metodo para registrar vehiculo nuevo
    private static void registrarVehiculoNuevo(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.println("Ingrese el DNI del cliente:");
        String dni = scanner.nextLine();

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        String categoria = null;
        while (categoria == null) {
            System.out.println("Seleccione el tipo de vehículo:");
            System.out.println("1. Automóvil");
            System.out.println("2. Motocicleta");
            System.out.println("3. Camioneta");
            System.out.println("4. Camión");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> categoria = "Automóvil";
                case 2 -> categoria = "Motocicleta";
                case 3 -> categoria = "Camioneta";
                case 4 -> categoria = "Camión";
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        System.out.println("Ingrese el peso del vehículo (kg):");
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese el número de ejes:");
        int ejes = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese el color:");
        String color = scanner.nextLine();
        System.out.println("Ingrese el número de motor:");
        String numeroMotor = scanner.nextLine();
        System.out.println("Ingrese la matrícula:");
        String matricula = scanner.nextLine();
        System.out.println("Ingrese el kilometraje:");
        int kilometraje = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la marca:");
        String marca = scanner.nextLine();
        System.out.println("Ingrese el modelo:");
        String modelo = scanner.nextLine();

        TipoVehiculo tipoVehiculo = new TipoVehiculo(peso, ejes, categoria);
        Vehiculo nuevoVehiculo = new Vehiculo(
                tipoVehiculo,
                numeroMotor,
                numeroMotor,
                color,
                kilometraje,
                new Marca(marca, new Modelo(modelo)),
                matricula
        );

        cliente.setVehiculo(nuevoVehiculo);
        System.out.println("Vehículo registrado exitosamente: " + nuevoVehiculo);
    }
    //Metodo para consultar revisiones teniendo en cuenta el ID adjuntado
    private static void consultarRevisionPorId(ArrayList<Revision> revisiones, Scanner scanner) {
        System.out.println("Ingrese el ID de la revisión:");
        int id = scanner.nextInt();

        Revision revisionEncontrada = null;
        for (Revision revision : revisiones) {
            if (revision.getIdRevision() == id) {
                revisionEncontrada = revision;
                break;
            }
        }

        if (revisionEncontrada == null) {
            System.out.println("Revisión no encontrada.");
        } else {
            System.out.println("Revisión encontrada: " + revisionEncontrada);
        }
    }
    // Este metodo sirve para imprimir por pantalla los clientes con su respectivo vehiculo asignado
    private static void consultarClientesYVehiculos(ArrayList<Cliente> clientes) {
        System.out.println("\n--- Lista de Clientes y Vehículos ---");
        for (Cliente cliente : clientes) {
            String matricula = (cliente.conocerVehiculo() != null) ? cliente.conocerVehiculo().getMatricula() : "Sin vehículo registrado";
            System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + " - Matrícula: " + matricula);
        }
    }
    // Este metodo es usado para asignar obleas a revisiones realizadas
    private static void asignarOblea(ArrayList<Revision> revisiones, Scanner scanner) {
        System.out.println("Ingrese el ID de la revisión a la que desea asignar una oblea:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Buscar la revisión en la lista
        Revision revisionEncontrada = null;
        for (Revision revision : revisiones) {
            if (revision.getIdRevision() == id) {
                revisionEncontrada = revision;
                break;
            }
        }

        // Verificar si la revisión fue encontrada
        if (revisionEncontrada == null) {
            System.out.println("Revisión no encontrada.");
            return;
        }

        // Verificar si ya tiene una oblea asignada
        if (revisionEncontrada.conocerOblea() != null) {
            System.out.println("Esta revisión ya tiene una oblea asignada.");
            revisionEncontrada.conocerOblea().mostrar(); // Mostrar la oblea existente
            return;
        }

        // Solicitar los datos necesarios para crear la nueva oblea
        System.out.println("Ingrese el número de oblea:");
        int nroDeOblea = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Validar que el número de oblea sea positivo
        if (nroDeOblea <= 0) {
            System.out.println("Error: El número de oblea debe ser un valor positivo. Intente nuevamente.");
            return;
        }

        System.out.println("Ingrese la fecha de vencimiento de la oblea (YYYY-MM-DD):");
        String fechaDeVencimiento = scanner.nextLine();

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaDeAlta = fechaActual.format(formatter);

        String tipoEstado = null;
        while (tipoEstado == null) {
            System.out.println("Seleccione el estado de la oblea:");
            System.out.println("1. Aprobado");
            System.out.println("2. Rechazado");
            System.out.println("3. En espera");
            System.out.print("Opción: ");
            int opcionEstado = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcionEstado) {
                case 1 -> tipoEstado = "Aprobado";
                case 2 -> tipoEstado = "Rechazado";
                case 3 -> tipoEstado = "En espera";
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        Estado estado = new Estado(tipoEstado); // Crear el estado seleccionado
        System.out.println("Ingrese el stock asociado a esta oblea:");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Crear la nueva oblea
        Oblea nuevaOblea = new Oblea(nroDeOblea, fechaDeVencimiento, revisionEncontrada.conocerVehiculo(), estado, stock, fechaDeAlta);

        // Asignar la oblea a la revisión
        revisionEncontrada.asignarOblea(nuevaOblea);

        System.out.println("Oblea asignada exitosamente:");
        nuevaOblea.mostrar();
    }

}
