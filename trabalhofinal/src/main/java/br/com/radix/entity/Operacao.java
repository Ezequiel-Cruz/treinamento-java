package br.com.radix.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class Operacao {
    public String tipoConta;
    public BigDecimal valor;
}
