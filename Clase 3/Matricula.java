import java.util.Arrays;

public class Matricula {
    //atributos
    private int id;
    private String[] cursos;

    //constructor
    public Matricula(int id, String[] cursos) {
        this.id = id;
        this.cursos = cursos;
    }

    //metodo toString
    public String toString() {
        return "Matricula: [id: " + id + " Cursos: " + Arrays.toString(cursos) + " ] ";
    }
}
