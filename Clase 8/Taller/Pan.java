package Taller;

import java.util.LinkedList;
import java.util.Queue;

public class Pan {
    public static boolean panSimilar(Queue<String> S1, Queue<String> S2){
        if (S1.isEmpty() || S2.isEmpty()) {
            return false;
        }

        String panInicio1 = S1.peek();
        String panInicio2 = S2.peek();

        String panFinal1 = null , panFinal2 = null;
        for (String Ingrediente : S1) {
            panFinal1 = Ingrediente;
        }
        for (String Ingrediente : S2) {
            panFinal2 = Ingrediente;
        }

        return panInicio1.equals(panInicio2) && panFinal1.equals(panFinal2);
    }
    
     public static void main(String[] args) {
            
            Queue<String> pan1 = new LinkedList<>();
            pan1.add("pan blanco");
            pan1.add("lechuga");
            pan1.add("pan blanco");

            Queue<String> pan2 = new LinkedList<>();
            pan2.add("pan blanco");
            pan2.add("tomate");
            pan2.add("pan blanco");

            System.out.println(panSimilar(pan1, pan2)); // true

            Queue<String> pan3 = new LinkedList<>();
            pan3.add("pan integral");
            pan3.add("queso");
            pan3.add("pan integral");

            Queue<String> pan4 = new LinkedList<>();
            pan4.add("pan blanco");
            pan4.add("queso");
            pan4.add("pan integral");

            System.out.println(panSimilar(pan3, pan4)); // false
            
        
        }

    
}