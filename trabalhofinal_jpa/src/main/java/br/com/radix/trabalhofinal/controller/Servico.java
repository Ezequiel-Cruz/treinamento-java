package br.com.radix.trabalhofinal.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.radix.trabalhofinal.model.Banco;
import br.com.radix.trabalhofinal.model.ContaNova;
import br.com.radix.trabalhofinal.model.IBanco;
import br.com.radix.trabalhofinal.model.IUsuario;
import br.com.radix.trabalhofinal.model.TipoDeConta;

@Path("/banco")
public class Servico {
	
	static private IBanco banco = Banco.obterBanco();

	
	@POST
	@Path("conta")
	@Produces(MediaType.APPLICATION_JSON)
	public String postConta(final ContaNova contaNova) {
		 IUsuario usuario = new IUsuario() {
	            @Override
	            public String obterIdentificador() {

	                return contaNova.usuario;
	            }
	        };
	        Boolean contaFoiCriada = Servico.banco.criarConta(usuario, TipoDeConta.valueOf(contaNova.tipoConta));

	        if (contaFoiCriada) {
	            return "";
	        } else {
	            return "{\"error\": \"N�o foi poss�vel criar esta conta\"";
	        }
	    }


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

}
