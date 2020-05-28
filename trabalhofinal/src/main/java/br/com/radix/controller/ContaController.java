package br.com.radix.controller;

import br.com.radix.entity.Conta;
import br.com.radix.entity.Operacao;
import br.com.radix.entity.OperacaoTransferencia;
import br.com.radix.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContaController {

    @Autowired
    ContaService contaService;

    @RequestMapping(value = "/conta", method = RequestMethod.GET)
    public List<Conta> listar() {

        return this.contaService.listaConta();
    }

    @RequestMapping(value = "/conta/{id}/depositar", method = RequestMethod.POST)
    public Conta depositar(@PathVariable("id") String usuario, @RequestBody Operacao operacao) {

        return this.contaService.deposita(usuario, operacao);
    }

    @RequestMapping(value = "/conta/{id}/sacar", method = RequestMethod.POST)
    public Conta sacar(@PathVariable("id") String usuario, @RequestBody Operacao operacao) {

        return this.contaService.saca(usuario, operacao);
    }

    @RequestMapping(value = "/conta/{id_origem}/transferir/{id_destino}", method = RequestMethod.POST)
    public Conta transferir(
            @PathVariable("id_origem") String usuarioOrigem,
            @PathVariable("id_destino") String usuarioDestino,
            @RequestBody OperacaoTransferencia operacaoTransferencia) {

        return this.contaService.transfere(usuarioOrigem, usuarioDestino, operacaoTransferencia);
    }
}
