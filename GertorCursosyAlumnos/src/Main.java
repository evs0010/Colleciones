import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        GestorCursos gestor = new GestorCursos();

        Curso curso1 = new Curso("Programación", "PRG101");
        Curso curso2 = new Curso("Bases de Datos", "BD102");

        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        Alumno alumno1 = new Alumno("María Pérez","apellido2" ,"12345678A","1");
        Alumno alumno2 = new Alumno("Juan López","apellido", "87654321B","2");

        gestor.registrarAlumno(alumno1);
        gestor.registrarAlumno(alumno2);

        gestor.inscribirAlumno(curso1, alumno1);
        gestor.inscribirAlumno(curso1, alumno2);
        gestor.inscribirAlumno(curso2, alumno1);

        gestor.mostrarCursos();
        gestor.mostrarAlumnosPorCurso(curso1);
        gestor.mostrarAlumnosPorCurso(curso2);


         Set<Alumno> alumnos = new TreeSet<>();

         
         
         
         


  Scanner sc = new Scanner(System.in);

  int opcion;
  do {
      System.out.println("\n--- Menú de Gestión ---");
      System.out.println("1. Agregar alumno");
      System.out.println("2. Agregar curso");
      System.out.println("3. Mostrar alumnos");
      System.out.println("4. Mostrar cursos");//añadir buscar alumno 
      System.out.println("5. Agregar alumno a curso");
      System.out.println("6. Mostrar alumnos ordenados");
      System.out.println("7. Mostrar alumnos de un curso");
      System.out.println("8. Mostrar cursos de un alumno");
      System.out.println("9. Eliminar alumno");
      System.out.println("10. Eliminar curso");
      System.out.println("0. Salir");
      System.out.print("Opción: ");
      opcion = Integer.parseInt(sc.nextLine());
  
      switch (opcion) {
          case 1 -> {  }
          case 2 -> {  }
          case 3 -> { }
          case 4 -> {  }
          case 5 -> {  }
          case 6 -> {  }
          case 7 -> {  }
          case 8 -> { }
          case 9 -> { }
          case 10 -> {  }
          case 0 -> System.out.println("Hasta luego.");
          default -> System.out.println("Opción inválida.");
      }
  
  } while (opcion != 0);
}
}
  


    
