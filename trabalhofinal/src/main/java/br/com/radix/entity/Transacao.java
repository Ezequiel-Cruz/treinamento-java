package br.com.radix.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Document
public class Transacao {

    @Id
    private String id;
    private BigDecimal valor;
    @CreatedDate
    private Instant data = Instant.now();

    public Transacao(String id, BigDecimal valor, Instant data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }

    public Transacao() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setData(Instant data) {
        this.data = data;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public Instant getData() {
        return this.data;
    }

    static BigDecimal obterSaldo(List<Transacao> transacoes) {
        BigDecimal saldo = BigDecimal.ZERO;

        for (Transacao transacao : transacoes) {
            saldo.add(transacao.getValor());
        }

        return saldo;
    }
}