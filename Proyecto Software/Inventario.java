// Clase Inventario maneja la lista de productos
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    // Lista para guardar los productos
    private List<Producto> productos;

    // Constructor
    public Inventario() {
        productos = new ArrayList<>();
    }

    // Método para agregar un producto (Crear)
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para mostrar todos los productos (Leer)
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    // Método para buscar un producto por ID
    public Producto buscarProducto(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Si no encuentra
    }

    // Método para eliminar un producto por ID (Eliminar)
    public boolean eliminarProducto(int id) {
        Producto p = buscarProducto(id);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
}
