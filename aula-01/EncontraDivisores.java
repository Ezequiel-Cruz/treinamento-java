public class EncontraDivisores {
    
    public static void main(String[] args) {
        int numero = 24;

        for(int i = numero; i > 0; i--) {
            if (numero % i == 0) {
                System.out.println("Numero divisor Decrescente " + i);
            }
        }

        for(int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                System.out.println("Numero divisor Crescente " + i);
            }
        }
    }
}