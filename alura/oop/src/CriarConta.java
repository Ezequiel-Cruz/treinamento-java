
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

        contaJoao.setTitular(joao);
        contaLucas.setTitular(lucas);
        contaLuiz.setTitular(luiz);

        contaJoao.deposita(200);
        contaLucas.deposita(550);
        contaLuiz.deposita(1900);

        System.out.println(contaJoao.getTitular().nome);
        System.out.println("Saldo: " + contaJoao.getSaldo());

        System.out.println(contaLucas.getTitular().nome);
        System.out.println("Saldo: " + contaLucas.getSaldo());

        System.out.println(contaLuiz.getTitular().nome);
        System.out.println("Saldo: " + contaLuiz.getSaldo());

        System.out.println("-------------------------");
        System.out.println("Saldo após operações: ");

        contaJoao.deposita(300);
        contaLucas.deposita(200);
        contaLuiz.deposita(200);

        contaLucas.saca(20);

        contaLuiz.transfere(100, contaJoao);

        System.out.println(contaJoao.getTitular().nome);
        System.out.println("Saldo: " + contaJoao.getSaldo());
        System.out.println("Profissão: " + contaJoao.getTitular().profissao);

        System.out.println(contaLucas.getTitular().nome);
        System.out.println("Saldo: " + contaLucas.getSaldo());
        System.out.println("Profissão: " + contaLucas.getTitular().profissao);

        System.out.println(contaLuiz.getTitular().nome);
        System.out.println("Saldo: " + contaLuiz.getSaldo());
        System.out.println("Profissão: " + contaLuiz.getTitular().profissao);

    }
}
