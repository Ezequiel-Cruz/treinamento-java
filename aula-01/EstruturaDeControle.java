public class EstruturaDeControle {
    
    public static void main(String[] args) {
        int numero1 = 10;

        if (numero1 % 2 == 0) {
            System.out.println("O número informado é par!");
        } else {
            System.out.println("O número informado não é par!");
        }

        int numero2 = 3;

        switch(numero2) {
            case 0:
                System.out.println("O numero é zero");
                break;
            case 1:
                System.out.println("O numero é um");
                break;
            case 2:
                System.out.println("O numero é dois");
                break;
            case 3:
                System.out.println("O numero é três");
                break;
            default:
                System.out.println("O numero não foi mapeado");
                break;
        }
    }
}
