// Importa clases para manejar listas y mapas
import java.util.*;

/**
 * Representa un grafo no dirigido con pesos en las aristas.
 * Usa una lista de adyacencia para almacenar conexiones.
 */
public class Grafo {
    // Mapa: clave = nodo, valor = lista de aristas conectadas
    private Map<String, List<Arista>> listaAdyacencia;

    /**
     * Crea un grafo vacío.
     */
    public Grafo() {
        this.listaAdyacencia = new HashMap<>();
    }

    /**
     * Agrega un nodo al grafo si no existe.
     * @param nodo Nombre del nodo.
     */
    public void agregarNodo(String nodo) {
        listaAdyacencia.putIfAbsent(nodo, new ArrayList<>());//agrega una nueva entrada al mapa solo si no existe y asegura que cada nodo tenga una lista de aristas
    }

    /**
     * Agrega una arista entre dos nodos con peso.
     * Como es no dirigido, conecta en ambas direcciones.
     * @param origen Nodo origen.
     * @param destino Nodo destino.
     * @param peso Peso de la arista.
     */
    public void agregarArista(String origen, String destino, int peso) {
        listaAdyacencia.get(origen).add(new Arista(destino, peso));
        listaAdyacencia.get(destino).add(new Arista(origen, peso)); // Bidireccional
    }

    /**
     * Devuelve la lista de adyacencia del grafo.
     * @return Mapa con nodos y sus aristas.
     */
    public Map<String, List<Arista>> obtenerListaAdyacencia() {
        return listaAdyacencia;
    }

    /**
     * Representa una arista con destino y peso.
     */
    public static class Arista {
        private String destino; // Nodo al que llega
        private int peso; // Costo de la arista

        /**
         * Crea una arista.
         * @param destino Nodo destino.
         * @param peso Peso.
         */
        public Arista(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }

        /**
         * Obtiene el destino.
         * @return Nombre del nodo destino.
         */
        public String getDestino() {
            return destino;
        }

        /**
         * Obtiene el peso.
         * @return Peso de la arista.
         */
        public int getPeso() {
            return peso;
        }
    }
}
