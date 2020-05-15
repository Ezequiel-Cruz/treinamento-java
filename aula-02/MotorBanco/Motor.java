import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap; 

class Usuario{ 
    private String nome;

    Usuario(String nome) {
        this.nome = nome;
    }

    public String obterNome() {
        return this.nome;
    }
}

class Conta {
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

class Banco {
    private Map<Usuario, Conta> mapaUsuarioConta;

    Banco(){
        this.mapaUsuarioConta = new HashMap();
    }

    public void criarConta(Usuario usuario) {
        Conta novaConta = new Conta();

        this.mapaUsuarioConta.put(usuario, novaConta);
    }

    public void verTodosOsSaldos() {
        for(Usuario u: this.mapaUsuarioConta.keySet()) {
            System.out.println(u.obterNome() + ":");
            this.mapaUsuarioConta.get(u).verSaldo();
            System.out.println("------------------------");
        }
    }

    public void depositar(Double valor, Usuario usuario) { 
        Conta conta = this.mapaUsuarioConta.get(usuario);
        conta.depositar(valor);
    }
    
    public Double sacar(Double valor, Usuario usuario) {
        Conta conta = this.mapaUsuarioConta.get(usuario);
        conta.sacar(valor);
        return valor;
    }

    public void transferir(Double valor, Usuario origem, Usuario destino) {
        Conta contaOrigem = this.mapaUsuarioConta.get(origem);
        Conta contaDestino = this.mapaUsuarioConta.get(destino);
        contaOrigem.transferir(valor, contaDestino);
    }
}

public class Motor {

    public static void main(String[] args) {
        //João
        Usuario joao = new Usuario("joao");
        //Maria
        Usuario maria = new Usuario("maria");

        Banco banco = new Banco();

        banco.criarConta(joao);
        banco.criarConta(maria);
    
        banco.depositar(50.0, joao);
        banco.sacar(10.0, maria);
        banco.transferir(10.0, joao, maria);

        banco.verTodosOsSaldos();
    }
}