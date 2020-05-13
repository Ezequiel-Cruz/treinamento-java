public class Funcoes {
    
    public static void main(String[] args){
        oiMundo();

        System.out.println("Soma de 1 e 3: " + soma(1,3));
    }

    public static void oiMundo() {
        System.out.println("Oi mundo java!");
    }

    public static int soma(int a, int b){
        return a + b;
    }
}