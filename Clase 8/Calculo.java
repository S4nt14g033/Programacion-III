

import java.util.LinkedList;
import java.util.Queue;

public class Calculo {
    public static boolean comparar(int a, int b){
        Queue<Integer> cola = new LinkedList<>();
        cola.add(a);
        cola.add(b);

        int primero = cola.poll();
        int segundo = cola.poll();

        double raiz = Math.sqrt(primero);
        double raizCubica = Math.cbrt(segundo);

        double tolerancia = 0.01;

        return Math.abs(raiz-raizCubica) < tolerancia;
    }

    public static void main(String[] args) {
        System.out.println(comparar(4, 8));
        System.out.println(comparar(16, 48));
        System.out.println(comparar(9, 27));
    }
}
