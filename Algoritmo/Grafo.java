import java.util.*; 

class Grafo { 
    private int V; // Número de nodos 
    private List<Vertice>[] listaAdyacencia; // Lista de adyacencia 
        public Grafo(int V) { 
        this.V = V; 
        listaAdyacencia = new ArrayList[V]; 
        for (int i = 0; i < V; i++) { 
        listaAdyacencia[i] = new ArrayList<>(); 
        } 
    }
} // Clase interna para representar un vértice class Vertice { int destino; int peso; public Vertice(int destino, int peso) { this.destino = destino; this.peso = peso; } } }