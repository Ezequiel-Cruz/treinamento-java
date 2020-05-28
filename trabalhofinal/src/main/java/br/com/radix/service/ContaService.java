package br.com.radix.service;

import br.com.radix.entity.Conta;
import br.com.radix.entity.Transacao;
import br.com.radix.repository.ContaRepository;
import br.com.radix.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    TransacaoService transacaoService;

    public List<Conta> listaConta() {

        return contaRepository.findAll();
    }

    public Conta salvarConta(Conta contaAdd) {

        List<Transacao> transacaoList = new ArrayList<>();
        for (Transacao transacaos: contaAdd.getTransacoes()) {

            if (transacaos !=null) {
               Transacao transacao = this.transacaoService.salvarTransacao(transacaos);

                transacaoList.add(transacao);
            }
        }
        contaAdd.setTransacoes(null);
        contaAdd.setTransacoes(transacaoList);
        return contaRepository.save(contaAdd);
    }

    public void deleteConta(String id) {
        contaRepository.delete(id);
    }

    public Conta getById(String id) {
        return contaRepository.findOne(id);
    }

}
