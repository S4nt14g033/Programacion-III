import java.util.Arrays;

public class Estudiante {
    //atributos
    private int id;
    private int cedula;
    private String nombre;
    private String facultad;
    private Matricula matricula;

    //constructor
    public Estudiante(int id, int cedula, String nombre, String facultad) {
        //autoreferencia para no crear otra variable
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.facultad = facultad;

    }

     //tarea
        // implementar el metodo matricular cursos para que cada estudiantes pueda realizar dicha operacion
        
    //Metodo matricular cursos
    public void matricularCursos(String[] cursos) {
        this.matricula = new Matricula(this.id, cursos);
        System.out.println(Arrays.toString(cursos));//imprime los cursos de cada estudiante
        
    }

     //obtener matricula
    public Matricula obtMatricula() {
        return this.matricula;
    }

    //Metodo toString
    public String toString() {
        return "Estudiante: [id: " + id + " cedula: " + cedula + " Nombre: " + nombre + " Facultad: " + facultad +  
        (matricula != null ? " " + matricula : "") +" ] ";
    }

   
}