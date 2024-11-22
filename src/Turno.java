public class Turno {
    private String fechaTurno;
    private String horaTurno;

    public Turno(String fechaTurno, String horaTurno) {
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
    }

    public String getFechaTurno() {
        return fechaTurno;
    }

    public void mostrar() {
        System.out.println("Turno:");
        System.out.println("  Fecha: " + fechaTurno);
        System.out.println("  Hora: " + horaTurno);
    }
}
