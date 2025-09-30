import java.util.LinkedList;
import java.util.Queue;

public class Orden {
    
    public static int orden (int[] arreglo){

        Queue<Integer> cola = new LinkedList<>();

        for (int numero : arreglo) {
            cola.offer(numero);
        }

        int max1 = -10000000;
        int max2 = -10000000;

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            if (actual > max1) {
                max2 = max1;
                max1 = actual;
            } else if (actual > max2 && actual< max1) {
                max2 = actual;
            } else if (actual == max1 && max2< max1) {
                max2 = actual;
            }
        }
        return max2;
    }

    public static void main(String[] args) {
        int[] arreglo1 = {10, 40, 30, 20, 50};
        int[] arreglo2 = {5, 5, 5, 5, 9};
        int[] arreglo3 = {-3, -1, -7, -2};

        System.out.println(orden(arreglo1));
        System.out.println(orden(arreglo2));
        System.out.println(orden(arreglo3));
    }
}
