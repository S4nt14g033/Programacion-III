// Clase Controlador maneja la lógica de la aplicación
public class Controlador {
    // Atributos
    private Inventario inventario;
    private Vista vista;

    // Constructor
    public Controlador(Inventario inventario, Vista vista) {
        this.inventario = inventario;
        this.vista = vista;
    }

    // Método para iniciar la aplicación
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();
            switch (opcion) {
                case 1:
                    // Agregar producto
                    Producto producto = vista.leerProducto();
                    inventario.agregarProducto(producto);
                    vista.mostrarMensaje("Producto agregado exitosamente.");
                    break;
                case 2:
                    // Mostrar productos
                    vista.mostrarMensaje("Lista de productos:");
                    inventario.mostrarProductos();
                    break;
                case 3:
                    // Buscar producto
                    int idBuscar = vista.leerId();
                    Producto encontrado = inventario.buscarProducto(idBuscar);
                    vista.mostrarProducto(encontrado);
                    break;
                case 4:
                    // Eliminar producto
                    int idEliminar = vista.leerId();
                    boolean eliminado = inventario.eliminarProducto(idEliminar);
                    if (eliminado) {
                        vista.mostrarMensaje("Producto eliminado exitosamente.");
                    } else {
                        vista.mostrarMensaje("Producto no encontrado.");
                    }
                    break;
                case 5:
                    // Salir
                    salir = true;
                    vista.mostrarMensaje("Saliendo de la aplicación.");
                    vista.cerrar();
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
