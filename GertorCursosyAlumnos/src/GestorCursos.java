import java.util.*;
import java.util.stream.Collectors;

public class GestorCursos {
    private List<Curso> cursos = new ArrayList<>();
    private Set<Alumno> alumnos = new HashSet<>();
    private Map<Curso, Set<Alumno>> inscripciones = new HashMap<>();

   
  // ----------- MÉTODOS PRINCIPALES -----------


//---1---------AÑADIR CURSOS------------
    public void añadirCurso(Scanner sc) {
        System.out.print("Nombre del curso: ");
        String nombre = sc.nextLine();
        System.out.print("Código del curso: ");
        String codigo = sc.nextLine();
        cursos.add(new Curso(nombre, codigo));
    }



//------- 2------AÑADIR ALUMNOS-----------------
    public void registrarAlumno(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Código interno: ");
        String codigo = sc.nextLine();
        alumnos.add(new Alumno(nombre, dni, apellido, codigo));
    }



    //------- 3--------------MOSTRAR TODOS LOS ALUMNOS ordenados alfabéticamente-----------------------
    public void mostrarAlumnos(Scanner sc) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
    
        System.out.println("¿Cómo deseas ordenar los alumnos?");
        System.out.println("1. Por nombre y apellido");
        System.out.println("2. Por DNI");
        System.out.println("3. Por código");
    
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        Comparator<Alumno> comparador;
    
        switch (opcion) {
            case 1:
                comparador = new Comparator<Alumno>() {
                    public int compare(Alumno a1, Alumno a2) {
                        int resultado = a1.getNombre().compareToIgnoreCase(a2.getNombre());
                        if (resultado == 0) {
                            resultado = a1.getApellido().compareToIgnoreCase(a2.getApellido());
                        }
                        return resultado;
                    }
                };
                break;
            case 2:
                comparador = new Comparator<Alumno>() {
                    public int compare(Alumno a1, Alumno a2) {
                        return a1.getDni().compareToIgnoreCase(a2.getDni());
                    }
                };
                break;
            case 3:
                comparador = new Comparator<Alumno>() {
                    public int compare(Alumno a1, Alumno a2) {
                        return a1.getCodigo().compareToIgnoreCase(a2.getCodigo());
                    }
                };
                break;

            default:
                System.out.println("Opción no válida. Se ordenará por nombre y apellido.");
                comparador = new Comparator<Alumno>() {
                    public int compare(Alumno a1, Alumno a2) {
                        int resultado = a1.getNombre().compareToIgnoreCase(a2.getNombre());
                        if (resultado == 0) {
                            resultado = a1.getApellido().compareToIgnoreCase(a2.getApellido());
                        }
                        return resultado;
                    }
                };
                break;
        }
    
        mostrarColeccionOrdenada(alumnos, comparador, "Lista de alumnos ordenados:");
    }
    public void mostrarColeccionOrdenada(Collection<Alumno> coleccion, Comparator<Alumno> comparador, String titulo) {
        List<Alumno> lista = new ArrayList<>(coleccion);
        Collections.sort(lista, comparador);
    
        System.out.println(titulo);
        for (Alumno a : lista) {
            System.out.println(a);
        }
    }
    
    
    

    //- 4---------------------MOSTRAR TODOS LOS CURSOS ORDENADOS----------------------
 public void mostrarCursos(Scanner sc) {
    if (cursos.isEmpty()) {
        System.out.println("No hay cursos registrados.");
        return;
    }

    System.out.println("¿Cómo deseas ordenar los cursos?");
    System.out.println("1. Por código");
    System.out.println("2. Por nombre");
    System.out.print("Elige una opción (1-2): ");

    int opcion = sc.nextInt();
    sc.nextLine(); // limpiar el buffer

    Comparator<Curso> comparador;

    switch (opcion) {
        case 1:
            comparador = new Comparator<Curso>() {
                @Override
                public int compare(Curso c1, Curso c2) {
                    return c1.getCodigo().compareToIgnoreCase(c2.getCodigo());
                }
            };
            break;
        case 2:
            comparador = new Comparator<Curso>() {
                @Override
                public int compare(Curso c1, Curso c2) {
                    return c1.getNombre().compareToIgnoreCase(c2.getNombre());
                }
            };
            break;
        default:
            System.out.println("Opción no válida. Se ordenará por código.");
            comparador = new Comparator<Curso>() {
                @Override
                public int compare(Curso c1, Curso c2) {
                    return c1.getCodigo().compareToIgnoreCase(c2.getCodigo());
                }
            };
            break;
    }

    // Ordenar la lista con el comparador seleccionado
    Collections.sort(cursos, comparador);

    System.out.println("Lista de cursos ordenados:");
    for (Curso c : cursos) {
        System.out.println(c);
    }
}

    
    

    // -- 5----BUSCAR ALUMNO POR CODIGO------

    public void buscarAlumno(Scanner sc) {
        System.out.print("Introduce el código del alumno: ");
        String codigo = sc.nextLine();
        Alumno encontrado = null;
        for (Alumno a : alumnos) {

            if (a.getCodigo().equals(codigo)) {  //.equalsIgnoreCase()
                encontrado = a;
                break;
            }
        }
    
        if (encontrado != null) {
            System.out.println("Alumno encontrado: " + encontrado);
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }


//----6-- INSCRIBIR UN ALUMNO A UN CURSO----------------
    public void inscribirAlumnoACurso(Scanner sc) {
        
        System.out.print("Nombre del alumno: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Apellido del alumno: ");
        String apellido = sc.nextLine().trim();
       
        
        Alumno alumnoEncontrado = null;
        for (Alumno a : alumnos) {
            if (a.getNombre().equalsIgnoreCase(nombre) && a.getApellido().equalsIgnoreCase(apellido)) {
                alumnoEncontrado = a;
                break;
            }
        }
        if (alumnoEncontrado == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }
    
        System.out.print("Nombre del curso: ");
        String nombreCurso = sc.nextLine().trim();
        
        Curso cursoEncontrado = null;
        for (Curso c : cursos) {
            if (c.getNombre().equalsIgnoreCase(nombreCurso)) {
                cursoEncontrado = c;
                break;
            }
        }
    
        if (cursoEncontrado == null) {
            System.out.println("Curso no encontrado.");
            return;
        }
    
        if (!inscripciones.containsKey(cursoEncontrado)) {           //Si inscripciones NO contiene ya el curso como clave...
            inscripciones.put(cursoEncontrado, new HashSet<>());   //...entonces crea una nueva entrada para ese curso, con un conjunto vacío de alumnos.
        }
    
        inscripciones.get(cursoEncontrado).add(alumnoEncontrado);
        System.out.println("Alumno inscrito correctamente.");
    }

    //------7-------MOSTRAR LOS ALUMNOS QUE TIENE UN CURSO-------------------------------

    public void mostrarAlumnosDeUnCurso(Scanner sc) {
        System.out.print("Nombre del curso: ");
        String nombreCurso = sc.nextLine().trim();
    
        Curso cursoEncontrado = null;
        for (Curso c : cursos) {
            if (c.getNombre().equals(nombreCurso)) {
                cursoEncontrado = c;
                break;
            }
        }
        if (cursoEncontrado == null) {
            System.out.println("Curso no encontrado.");
            return;
        }
    
        Set<Alumno> inscritos = inscripciones.get(cursoEncontrado);
        if (inscritos == null || inscritos.isEmpty()) { //no hay cursos con dicho nombre y alumnos o dicho curso no está en la colección
            System.out.println("No hay alumnos inscritos en este curso.");
        } else {
            System.out.println("Alumnos en el curso " + cursoEncontrado.getNombre() + ":");
            for (Alumno a : inscritos) {
                System.out.println(a);
            }
        }
    }
    
//----8----------MOSTRAR LOS CURSOS A LOS QUE ESTÁ INSCRITO UN ALUMN-------------
public void mostrarCursosDeUnAlumno(Scanner sc) {
    System.out.print("Nombre del alumno: ");
    String nombre = sc.nextLine().trim();
    System.out.print("Apellido del alumno: ");
    String apellido = sc.nextLine().trim();

    Alumno alumnoEncontrado = null;
    for (Alumno a : alumnos) {
        if (a.getNombre().equals(nombre) && a.getApellido().equals(apellido)) {
            alumnoEncontrado = a;
            break;
        }
    }

    if (alumnoEncontrado == null) {
        System.out.println("Alumno no encontrado.");
        return;
    }

    System.out.println("Cursos en los que está inscrito " + alumnoEncontrado.getNombre() + ":");

    boolean tieneCursos = false;
    for (Curso c : cursos) {
        Set<Alumno> inscritos = inscripciones.get(c);
        if (inscritos != null && inscritos.contains(alumnoEncontrado)) {
            System.out.println( c.getNombre());
            tieneCursos = true;
        }
    }

    if (!tieneCursos) {
        System.out.println("Este alumno no está inscrito en ningún curso.");
    }
}

//----9----------MOSTRAR LOS CURSOS A LOS QUE ESTÁ INSCRITO UN ALUMN-------------
public void eliminarAlumno(Scanner sc) {
    System.out.print("Nombre del alumno: ");
    String nombre = sc.nextLine().trim();
    System.out.print("Apellido del alumno: ");
    String apellido = sc.nextLine().trim();

    Alumno alumnoEncontrado = null;
    for (Alumno a : alumnos) {
        if (a.getNombre().equalsIgnoreCase(nombre) && a.getApellido().equalsIgnoreCase(apellido)) {
            alumnoEncontrado = a;
            break;
        }
    }

    if (alumnoEncontrado == null) {
        System.out.println("Alumno no encontrado.");
        return;
    }

    alumnos.remove(alumnoEncontrado);

    for (Set<Alumno> lista : inscripciones.values()) {
        lista.remove(alumnoEncontrado);
    }

    System.out.println("Alumno eliminado correctamente.");
}



public void eliminarCurso(Scanner sc) {
    System.out.print("Nombre del curso: ");
    String nombreCurso = sc.nextLine().trim();

    Curso cursoEncontrado = null;
    for (Curso c : cursos) {
        if (c.getNombre().equalsIgnoreCase(nombreCurso)) {
            cursoEncontrado = c;
            break;
        }
    }

    if (cursoEncontrado == null) {
        System.out.println("Curso no encontrado.");
        return;
    }

    cursos.remove(cursoEncontrado);
    inscripciones.remove(cursoEncontrado);

    System.out.println("Curso eliminado correctamente.");



} public static List<Alumno> filtrar(List<Alumno> alumnos, String campo, String valor) {
        return alumnos.stream()
            .filter(a -> switch (campo.toLowerCase()) {
                case "dni" -> a.getDni().contains(valor);
                case "nombre" -> a.getNombre().toLowerCase().contains(valor.toLowerCase());
                case "apellido" -> a.getApellido().toLowerCase().contains(valor.toLowerCase());
                case "id" -> a.getCodigo().contains(valor);
                default -> false;
            })
            .collect(Collectors.toList());
    }

    public static List<Alumno> ordenar(List<Alumno> alumnos, String campo) {
        List<Alumno> lista = new ArrayList<>(alumnos);
        lista.sort((a1, a2) -> switch (campo.toLowerCase()) {
            case "dni" -> a1.getDni().compareTo(a2.getDni());
            case "nombre" -> a1.getNombre().compareToIgnoreCase(a2.getNombre());
            case "apellido" -> a1.getApellido().compareToIgnoreCase(a2.getApellido());
            case "id" -> a1.getCodigo().compareTo(a2.getCodigo());
            default -> 0;
        });
        return lista;
    }



  

public List<Curso> getCursos() {
    return cursos;
}
public Set<Alumno> getAlumnos() {
    return alumnos;
}

}
