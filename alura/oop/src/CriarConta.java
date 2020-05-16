
public class CriarConta {
    public static void main(String[] args) {
        Cliente joao = new Cliente();
        Cliente lucas = new Cliente();
        Cliente luiz = new Cliente();
        
        joao.nome = "João Costa Silva";
        joao.cpf = "332.331.231-98";
        joao.profissao = "Analista de Contas";

        lucas.nome = "Lucas Alburquerque";
        lucas.cpf = "111.111.111-11";
        lucas.profissao = "Gerente de Produção";

        luiz.nome = "Luiz de Bragança";
        luiz.cpf = "515.151.515-00";
        luiz.profissao = "Programador";

        Conta contaJoao = new Conta();
        Conta contaLucas = new Conta();
        Conta contaLuiz = new Conta();

        contaJoao.titular = joao;
        contaLucas.titular = lucas;
        contaLuiz.titular = luiz;

        contaJoao.saldo = 200;
        contaLucas.saldo = 550;
        contaLuiz.saldo = 1900;

        System.out.println(contaJoao.titular.nome);
        System.out.println("Saldo: " + contaJoao.saldo);

        System.out.println(contaLucas.titular.nome);
        System.out.println("Saldo: " + contaLucas.saldo);

        System.out.println(contaLuiz.titular.nome);
        System.out.println("Saldo: " + contaLuiz.saldo);

        System.out.println("-------------------------");
        System.out.println("Saldo após operações: ");

        contaJoao.deposita(300);
        contaLucas.deposita(200);
        contaLuiz.deposita(200);

        contaLucas.saca(20);

        contaLuiz.transfere(100, contaJoao);

        System.out.println(contaJoao.titular.nome);
        System.out.println("Saldo: " + contaJoao.saldo);

        System.out.println(contaLucas.titular.nome);
        System.out.println("Saldo: " + contaLucas.saldo);

        System.out.println(contaLuiz.titular.nome);
        System.out.println("Saldo: " + contaLuiz.saldo);

    }
}
