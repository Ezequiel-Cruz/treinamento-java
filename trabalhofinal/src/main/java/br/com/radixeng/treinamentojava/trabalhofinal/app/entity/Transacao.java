package br.com.radixeng.treinamentojava.trabalhofinal.app.entity;

import java.util.Date;
import java.util.List;

public class Transacao {
    private Double valor;
    private Date data;

    public Double obterValor() {
        return this.valor;
    }

    public Date obterData() {
        return this.data;
    }

    Transacao(Double valor, Date data) {
        this.valor = valor;
        this.data = data;
    }

    static Double obterSaldo(List<Transacao> transacoes) {
        Double saldo = 0.0;

        for (Transacao transacao : transacoes) {
            saldo += transacao.obterValor();
        }

        return saldo;
    }
}
