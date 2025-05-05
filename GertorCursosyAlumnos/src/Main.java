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
            System.out.println("3. Agregar alumno a curso");
            System.out.println("4. Mostrar alumnos ordenados");
            System.out.println("5. Mostrar alumnos de un curso");
            System.out.println("6. Mostrar cursos de un alumno");
            System.out.println("7. Eliminar alumno");
            System.out.println("8. Eliminar curso");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    gestor.registrarAlumno(new Alumno(nombre, apellido, dni, id));
                }
                case 2 -> {
                    System.out.print("Nombre del curso: ");
                    String nombre = sc.nextLine();
                    System.out.print("Código del curso: ");
                    String codigo = sc.nextLine();
                    gestor.agregarCurso(new Curso(nombre, codigo));
                }
                case 3 -> {
                    System.out.print("Código del curso: ");
                    String codCurso = sc.nextLine();
                    Curso curso = gestor.buscarCursoPorCodigo(codCurso);
                    if (curso == null) {
                        System.out.println("Curso no encontrado.");
                        break;
                    }

                    System.out.print("DNI del alumno: ");
                    String dniAlumno = sc.nextLine();
                    Alumno alumno = gestor.buscarAlumnoPorDni(dniAlumno);
                    if (alumno == null) {
                        System.out.println("Alumno no encontrado.");
                        break;
                    }

                    gestor.inscribirAlumno(curso, alumno);
                    System.out.println("Alumno inscrito correctamente.");
                }
                case 4 -> {
                    List<Alumno> lista = new ArrayList<>(gestor.getAlumnos());
                    System.out.println("Ordenar por: 1-ID, 2-Nombre, 3-Apellido");
                    int criterio = Integer.parseInt(sc.nextLine());
                    switch (criterio) {
                        case 1 -> lista.sort(Comparator.comparing(Alumno::getCodigo));
                        case 2 -> lista.sort(Comparator.comparing(Alumno::getNombre));
                        case 3 -> lista.sort(Comparator.comparing(Alumno::getApellido));
                        default -> System.out.println("Criterio inválido.");
                    }
                    lista.forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Código del curso: ");
                    String codigo = sc.nextLine();
                    Curso curso = gestor.buscarCursoPorCodigo(codigo);
                    if (curso != null) {
                        gestor.mostrarAlumnosPorCurso(curso);
                    } else {
                        System.out.println("Curso no encontrado.");
                    }
                }
                case 6 -> {
                    System.out.print("DNI del alumno: ");
                    String dni = sc.nextLine();
                    gestor.mostrarCursosDeAlumno(dni);
                }
                case 7 -> {
                    System.out.print("DNI del alumno a eliminar: ");
                    String dni = sc.nextLine();
                    Alumno alumno = gestor.buscarAlumnoPorDni(dni);
                    if (alumno != null) {
                        gestor.eliminarAlumno(alumno);
                        System.out.println("Alumno eliminado.");
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                }
                case 8 -> {
                    System.out.print("Código del curso a eliminar: ");
                    String codigo = sc.nextLine();
                    gestor.eliminarCurso(codigo);
                    System.out.println("Curso eliminado.");
                }
                case 0 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }


    }
