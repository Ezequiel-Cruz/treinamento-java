package br.com.radix.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Conta {

    private String agencia;
    @Id
    private String numero;
    private String tipoConta;
    private BigDecimal saldo;
    private List<Transacao> transacoes = new ArrayList<>();

    public Conta(){
        super();
    }

    public Conta(String agencia, String numero, String tipoConta, BigDecimal saldo, List<Transacao> transacoes) {
        this.agencia = agencia;
        this.numero = numero;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.transacoes = transacoes;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }


}
