package br.com.radix.controller;

import br.com.radix.entity.Conta;
import br.com.radix.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContaController {

    @Autowired
    ContaService contaService;

    @RequestMapping(value = "/conta", method = RequestMethod.GET)
    public List<Conta> listar() {
        return this.contaService.listaConta();
    }
}
