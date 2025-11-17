// Clase BaseDeDatos simula la base de datos
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    // Lista para guardar los productos
    private List<Producto> productos;

    // Constructor
    public BaseDeDatos() {
        productos = new ArrayList<>();
    }

    // Método para agregar un producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para buscar un producto por SKU (ignorando mayúsculas/minúsculas)
    public Producto buscarProductoSku(String sku) {
        for (Producto p : productos) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                return p;
            }
        }
        return null; // Si no encuentra
    }

    // Método para buscar todos los productos
    public List<Producto> buscarTodos() {
        return productos;
    }

    // Método para eliminar un producto por SKU
    public boolean EliminarProducto(String sku) {
        Producto p = buscarProductoSku(sku);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
}
