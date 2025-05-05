public class Curso {
    private String nombre;
    private String codigo;

    public Curso(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }

    @Override
    public String toString() {
        return nombre + " (Código: " + codigo + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso c = (Curso) o;
        return codigo.equals(c.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
