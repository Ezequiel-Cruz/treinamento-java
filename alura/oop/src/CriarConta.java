
public class CriarConta {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta();
        Conta segundaConta = new Conta();

        primeiraConta.saldo = 200;

        System.out.println("Primeira Conta: " + primeiraConta.saldo);

        primeiraConta.saldo += 120;
        System.out.println("Primeira Conta Saldo Atualizado: " + primeiraConta.saldo);

        segundaConta.saldo = 550;
        segundaConta.deposita(100);

        System.out.println("Segunda conta: " + segundaConta.saldo);

        primeiraConta.saca(50);
        System.out.println("Saldo da conta apos saque: " + primeiraConta.saldo);
    }
}
