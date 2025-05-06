import java.util.*;

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
    public void mostrarAlumnos() {
                //Verifica que existan alumnos
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
    //copia la coleccion set, la cual no se puede ordenar en un ArrayList ordenable 
        List<Alumno> listaOrdenada = new ArrayList<>(alumnos);
        Collections.sort(listaOrdenada, Comparator.comparing(Alumno::getNombre));
        //Ordenamos la coleccion por orden alfabetico del nombre
    
        System.out.println("Lista de alumnos (ordenados por nombre):");
        for (Alumno a : listaOrdenada) {
            System.out.println(a);
        }
    }
    

    //- 4---------------------MOSTRAR TODOS LOS CURSOS ORDENADOS POR ID----------------------
    public void mostrarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }
    
        // Ordenar ascendentemente la colecciób por codigo 
        Collections.sort(cursos, Comparator.comparing(Curso::getCodigo));  //curso1.getCodigo().compareTo(curso2.getCodigo()) .reversed()

    
        System.out.println("Lista de cursos (ordenados por código):");
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
}

  

public List<Curso> getCursos() {
    return cursos;
}
public Set<Alumno> getAlumnos() {
    return alumnos;
}

}
