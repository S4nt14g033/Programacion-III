import java.util.Stack;

public class OperacionesPila {

    Stack<String> pilasignos;
    
    public boolean validarParentesis(String[] s){
        boolean flag = false;

        pilasignos = new Stack<>();


        //almacenar en la pila el arreglo de signos

        for(int i = 0; i<s.length; i++){
            pilasignos.push(s[i]);
        }

        int tam = pilasignos.size();
        int cont1 = 0, cont2 = 0;
        //recorrer la pila

        for(int i=0; i< tam; i++){
            if(pilasignos.peek().equals("(")){
                cont1 += 1;
            }else{
                cont2 += 1;
            }
            pilasignos.pop();
        }
        return cont1 == cont2 ? true: false;

        /*Tarea
         * implementar los metodos de la clase vector
         * realizar ejemplos para validar su funcionamiento
         * todos los elementos
         */
    }
}
