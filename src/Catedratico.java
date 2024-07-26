import java.util.Date;

public class Catedratico extends Persona {
    private String numeroEmpleado;

    public Catedratico(String nombre, String apellido, Date fechaNacimiento, String numeroEmpleado) {
        super(nombre, apellido, fechaNacimiento);
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    @Override
    public String toString() {
        return super.toString() + " | Empleado No: " + numeroEmpleado;
    }
}
