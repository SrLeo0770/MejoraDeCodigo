import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Alumno extends Persona {
    private String carrera;
    private List<Curso> cursos;

    public Alumno(String nombre, String apellido, Date fechaNacimiento, String carrera) {
        super(nombre, apellido, fechaNacimiento);
        this.carrera = carrera;
        this.cursos = new ArrayList<>();
    }

    public String getCarrera() {
        return carrera;
    }

    public void inscribirCurso(Curso curso) {
        cursos.add(curso);
        System.out.println("Inscrito en el curso: " + curso.getNombre());
    }

    @Override
    public String toString() {
        String detalles = super.toString() + " | Carrera: " + carrera + "\nCursos Inscritos:";
        for (Curso curso : cursos) {
            detalles += "\n - " + curso.getNombre();
        }
        return detalles;
    }
}
