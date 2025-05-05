public class Main {
    public static void main(String[] args) {
        GestorCursos gestor = new GestorCursos();

        Curso curso1 = new Curso("Programación", "PRG101");
        Curso curso2 = new Curso("Bases de Datos", "BD102");

        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        Alumno alumno1 = new Alumno("María Pérez", "12345678A");
        Alumno alumno2 = new Alumno("Juan López", "87654321B");

        gestor.registrarAlumno(alumno1);
        gestor.registrarAlumno(alumno2);

        gestor.inscribirAlumno(curso1, alumno1);
        gestor.inscribirAlumno(curso1, alumno2);
        gestor.inscribirAlumno(curso2, alumno1);

        gestor.mostrarCursos();
        gestor.mostrarAlumnosPorCurso(curso1);
        gestor.mostrarAlumnosPorCurso(curso2);
    }
}
