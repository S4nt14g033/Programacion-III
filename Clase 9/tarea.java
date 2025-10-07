public class tarea {

    private String id;
    private String descripcion;
    private int prioridad;

    //constructor

    public tarea(String id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    //obtencion de datos
    public String getId() {
        return id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getPrioridad() {
        return prioridad;
    }

    //metodo para consultar el estado de la tarea
    public String ConsultarEstadoTarea() {
        return "ID: " + id + ", Descripcion: " + descripcion + ", Prioridad: " + prioridad;
    }
}