package arreglos;
public class ArregloInverso {
     public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};

        // TODO: invierte el arreglo sin usar librerías
        // Pista: intercambia el primer elemento con el último, el segundo con el penúltimo, etc.
        for (int i = 0; i < numeros.length / 2; i++) { // tamaño del arreglo entre 2 porque cambiamos dos elementos a la vez
            int temp = numeros[i]; // guardamos el valor del primer elemento en una variable temporal
            numeros[i] = numeros[numeros.length - 1 - i]; // asignamos el valor del último elemento al primero
            numeros[numeros.length - 1 - i] = temp;// asignamos el valor de la variable temporal al último elemento
        }

        // Imprimir resultado
        for (int n : numeros) {
            System.out.print(n + " ");
        }
    }    
}
