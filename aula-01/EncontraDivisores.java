public class EncontraDivisores {
    
    public static void main(String[] args) {
        int numero = 24;

        for(int i = 1; i <= numero; i++) {
            if (i % 2 == 1) {
                System.out.println("Numero impares: " + i);
            }
        }
    }
}
