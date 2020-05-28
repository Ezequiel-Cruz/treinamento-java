package br.com.radix.service;

import br.com.radix.entity.Transacao;
import br.com.radix.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;


    public List<Transacao> listaTransacao() {
        return transacaoRepository.findAll();
    }

    public Transacao salvarTransacao(Transacao transacaoAdd) {

        return transacaoRepository.save(transacaoAdd);

    }

    public Transacao getById(String id) {
        return transacaoRepository.findOne(id);
    }

    public Transacao getByNome(String nome) {

        return transacaoRepository.findOne(nome);
    }
}
