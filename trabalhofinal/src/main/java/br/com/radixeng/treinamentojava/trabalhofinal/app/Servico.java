package br.com.radixeng.treinamentojava.trabalhofinal.app;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

class NovaConta {
    public String usuario;
    public String tipoConta;
}

class Operacao {
    public Double valor;
    public String tipoConta;
}

class RespostaConta {
    public TipoDeConta tipo;
    public Double saldo;
}

class RespostaListaContas {
    public List<RespostaConta> contas = new ArrayList<>();
}

@Path("/banco")
public class Servico {

    static private IBanco banco = Banco.obterBanco();

    /**
     * postConta cria conta de um usuario cadastrado previamente
     * @return String
     */
    @POST
    @Path("conta")
    @Produces(MediaType.APPLICATION_JSON)
    public String postConta(NovaConta novaConta) {

        IUsuario usuario = new IUsuario() {
            @Override
            public String obterIdentificador() {

                return novaConta.usuario;
            }
        };

        Boolean contaFoiCriada = Servico.banco.criarConta(usuario, TipoDeConta.valueOf(novaConta.tipoConta));

        if (contaFoiCriada) {
            return "";
        } else {
            return "{\"error\": \"Não foi possível criar esta conta\"";
        }
    }

    /**
     * deposita na conta passada o valor informado
     * @return String
     */
    @POST
    @Path("conta/{id_usuario}/depositar")
    @Produces(MediaType.APPLICATION_JSON)
    public String depositar(@PathParam("id_usuario") String usuario, Operacao operacaoDeposito) {
        IUsuario usuarioAlvo = new IUsuario() {
            @Override
            public String obterIdentificador() {
                return usuario;
            }
        };

        Servico.banco.depositar(operacaoDeposito.valor, usuarioAlvo,TipoDeConta.valueOf(operacaoDeposito.tipoConta));

        return "";
    }

    /**
     * retira valor da conta passada com o valor informado
     * @return String
     */
    @POST
    @Path("conta/{id_usuario}/sacar")
    @Produces(MediaType.APPLICATION_JSON)
    public String sacar(@PathParam("id_usuario") String usuario, Operacao operacaoSaque) {
        IUsuario usuarioAlvo = new IUsuario() {
            @Override
            public String obterIdentificador() {

                return usuario;
            }
        };

        Servico.banco.sacar(operacaoSaque.valor, usuarioAlvo,TipoDeConta.valueOf(operacaoSaque.tipoConta));

        return "";
    }

    @POST
    @Path("conta/{id_usuario}/transferir/{id_usuario_destino}")
    @Produces(MediaType.APPLICATION_JSON)
    public String transferir(@PathParam("id_usuario") String usuario, Operacao operacaoSaque) {
        IUsuario usuarioAlvo = new IUsuario() {
            @Override
            public String obterIdentificador() {

                return usuario;
            }
        };

        Servico.banco.transferir(operacaoSaque.valor,
                usuarioAlvo,
                TipoDeConta.valueOf(operacaoSaque.tipoConta),
                usuarioAlvo,
                TipoDeConta.valueOf(operacaoSaque.tipoConta));

        return "";
    }

    /**
     * Obtem a lista de contas de um usuário
     * @param usuario
     * @return
     */
    @GET
    @Path("conta/{id_usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public RespostaListaContas obterConta(@PathParam("id_usuario") String usuario) {
        IUsuario usuarioAlvo = new IUsuario() {
            @Override
            public String obterIdentificador() {

                return usuario;
            }
        };

        RespostaListaContas resposta = new RespostaListaContas();

        Map<TipoDeConta, Conta> contas = Servico.banco.obterContasUsuario(usuarioAlvo);
        for (TipoDeConta tipo: contas.keySet()) {
            RespostaConta c = new RespostaConta();
            c.saldo = contas.get(tipo).obterSaldo();
            c.tipo = tipo;
            resposta.contas.add(c);
        }

        return resposta;
    }

    @GET
    @Path("visaoGerencial")
    @Produces(MediaType.APPLICATION_JSON)
    public String obtervisaoGerencial() {

        return Servico.banco.verTodosOsSaldos().toString();
    }
}
