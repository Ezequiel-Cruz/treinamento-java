package br.com.radix.controller;

import br.com.radix.entity.Cliente;
import br.com.radix.entity.Operacao;
import br.com.radix.service.ClienteService;
import br.com.radix.service.ContaService;
import br.com.radix.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    ContaService contaService;
    TransacaoService transacaoService;

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Cliente> listar() {

        return this.clienteService.listaCliente();
    }

    @RequestMapping(value = "/cliente/{nome}", method = RequestMethod.GET)
    public Cliente getById(@PathVariable String nome) {

        return this.clienteService.getById(nome);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public Cliente salvar(@RequestBody Cliente cliente) {

        return this.clienteService.salvarCliente(cliente);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.PATCH)
    public Cliente editar(@RequestBody Cliente cliente) {

        return this.clienteService.salvarCliente(cliente);
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {

        this.clienteService.deleteCliente(id);
    }

    @RequestMapping(value = "/cliente/{id}/deposita", method = RequestMethod.POST)
    public Cliente salvar(@PathVariable("id") String usuario, @RequestBody Operacao operacao) {

        return this.clienteService.depositaSaldo(usuario, operacao);
    }
}
