package br.com.radixeng.treinamentojava.trabalhofinal.app.entity;

import br.com.radixeng.treinamentojava.trabalhofinal.app.exception.TipoDeContaInvalida;
import br.com.radixeng.treinamentojava.trabalhofinal.app.dao.EntityDao;

import java.util.*;

public class Banco extends EntityDao implements IBanco {

    public Map<String, Map<TipoDeConta,Conta>> mapaUsuarioContas;

    private static Banco instance = new Banco();

    // Singleton
    public static Banco obterBanco() {
        if (Banco.instance != null) {
            return Banco.instance;
        } else {
            Banco.instance = new Banco();
            return Banco.instance;
        }
    }

    private Banco(){
        super(Banco.class);
        this.mapaUsuarioContas = new HashMap();
    }

    public Boolean criarConta(IUsuario usuario, TipoDeConta tipo){
        try {
            Map<TipoDeConta, Conta> contas = new HashMap<>();

            Conta novaConta = Conta.instanciaConta(tipo);

            if (this.mapaUsuarioContas.containsKey(usuario.obterIdentificador())) {
                this.mapaUsuarioContas.get(usuario.obterIdentificador()).put(tipo, novaConta);
            } else {

                contas.put(tipo, novaConta);
                this.mapaUsuarioContas.put(usuario.obterIdentificador(), contas);
            }

            save(this.mapaUsuarioContas);

            return true;
        } catch (TipoDeContaInvalida e) {
            System.out.println("Tipo de conta inválido para este usuário.");
            return false;
        }
    }

    public String verTodosOsSaldos() {
        String retorno = "";
        for(String identificadorUsuario: this.mapaUsuarioContas.keySet()) {
            retorno += identificadorUsuario + "\n"; // Trazer o nome da conta
            Map<TipoDeConta, Conta> tiposDeContaUsuario = this.mapaUsuarioContas.get(identificadorUsuario);
            for (TipoDeConta tipoConta : tiposDeContaUsuario.keySet()) {
                retorno += tipoConta + "\n";
                retorno += "Valor em conta: " + tiposDeContaUsuario.get(tipoConta).obterSaldo() + "\n";
            }
            retorno += "-------------------------\n";
        }

        return retorno;
    }


    public void depositar(Double valor, IUsuario usuario, TipoDeConta tipo) {
        Conta conta = this.obterContaApartirUsuario(tipo, usuario);

        conta.depositar(valor);
    }

    public Double sacar(Double valor, IUsuario usuario, TipoDeConta tipo) {
        Conta conta = this.obterContaApartirUsuario(tipo, usuario);

        try {
            conta.sacar(valor);
        } catch (java.lang.NullPointerException e) {
            System.out.println("Ocorreu um erro inesperado: "+ usuario.obterIdentificador());
            // throw e;
        }

        return valor;
    }

    public void transferir(Double valor, IUsuario origem, TipoDeConta tipoOrigem, IUsuario destino, TipoDeConta tipoDestino) {
        Conta contaOrigem = this.obterContaApartirUsuario(tipoOrigem, origem);
        Conta contaDestino = this.obterContaApartirUsuario(tipoDestino, destino);
        contaOrigem.transferir(valor, contaDestino);
    }

    public Map<TipoDeConta, Conta> obterContasUsuario(IUsuario usuario) {
        return this.mapaUsuarioContas.get(usuario.obterIdentificador());
    }

    private Conta obterContaApartirUsuario(TipoDeConta tipo, IUsuario usuario) {
        Map<TipoDeConta, Conta> tiposDeContaUsuario = this.mapaUsuarioContas.get(usuario.obterIdentificador());
        Conta conta = tiposDeContaUsuario.get(tipo);

        return conta;
    }

    public Map<String, Map<TipoDeConta,Conta>> visaoGerencial() {

        return this.mapaUsuarioContas;
    }
}

