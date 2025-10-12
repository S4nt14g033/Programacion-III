package arreglos;
public class minMax {
    public static void main(String[] args) {
        int numeros[] = {3,5,7,2,8,1};
        int min = numeros[0];
        int max = numeros[0];

        for ( int i = 0; i < numeros.length; i++){
            if (numeros[i] > max) {
                max = numeros[i];   
            }
            if (numeros[i] < min) {
            min = numeros[i];
            }
        }

        System.out.println("El valor máximo es: " + max);
        System.out.println("El valor mínimo es: " + min);

    } 
}
