package br.com.radix.trabalhofinal.model;

import java.util.*;

public interface IBanco {
    Boolean criarConta(IUsuario usuario, TipoDeConta tipo);

    void depositar(Double valor, IUsuario usuario, TipoDeConta tipo);

    public Double sacar(Double valor, IUsuario usuario, TipoDeConta tipo);

    public void transferir(Double valor, IUsuario origem, TipoDeConta tipoOrigem, IUsuario destino, TipoDeConta tipoDestino);

    Map<String, Map<TipoDeConta, Conta>> visaoGerencial();

    Map<TipoDeConta, Conta> obterContasUsuario(IUsuario usuario);
}

