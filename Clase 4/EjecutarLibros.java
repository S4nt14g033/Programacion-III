import java.util.Arrays;

public class EjecutarLibros {

     public static void main(String[] args) {
        Libros libro1 = new Libros("Cien Años de Soledad", "Gabriel Garcia Marquez", 30000);
        Libros libro2 = new Libros("1984", "George Orwell", 25000);
        Libros libro3 = new Libros("El Principito", "Antoine de Saint-Exupéry", 20000);
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

        System.out.print("libros sobre ");
        libros[0].FiltroLibros(libros);
        System.out.println("el total de los libros es: " + libros[0].calcularPrecio(libros));

        //implementar lo que falta
    }
    
}