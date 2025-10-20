//Parcial de Nicolas Santiago Niño Cardona
//Parcial B/II
//S441A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenColaMapa {

        static class ColaCircularEnteros {
        private int[] datos;
        private int cabeza;
        private int cola;
        private int tam;

            public ColaCircularEnteros(int capacidad) {
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
                datos [cola] = x;
                cola = (cola + 1) % datos.length;
                tam++;
            
            }

            public int desencolar() {
                if (estaVacia()) throw new IllegalStateException("Cola vacia");
                int v = datos[cabeza];
                cabeza = (cabeza + 1) % datos.length;
                tam--;
                return v;
            }
        }
    
        //calcular el balance de parentesis encolando +1 y -1
        public static int balanceConCola(String s ) {
            //todo: usar colaCircularEnteros para encolar y luego sumar
            ColaCircularEnteros cola = new ColaCircularEnteros(s.length());

            for(char c : s.toCharArray()){
                    //si "(" encola +1
                if (c == '(') {
                cola.encolar(1);
                }else {
                 //si ")" encola -1
                    cola.encolar(-1);
                }
            }
            //sumar los elementos de la cola, creando un contador
            int suma = 0;
            while(!cola.estaVacia()){
                suma+=cola.desencolar();
            }
            return suma;
        }
    

        //registra intentos por nombre en un mapa
        public static int registrarIntento(Map<String, Integer > intentos, String nombre) {
            //incrementar si existe o iniciar en 1 si no existe

            //verifica si el nombre existe dentro del mapa
            if (intentos.containsKey(nombre)) {
                //si existe incrementa el contador en 1
                int contadorActual = intentos.get(nombre);
                intentos.put(nombre, contadorActual + 1);
                return contadorActual + 1;
            }else {
                //si no existe inicia en 1
                intentos.put(nombre,1);
                return 1;
            }
            
        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese una cadena de parentesis:");
            String cadena = sc.nextLine();
            System.out.println("Balance de cola: " + balanceConCola(cadena));

            Map<String, Integer> intentos = new HashMap<String,Integer>();
            System.out.println("Intentos de Ana: " + registrarIntento(intentos, "Ana"));
            System.out.println("Intentos de Ana: " + registrarIntento(intentos, "Ana"));

            sc.close();
        }
    }  



