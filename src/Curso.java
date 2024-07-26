import java.util.ArrayList;

public class Curso {
    private String nombre;
    private int creditos;
    private Catedratico catedratico;
    private ArrayList<Persona> estudiantes;

    public Curso(String nombre, int creditos, Catedratico catedratico) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.catedratico = catedratico;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Catedratico getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(Catedratico catedratico) {
        this.catedratico = catedratico;
    }

    public ArrayList<Persona> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Persona estudiante) {
        estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(Persona estudiante) {
        estudiantes.remove(estudiante);
    }

    @Override
    public String toString() {
        return "Curso: " + nombre + " | Créditos: " + creditos + " | Catedrático: " + catedratico + " | Estudiantes: " + estudiantes.size();
    }
}
