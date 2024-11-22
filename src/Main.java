import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        Vehiculo vehiculoEjemplo = new Vehiculo(new TipoVehiculo(222,2, "Auto"), "Azul", "123", "Azul", 120, new Marca("Nissan", new Modelo("Tiida")), "ABC123");


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


        Empleado empleado = new Empleado(
                "Juanfer",
                "Quintero",
                "12345679",
                "1155667789",
                "juanfer.quintero@email.com",
                "1990-05-20",
                "Calle Falsa 1234",
                new Rol("Encargado de Cobro", "Registrar datos para inspeccion")
        );


        clientes.add(clienteEjemplo);


        // Caso de uso registrar inspección técnica


        // Usuario ingrese nombre y apellido
        System.out.println("(Para el ejemplo del caso de uso ingrese Juan el nombre y Perez en el apellido)");
        System.out.println("Ingrese el nombre del usuario");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del usuario");


        String apellido = scanner.nextLine();


        Cliente usuario = null;


        // Buscamos el cliente que tenga ese nombre y apellido
        for (Cliente cliente : clientes){
            if(cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellido)){
                usuario = cliente;
            }
        }


        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }


        // El cliente ingrese la matricula de su vehiculo
        System.out.println("(Para el ejemplo del caso de uso ingrese ABC123 en la matricula)");
        System.out.println("Ingrese el numero de matricula");
        String matricula = scanner.nextLine();


        Vehiculo vehiculoUsuario = null;


        // Verificamos que la matricula ingresada sea la de ese cliente
        if(usuario.conocerVehiculo().getMatricula().equals(matricula)){
            vehiculoUsuario = usuario.conocerVehiculo();
        }
        if(vehiculoUsuario == null){
            System.out.println("Vehiculo no coincide");
            return;
        }


        // Si la matricula ingresada es la del vehiculo del usuario preguntamos si almacemamos los datos de inspeccion
        System.out.println("Presione 1 para Almacenar datos inspección");
        int opcion = scanner.nextInt();


        if (opcion != 1){
            return;
        }


        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaActualFormateada = fechaActual.format(formatter);
        String fechaVencimiento = fechaActual.plusDays(10).format(formatter);


        Revision revision = new Revision(0,fechaActualFormateada, fechaVencimiento, vehiculoUsuario,  empleado, new Estado("Pendiente"));


        // Mostramos la revision creada
        System.out.println("Revision iniciada: " + revision);
    }
}


