

public class MergeSort {
    // Método para ordenar un arreglo usando el algoritmo MergeSort
    public static void ordenarMergeSort(int[] arreglo) {
        if (arreglo.length < 2) { // Si el arreglo tiene menos de 2 elementos, ya está ordenado
            return;
        }
        int medio = arreglo.length / 2; // Encontramos el punto medio
        int[] izquierda = new int[medio]; // Creamos arreglo para la mitad izquierda
        int[] derecha = new int[arreglo.length - medio]; // Creamos arreglo para la mitad derecha

        // Copiamos los elementos a los subarreglos
        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }

        // Llamadas recursivas para ordenar las mitades
        ordenarMergeSort(izquierda);
        ordenarMergeSort(derecha);

        // Mezclamos las mitades ordenadas
        mezclar(arreglo, izquierda, derecha);
    }

    // Método auxiliar para mezclar dos subarreglos ordenados
    private static void mezclar(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0; // Índices para los arreglos
        // Mezclamos mientras haya elementos en ambos subarreglos
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) { // Si el elemento de izquierda es menor o igual
                arreglo[k++] = izquierda[i++]; // Lo ponemos en el arreglo principal
            } else {
                arreglo[k++] = derecha[j++]; // Ponemos el de derecha
            }
        }
        // Copiamos los elementos restantes de izquierda
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }
        // Copiamos los elementos restantes de derecha
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] arreglo = {12, 11, 13, 5, 6, 7}; // Arreglo de ejemplo desordenado
        System.out.println("Ejemplo de MergeSort");
        System.out.println("Arreglo original:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();

        ordenarMergeSort(arreglo); // Llamamos al método de ordenamiento

        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
