import java.util.Scanner;

public class Fatorial {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int fatorial = 1;

        System.out.print("Entre com o numero: ");
	    int entrada = sc.nextInt();
	    System.out.println("");

        for (int i = 1; i <= entrada; i++) {
        
            fatorial *= i;			
            System.out.println( i + "!= " + fatorial);	
        }

        System.out.println(fator(1));	
    }

    public static int fator(int n) {
        if (n > 1) {
            return n * fator(n-1);
        } else {
            return 1;
        }
    }
}