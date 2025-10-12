package pilas;

import java.util.Stack;

public class invertirCadena {
    public static void main(String[] args) {
        String cadena = "Hola Mundo";
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < cadena.length(); i++){ // recorremos la cadena
            pila.push(cadena.charAt(i)); // agregamos cada caracter a la pila
        }

        String invertida = " "; // cadena vacía para ir agregando los caracteres invertidos
        while (!pila.empty()) { // mientras la pila no esté vacía
            invertida += pila.pop(); // sacamos el caracter de la pila y lo agregamos a la cadena invertida
        }

        System.out.println("texto original " + cadena);
        System.out.println("texto invertido " + invertida);
    }
}
