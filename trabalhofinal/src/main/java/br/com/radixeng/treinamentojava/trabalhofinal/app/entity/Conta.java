package br.com.radixeng.treinamentojava.trabalhofinal.app.entity;


import br.com.radixeng.treinamentojava.trabalhofinal.app.exception.TipoDeContaInvalida;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static Conta instanciaConta(TipoDeConta tipoConta) throws TipoDeContaInvalida {

        switch (tipoConta) {
            case CONTA_CORRENTE:
                return new ContaCorrente();
            case CONTA_POUPANCA:
                return new ContaPoupanca();
            case CONTA_INVESTIMENTO:
                return new ContaInvestimento();
        }

        throw new TipoDeContaInvalida();
    }
}
