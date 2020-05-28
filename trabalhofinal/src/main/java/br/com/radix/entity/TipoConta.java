package br.com.radix.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum TipoConta {
    CONTA_CORRENTE, CONTA_POUPANCA, CONTA_INVESTIMENTO
}
