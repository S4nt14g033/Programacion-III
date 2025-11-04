// Clase para verificar el balance del árbol
public class BalanceArbol {
    // Método para calcular la altura del árbol
    public static int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = altura(nodo.izquierdo);
        int alturaDerecha = altura(nodo.derecho);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // Método para verificar si el árbol está balanceado
    public static boolean estaBalanceado(Nodo raiz) {
        if (raiz == null) {
            return true;
        }
        int alturaIzquierda = altura(raiz.izquierdo);
        int alturaDerecha = altura(raiz.derecho);
        if (Math.abs(alturaIzquierda - alturaDerecha) > 1) {
            return false;
        }
        return estaBalanceado(raiz.izquierdo) && estaBalanceado(raiz.derecho);
    }


}
