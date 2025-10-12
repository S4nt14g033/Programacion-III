package arreglos;

public class suma {
    public static void main(String[] args) {
        int numeros[] = {5,9,7,54,6,3,1,42};
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        System.out.println("La suma de los elementos del arreglo es: " + suma);
    }


}
