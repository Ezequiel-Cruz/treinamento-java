package com.mycompany.app.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Conta {

    protected List<Transacao> transacoes;

    protected Double adicionarTransacao(Double valor) {

        Transacao transacao = new Transacao(valor, new Date());
        transacoes.add(transacao);
        return valor;
    }

    public void depositar(Double valor) {

        this.adicionarTransacao(valor);
    }

    public Double sacar(Double valor) {

        return this.adicionarTransacao(-valor);
    }

    public void transferir(Double valor, Conta destino) {

        this.sacar(valor);
        destino.depositar(valor);
    }

    public Double obterSaldo() {

        return Transacao.obterSaldo(this.transacoes);
    }

    public void verSaldo() {

        System.out.println("Valor em conta: " + this.obterSaldo());
    }

    Conta() {

        this.transacoes = new ArrayList<>();
    }

    public static Conta instanciaConta(String tipoConta) throws TipoDeContaInvalida {
        if (tipoConta.equals(ContaCorrente.class.getName())) {
            return new ContaCorrente();
        } else if (tipoConta.equals(ContaPoupanca.class.getName())) {
            return new ContaPoupanca();
        } else if (tipoConta.equals(ContaInvestimento.class.getName())) {
            return new ContaInvestimento();
        } else {
            throw new TipoDeContaInvalida();
        }
    }
}
