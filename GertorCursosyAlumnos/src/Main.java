import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      GestorCursos gestor = new GestorCursos();

     gestor.getAlumnos().add(new Alumno("Lucía", "111A", "Perez", "A01"));
     gestor.getAlumnos().add(new Alumno("Carlos", "222B", "Lopez", "A02"));
     gestor.getAlumnos().add(new Alumno("Ana", "333C", "Gomez", "A03"));

     gestor.getCursos().add(new Curso("Programación", "C01"));
     gestor.getCursos().add(new Curso("Base de Datos", "C02"));
     gestor.getCursos().add(new Curso("Diseño Web", "C03"));




        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir alumno");
            System.out.println("2. Añadir curso");
            System.out.println("3. Mostrar alumnos");
            System.out.println("4. Mostrar cursos");
            System.out.println("5. Buscar alumno (por código)");
            System.out.println("6. Inscribir alumno a curso");
            System.out.println("7. Mostrar alumnos de un curso");
            System.out.println("8. Mostrar cursos de un alumno");
            System.out.println("9. Eliminar alumno");
            System.out.println("10. Eliminar curso");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
              case 1:
                  gestor.registrarAlumno(sc);
                  break;
              case 2:
                  gestor.añadirCurso(sc);
                  break;
              case 3:
                  gestor.mostrarAlumnos();
                  break;
              case 4:
                  gestor.mostrarCursos();
                  break;
              case 5:
                  gestor.buscarAlumno(sc);
                  break;
              case 6:
                  gestor.inscribirAlumnoACurso(sc);
                  break;
              case 7:
                  gestor.mostrarAlumnosDeUnCurso(sc);
                  break;
              case 8:
                  gestor.mostrarCursosDeUnAlumno(sc);
                  break;
              case 9:
                  gestor.eliminarAlumno(sc);
                  break;
              case 10:
                  gestor.eliminarCurso(sc);
                  break;
              case 0:
                  System.out.println("Saliendo...");
                  break;
              default:
                  System.out.println("Opción no válida.");
          }
          

        } while (opcion != 0);





        
    }
}
