// Clase Producto representa un producto en el inventario
public class Producto {
    // Atributos del producto
    private String sku; // Identificador único del producto
    private String nombre; // Nombre del producto
    private int cantidad; // Cantidad del producto
    private double precio; // Precio del producto

    // Constructor para crear un producto
    public Producto(String sku, String nombre, int cantidad, double precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Métodos para obtener los valores (getters)
    public String getSku() {
        return sku;
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
    public void setSku(String sku) {
        this.sku = sku;
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
        return "SKU: " + sku + " | Nombre: " + nombre + " | Cantidad: " + cantidad + " | Precio: " + precio;
    }
}
