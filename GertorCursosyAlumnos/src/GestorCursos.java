import java.util.*;

public class GestorCursos {
    private List<Curso> cursos = new ArrayList<>();
    private Set<Alumno> alumnos = new HashSet<>();
    private Map<Curso, Set<Alumno>> inscripciones = new HashMap<>();

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void registrarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void inscribirAlumno(Curso curso, Alumno alumno) {
        if (cursos.contains(curso) && alumnos.contains(alumno)) {
            inscripciones.computeIfAbsent(curso, k -> new HashSet<>()).add(alumno);
        }
    }

    public void mostrarCursos() {
        cursos.forEach(System.out::println);
    }

    public void mostrarAlumnosPorCurso(Curso curso) {
        if (inscripciones.containsKey(curso)) {
            System.out.println("Alumnos en el curso " + curso + ":");
            inscripciones.get(curso).forEach(System.out::println);
        } else {
            System.out.println("No hay alumnos inscritos en " + curso);
        }
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) return c;
        }
        return null;
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnos.remove(alumno);
        for (Set<Alumno> lista : inscripciones.values()) {
            lista.remove(alumno);
        }
    }
}
