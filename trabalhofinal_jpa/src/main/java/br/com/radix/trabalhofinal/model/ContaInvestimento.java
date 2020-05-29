package br.com.radix.trabalhofinal.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContaInvestimento extends Conta {
    public Double sacar(Double valor) {
        // Date dataAtual = new Date();
        List<Transacao> transacoesComMaisDeTrintaDias = new ArrayList<>();

        for (Transacao transacao : this.transacoes) {
            Calendar calendarTransacaoAposTrintaDias = Calendar.getInstance();
            calendarTransacaoAposTrintaDias.setTime(transacao.obterData());
            calendarTransacaoAposTrintaDias.add(Calendar.DATE, 30);

            if (transacao.obterValor() < 0 || calendarTransacaoAposTrintaDias.before(new Date())) {
                transacoesComMaisDeTrintaDias.add(transacao);
            }
        }

        Double saldo = Transacao.obterSaldo(transacoesComMaisDeTrintaDias);
        if (saldo > 0 && saldo > valor ) {
            this.sacar(valor);
            return valor;
        }

        return 0.0;
    }
}
