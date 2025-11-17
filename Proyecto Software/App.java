// Clase App es el punto de entrada de la aplicación
public class App {
    public static void main(String[] args) {
        // Crear instancias del modelo, vista y controlador
        BaseDeDatos baseDeDatos = new BaseDeDatos();
        InventarioVista vista = new InventarioVista();
        ControladorInventario controlador = new ControladorInventario(baseDeDatos, vista);

        // Iniciar la aplicación
        controlador.iniciar();
    }
}
