 public class nodoArbol {
    //1 . visitar raiz
    //2 . recorrer subarbol izquierdo
    //3 . recorrer subarbol derecho
    private nodoArbol Izquierda;
    private nodoArbol derecha;
    private int valor;
 
    public nodoArbol(int valor) {
        this.valor = valor;
        this.Izquierda = null;
        this.derecha = null;
   
    }
    //getters
 
    public int getValor() {
        return valor;
    }
    public nodoArbol getizquierda() {
        return Izquierda;
    }
    public nodoArbol getderecha() {
        return derecha;
    }
 
    //setters
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setderecha(nodoArbol Izquierda) {//asigna un nodo al hijo izquierdo
        this.Izquierda = Izquierda;
    }
    public void setizquierda(nodoArbol derecha) {//asigna un nodo al hijo derecho
        this.derecha = derecha;
    }
 
}
 
 class ArbolBinario {
    private nodoArbol raiz;
 
    public ArbolBinario() {
        this.raiz = null;
    }
 
    public nodoArbol getRaiz() {
        return raiz;
    }
 
    public void setRaiz(nodoArbol raiz) {
        this.raiz = raiz;
    }
 
   
   
    public void recorridoPreorden () {
        System.out.println("Recorrido en Preorden: ");
        recorrido(raiz);// llama al metodo recursivo recorrido pasandole la raiz como punto de inicio
    }
     private void recorrido(nodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        System.out.println(nodo.getValor());// visita el nodo actual
        recorrido(nodo.getizquierda());// recorre el subarbol izquierdo
        recorrido(nodo.getderecha());// recorre el subarbol derecho
        //se detiene cuando encuentra un nodo nulo
    }
   
    public void insertar(int valor) {// recibe el nuevo valor y llama al  metodo recursivo insertarValor
        raiz = insertarValor(raiz, valor);// raiz es el punto de partida
    }
    public nodoArbol insertarValor(nodoArbol nodo, int valor) {
        if (nodo == null) {// cuando encuetra un espacio vacio crea un nuevo nodo y lo enlaza al padre
            return new nodoArbol(valor);
        }
    //decide si insertar a la izquierda o derecha
        if (valor < nodo.getValor()) {
            nodo.setizquierda(nodo);(insertarValor(nodo.getizquierda(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setderecha(insertarValor(nodo.getderecha(), valor));
        }
        return nodo;
    }
 
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(42);
        arbol.insertar(9);
        arbol.insertar(10);
        arbol.insertar(18);
        arbol.insertar(34);
        arbol.insertar(49);
        arbol.insertar(33);
        arbol.insertar(21);
 
      arbol.recorridoPreorden();
    }
}