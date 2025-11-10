
public class Seleccion {
    // Método para ordenar un arreglo usando el algoritmo de selección
    public static void ordenarSeleccion(int[] arreglo) {
        int n = arreglo.length; // Obtenemos la longitud del arreglo
        for (int i = 0; i < n - 1; i++) { // Recorremos el arreglo
            int indiceMinimo = i; // Asumimos que el mínimo está en la posición i
            for (int j = i + 1; j < n; j++) { // Buscamos el mínimo en el resto del arreglo
                if (arreglo[j] < arreglo[indiceMinimo]) { // Si encontramos un elemento menor
                    indiceMinimo = j; // Actualizamos el índice del mínimo
                }
            }
            // Intercambiamos el elemento mínimo con el elemento en la posición i
            int temporal = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temporal;
        }
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] arreglo = {64, 25, 12, 22, 11}; // Arreglo de ejemplo desordenado

        System.out.println("Ejemplo de Selección");
        System.out.println("Arreglo original:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();

        ordenarSeleccion(arreglo); // Llamamos al método de ordenamiento

        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
