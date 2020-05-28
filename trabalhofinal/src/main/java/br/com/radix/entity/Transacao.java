package br.com.radix.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Document
public class Transacao {

    @Id
    private String id;
    private BigDecimal valor;
    private Date data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal obterValor() {
        return this.valor;
    }

    public Date obterData() {
        return this.data;
    }

    public Transacao(BigDecimal valor, Date data) {
        this.valor = valor;
        this.data = data;
    }

    static BigDecimal obterSaldo(List<Transacao> transacoes) {
        BigDecimal saldo = BigDecimal.ZERO;

        for (Transacao transacao : transacoes) {
            saldo.add(transacao.getValor());
        }

        return saldo;
    }
}