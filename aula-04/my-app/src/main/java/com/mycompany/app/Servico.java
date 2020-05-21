package com.mycompany.app;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

class NovaConta {
    public String usuario;
    public String tipoconta;
}

@Path("/")
public class Servico {

    // static private IBanco banco = Banco.criarConta();

    /**
     * Criar conta de um usuario cadastrado
     * @return String
     */

    @POST
    @Path("conta")
    @Produces(MediaType.APPLICATION_JSON)
    public String CriarConta(String body){
        return body;
    }
}
