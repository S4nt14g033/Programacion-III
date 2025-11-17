// Clase Vista maneja la interfaz de usuario en consola
import java.util.Scanner;

public class Vista {
    // Scanner para leer entrada del usuario
    private Scanner scanner;

    // Constructor
    public Vista() {
        scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú principal
    public void mostrarMenu() {
        System.out.println("\n--- Menú de Inventario ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Imprimir lista de productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    // Método para leer la opción del menú
    public int leerOpcion() {
        return scanner.nextInt();
    }

    // Método para leer datos de un producto
    public Producto leerProducto() {
        System.out.print("ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad del producto: ");
        int cantidad = scanner.nextInt();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        return new Producto(id, nombre, cantidad, precio);
    }

    // Método para leer ID para buscar o eliminar
    public int leerId() {
        System.out.print("ID del producto: ");
        return scanner.nextInt();
    }

    // Método para mostrar un mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para mostrar un producto
    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Método para cerrar el scanner
    public void cerrar() {
        scanner.close();
    }
}
