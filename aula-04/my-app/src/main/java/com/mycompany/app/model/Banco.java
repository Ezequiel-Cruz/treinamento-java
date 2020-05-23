package com.mycompany.app.model;

import java.util.HashMap;
import java.util.Map;

interface IBanco {
    public void criarConta(Usuario usuario, String tipo);
    public void verTodosOsSaldos();
    public void depositar(Double valor, Usuario usuario, String tipo);
    public void transferir(Double valor, Usuario origem, String tipoOrigem, Usuario destino, String tipoDestino);
}

public class Banco {

    private Map<Usuario,Map<String,Conta>> mapaUsuarioContas;

    public Banco(){

       this.mapaUsuarioContas = new HashMap();
    }

    public void criarConta(Usuario usuario, String tipo){
        try {

            Conta novaConta = Conta.instanciaConta(tipo);

            if (this.mapaUsuarioContas.containsKey(usuario)) {
                this.mapaUsuarioContas.get(usuario).put(tipo, novaConta);
            } else {
                Map<String, Conta> contas = new HashMap<>();
                contas.put(tipo, novaConta);
                this.mapaUsuarioContas.put(usuario, contas);
            }

        } catch (TipoDeContaInvalida e) {
            System.out.println("Tipo de conta inválido para este usuário.");
        }
    }

    public void verTodosOsSaldos() {
        for(Usuario u: this.mapaUsuarioContas.keySet()) {
            System.out.println(u.obterNome()); // Trazer o nome da conta
            Map<String, Conta> tiposDeContaUsuario = this.mapaUsuarioContas.get(u);
            for (String tipoConta : tiposDeContaUsuario.keySet()) {
                System.out.println(tipoConta);
                tiposDeContaUsuario.get(tipoConta).verSaldo();
            }
            System.out.println("-------------------------");
        }
    }

    public void depositar(Double valor, Usuario usuario, String tipo) {
        Conta conta = this.obterContaApartirUsuario(tipo, usuario);

        conta.depositar(valor);
    }

    public Double sacar(Double valor, Usuario usuario, String tipo) {
        Conta conta = this.obterContaApartirUsuario(tipo, usuario);

        try {
            conta.sacar(valor);
        } catch (java.lang.NullPointerException e) {
            System.out.println("Ocorreu um erro inesperado: "+ usuario.obterNome());
            // throw e;
        }

        return valor;
    }

    public void transferir(Double valor, Usuario origem, String tipoOrigem, Usuario destino, String tipoDestino) {
        Conta contaOrigem = this.obterContaApartirUsuario(tipoOrigem, origem);//this.mapaUsuarioConta.get(origem);
        Conta contaDestino = this.obterContaApartirUsuario(tipoDestino, destino);//this.mapaUsuarioConta.get(destino);
        contaOrigem.transferir(valor, contaDestino);
    }

    private Conta obterContaApartirUsuario(String tipo, Usuario usuario) {
        Map<String, Conta> tiposDeContaUsuario = this.mapaUsuarioContas.get(usuario);
        Conta conta = tiposDeContaUsuario.get(tipo);

        return conta;
    }
}
