import java.util.LinkedList;
import java.util.Queue;

public class Tel {
    
    public static String formatoTelefono(int[] digitos){

        if (digitos == null || digitos.length !=10) {

            System.out.println("deben haber exactamente 10 digitos");
            return "";
            
        }

        Queue<Integer> cola = new LinkedList<>();
        for (int d : digitos){
            cola.add(d);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("(");
        for (int i = 0; i<3; i++) sb.append(cola.poll());
        sb.append(")");
        for (int i = 0; i<3; i++) sb.append(cola.poll());
        sb.append("-");
        for (int i = 0; i<4; i++) sb.append(cola.poll());

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] ejemplo1 = {1,2,3,4,5,6,7,8,9,0};
        int[] ejemplo2 = {3,0,0,1,4,5,6,7};
        int[] ejemplo3 = {3,0,0,6,2,1,9,5,3,3};
        int[] ejemplo4 = {3,5,4,6,7,8,9,4,5,6,4,6};

        System.out.println(formatoTelefono(ejemplo1));
        System.out.println(formatoTelefono(ejemplo2));
        System.out.println(formatoTelefono(ejemplo3));
        System.out.println(formatoTelefono(ejemplo4));
    }
}
