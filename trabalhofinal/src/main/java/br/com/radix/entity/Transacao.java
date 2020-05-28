package br.com.radix.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Document
public class Transacao {

    @Id
    private ObjectId _id;
    private BigDecimal valor;
    @DateTimeFormat
    private Date data;

    public Transacao(ObjectId _id) {
        this._id = ObjectId.get();
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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