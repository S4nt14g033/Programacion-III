import java.util.Arrays;

public class EjecutarLibros {

     public static void main(String[] args) {
        Libros libro1 = new Libros("Cien Años de Soledad", "Gabriel Garcia Marquez", 30000);
        Libros libro2 = new Libros("1984", "George Orwell", 25000);
        Libros libro3 = new Libros("El Principito", "Antoine de Saint-Exupéry", 25000);
        Libros libro4 = new Libros("El Alquimista", "Paulo Coelho", 28000);
        Libros libro5 = new Libros("Don Quijote de la Mancha", "Miguel de Cervantes", 35000);


        


       /* System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
        System.out.println(libro4);*/

    
        Libros[] libros = new Libros[5];

        libros[0] = libro1; 
        libros[1] = libro2;
        libros[2] = libro3;
        libros[3] = libro4;
        libros[4] = libro5;



        /*System.out.println("Libros con precio mayor a 15550: ");
        libros[0].FiltroLibros(libros,15000);*/

        libros[0].ordenar(libros);
        System.out.println("\n Libros ordenados por precio: ");
        for (Libros libro: libros) {
            System.out.println(libro);
        }
    }
    
}