
public class CriarConta {
    public static void main(String[] args) {
        Conta joao = new Conta();
        Conta lucas = new Conta();
        Conta luiz = new Conta();

        joao.saldo = 200;

        System.out.println("Primeira Conta: " + joao.saldo);

        joao.saldo += 120;
        System.out.println("Primeira Conta Saldo Atualizado: " + joao.saldo);

        lucas.saldo = 550;
        lucas.deposita(100);

        System.out.println("Segunda conta: " + lucas.saldo);

        joao.saca(50);
        System.out.println("Saldo da conta apos saque: " + joao.saldo);

        luiz.deposita(1000);
        luiz.transfere(300, joao);

        System.out.println("Saldo Luiz: " + luiz.saldo);
        System.out.println("Saldo Lucas: " + lucas.saldo);
        System.out.println("Saldo João: " + joao.saldo);
    }
}
