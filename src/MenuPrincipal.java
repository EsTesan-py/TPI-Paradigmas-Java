import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MenuPrincipal extends JFrame {

    // Simulamos una base de datos de clientes
    private final Map<String, String> clientesRegistrados = new HashMap<>();

    public MenuPrincipal() {
        // Inicializamos clientes registrados para la simulación
        clientesRegistrados.put("12345678", "Juan Pérez");
        clientesRegistrados.put("87654321", "María Gómez");

        // Configuración básica de la ventana
        setTitle("Menú de Inspección");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10)); // 7 botones

        // Botones del menú
        JButton btnRegistrarInspeccion = new JButton("Registrar datos para inspección");
        JButton btnRegistrarCliente = new JButton("Registrar cliente nuevo");
        JButton btnRegistrarVehiculo = new JButton("Registrar vehículo nuevo");
        JButton btnConsultarRevision = new JButton("Consultar revisión mediante ID");
        JButton btnConsultarClientesVehiculos = new JButton("Consultar clientes y vehículos");
        JButton btnAsignarOblea = new JButton("Asignar oblea a una revisión");
        JButton btnSalir = new JButton("Cancelar y salir del menú");

        // Agregar botones al panel
        panel.add(btnRegistrarInspeccion);
        panel.add(btnRegistrarCliente);
        panel.add(btnRegistrarVehiculo);
        panel.add(btnConsultarRevision);
        panel.add(btnConsultarClientesVehiculos);
        panel.add(btnAsignarOblea);
        panel.add(btnSalir);

        // Acciones de los botones
        btnRegistrarInspeccion.addActionListener(e -> registrarInspeccion());
        btnRegistrarCliente.addActionListener(e -> registrarCliente());
        btnRegistrarVehiculo.addActionListener(e -> registrarVehiculo());
        btnSalir.addActionListener(e -> System.exit(0));

        // Añadir panel al marco
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    // Función para registrar datos para inspección
    private void registrarInspeccion() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre:");
        if (nombre == null || nombre.isBlank()) {
            JOptionPane.showMessageDialog(this, "Nombre no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String apellido = JOptionPane.showInputDialog(this, "Ingrese el apellido:");
        if (apellido == null || apellido.isBlank()) {
            JOptionPane.showMessageDialog(this, "Apellido no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Datos registrados:\nNombre: " + nombre + "\nApellido: " + apellido);
    }

    // Función para registrar un cliente nuevo
    private void registrarCliente() {
        JFrame frame = new JFrame("Registrar Cliente Nuevo");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 2, 10, 10));

        // Campos de entrada
        JTextField txtNombre = new JTextField();
        JTextField txtApellido = new JTextField();
        JTextField txtDni = new JTextField();
        JTextField txtTelefono = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtFechaNacimiento = new JTextField();
        JTextField txtDireccion = new JTextField();

        // Etiquetas
        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);
        frame.add(new JLabel("Apellido:"));
        frame.add(txtApellido);
        frame.add(new JLabel("DNI:"));
        frame.add(txtDni);
        frame.add(new JLabel("Teléfono:"));
        frame.add(txtTelefono);
        frame.add(new JLabel("Correo Electrónico:"));
        frame.add(txtEmail);
        frame.add(new JLabel("Fecha de Nacimiento (YYYY-MM-DD):"));
        frame.add(txtFechaNacimiento);
        frame.add(new JLabel("Dirección:"));
        frame.add(txtDireccion);

        // Botones
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnConfirmar = new JButton("Confirmar");
        frame.add(btnCancelar);
        frame.add(btnConfirmar);

        // Acción del botón Confirmar
        btnConfirmar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                String dni = txtDni.getText().trim();
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                clientesRegistrados.put(dni, nombre + " " + apellido); // Agregar cliente
                JOptionPane.showMessageDialog(frame, "Cliente registrado con éxito:\nNombre: " + nombre + "\nApellido: " + apellido + "\nDNI: " + dni);
                frame.dispose(); // Cerrar ventana
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error al registrar cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción del botón Cancelar
        btnCancelar.addActionListener(e -> frame.dispose());

        // Hacer visible el formulario
        frame.setVisible(true);
    }

    private void registrarVehiculo() {
        String dni = JOptionPane.showInputDialog(this, "Ingrese el DNI del cliente:");
        if (!clientesRegistrados.containsKey(dni)) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFrame frame = new JFrame("Registrar Vehículo Nuevo");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiquetas y campos de entrada
        JLabel lblTipoVehiculo = new JLabel("Tipo de vehículo:");
        String[] tipos = {"Automóvil", "Motocicleta", "Camioneta", "Camión"};
        JComboBox<String> cmbTipos = new JComboBox<>(tipos);

        JLabel lblPeso = new JLabel("Peso (kg):");
        JTextField txtPeso = new JTextField();

        JLabel lblEjes = new JLabel("Número de ejes:");
        JTextField txtEjes = new JTextField();

        JLabel lblColor = new JLabel("Color:");
        JTextField txtColor = new JTextField();

        JLabel lblMotor = new JLabel("Número de motor:");
        JTextField txtMotor = new JTextField();

        JLabel lblMatricula = new JLabel("Matrícula:");
        JTextField txtMatricula = new JTextField();

        JLabel lblKilometraje = new JLabel("Kilometraje:");
        JTextField txtKilometraje = new JTextField();

        JLabel lblMarca = new JLabel("Marca:");
        JTextField txtMarca = new JTextField();

        JLabel lblModelo = new JLabel("Modelo:");
        JTextField txtModelo = new JTextField();

        // Botones
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnConfirmar = new JButton("Confirmar");

        // Añadir componentes al diseño
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(lblTipoVehiculo, gbc);
        gbc.gridx = 1;
        frame.add(cmbTipos, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(lblPeso, gbc);
        gbc.gridx = 1;
        frame.add(txtPeso, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(lblEjes, gbc);
        gbc.gridx = 1;
        frame.add(txtEjes, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(lblColor, gbc);
        gbc.gridx = 1;
        frame.add(txtColor, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        frame.add(lblMotor, gbc);
        gbc.gridx = 1;
        frame.add(txtMotor, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        frame.add(lblMatricula, gbc);
        gbc.gridx = 1;
        frame.add(txtMatricula, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        frame.add(lblKilometraje, gbc);
        gbc.gridx = 1;
        frame.add(txtKilometraje, gbc);

        gbc.gridx = 0; gbc.gridy = 7;
        frame.add(lblMarca, gbc);
        gbc.gridx = 1;
        frame.add(txtMarca, gbc);

        gbc.gridx = 0; gbc.gridy = 8;
        frame.add(lblModelo, gbc);
        gbc.gridx = 1;
        frame.add(txtModelo, gbc);

        // Botones en la parte inferior
        gbc.gridx = 0; gbc.gridy = 9;
        frame.add(btnCancelar, gbc);
        gbc.gridx = 1;
        frame.add(btnConfirmar, gbc);

        // Acción de los botones
        btnCancelar.addActionListener(e -> frame.dispose());
        btnConfirmar.addActionListener(e -> {
            try {
                String tipoVehiculo = (String) cmbTipos.getSelectedItem();
                double peso = Double.parseDouble(txtPeso.getText().trim());
                int ejes = Integer.parseInt(txtEjes.getText().trim());
                String color = txtColor.getText().trim();
                String motor = txtMotor.getText().trim();
                String matricula = txtMatricula.getText().trim();
                int kilometraje = Integer.parseInt(txtKilometraje.getText().trim());
                String marca = txtMarca.getText().trim();
                String modelo = txtModelo.getText().trim();

                JOptionPane.showMessageDialog(frame,
                        "Vehículo registrado exitosamente:\n" +
                                "Tipo: " + tipoVehiculo + "\n" +
                                "Peso: " + peso + " kg\n" +
                                "Ejes: " + ejes + "\n" +
                                "Color: " + color + "\n" +
                                "Motor: " + motor + "\n" +
                                "Matrícula: " + matricula + "\n" +
                                "Kilometraje: " + kilometraje + "\n" +
                                "Marca: " + marca + "\n" +
                                "Modelo: " + modelo
                );
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
