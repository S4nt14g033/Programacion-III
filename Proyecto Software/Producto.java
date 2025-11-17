// Clase Producto representa un producto en el inventario
public class Producto {
    // Atributos del producto
    private int id; // Identificador único del producto
    private String nombre; // Nombre del producto
    private int cantidad; // Cantidad del producto
    private double precio; // Precio del producto

    // Constructor para crear un producto
    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Métodos para obtener los valores (getters)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    // Métodos para cambiar los valores (setters)
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para mostrar información del producto
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Cantidad: " + cantidad + ", Precio: " + precio;
    }
}
