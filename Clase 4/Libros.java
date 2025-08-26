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

    public void FiltroLibros(Libros[] libros){
        for (Libros libro : libros) {
            if (libro.precio == 15550) {
                System.out.println(libro);
            }
        }
    }


    //diagrama de clases y matrices parcial de programacion III
}