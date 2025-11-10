

public class QuickSort {
    // Método para ordenar un arreglo usando el algoritmo QuickSort
    public static void ordenarQuickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto) { // Si hay más de un elemento
            int indicePivote = particionar(arreglo, bajo, alto); // Particionamos el arreglo
            ordenarQuickSort(arreglo, bajo, indicePivote - 1); // Ordenamos la parte izquierda
            ordenarQuickSort(arreglo, indicePivote + 1, alto); // Ordenamos la parte derecha
        }
    }

    // Método auxiliar para particionar el arreglo
    private static int particionar(int[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto]; // Elegimos el último elemento como pivote
        int i = (bajo - 1); // Índice del elemento más pequeño
        for (int j = bajo; j < alto; j++) { // Recorremos el arreglo
            if (arreglo[j] < pivote) { // Si el elemento actual es menor que el pivote
                i++; // Incrementamos el índice
                // Intercambiamos elementos
                int temporal = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temporal;
            }
        }
        // Intercambiamos el pivote con el elemento en i+1
        int temporal = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temporal;
        return i + 1; // Retornamos el índice del pivote
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] arreglo = {10, 7, 8, 9, 1, 5}; // Arreglo de ejemplo desordenado
        System.out.println("Ejemplo de QuickSort");
        System.out.println("Arreglo original:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();

        ordenarQuickSort(arreglo, 0, arreglo.length - 1); // Llamamos al método de ordenamiento

        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
