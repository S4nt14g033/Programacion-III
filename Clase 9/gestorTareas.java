import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class gestorTareas {

    private Queue<tarea> filaEspera;

    private Stack<tarea> filaPrioridad;

    private Map<String, tarea> tareasCompletadas;

    public gestorTareas(){
    this.filaEspera = new java.util.LinkedList<>();
    this.filaPrioridad = new Stack<>();
    this.tareasCompletadas = new java.util.HashMap<>();
    }
}


 //agregar tarea a la fila de espera
public void agregarTarea(tarea nuevaTarea){

    if (tarea.getPrioridad() == 3) {
        filaPrioridad.push(nuevaTarea);
    } else {
        filaEspera.add(nuevaTarea);
        
    }
}

//procesar tarea de la fila de prioridad
public void procesarTareaPrioridad(){
    if (!filaPrioridad.isEmpty()) {
        tarea tareaProcesada = filaPrioridad.pop();
        tareasCompletadas.put(tareaProcesada.getId(), tareaProcesada);
        System.out.println("Tarea procesada de prioridad alta: " + tareaProcesada.ConsultarEstadoTarea());
    } else {
        System.out.println("No hay tareas de prioridad alta en la fila.");
    }
}






