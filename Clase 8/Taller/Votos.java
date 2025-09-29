package Taller;

import java.util.LinkedList;
import java.util.Queue;

public class Votos {

    public static int contarVotos(int upvotes, int downvotes) {
        Queue<Integer> votos = new LinkedList<>();
        for (int i= 0; i<upvotes; i++) {
            votos.add(1); // Representa un upvote
        }

        for (int i= 0; i<downvotes; i++) {
            votos.add(-1); // Representa un downvote
        }

        int total = 0;
        while (!votos.isEmpty()) {
            total += votos.poll();
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(contarVotos(13, 0));
        System.out.println(contarVotos(2, 33));
        System.out.println(contarVotos(132, 132));
    }
}