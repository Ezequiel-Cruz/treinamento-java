package br.com.radix.service;

import br.com.radix.entity.*;
import br.com.radix.repository.ContaRepository;
import br.com.radix.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    TransacaoService transacaoService;
    @Autowired
    ClienteService clienteService;

    public List<Conta> listaConta() {

        return this.contaRepository.findAll();
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
        return this.contaRepository.save(contaAdd);
    }

    public void deleteConta(String id) {
        this.contaRepository.delete(id);
    }

    public Conta getById(String id) {
        return this.contaRepository.findOne(id);
    }

    public Conta saca (String usuario, Operacao operacao) {
        Cliente cliente =  this.clienteService.getByNome(usuario);

        if (cliente == null) {
            return null;
        }

        List<Conta> listContas = new ArrayList<>();

        for (Conta contas: cliente.getContas()) {
            String tipoDaConta = contas.getTipoConta();

            if (operacao.tipoConta.equals(tipoDaConta)) {

                contas.setSaldo(this.saca(contas.getSaldo(), operacao.valor));
                listContas.add(contas);
            }
        }
        Conta contaAtualizada = listContas.get(0);

        return this.contaRepository.save(contaAtualizada);
    }

    public Conta deposita (String usuario, Operacao operacao) {

        Cliente cliente =  this.clienteService.getByNome(usuario);

        if (cliente == null) {
            return null;
        }

        List<Conta> listContas = new ArrayList<>();

        for (Conta contas: cliente.getContas()) {
            String tipoDaConta = contas.getTipoConta();

            if (operacao.tipoConta.equals(tipoDaConta)) {

                contas.setSaldo(this.deposito(contas.getSaldo(), operacao.valor));
                listContas.add(contas);
            }
        }
        Conta contaAtualizada = listContas.get(0);

        return this.contaRepository.save(contaAtualizada);
    }

    public Conta transfere (String usuarioOrigem, String usuarioDestino, OperacaoTransferencia operacao) {
        Cliente clienteOrigem =  this.clienteService.getByNome(usuarioOrigem);
        Cliente clienteDestino =  this.clienteService.getByNome(usuarioDestino);

        if (clienteOrigem == null) {
            return null;
        }

        if (usuarioDestino == null) {
            return null;
        }

        List<Conta> listContasOrigem = new ArrayList<>();

        for (Conta contas: clienteOrigem.getContas()) {
            String tipoDaConta = contas.getTipoConta();

            if (operacao.tipoContaOrigem.equals(tipoDaConta)) {

                contas.setSaldo(this.saca(contas.getSaldo(), operacao.valor));
                listContasOrigem.add(contas);
            }
        }
        Conta contaAtualizadaOrigem = listContasOrigem.get(0);

        this.contaRepository.save(contaAtualizadaOrigem);

        // Destino
        List<Conta> listContasDestino = new ArrayList<>();

        for (Conta contas: clienteDestino.getContas()) {
            String tipoDaConta = contas.getTipoConta();

            if (operacao.tipoContaDestino.equals(tipoDaConta)) {

                contas.setSaldo(this.deposito(contas.getSaldo(), operacao.valor));
                listContasDestino.add(contas);
            }
        }
        Conta contaAtualizadaDestino = listContasDestino.get(0);

        return this.contaRepository.save(contaAtualizadaDestino);
    }

    private BigDecimal deposito(BigDecimal valorAtual, BigDecimal valorDaOperacao) {
        BigDecimal saldoAtual = valorAtual;
        BigDecimal saldoDaOperacao = valorDaOperacao;
        BigDecimal saldoAtualizado = saldoAtual.add(saldoDaOperacao);

        return saldoAtualizado;
    }

    private BigDecimal saca(BigDecimal valorAtual, BigDecimal valorDaOperacao) {
        BigDecimal saldoAtual = valorAtual;
        BigDecimal saldoDaOperacao = valorDaOperacao;
        BigDecimal saldoAtualizado = saldoAtual.subtract(saldoDaOperacao);

        return saldoAtualizado;
    }
}
