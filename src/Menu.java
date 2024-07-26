import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Menu {
    private Scanner scanner;
    private Curso curso;
    private SimpleDateFormat dateFormat;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.curso = null;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("1. Crear curso");
            System.out.println("2. Agregar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Mostrar curso");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = 0;
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida, por favor intente de nuevo.");
                scanner.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    crearCurso();
                    break;
                case 2:
                    agregarEstudiante();
                    break;
                case 3:
                    eliminarEstudiante();
                    break;
                case 4:
                    mostrarCurso();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private void crearCurso() {
        System.out.print("Nombre del curso: ");
        String nombreCurso = scanner.next();
        System.out.print("Créditos del curso: ");
        int creditos = scanner.nextInt();
        System.out.print("Nombre del catedrático: ");
        String nombreCatedratico = scanner.next();
        System.out.print("Apellido del catedrático: ");
        String apellidoCatedratico = scanner.next();
        System.out.print("Fecha de nacimiento del catedrático (dd/MM/yyyy): ");
        String fechaNacimientoCatedratico = scanner.next();
        System.out.print("Número de empleado del catedrático: ");
        String numeroEmpleado = scanner.next();
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = dateFormat.parse(fechaNacimientoCatedratico);
        } catch (ParseException e) {
            System.out.println("Fecha de nacimiento inválida.");
            return;
        }
        Catedratico catedratico = new Catedratico(nombreCatedratico, apellidoCatedratico, fechaNacimiento, numeroEmpleado);
        curso = new Curso(nombreCurso, creditos, catedratico);
    }

    private void agregarEstudiante() {
        if (curso == null) {
            System.out.println("Primero debe crear un curso.");
            return;
        }
        System.out.print("Nombre del estudiante: ");
        String nombreEstudiante = scanner.next();
        System.out.print("Apellido del estudiante: ");
        String apellidoEstudiante = scanner.next();
        System.out.print("Fecha de nacimiento del estudiante (dd/MM/yyyy): ");
        String fechaNacimientoEstudiante = scanner.next();
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = dateFormat.parse(fechaNacimientoEstudiante);
        } catch (ParseException e) {
            System.out.println("Fecha de nacimiento inválida.");
            return;
        }
        Persona estudiante = new Persona(nombreEstudiante, apellidoEstudiante, fechaNacimiento);
        curso.agregarEstudiante(estudiante);
    }

    private void eliminarEstudiante() {
        if (curso == null) {
            System.out.println("Primero debe crear un curso.");
            return;
        }
        System.out.print("Nombre del estudiante: ");
        String nombreEstudiante = scanner.next();
        System.out.print("Apellido del estudiante: ");
        String apellidoEstudiante = scanner.next();
        Persona estudianteAEliminar = null;
        for (Persona est : curso.getEstudiantes()) {
            if (est.getNombre().equals(nombreEstudiante) && est.getApellido().equals(apellidoEstudiante)) {
                estudianteAEliminar = est;
                break;
            }
        }
        if (estudianteAEliminar != null) {
            curso.eliminarEstudiante(estudianteAEliminar);
            System.out.println("Estudiante eliminado.");
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private void mostrarCurso() {
        if (curso == null) {
            System.out.println("Primero debe crear un curso.");
            return;
        }
        System.out.println(curso);
    }

    public static boolean isUsbConnected(String usbPath, String usbName) {
        File usb = new File(usbPath);
        if (usb.exists() && usb.isDirectory()) {
            try {
                Path path = Paths.get(usbPath);
                FileStore fileStore = Files.getFileStore(path);
                return fileStore.name().equalsIgnoreCase(usbName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
