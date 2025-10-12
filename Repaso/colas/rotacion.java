package colas;

import java.util.*;

public class rotacion {
    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();

        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(5);
        
        int rotacion = 2; //numero de rotaciones

        System.out.println("Cola original " + cola);

        for (int i = 0; i < rotacion; i++){
            int elemento = cola.remove(); //quitar el primero
            cola.add(elemento);//lo vuelve agregar como ultimo
        }

        System.out.println("Cola despues de rotar " + rotacion + " posiciones " + cola);

    }
}
