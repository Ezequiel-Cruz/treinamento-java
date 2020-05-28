package br.com.radix.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Document
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private BigDecimal valor;
    @CreatedDate
    private Date data;

    public Transacao() {
        super();
    }

    public Transacao(String id, BigDecimal valor, Date data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }

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