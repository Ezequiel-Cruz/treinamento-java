public class EstruturaDeRepeticao {
    public static void main(String[] args) {
        int ate = 10;
        int contador = 0;
        while(contador <= ate) {
            System.out.println("O número atual com while é: " + contador);
            contador++;
        }

        for(int contador2 = 0; contador2 <= ate; contador2++) {
            System.out.println("O número atual com for é: " + contador2);
        }
    }
}