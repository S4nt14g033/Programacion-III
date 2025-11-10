

public class Insercion {
    // Método para ordenar un arreglo usando el algoritmo de inserción
    public static void ordenarInsercion(int[] arreglo) {
        int n = arreglo.length; // Obtenemos la longitud del arreglo
        for (int i = 1; i < n; i++) { // Empezamos desde el segundo elemento
            int clave = arreglo[i]; // Tomamos el elemento actual como clave
            int j = i - 1; // Índice del elemento anterior

            // Movemos los elementos mayores que la clave una posición adelante
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j]; // Desplazamos el elemento
                j = j - 1; // Decrementamos el índice
            }
            arreglo[j + 1] = clave; // Insertamos la clave en su posición correcta
        }
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] arreglo = {12, 11, 13, 5, 6}; // Arreglo de ejemplo desordenado
        System.out.println("Ejemplo de Inserción");
        System.out.println("Arreglo original:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();

        ordenarInsercion(arreglo); // Llamamos al método de ordenamiento

        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
