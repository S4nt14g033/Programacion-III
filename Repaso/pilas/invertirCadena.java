package pilas;

import java.util.Stack;

public class invertirCadena {
    public static void main(String[] args) {
        String cadena = "Hola Mundo";
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < cadena.length(); i++){
            pila.push(cadena.charAt(i));
        }

        String invertida = " ";
        while (!pila.empty()) {
            invertida += pila.pop();
        }

        System.out.println("texto original " + cadena);
        System.out.println("texto invertido " + invertida);
    }
}
