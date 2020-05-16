
public class CriarConta {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta();
        Conta segundaConta = new Conta();

        primeiraConta.saldo = 200;

        System.out.println("Primeira Conta: " + primeiraConta.saldo);

        primeiraConta.saldo += 120;
        System.out.println("Primeira Conta Saldo Atualizado: " + primeiraConta.saldo);

        segundaConta.saldo = 550;
        System.out.println("Segunda conta: " + segundaConta.saldo);

        System.out.println("Agencia: " + primeiraConta.agencia );
        System.out.println("Agencia: " + segundaConta.agencia );


    }
}
