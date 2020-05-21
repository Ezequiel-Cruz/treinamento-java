package br.com.radixeng.treinamentojava.trabalhofinal.app;

import java.util.*;

public interface IBanco {
    Boolean criarConta(IUsuario usuario, TipoDeConta tipo);

    void depositar(Double valor, IUsuario usuario, TipoDeConta tipo);

    public Double sacar(Double valor, IUsuario usuario, TipoDeConta tipo);

    public void transferir(Double valor, IUsuario origem, TipoDeConta tipoOrigem, IUsuario destino, TipoDeConta tipoDestino);

    String verTodosOsSaldos();

    Map<TipoDeConta, Conta> obterContasUsuario(IUsuario usuario);
}

