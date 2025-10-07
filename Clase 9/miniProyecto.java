public class miniProyecto {
    public static void main(String[] args) {
       gestorTareas gestor = new gestorTareas();

       gestor.agregarTarea(new tarea("1", "Tarea de baja prioridad", 1));
       gestor.agregarTarea(new tarea("2", "Tarea de prioridad media", 2));
       gestor.agregarTarea(new tarea("3", "Tarea de alta prioridad", 3));

       gestor.mostrarEstadoTareas();
    }
}