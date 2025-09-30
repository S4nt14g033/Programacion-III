import java.util.*;

public class nombres {
    
    public static String nombres(List<String> nombres){
        Queue<String> cola = new LinkedList<>(nombres);
        List<Character> iniciales = new ArrayList<>();

        while (!cola.isEmpty()) {
            String nombre = cola.poll();
            if (nombre != null && !nombre.isEmpty()) {
                char inicial = Character. toUpperCase(nombre.charAt(0));
                iniciales.add(inicial);
            }
        }

        Collections.sort(iniciales);

        StringBuilder resultado = new StringBuilder();
        for (char c : iniciales){
            resultado.append(c);
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        List<String> ejemplo1 = Arrays.asList("Adam", "Sarah", "Malcolm");
        System.out.println(nombres(ejemplo1));

        List<String> ejemplo2 = Arrays.asList("bruce", "clark", "diana");
        System.out.println(nombres(ejemplo2));

        List<String> ejemplo3 = Arrays.asList("Zoe", "anna", "leo");
        System.out.println(nombres(ejemplo3)); 
    }
}
