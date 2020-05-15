package br.com.motor.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Banco {
    private Map<Usuario, Conta> mapaUsuarioConta;

    public Banco(){
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
