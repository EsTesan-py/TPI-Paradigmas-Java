import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Revision> revisiones = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Ejemplo inicial de datos
        Vehiculo vehiculoEjemplo = new Vehiculo(
                new TipoVehiculo(222, 2, "Auto"),
                "Azul",
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
                vehiculoEjemplo
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
        Revision revision1 = new Revision(1, "25-11-2023", "27-12-2024", vehiculoEjemplo, empleadoEjemplo, new Estado("Aprobado"));

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
            System.out.println("6. Cancelar y salir del menú");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> registrarDatosInspeccion(clientes, revisiones, empleadoEjemplo, scanner);
                case 2 -> registrarClienteNuevo(clientes, scanner);
                case 3 -> registrarVehiculoNuevo(clientes, scanner);
                case 4 -> consultarRevisionPorId(revisiones, scanner);
                case 5 -> consultarClientesYVehiculos(clientes);
                case 6 -> System.out.println("Saliendo del menú...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }

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
                new Estado("Pendiente")
        );

        revisiones.add(revision);
        System.out.println("Revisión registrada exitosamente: " + revision);
    }

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

        Cliente nuevoCliente = new Cliente(nombre, apellido, dni, telefono, correo, fechaNacimiento, direccion, null);
        clientes.add(nuevoCliente);

        System.out.println("Cliente registrado exitosamente: " + nuevoCliente);
    }

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

        System.out.println("Ingrese el tipo de vehículo:");
        String tipo = scanner.nextLine();
        System.out.println("Ingrese el color:");
        String color = scanner.nextLine();
        System.out.println("Ingrese el número de motor:");
        String numeroMotor = scanner.nextLine();
        System.out.println("Ingrese la matrícula:");
        String matricula = scanner.nextLine();
        System.out.println("Ingrese la marca:");
        String marca = scanner.nextLine();
        System.out.println("Ingrese el modelo:");
        String modelo = scanner.nextLine();

        Vehiculo nuevoVehiculo = new Vehiculo(
                new TipoVehiculo(0, 0, tipo),
                color,
                numeroMotor,
                color,
                0,
                new Marca(marca, new Modelo(modelo)),
                matricula
        );

        cliente.setVehiculo(nuevoVehiculo);
        System.out.println("Vehículo registrado exitosamente: " + nuevoVehiculo);
    }

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

    private static void consultarClientesYVehiculos(ArrayList<Cliente> clientes) {
        System.out.println("\n--- Lista de Clientes y Vehículos ---");
        for (Cliente cliente : clientes) {
            String matricula = (cliente.conocerVehiculo() != null) ? cliente.conocerVehiculo().getMatricula() : "Sin vehículo registrado";
            System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + " - Matrícula: " + matricula);
        }
    }
}
