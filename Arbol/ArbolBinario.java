// Clase para el árbol binario con recorridos
public class ArbolBinario {
    Nodo raiz;

    // Constructor
    public ArbolBinario() {
        raiz = null;
    }

    // Método para recorrido inorder (izquierdo-raíz-derecho)
    void recorridoInorder(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        // Primero visita el subárbol izquierdo
        recorridoInorder(nodo.izquierdo);
        // Luego imprime el dato del nodo
        System.out.print(nodo.dato + " ");
        // Finalmente visita el subárbol derecho
        recorridoInorder(nodo.derecho);
    }

    // Método para recorrido preorder (raíz-izquierdo-derecho)
    void recorridoPreorder(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        // Primero imprime el dato del nodo
        System.out.print(nodo.dato + " ");
        // Luego visita el subárbol izquierdo
        recorridoPreorder(nodo.izquierdo);
        // Finalmente visita el subárbol derecho
        recorridoPreorder(nodo.derecho);
    }

    // Método para recorrido postorder (izquierdo-derecho-raíz)
    void recorridoPostorder(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        // Primero visita el subárbol izquierdo
        recorridoPostorder(nodo.izquierdo);
        // Luego visita el subárbol derecho
        recorridoPostorder(nodo.derecho);
        // Finalmente imprime el dato del nodo
        System.out.print(nodo.dato + " ");
    }

    // Método para iniciar el recorrido inorder desde la raíz
    public void inorder() {
        recorridoInorder(raiz);
    }

    // Método para iniciar el recorrido preorder desde la raíz
    public void preorder() {
        recorridoPreorder(raiz);
    }

    // Método para iniciar el recorrido postorder desde la raíz
    public void postorder() {
        recorridoPostorder(raiz);
    }

    // Método para calcular la altura del árbol
    public int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = altura(nodo.izquierdo);
        int alturaDerecha = altura(nodo.derecho);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // Método para verificar si el árbol está balanceado
    public boolean estaBalanceado() {
        return estaBalanceado(raiz);
    }

    private boolean estaBalanceado(Nodo nodo) {
        if (nodo == null) {
            return true;
        }
        int alturaIzquierda = altura(nodo.izquierdo);
        int alturaDerecha = altura(nodo.derecho);
        if (Math.abs(alturaIzquierda - alturaDerecha) > 1) {
            return false;
        }
        return estaBalanceado(nodo.izquierdo) && estaBalanceado(nodo.derecho);
    }

    // Método principal con ejemplo de todos los recorridos y verificación de balance
    public static void main(String[] args) {
        // Crear un árbol binario simple
        ArbolBinario arbol = new ArbolBinario();
        arbol.raiz = new Nodo(1);
        arbol.raiz.izquierdo = new Nodo(2);
        arbol.raiz.derecho = new Nodo(3);
        arbol.raiz.izquierdo.izquierdo = new Nodo(4);
        arbol.raiz.izquierdo.derecho = new Nodo(5);

        // Mostrar el recorrido inorder
        System.out.println("Recorrido inorder del árbol:");
        arbol.inorder();
        System.out.println();

        // Mostrar el recorrido preorder
        System.out.println("Recorrido preorder del árbol:");
        arbol.preorder();
        System.out.println();

        // Mostrar el recorrido postorder
        System.out.println("Recorrido postorder del árbol:");
        arbol.postorder();
        System.out.println();

        // Verificar balance
        boolean balanceado = arbol.estaBalanceado();
        System.out.println("¿El árbol está balanceado? " + balanceado);
        int alturaArbol = arbol.altura(arbol.raiz);
        System.out.println("Altura del árbol: " + alturaArbol);
    }
}
