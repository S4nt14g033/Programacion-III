// Clase Main es el punto de entrada de la aplicación
public class Main {
    public static void main(String[] args) {
        // Crear instancias del modelo, vista y controlador
        Inventario inventario = new Inventario();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(inventario, vista);

        // Iniciar la aplicación
        controlador.iniciar();
    }
}
