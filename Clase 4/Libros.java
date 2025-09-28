import java.util.Arrays;

class Libros {

    private String titulo;
    private String autor;
    private int precio;

    


    public Libros(String titulo, String autor, int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String toString() {
        return "Libros [titulo: " + titulo + ", autor: " + autor + ", precio: " + precio + "]";
    }

    //calcular precio de los libros en el arreglo
    public int calcularPrecio(Libros[] libros) {
        int total = 0;
        for (Libros libro : libros) {
            total += libro.precio;
        }
        return total;
    }


    // filtrar libros por precio mayor al valor minimo
    public void FiltroLibros(Libros[] libros, int valorMinimo){
        for (Libros libro : libros) {
            if (libro.precio > valorMinimo) {
                System.out.println(libro);
            }
        }
    };

    public void ordenar(Libros[] libros){
        int cant_libros = libros.length; //obtencion de la cantidad de libros en el arreglo
        //algoritmo de burbuja
        for (int i = 0; i < cant_libros - 1 ; i++) { //ciclo, controla el numero de pasadas
            for ( int j = 0; j < cant_libros - i - 1; j++) {//compara los elementos y hace el intercambio si estan desordenados
                if (libros[j].precio > libros[j+1].precio) { // si el precio del libro actual es mayor al siguiente intercambian posiciones
                    //intercambio de posicion de libros con una variable temporal
                    Libros tempo = libros[j];
                    libros[j] = libros[j+1];
                    libros[j+1] = tempo;
                    
                }
            }
        }
    };

    //diagrama de clases y matrices parcial de programacion III
}