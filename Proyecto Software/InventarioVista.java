// Clase InventarioVista maneja la interfaz de usuario en consola
import java.util.List;
import java.util.Scanner;

public class InventarioVista {
    // Scanner para leer entrada del usuario
    private Scanner scanner;

    // Constructor
    public InventarioVista() {
        scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú principal y retornar la opción seleccionada
    public int mostrarMenu() {
        System.out.println("\n--- Menú de Inventario ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
        return scanner.nextInt();
    }

    // Método para pedir datos del usuario y crear un producto
    public Producto pedirDatosUsuario() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("SKU del producto: ");
        String sku = scanner.nextLine();
        System.out.print("Cantidad del producto: ");
        int cantidad = scanner.nextInt();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        return new Producto(sku, nombre, cantidad, precio);
    }

    // Método para pedir SKU
    public String pedirSku() {
        System.out.print("SKU del producto: ");
        return scanner.nextLine();
    }

    // Método para mostrar un producto
    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Método para mostrar la lista de productos
    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            mostrarMensaje("No hay productos registrados.");
        } else {
            for (Producto p : productos) {
                mostrarProducto(p);
            }
        }
    }

    // Método para mostrar un mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para cerrar el scanner
    public void cerrar() {
        scanner.close();
    }
}
