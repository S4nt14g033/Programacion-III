import java.util.Arrays;

public class EjecutarEstudiante {

    public static void main(String[] args) {
        
        //creacion de objetos
        Estudiante objEst1 = new Estudiante (1, 1013114634, "Santiago", "Ingenieria");
        Estudiante objEst2 = new Estudiante (2, 1322846773, "Angelica", "Ingenieria");
        Estudiante objEst3 = new Estudiante (3, 1111298734, "Brayan", "Medicina");
        
        System.out.println(objEst1);
        System.out.println(objEst2);
        System.out.println(objEst3);

        //creacion arreglo de objetos (Estudiantes)
        
        Estudiante[] e = new Estudiante[4];

        e[0] = objEst1;
        e[1] = objEst2;
        e[2] = objEst3;
        e[3] = new Estudiante(4, 100894094, "Peter", "ingenieria");

        System.out.println(Arrays.toString(e));

        //tarea
        // implementar el metodo matricular cursos para que cada estudiantes pueda realizar dicha operacion
    }
}