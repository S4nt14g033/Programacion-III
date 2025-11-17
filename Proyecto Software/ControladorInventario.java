// Clase ControladorInventario maneja la lógica de la aplicación
public class ControladorInventario {
    // Atributos
    private BaseDeDatos baseDatos;
    private InventarioVista vista;

    // Constructor
    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }

    // Método para iniciar la aplicación
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    // Agregar producto
                    Producto producto = vista.pedirDatosUsuario();
                    baseDatos.agregarProducto(producto);
                    vista.mostrarMensaje("Producto agregado exitosamente.");
                    break;
                case 2:
                    // Buscar producto
                    String skuBuscar = vista.pedirSku();
                    Producto encontrado = baseDatos.buscarProductoSku(skuBuscar);
                    vista.mostrarProducto(encontrado);
                    break;
                case 3:
                    // Mostrar todos los productos
                    vista.mostrarProductos(baseDatos.buscarTodos());
                    break;
                case 4:
                    // Eliminar producto
                    String skuEliminar = vista.pedirSku();
                    boolean eliminado = baseDatos.EliminarProducto(skuEliminar);
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
