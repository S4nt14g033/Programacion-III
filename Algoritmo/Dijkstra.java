// Importa clases para manejar listas, mapas y colas
import java.util.*;

/**
 * Implementa el algoritmo de Dijkstra para caminos más cortos.
 * Encuentra distancias mínimas desde un nodo origen a todos los demás.
 * Asume pesos no negativos.
 */
public class Dijkstra {
    /**
     * Calcula distancias más cortas desde el origen.
     * Usa cola de prioridad para elegir el nodo con menor distancia.
     * @param grafo Grafo a procesar.
     * @param origen Nodo de inicio.
     * @return Mapa con distancias mínimas.
     */
    public static Map<String, Integer> calcularCaminoMasCorto(Grafo grafo, String origen) {
        // Mapa de distancias: clave = nodo, valor = distancia mínima
        Map<String, Integer> distancia = new HashMap<>();
        // Mapa de nodos anteriores (para reconstruir camino, no usado aquí)
        Map<String, String> anterior = new HashMap<>();
        // Conjunto de nodos visitados
        Set<String> visitado = new HashSet<>();
        // Cola de prioridad: ordena por distancia
        PriorityQueue<NodoDistancia> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(NodoDistancia::getDistancia));

        // Inicializar distancias: infinito para todos, 0 para origen
        for (String nodo : grafo.obtenerListaAdyacencia().keySet()) {
            distancia.put(nodo, Integer.MAX_VALUE);
        }
        distancia.put(origen, 0);
        colaPrioridad.add(new NodoDistancia(origen, 0));

        // Bucle principal: procesar nodos
        while (!colaPrioridad.isEmpty()) {
            NodoDistancia actual = colaPrioridad.poll();
            String nodoActual = actual.getNodo();

            if (visitado.contains(nodoActual)) continue;
            visitado.add(nodoActual);

            // Revisar vecinos
            for (Grafo.Arista arista : grafo.obtenerListaAdyacencia().get(nodoActual)) {
                String vecino = arista.getDestino();
                int peso = arista.getPeso();
                int nuevaDistancia = distancia.get(nodoActual) + peso;

                if (nuevaDistancia < distancia.get(vecino)) {
                    distancia.put(vecino, nuevaDistancia);
                    anterior.put(vecino, nodoActual);
                    colaPrioridad.add(new NodoDistancia(vecino, nuevaDistancia));
                }
            }
        }

        return distancia;
    }

    /**
     * Clase auxiliar para cola de prioridad: nodo con distancia.
     */
    private static class NodoDistancia {
        private String nodo; // Nombre del nodo
        private int distancia; // Distancia desde origen

        /**
         * Crea un NodoDistancia.
         * @param nodo Nombre.
         * @param distancia Valor.
         */
        public NodoDistancia(String nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }

        /**
         * Obtiene el nodo.
         * @return Nombre del nodo.
         */
        public String getNodo() {
            return nodo;
        }

        /**
         * Obtiene la distancia.
         * @return Distancia.
         */
        public int getDistancia() {
            return distancia;
        }
    }

    /**
     * Ejemplo de uso: crea grafo y calcula distancias desde A.
     * Grafo ejemplo:
     * A --4-- B --10-- D --7-- E
     * | \     |       ^
     * 2  5    3       |
     * |   \   |       |
     * v    v  v       |
     * C ---- B       |
     * (Nota: B-C tiene 5, C-D tiene 3)
     * @param args No usados.
     */
    public static void main(String[] args) {
        System.out.println("Ejemplo con pesos:");
        Grafo grafo = new Grafo();

        // Agregar nodos
        grafo.agregarNodo("A");
        grafo.agregarNodo("B");
        grafo.agregarNodo("C");
        grafo.agregarNodo("D");
        grafo.agregarNodo("E");

        // Agregar aristas con pesos
        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("A", "C", 2);
        grafo.agregarArista("B", "C", 5);
        grafo.agregarArista("B", "D", 10);
        grafo.agregarArista("C", "D", 3);
        grafo.agregarArista("D", "E", 7);

        // Calcular distancias desde A
        System.out.println("Punto inicial: A");
        Map<String, Integer> distancias = calcularCaminoMasCorto(grafo, "A");

        // Mostrar resultados
        System.out.println("Distancias desde A:");
        for (Map.Entry<String, Integer> entrada : distancias.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }

        // Ejemplo sin pesos: asumir peso 1 en todas las aristas
        System.out.println("\nEjemplo sin pesos (peso 1 para mostrar cuantos caminos hay que tomar):");
        ejemploSinPesos();
    }

    /**
     * Ejemplo simplificado: grafo con letras, sin pesos (peso 1).
     * Equivalente a BFS para caminos más cortos.
     * Grafo: A - B - C - D
     *        |   |
     *        E - F
     */
    public static void ejemploSinPesos() {
        Grafo grafo = new Grafo();

        // Nodos: A, B, C, D, E, F
        grafo.agregarNodo("A");
        grafo.agregarNodo("B");
        grafo.agregarNodo("C");
        grafo.agregarNodo("D");
        grafo.agregarNodo("E");
        grafo.agregarNodo("F");

        // Aristas sin pesos (peso 1)
        grafo.agregarArista("A", "B", 1);
        grafo.agregarArista("B", "C", 1);
        grafo.agregarArista("C", "D", 1);
        grafo.agregarArista("A", "E", 1);
        grafo.agregarArista("E", "F", 1);
        grafo.agregarArista("B", "F", 1);

        // Calcular distancias desde A
        Map<String, Integer> distancias = calcularCaminoMasCorto(grafo, "A");

        // Mostrar resultados
        System.out.println("Distancias desde A (peso 1):");
        for (Map.Entry<String, Integer> entrada : distancias.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
