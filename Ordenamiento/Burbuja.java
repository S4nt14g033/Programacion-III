

public class Burbuja {
    // Método para ordenar un arreglo usando el algoritmo de burbuja
    public static void ordenarBurbuja(int[] arreglo) {
        int n = arreglo.length; // Obtenemos la longitud del arreglo
        for (int i = 0; i < n - 1; i++) { // Recorremos el arreglo varias veces
            for (int j = 0; j < n - i - 1; j++) { // En cada pasada, comparamos elementos adyacentes
                if (arreglo[j] > arreglo[j + 1]) { // Si el elemento actual es mayor que el siguiente
                    // Intercambiamos los elementos
                    int temporal = arreglo[j]; // Guardamos el valor actual en una variable temporal
                    arreglo[j] = arreglo[j + 1]; // Ponemos el siguiente en la posición actual
                    arreglo[j + 1] = temporal; // Ponemos el temporal en la siguiente posición
                }
            }
        }
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] arreglo = {64, 34, 25, 12, 22, 11, 90}; // Arreglo de ejemplo desordenado
        System.out.println("Ejemplo de Burbuja");
        System.out.println("Arreglo original:");
        for (int num : arreglo) {
            System.out.print(num + " "); // Imprimimos cada elemento
        }
        System.out.println();

        ordenarBurbuja(arreglo); // Llamamos al método de ordenamiento

        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " "); // Imprimimos el arreglo ordenado
        }
    }
}
