public class Alumno {
    private String nombre;
    private String dni;

    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getDni() { return dni; }

    @Override
    public String toString() {
        return nombre + " (DNI: " + dni + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno a = (Alumno) o;
        return dni.equals(a.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}
