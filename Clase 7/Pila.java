import java.util.Stack;

public class Pila {
    public static void main(String[] args) {
        //creacion de la pila
         Stack<Integer> pila = new Stack<>();

         //insertar elementos en la pila
         pila.push(8);
         pila.push(4);
         pila.push(9);
         pila.push(10);
         pila.push(6);

         //imprimir la pila
         System.out.println(pila);

         //mostrar el elemento que esta en el tope de la pila sin removerlo
         System.out.println("Tope de la pila: " + pila.peek());

         //remover el elemento que esta en el tope de la pila
         System.out.println("Elemento removido del tope de la pila " + pila.pop());

         //imprimir la pila
         System.out.println(pila);
    }
    
}