import java.util.Arrays;

public class Estudiante {
    //atributos
    private int id;
    private int cedula;
    private String nombre;
    private String facultad;

    //constructor
    public Estudiante(int id, int cedula, String nombre, String facultad) {
        //autoreferencia para no crear otra variable
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.facultad = facultad;

    }

    //Metodo matricular cursos
    public void matricularCursos(String[] cursos) {

        System.out.println(Arrays.toString(cursos));
        
    }

    //Metodo toString
    public String toString() {
        return "Estudiante: [id: " + id + " cedula: " + cedula + " Nombre: " + nombre + " Facultad: " + facultad + " ] ";
    }
}