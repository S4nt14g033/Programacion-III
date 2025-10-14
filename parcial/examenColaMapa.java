package Parcial;

//Parcial de Nicolas Santiago Niño Cardona
//Parcial B/II

import java.util.*;

public class ExamenColaMapa {

        static class colaCircularEnteros {
        private int[] datos;
        private int cabeza;
        private int cola;
        private int tam;
            
        public colaCircularEnteros(int capacidad) {
            datos = new int[capacidad];
            cabeza = 0;
            cola = 0;
            tam = 0;
        }

        public boolean estaVacia() {
            return tam == 0;
        }
        public boolean estaLlena() {
            return tam == datos.length;
        }

        public void encolar(int x){
            if (estaLlena()) throw new IllegalStateException("Cola llena");
            datos[cabeza] = x;
            cabeza = (cabeza + 1) % datos.length;
            tam++;
            
        }

        public int desencolar(){
            if (estaVacia()) throw new IllegalStateException("Cola vacia");
            int v = datos[cola];
            cola = (cola + 1) % datos.length;
            tam--;
            return v;
        }

    
        //calcular el balance de parentesis encolando +1 y -1
        public static int balanceConCola(String[] s ) {
            //todo: usar colaCircularEnteros para encolar y luego sumar
            colaCircularEnteros cola = new colaCircularEnteros(s.length);

            for(char c : s.toCharArray()){
                //si "(" encola +1
            } if (c == "(") {
                cola.encolar(1);
            }else {
                //si ")" encola -1
                cola.encolar(-1);
            }


            return cont1 - cont2;
        }

        //registra intentos por nombre en un mapa
        public static int registrarIntento(Map<String, Integer> Intentos, String nombre) {
            //incrementar si existe o iniciar en 1 si no existe
            return 0;
        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String cadena = sc.nextLine();
            System.out.println("Balance de cola: " + balanceConCola(cadena.split("")));

            Map<String, Integer> intentos = new HashMap<String,Integer>();
            System.out.println("Intentos de Ana: " + registrarIntento(intentos, "Ana"));
            System.out.println("Intentos de Ana: " + registrarIntento(intentos, "Ana"));

            sc.close();
        }
    }  
}


