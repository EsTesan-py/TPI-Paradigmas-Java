public class Estado {
    private String tipo; // Aprobado, En espera, Rechazado

    public Estado(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
