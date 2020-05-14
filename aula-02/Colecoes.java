import java.util.ArrayList; //interface
import java.util.List; // Implementação da Interface

import java.util.Map; // Interface
import java.util.HashMap; // Implementação da Interface

public class Colecoes {

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList();

        lista.add(10);
        lista.add(15);
        lista.add(20);
        lista.add(30);

        for(Integer inteiro: lista) {
            System.out.println(inteiro);
        }

        
        List<Integer> lista = new ArrayList();

        lista.add(50);
        lista.add(33);
        lista.add(85);
        lista.add(99);

        for(Integer inteiro: lista) {
            System.out.println(inteiro);
        }

        Map<String, Integer> dicionario = new HashMap();

        dicionario.put("teste",10);

        System.out.println("Valor teste no dicionario: " + dicionario.get("teste"));
    }
}