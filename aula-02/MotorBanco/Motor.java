
class Usuario{ 
    private String nome;
    private Conta conta;

    Usuario(String nome) {
        this.nome = nome;
    }

    public void criarConta() {
        this.conta = new Conta();
    }

    public Conta obterConta() {
        return this.conta;
    }
}

class Conta{
    private Double valor;

    public void depositar(Double valor) { 
        this.valor += valor;
    }
    public Double sacar(Double valor){
        this.valor -= valor;

        return valor;
    }
    public void transferir(Double valor, Conta destino){
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void verSaldo() {
        System.out.println("Valor em conta: " + this.valor);
    }

    Conta() {
        this.valor = 0.0;
    }

}

public class Motor {

    public static void main(String[] args) {
        //João
        Usuario joao = new Usuario("joao");
        //Maria
        Usuario maria = new Usuario("maria");

        // Operação
        joao.criarConta();
        maria.criarConta();

        joao.obterConta().depositar(50.0);

        maria.obterConta().sacar(10.0);

        joao.obterConta().transferir(10.0, maria.obterConta());

        System.out.println("João");
        joao.obterConta().verSaldo();

        System.out.println("Maria");
        maria.obterConta().verSaldo();
    }
}