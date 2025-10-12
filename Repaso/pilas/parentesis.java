package pilas;

import java.util.Stack;

public class parentesis {
   public static void main(String[] args) {
     String[] signos = {"(","(",")",")", "("};

        Stack<String> pilaSignos = new Stack<>();

    

        int tam = pilaSignos.size();
        int cont1 = 0, cont2 = 0;
        boolean balanceado = true;

        for(int i = 0; i < signos.length; i++){
            pilaSignos.push(signos[i]);
        }
        

        for (int i = 0; i < signos.length; i++){
            if (pilaSignos.peek().equals("(")){
                cont1 += 1;
            } else {
                cont2 += 1;
            }
            pilaSignos.pop();
        }

        if (cont1 == cont2){
            balanceado = true;
        } else {
            balanceado = false;
        }

        System.out.println("Los paréntesis están balanceados: " + balanceado);

    }
}
