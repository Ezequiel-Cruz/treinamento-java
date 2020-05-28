package br.com.radix.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Document
public class Conta {

    @Id
    private ObjectId _id;
    private String agencia;
    private String numero;
    private String tipoConta;
    private BigDecimal saldo;
    @DBRef
    protected Collection<Transacao> transacoes = new ArrayList<Transacao>();

    public Conta() {
        this._id = ObjectId.get();
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Collection<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(Collection<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
