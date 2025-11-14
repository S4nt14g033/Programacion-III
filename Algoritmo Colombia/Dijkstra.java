// Importa clases para manejar listas, mapas y colas
import java.util.*;

/**
 * Implementa el algoritmo de Dijkstra para caminos más cortos.
 * Encuentra distancias mínimas desde un nodo origen a todos los demás.
 * Asume pesos no negativos.
 * Ahora modificado para encontrar todos los caminos de Cali a Cartagena en el mapa de Colombia,
 * y ordenar los recorridos para obtener el menor.
 */
public class Dijkstra {

    /**
     * Clase para representar un camino completo: lista de nodos y distancia total.
     */
    public static class Camino {
        private List<String> ruta; // Lista de ciudades en el orden del camino
        private int distanciaTotal; // Distancia acumulada del camino

        /**
         * Crea un camino.
         * @param ruta Lista de nodos (ciudades).
         * @param distanciaTotal Distancia total.
         */
        public Camino(List<String> ruta, int distanciaTotal) {
            this.ruta = new ArrayList<>(ruta); // Copia la lista para evitar modificaciones externas
            this.distanciaTotal = distanciaTotal;
        }

        /**
         * Obtiene la ruta.
         * @return Lista de ciudades.
         */
        public List<String> getRuta() {
            return ruta;
        }

        /**
         * Obtiene la distancia total.
         * @return Distancia.
         */
        public int getDistanciaTotal() {
            return distanciaTotal;
        }

        /**
         * Representa el camino como string.
         * @return String con ruta y distancia.
         */
        @Override
        public String toString() {
            return "Ruta: " + ruta + ", Distancia: " + distanciaTotal + " km";
        }
    }

    /**
     * Encuentra todos los caminos posibles de origen a destino usando DFS recursivo.
     * DFS significa Depth-First Search, que explora en profundidad antes de ancho.
     * Calcula la distancia acumulada para cada camino sumando los pesos de las aristas.
     * @param grafo Grafo del mapa.
     * @param origen Ciudad de inicio.
     * @param destino Ciudad final.
     * @return Lista de todos los caminos encontrados.
     */
    public static List<Camino> encontrarTodosLosCaminos(Grafo grafo, String origen, String destino) {
        List<Camino> caminos = new ArrayList<>(); // Lista para almacenar todos los caminos
        Set<String> visitado = new HashSet<>(); // Para evitar ciclos (no repetir ciudades en un camino)
        List<String> rutaActual = new ArrayList<>(); // Ruta actual en construcción
        rutaActual.add(origen); // Agrega el origen a la ruta
        dfs(grafo, origen, destino, visitado, rutaActual, 0, caminos); // Llama a DFS
        return caminos;
    }

    /**
     * Método auxiliar DFS recursivo para explorar caminos.
     * Backtracking es una técnica para explorar todas las posibilidades, volviendo atrás cuando no hay más opciones.
     * @param grafo Grafo.
     * @param actual Nodo actual.
     * @param destino Nodo final.
     * @param visitado Conjunto de nodos visitados.
     * @param rutaActual Ruta en construcción.
     * @param distanciaActual Distancia acumulada.
     * @param caminos Lista donde agregar caminos completos.
     */
    private static void dfs(Grafo grafo, String actual, String destino, Set<String> visitado, List<String> rutaActual, int distanciaActual, List<Camino> caminos) {
        if (actual.equals(destino)) { // Si llegamos al destino, agregamos el camino
            caminos.add(new Camino(rutaActual, distanciaActual));
            return;
        }

        visitado.add(actual); // Marca como visitado

        // Explora cada vecino
        for (Grafo.Arista arista : grafo.obtenerListaAdyacencia().get(actual)) {
            String vecino = arista.getDestino();
            if (!visitado.contains(vecino)) { // Si no visitado, continúa
                rutaActual.add(vecino); // Agrega a ruta
                dfs(grafo, vecino, destino, visitado, rutaActual, distanciaActual + arista.getPeso(), caminos); // Recursión
                rutaActual.remove(rutaActual.size() - 1); // Backtrack: remueve el último
            }
        }

        visitado.remove(actual); // Backtrack: desmarca visitado
    }

    /**
     * Ordena una lista de caminos por distancia usando el método de burbuja.
     * El método de burbuja compara elementos adyacentes y los intercambia si están en orden incorrecto.
     * Repite pasadas hasta que no haya más intercambios.
     * @param caminos Lista de caminos a ordenar.
     */
    public static void ordenarCaminosPorDistancia(List<Camino> caminos) {
        int n = caminos.size(); // Número de caminos
        for (int i = 0; i < n - 1; i++) { // Pasadas
            for (int j = 0; j < n - i - 1; j++) { // Comparaciones
                if (caminos.get(j).getDistanciaTotal() > caminos.get(j + 1).getDistanciaTotal()) {
                    // Intercambia si el actual es mayor que el siguiente
                    Camino temp = caminos.get(j);
                    caminos.set(j, caminos.get(j + 1));
                    caminos.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Calcula distancias más cortas desde el origen (método original de Dijkstra, no usado ahora).
     * Usa cola de prioridad para elegir el nodo con menor distancia.
     * La cola de prioridad asegura que siempre se procese el nodo con la distancia más pequeña primero.
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
     * Método principal: crea el grafo del mapa de Colombia, encuentra caminos de Cali a Cartagena,
     * los ordena y muestra el menor.
     * @param args No usados.
     */
    public static void main(String[] args) {
        // Crea el grafo del mapa de Colombia
        Grafo grafoColombia = new Grafo();

        // Agrega ciudades como nodos
        grafoColombia.agregarNodo("Cali"); // Origen
        grafoColombia.agregarNodo("Bogotá");
        grafoColombia.agregarNodo("Medellín");
        grafoColombia.agregarNodo("Barranquilla");
        grafoColombia.agregarNodo("Cartagena"); // Destino
        grafoColombia.agregarNodo("Pereira");
        grafoColombia.agregarNodo("Manizales");
        grafoColombia.agregarNodo("Armenia");
        grafoColombia.agregarNodo("Ibagué");
        grafoColombia.agregarNodo("Tunja");

        // Agrega conexiones (aristas) con distancias aproximadas en km para múltiples rutas
        // Ruta 1: Cali -> Pereira -> Medellín -> Cartagena
        grafoColombia.agregarArista("Cali", "Pereira", 150);
        grafoColombia.agregarArista("Pereira", "Medellín", 200);
        grafoColombia.agregarArista("Medellín", "Cartagena", 600);

        // Ruta 2: Cali -> Armenia -> Ibagué -> Bogotá -> Tunja -> Cartagena (vía Barranquilla)
        grafoColombia.agregarArista("Cali", "Armenia", 100);
        grafoColombia.agregarArista("Armenia", "Ibagué", 120);
        grafoColombia.agregarArista("Ibagué", "Bogotá", 200);
        grafoColombia.agregarArista("Bogotá", "Tunja", 150);
        grafoColombia.agregarArista("Tunja", "Barranquilla", 700);
        grafoColombia.agregarArista("Barranquilla", "Cartagena", 100);

        // Ruta 3: Cali -> Manizales -> Pereira -> Medellín -> Cartagena
        grafoColombia.agregarArista("Cali", "Manizales", 180);
        grafoColombia.agregarArista("Manizales", "Pereira", 50);
        // Pereira a Medellín ya agregado

        // Ruta 4: Cali -> Bogotá -> Cartagena
        grafoColombia.agregarArista("Cali", "Bogotá", 450);
        grafoColombia.agregarArista("Bogotá", "Cartagena", 1000);

        // Encuentra todos los caminos de Cali a Cartagena
        List<Camino> caminos = encontrarTodosLosCaminos(grafoColombia, "Cali", "Cartagena");

        // Ordena los caminos por distancia usando burbuja
        ordenarCaminosPorDistancia(caminos);

        // Muestra todos los caminos
        System.out.println("Todos los caminos de Cali a Cartagena:");
        for (Camino camino : caminos) {
            System.out.println(camino);
        }

        // Muestra el camino con menor distancia
        if (!caminos.isEmpty()) {
            System.out.println("\nCamino con menor distancia:");
            System.out.println(caminos.get(0));
        } else {
            System.out.println("No se encontraron caminos.");
        }
    }
}
