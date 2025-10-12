package colas;

import java.util.*;

public class Banco {
    public static void main(String[] args) {
        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("Cliente 1");
        filaBanco.add("Cliente 2");
        filaBanco.add("Cliente 3");
        filaBanco.add("Cliente 4");

        while (!filaBanco.isEmpty()) {
            System.out.println("Atendiendo a: " + filaBanco.poll());
        }
    }
}
