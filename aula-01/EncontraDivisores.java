public class EncontraDivisores {
    
    public static void main(String[] args) {
        int numero = 24;

       int numeroDivisores = 0;
        for(int i = numero; i >= 1; i--) {
            if (numero % i == 0) {
                System.out.println("Numero divisor " + i);

                numeroDivisores++;
                if (numeroDivisores == 3) {
                    break;
                }
            }
        }
    }
}